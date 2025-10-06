package pageObjectModel.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectModel.locators.LoginPageLocators;

public class LoginPage {
    public WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterUsername(String username) {
        WebElement element = driver.findElement(LoginPageLocators.USERNAME.getLocator());

        Point point = element.getLocation();
        System.out.println("Scroll to " + point.getX()+ " " + point.getY());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+point.getX()+","+point.getY()+")");
       // js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.PASSWORD.getLocator()).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON.getLocator()).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLogoutDisplayed() {
        return driver.findElement(LoginPageLocators.LOGOUT_BUTTON.getLocator()).isDisplayed();
    }
}

