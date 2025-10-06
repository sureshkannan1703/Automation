package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * =============================================================
 * ACTIONS CLASS IN SELENIUM – DETAILED NOTES
 * =============================================================
 *
 * What is Actions class?
 * ----------------------
 * - A Selenium class that allows handling advanced user interactions
 *   like mouse and keyboard events.
 * - Part of: org.openqa.selenium.interactions.Actions
 *
 * Why do we need it?
 * ------------------
 * - Basic WebElement methods like click(), sendKeys() only work
 *   for simple actions.
 * - For real-life complex cases like:
 *     - Mouse hover to see hidden menus
 *     - Right-click to open context menus
 *     - Double-click for special buttons
 *     - Drag and drop operations
 *     - Keyboard combinations (CTRL + C, CTRL + V)
 *   we need Actions class.
 *
 * How to use?
 * -----------
 * 1. Create Actions object:
 *       Actions actions = new Actions(driver);
 *
 * 2. Call required method(s).
 *
 * 3. Finish with perform():
 *       actions.moveToElement(element).click().perform();
 *
 * =============================================================
 */
public class HandlingActions {

    public static void main(String[] args) throws InterruptedException {

        // STEP 1: Setup ChromeDriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // STEP 2: Create Actions object
            Actions actions = new Actions(driver);

            /**
             * =========================================================
             * DOUBLE CLICK
             * ---------------------------------------------------------
             * Used when double click is required on a button/element.
             * Example: "Double Click Me" button in demoqa.
             * =========================================================
             */
            driver.get("https://demoqa.com/buttons");
            driver.manage().window().maximize();

            WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
            actions.doubleClick(doubleClickBtn).perform();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            System.out.println("Double Click performed");

            /**
             * =========================================================
             * RIGHT CLICK (CONTEXT CLICK)
             * ---------------------------------------------------------
             * Used to simulate right-click, which opens context menu.
             * =========================================================
             */
            WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
            actions.contextClick(rightClickBtn).perform();
            System.out.println("Right Click performed");

            /**
             * =========================================================
             * MOUSE HOVER
             * ---------------------------------------------------------
             * Useful for hidden menus or dropdown menus that
             * appear only when hovered.
             * =========================================================
             */
            driver.get("https://demoqa.com/menu");
            WebElement menuElement = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
            actions.moveToElement(menuElement).perform();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            System.out.println("Mouse Hover performed");

            /**
             * =========================================================
             * DRAG AND DROP
             * ---------------------------------------------------------
             * Drag an element and drop it into another.
             * Example: Draggable & Droppable demo.
             * =========================================================
             */
            driver.get("https://demoqa.com/droppable");
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));
            actions.dragAndDrop(source, target).perform();
            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            System.out.println("Drag and Drop performed");

            /**
             * =========================================================
             * CLICK AND HOLD
             * ---------------------------------------------------------
             * Press mouse, hold it, move, and then release.
             * Sometimes required when normal dragAndDrop fails.
             * =========================================================
             */
            actions.clickAndHold(source).moveToElement(target).release().perform();
            System.out.println("Click and Hold performed");

            /**
             * =========================================================
             * KEYBOARD ACTIONS
             * ---------------------------------------------------------
             * Simulate keyboard actions like typing, pressing
             * special keys, or key combinations.
             *
             * Methods:
             *    - sendKeys(Keys.ENTER)
             *    - keyDown(Keys.CONTROL)
             *    - keyUp(Keys.CONTROL)
             * =========================================================
             */
            driver.get("https://demoqa.com/text-box");
            WebElement textBox = driver.findElement(By.id("userName"));
            actions.click(textBox)                     // focus
                    .sendKeys("Selenium User")          // type text
                    .perform();
            System.out.println("Keyboard typing performed");

            /**
             * =========================================================
             * COMBINED ACTIONS
             * ---------------------------------------------------------
             * Actions can be chained together before calling perform().
             * Example: Hold SHIFT while typing to enter uppercase.
             * =========================================================
             */


            actions.click(textBox)
                    .keyDown(Keys.SHIFT)
                    .sendKeys("selenium")
                    .keyUp(Keys.SHIFT)
                    .perform();
            System.out.println("SHIFT + Typing performed");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}

