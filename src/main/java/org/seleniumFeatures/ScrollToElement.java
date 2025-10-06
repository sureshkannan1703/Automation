package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class ScrollToElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");

        WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled to Forms element!");
    }

    public void scrollToElementUsingActions(){
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).perform();

    }

    public void scrollByCustom(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,500)");  // scroll down 500px

    }

    /*Use window.scrollTo(0, document.body.scrollHeight) → scroll to bottom.

    Use scrollIntoView(true) → scroll to a specific element.

    Use window.scrollBy(x,y) → scroll by pixels.

    Use Actions class as an alternative for element focus.*/


}
