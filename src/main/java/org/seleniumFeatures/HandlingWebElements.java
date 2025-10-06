package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingWebElements {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to demo site
        driver.get("https://demoqa.com/elements");

        // ******** REAL-LIFE WEB ELEMENT HANDLING EXAMPLES ********

        // (A) Locate a single WebElement using id
        WebElement elementsCard = driver.findElement(By.xpath("//h5[text()='Elements']"));
        System.out.println("Text of element: " + elementsCard.getText());

        // (B) Click a WebElement
        elementsCard.click();
        Thread.sleep(1000);

        // (C) Locate multiple elements (list of WebElements)
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".accordion button"));
        System.out.println("Menu items count: " + menuItems.size());
        for (WebElement item : menuItems) {
            System.out.println(" - " + item.getText());
        }

        // (D) Get attributes of WebElement
        WebElement textBoxMenu = driver.findElement(By.xpath("//span[text()='Text Box']"));
        System.out.println("Tag name: " + textBoxMenu.getTagName());
        System.out.println("Class attribute: " + textBoxMenu.getAttribute("class"));

        // (E) Check element state
        if (textBoxMenu.isDisplayed() && textBoxMenu.isEnabled()) {
            System.out.println("TextBox menu is visible and clickable.");
            textBoxMenu.click();
        }

        // (F) Work with input field as WebElement
        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Suresh Kannan");
        System.out.println("Entered value: " + username.getAttribute("value"));

        // (G) Check if checkbox is selected
        driver.get("https://demoqa.com/checkbox");
        WebElement checkbox = driver.findElement(By.id("tree-node-home"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Checkbox selected state: " + checkbox.isSelected());

        // (H) Get CSS value (useful for styling checks)
        WebElement header = driver.findElement(By.cssSelector(".main-header"));
        System.out.println("Header color: " + header.getCssValue("color"));
        System.out.println("Header font-size: " + header.getCssValue("font-size"));

        // (I) Example: Verify if element exists (try-catch)
        try {
            WebElement hidden = driver.findElement(By.id("nonExisting"));
            System.out.println("Hidden element found: " + hidden.isDisplayed());
        } catch (Exception e) {
            System.out.println("Element not found (safe handling).");
        }

        // Pause for demo
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}
