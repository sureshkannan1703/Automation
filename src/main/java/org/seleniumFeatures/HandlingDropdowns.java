package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingDropdowns {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to demo site with dropdowns
        driver.get("https://demoqa.com/select-menu");

        // ******** REAL-LIFE DROPDOWN HANDLING EXAMPLES ********

        // (A) Handling a standard <select> dropdown (static dropdown)
        WebElement singleSelect = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        Select select = new Select(singleSelect);

        // Select by visible text
        select.selectByVisibleText("Blue");
        Thread.sleep(1000);

        // Select by value attribute
        select.selectByValue("3"); // "Green"
        Thread.sleep(1000);

        // Select by index
        select.selectByIndex(4); // "Purple"
        Thread.sleep(1000);

        // (B) Get all available options in dropdown
        List<WebElement> allOptions = select.getOptions();
        System.out.println("Available colors in dropdown:");
        for (WebElement option : allOptions) {
            System.out.println(" - " + option.getText());
        }

        // (C) Get currently selected option
        WebElement selected = select.getFirstSelectedOption();
        System.out.println("Currently selected color: " + selected.getText());

        // (D) Handling multi-select dropdown
        WebElement multiSelect = driver.findElement(By.id("cars"));
        Select multi = new Select(multiSelect);

        if (multi.isMultiple()) {
            multi.selectByVisibleText("Volvo");
            multi.selectByVisibleText("Saab");
            multi.selectByIndex(2); // Opel
            Thread.sleep(2000);

            // Print selected options
            List<WebElement> selectedOptions = multi.getAllSelectedOptions();
            System.out.println("Selected cars:");
            for (WebElement car : selectedOptions) {
                System.out.println(" - " + car.getText());
            }

            // Deselect example
            multi.deselectByVisibleText("Saab");
        }

        // (E) Handling custom dropdown (not <select>, dynamic list)
        driver.get("https://demoqa.com/select-menu");

        WebElement customDropdown = driver.findElement(By.id("withOptGroup"));
        customDropdown.click();
        Thread.sleep(1000);

        // Select an option by visible text (custom dropdown requires xpath/css)
        WebElement customOption = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        customOption.click();
        System.out.println("Custom dropdown selected: " + customOption.getText());

        // (F) Verify dropdown is enabled
        if (singleSelect.isEnabled()) {
            System.out.println("Dropdown is enabled for selection.");
        } else {
            System.out.println("Dropdown is disabled.");
        }

        // Pause for observation
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}

/*
    General Pattern for Non-Select Dropdown:
    Locate dropdown toggle (the clickable element).
    Perform .click() to expand it.
    Locate option element (could be <li>, <div>, <span>).
    Use click() on the desired option.

    If a element has select tag prepare xpath until that tag.
 */