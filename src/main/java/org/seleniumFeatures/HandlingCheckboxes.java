package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingCheckboxes {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to demo site with checkboxes
        driver.get("https://demoqa.com/checkbox");

        // ******** REAL-LIFE CHECKBOX HANDLING EXAMPLES ********

        // (A) Locate a single checkbox
        WebElement expandAll = driver.findElement(By.cssSelector("button[title='Expand all']"));
        expandAll.click(); // expand all options first

        WebElement homeCheckbox = driver.findElement(By.cssSelector("label[for='tree-node-home'] span.rct-checkbox"));
        if(homeCheckbox.isDisplayed()){
            System.out.println("Home checkbox pressed");
            homeCheckbox.click();
        }
        Thread.sleep(1000);

        // (B) Verify if a checkbox is selected
        WebElement homeInput = driver.findElement(By.id("tree-node-home"));
        if (homeInput.isSelected()) {
            System.out.println("Home checkbox is selected.");
        } else {
            System.out.println("Home checkbox is NOT selected.");
        }

        // (C) Select checkbox only if not already selected
        WebElement desktopCheckbox = driver.findElement(By.id("tree-node-desktop"));
        if (!desktopCheckbox.isSelected()) {
            driver.findElement(By.cssSelector("label[for='tree-node-desktop'] span.rct-checkbox")).click();
            System.out.println("Desktop checkbox selected.");
        }

        // (D) Deselect a checkbox (only possible if it’s already selected)
        if (desktopCheckbox.isSelected()) {
            driver.findElement(By.cssSelector("label[for='tree-node-desktop'] span.rct-checkbox")).click();
            System.out.println("Desktop checkbox deselected.");
        }

        // (E) Handling multiple checkboxes (loop through all)
        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Total checkboxes available: " + allCheckboxes.size());

        for (WebElement checkbox : allCheckboxes) {

            if (!checkbox.isSelected()) {
                checkbox.click(); // select all unchecked boxes

            }
        }
        System.out.println("All checkboxes selected.");

        // (F) Example of reading checkbox label text
        WebElement documentsLabel = driver.findElement(By.xpath("//label[@for='tree-node-documents']/span[@class='rct-title']"));
        System.out.println("Checkbox label is: " + documentsLabel.getText());

        // Pause for demo
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}
