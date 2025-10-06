package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlingWindows {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");

        // Store the current (main) window handle
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main Window ID: " + mainWindow);

        // ==============================
        // 1. Handling New Tab
        // ==============================
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        newTabBtn.click();

        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All Windows IDs: " + allWindows);

        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                System.out.println("New Tab Text: " +
                        driver.findElement(By.id("sampleHeading")).getText());
                driver.close(); // close new tab
            }
        }
        driver.switchTo().window(mainWindow); // back to main window

        // ==============================
        // 2. Handling New Window
        // ==============================
        WebElement newWindowBtn = driver.findElement(By.id("windowButton"));
        newWindowBtn.click();

        allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                System.out.println("New Window Text: " +
                        driver.findElement(By.id("sampleHeading")).getText());
                driver.close(); // close new window
            }
        }
        driver.switchTo().window(mainWindow);

        // ==============================
        // 3. Handling New Window Message
        // ==============================
        WebElement newMsgBtn = driver.findElement(By.id("messageWindowButton"));
        newMsgBtn.click();

        allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                String bodyText = driver.findElement(By.tagName("body")).getText();
                System.out.println("New Message Window Text: " + bodyText);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);

        driver.quit();
    }
}

/**
 * ===========================================
 *  HANDLING WINDOWS IN SELENIUM (DemoQA)
 * ===========================================
 *
 * 1. What are Windows?
 *    - A new browser window/tab is opened by the app.
 *    - Selenium assigns each window a unique WindowHandle (ID).
 *
 * ===========================================
 *  USEFUL COMMANDS
 * ===========================================
 *
 * // Get current window ID
 * String mainWindow = driver.getWindowHandle();
 *
 * // Get all open window IDs
 * Set<String> allWindows = driver.getWindowHandles();
 *
 * // Switch to window
 * driver.switchTo().window(windowID);
 *
 * // Close current window
 * driver.close();
 *
 * // Quit entire browser
 * driver.quit();
 *
 * ===========================================
 *  REAL LIFE USE CASES
 * ===========================================
 *  Payment gateways (opens in new tab/window)
 *  Third-party login (Google, Facebook, LinkedIn)
 *  Document preview windows
 *  Popup advertisements
 *
 * ===========================================
 * BEST PRACTICES
 * ===========================================
 * Always store the main window handle.
 * After closing child windows, switch back to the main window.
 * Use loops to iterate through window handles.
 * Use driver.quit() only at the very end (closes all windows).
 */
