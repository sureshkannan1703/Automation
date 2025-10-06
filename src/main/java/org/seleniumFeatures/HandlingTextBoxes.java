package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTextBoxes {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup WebDriver (use your chromedriver path if required)
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to demo site
        driver.get("https://demoqa.com/text-box");

        // ******** REAL-LIFE TEXTBOX HANDLING EXAMPLES ********

        // (A) Entering a simple username
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Suresh Kannan");

        // (B) Clearing a pre-filled value before typing
        username.clear();
        username.sendKeys("Automation Student");

        // (C) Entering email ID into textbox
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("student@testmail.com");

        // (D) Entering address (multiline textbox)
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys("123, Main Street\nChennai\nIndia - 600001");

        // (E) Using keyboard keys with textbox (Tab / Enter)
        email.sendKeys(Keys.TAB);  // moves to next field
        address.sendKeys(Keys.CONTROL + "a"); // select all
        address.sendKeys(Keys.DELETE);        // delete all content
        address.sendKeys("Updated Address after delete");

        // (F) Appending text without clearing
        username.sendKeys(" - Appended Value");

        // (G) Handling numeric input (simulate PIN or OTP)
        WebElement otpField = driver.findElement(By.id("permanentAddress"));
        otpField.sendKeys("987654");

        // (H) Submitting form with Enter key
        otpField.sendKeys(Keys.ENTER);

        // (I) Checking if textbox is enabled/disabled
        if(username.isEnabled()) {
            System.out.println("Username field is enabled");
        } else {
            System.out.println("Username field is disabled");
        }

        // (J) Reading already typed value (using getAttribute)
        String enteredEmail = email.getAttribute("value");
        System.out.println("Typed Email is: " + enteredEmail);

        // (K) Example of hidden textboxes (try-catch handling)
        try {
            WebElement hiddenField = driver.findElement(By.id("hiddenTextbox"));
            if(hiddenField.isDisplayed()) {
                hiddenField.sendKeys("Visible and typing...");
            } else {
                System.out.println("Textbox is hidden, cannot type!");
            }
        } catch(Exception e) {
            System.out.println("Textbox not found, skipping hidden field case");
        }

        // Pause for demo
        Thread.sleep(4000);

        // Close browser
        driver.quit();
    }
}

