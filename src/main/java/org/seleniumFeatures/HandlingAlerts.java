package org.seleniumFeatures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to demo site with alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // ==============================
        // 1. Handling Simple Alert
        // ==============================
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        Thread.sleep(5000);
        simpleAlert.accept(); // Click OK button

        // ==============================
        // 2. Handling Confirmation Alert
        // ==============================
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
        Thread.sleep(5000);
        confirmAlert.dismiss(); // Click Cancel button

        // ==============================
        // 3. Handling Prompt Alert
        // ==============================
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Selenium Automation"); // Enter text
        Thread.sleep(5000);
        promptAlert.accept(); // Click OK

        Thread.sleep(2000);
        driver.quit();
    }
}

/**
 * ===========================================
 *  HANDLING ALERTS IN SELENIUM
 * ===========================================
 *
 * 1. What is an Alert?
 *    - Alerts are popup messages displayed by the browser.
 *    - They are NOT part of the DOM → cannot be located by Xpath/CSS.
 *    - Selenium handles them using driver.switchTo().alert().
 *
 * ===========================================
 *  TYPES OF ALERTS
 * ===========================================
 *
 * 1. Simple Alert
 *    - Displays a message with OK button.
 *    - Methods:
 *      -> getText() → fetch alert message.
 *      -> accept() → click OK.
 *
 * 2. Confirmation Alert
 *    - Displays a message with OK & Cancel.
 *    - Methods:
 *      -> accept() → click OK.
 *      -> dismiss() → click Cancel.
 *
 * 3. Prompt Alert
 *    - Displays a message with input box + OK/Cancel.
 *    - Methods:
 *      -> sendKeys("text") → enter value.
 *      -> accept() → submit value.
 *      -> dismiss() → cancel.
 *
 * ===========================================
 *  IMPORTANT COMMANDS
 * ===========================================
 *
 * driver.switchTo().alert()   → Switch focus to alert.
 * alert.getText()             → Get alert message.
 * alert.accept()              → Click OK.
 * alert.dismiss()             → Click Cancel.
 * alert.sendKeys("value")     → Enter text in prompt.
 *
 * ===========================================
 *  REAL LIFE USE CASES
 * ===========================================
 *  Login failure alert → "Invalid Credentials".
 *  Delete confirmation popup → "Are you sure you want to delete?".
 *  Payment confirmation prompt.
 *  Prompt box asking for verification code.
 *
 * ===========================================
 *  BEST PRACTICES
 * ===========================================
 * Always use Explicit Wait before switching to alert:
 *      new WebDriverWait(driver, Duration.ofSeconds(5))
 *          .until(ExpectedConditions.alertIsPresent());
 *
 *  Avoid Thread.sleep() → prefer WebDriverWait.
 *  For large projects, wrap alert handling in reusable functions.
 */

