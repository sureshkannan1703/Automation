package pageObjectModel.locators;

import org.openqa.selenium.By;

public enum LoginPageLocators {
    USERNAME(By.id("userName")),
    PASSWORD(By.id("password")),
    LOGIN_BUTTON(By.id("login")),
    LOGOUT_BUTTON(By.id("submit")); // optional, for verification after login

    private final By locator;

    private int a;

    LoginPageLocators(By locator) {

        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
