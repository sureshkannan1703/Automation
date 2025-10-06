package org.seleniumFeatures;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");

        // ==============================
        // 1. Switch to Frame by ID
        // ==============================
        driver.switchTo().frame("frame1"); // frame id=frame1
        WebElement heading1 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame 1 Text: " + heading1.getText());

        driver.switchTo().defaultContent(); // back to main page

        // ==============================
        // 2. Switch to Another Frame
        // ==============================
        driver.switchTo().frame("frame2"); // frame id=frame2
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        System.out.println("Frame 2 Text: " + heading2.getText());

        driver.switchTo().defaultContent();

        // ==============================
        // 3. Nested Frames Example
        // ==============================
        driver.get("https://demoqa.com/nestedframes");

        // Switch to parent frame
        driver.switchTo().frame(driver.findElement(By.id("frame1")));

        // Inside parent, switch to child frame
        driver.switchTo().frame(0);
        String childText = driver.findElement(By.tagName("p")).getText();
        System.out.println("Nested Frame Child Text: " + childText);

        // Move back to parent
        driver.switchTo().parentFrame();
        String parentText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Nested Frame Parent Text: " + parentText);

        driver.switchTo().defaultContent(); // return to main page

        driver.quit();
    }
}

/**
 * ===========================================
 * HANDLING FRAMES IN SELENIUM (DemoQA)
 * ===========================================
 *
 * 1. What is a Frame?
 *    - A frame (iframe) is an HTML page embedded inside another page.
 *    - Elements inside frames need focus switch before interacting.
 *
 * ===========================================
 * SWITCHING TO FRAMES
 * ===========================================
 *
 * 1. By ID/Name
 *    driver.switchTo().frame("frame1");
 *
 * 2. By Index
 *    driver.switchTo().frame(0);
 *
 * 3. By WebElement
 *    WebElement frameElement = driver.findElement(By.id("frame2"));
 *    driver.switchTo().frame(frameElement);
 *
 * ===========================================
 * EXITING FROM FRAMES
 * ===========================================
 *
 * driver.switchTo().parentFrame();     // Back to parent frame only
 * driver.switchTo().defaultContent();  // Back to main page
 *
 * ===========================================
 *  REAL LIFE USE CASES
 * ===========================================
 *  Forms inside embedded iframes
 *  Payment gateways (credit card fields)
 *  Ads or widgets (Google Ads, Social Media plugins)
 *  Complex dashboards with nested layouts
 *
 * ===========================================
 *  BEST PRACTICES
 * ===========================================
 *  Always inspect if element is inside <iframe>.
 *  Prefer WebElement or ID over index (index can change).
 *  Use parentFrame() for nested frames, defaultContent() for main page.
 *  If you see InvalidElementStateException → likely wrong frame.
 */
