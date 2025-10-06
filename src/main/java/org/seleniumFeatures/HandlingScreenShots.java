package org.seleniumFeatures;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

/**
 * =============================================================
 * TAKING SCREENSHOTS IN SELENIUM
 * =============================================================
 *
 * Why take screenshots?
 * ---------------------
 * 1. Debugging failed test cases
 * 2. Reporting (attach screenshots in reports)
 * 3. Tracking application state at runtime
 *
 * Selenium provides:
 * ------------------
 * TakesScreenshot interface
 *    - Available in WebDriver
 *    - Can capture:
 *         a) Full page screenshot
 *         b) Specific WebElement screenshot (from Selenium 4)
 *
 * =============================================================
 * METHODS TO CAPTURE SCREENSHOTS
 * =============================================================
 *
 * 1. Full Page Screenshot
 * -----------------------
 * - Convert driver object to TakesScreenshot.
 * - Use getScreenshotAs() method.
 *
 * 2. Element Screenshot (Selenium 4+)
 * -----------------------------------
 * - Capture screenshot of a specific WebElement only.
 *
 * 3. Good Practices
 * -------------------
 * - Save with unique names (timestamp).
 * - Store in "screenshots" folder.
 * - Use try-catch for IOException.
 * =============================================================
 */
public class HandlingScreenShots{

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        int as = 100;

        double dd = as;

        int ks = (int)dd;

        try {
            driver.get("https://demoqa.com");

            /**
             * ---------------------------------------------------------
             * 1. FULL PAGE SCREENSHOT
             * ---------------------------------------------------------
             */
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            // save with timestamp
            String filePath = "C:\\Users\\Public\\screenshots\\fullpage_" + System.currentTimeMillis() + ".png";
            FileHandler.copy(src, new File(filePath));
            System.out.println("Full page screenshot saved: " + filePath);

            /**
             * ---------------------------------------------------------
             * 2. ELEMENT SCREENSHOT (Selenium 4 feature)
             * ---------------------------------------------------------
             */
            WebElement logo = driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']"));
            File elementSrc = logo.getScreenshotAs(OutputType.FILE);

            String elementPath = "C:\\Users\\Public\\screenshots\\element_" + System.currentTimeMillis() + ".png";
            FileHandler.copy(elementSrc, new File(elementPath));
            System.out.println("Element screenshot saved: " + elementPath);

            /**
             * ---------------------------------------------------------
             * 3. SECTION / PARTIAL PAGE SCREENSHOT
             * ---------------------------------------------------------
             * Capture a DIV section of page using WebElement.
             */
            WebElement section = driver.findElement(By.className("category-cards"));
            File sectionSrc = section.getScreenshotAs(OutputType.FILE);

            String sectionPath = "C:\\Users\\Public\\screenshots\\section_" + System.currentTimeMillis() + ".png";
            FileHandler.copy(sectionSrc, new File(sectionPath));
            System.out.println("Section screenshot saved: " + sectionPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}

