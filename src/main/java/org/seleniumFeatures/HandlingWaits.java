package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HandlingWaits {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dynamic-properties");

        // ==============================
        // 1. IMPLICIT WAIT
        // ==============================
        // Tells WebDriver to wait up to 10 seconds for any element
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        WebElement text = driver.findElement(By.id("enableAfter")); // waits until element appears
        System.out.println("Element found with Implicit Wait: " + text.getText());

        // ==============================
        // 2. EXPLICIT WAIT
        // ==============================
        WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(10000));
        WebElement visibleBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("enableAfter"))
        );
        visibleBtn.click();
        System.out.println("Clicked button using Explicit Wait");

        // ==============================
        // 3. FLUENT WAIT
        // ==============================
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))      // total wait time
                .pollingEvery(Duration.ofSeconds(2))      // check every 2 sec
                .ignoring(NoSuchElementException.class);  // ignore exception while checking

        WebElement colorChangeBtn = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement btn = driver.findElement(By.id("colorChange"));
                if (btn.getCssValue("color").equals("rgba(220, 53, 69, 1)")) {
                    return btn; // return when condition is true
                }
                return null;
            }
        });
        System.out.println("Fluent Wait detected button color change.");

        driver.quit();
    }
}
/**
 * ===========================================
 *  WHAT ARE WAITS IN SELENIUM?
 * ===========================================
 *
 * In real-world applications, elements don’t always load instantly.
 *  A wait tells WebDriver to "pause" until a condition is true or
 *    a certain time has passed.
 *  Without waits, Selenium may try to interact with elements too early,
 *    causing "NoSuchElementException" or "ElementNotInteractableException".
 *
 * ===========================================
 *  TYPES OF WAITS IN SELENIUM
 * ===========================================
 *
 * 1. IMPLICIT WAIT
 * -----------------
 * - Tells WebDriver to wait for a certain time while locating elements.
 * - Applies to all findElement() calls.
 * - Once set, it stays for the entire session.
 *
 * Example:
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 *
 * ⚠ Limitation:
 *    - Works only for element location (not conditions like clickable).
 *    - Not recommended for dynamic web applications.
 *
 * ---------------------------------------------------------
 *
 * 2. EXPLICIT WAIT
 * -----------------
 * - Waits for a specific condition to be met before proceeding.
 * - More flexible and precise than implicit wait.
 *
 * Example:
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 * WebElement element = wait.until(
 *     ExpectedConditions.visibilityOfElementLocated(By.id("username"))
 * );
 * element.sendKeys("testuser");
 *
 * Common ExpectedConditions:
 * - visibilityOfElementLocated(By)
 * - elementToBeClickable(By)
 * - presenceOfElementLocated(By)
 * - textToBePresentInElement(By, "someText")
 * - alertIsPresent()
 *
 * ---------------------------------------------------------
 *
 * 3. FLUENT WAIT
 * -----------------
 * - Similar to Explicit Wait but allows:
 *   polling frequency (how often Selenium checks)
 *    ignoring specific exceptions
 *
 * Example:
 * Wait<WebDriver> fluentWait = new FluentWait<>(driver)
 *     .withTimeout(Duration.ofSeconds(20))
 *     .pollingEvery(Duration.ofSeconds(2))
 *     .ignoring(NoSuchElementException.class);
 *
 * WebElement element = fluentWait.until(
 *     ExpectedConditions.elementToBeClickable(By.id("submit"))
 * );
 * element.click();
 *
 * ===========================================
 * 🔹 REAL LIFE USE CASES
 * ===========================================
 * Login page: wait until username & password fields are visible
 *  Shopping site: wait until "Add to Cart" button is clickable
 * Payment gateway: wait until confirmation message appears
 * File upload: wait until progress bar disappears
 *
 * ===========================================
 * GOOD PRACTICES
 * ===========================================
 *  Prefer EXPLICIT WAIT over IMPLICIT WAIT
 *    (Explicit is more precise and reliable).
 *
 *  NEVER mix Implicit and Explicit Wait
 *    (causes unpredictable delays).
 *
 * Use FLUENT WAIT for highly dynamic elements
 *    (polling reduces test time instead of waiting full duration).
 *
 *  Always wait for specific conditions (clickable, visible, text present).
 *
 * Avoid Thread.sleep() unless debugging
 *    (hardcoded waits slow down tests unnecessarily).
 *
 * ===========================================
 * 🔹 DEBUGGING TIP
 * ===========================================
 * If element not found even after waits:
 * - Check if element is inside an iframe → switchTo().frame()
 * - Check if window/tab changed → switchTo().window()
 * - Check locator correctness
 */
