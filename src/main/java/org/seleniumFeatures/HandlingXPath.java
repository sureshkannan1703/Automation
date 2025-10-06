package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingXPath {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to demo site
        driver.get("https://demoqa.com/elements");

        // ******** XPATH HANDLING EXAMPLES ********

        // (A) Absolute XPath (not recommended for real projects)
        WebElement absolute = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div[1]/span/div/div[1]/div[1]"));
        System.out.println("Absolute XPath text: " + absolute.getText());

        // (B) Relative XPath (preferred way)
        WebElement relative = driver.findElement(By.xpath("//h5[text()='Elements']"));
        System.out.println("Relative XPath text: " + relative.getText());

        // (C) Attribute-based XPath
        WebElement textBox = driver.findElement(By.xpath("//span[@class='text' and text()='Text Box']"));
        textBox.click();

        // (D) XPath using OR condition
        WebElement element = driver.findElement(By.xpath("//input[@id='userName' or @placeholder='Full Name']"));
        element.sendKeys("Suresh Kannan");

        // (E) XPath with contains()
        WebElement email = driver.findElement(By.xpath("//input[contains(@id,'userEmail')]"));
        email.sendKeys("test@mail.com");

        // (F) XPath with starts-with()
        WebElement address = driver.findElement(By.xpath("//textarea[starts-with(@id,'current')]"));
        address.sendKeys("Chennai, India");

        // (G) XPath with normalize-space() (trims spaces)
        WebElement checkBoxMenu = driver.findElement(By.xpath("//span[normalize-space(text())='Check Box']"));
        System.out.println("Menu: " + checkBoxMenu.getText());

        // (H) Index-based XPath (not recommended unless unique)
        WebElement firstMenuItem = driver.findElement(By.xpath("(//li[@class='btn btn-light '])[1]"));
        System.out.println("First menu item: " + firstMenuItem.getText());

        // (I) XPath Axes - Parent
        WebElement parentExample = driver.findElement(By.xpath("//input[@id='userEmail']/parent::div"));
        System.out.println("Parent tag: " + parentExample.getTagName());

        // (J) XPath Axes - Child
        List<WebElement> children = driver.findElements(By.xpath("//div[@class='col-md-9 col-sm-12']/child::input"));
        System.out.println("Children count under div: " + children.size());

        // (K) XPath Axes - Following
        WebElement following = driver.findElement(By.xpath("//input[@id='userEmail']/following::textarea[1]"));
        following.sendKeys("Followed Address");

        // (L) XPath Axes - Preceding
        WebElement preceding = driver.findElement(By.xpath("//textarea[@id='currentAddress']/preceding::input[1]"));
        System.out.println("Preceding element tag: " + preceding.getTagName());

        // (M) XPath Axes - Sibling
        WebElement sibling = driver.findElement(By.xpath("//span[text()='Text Box']/following-sibling::span"));
        System.out.println("Sibling: " + sibling.getText());

        // (N) XPath Axes - Ancestor
        WebElement ancestor = driver.findElement(By.xpath("//input[@id='userName']/ancestor::form"));
        System.out.println("Ancestor tag: " + ancestor.getTagName());

        // (O) XPath Axes - Descendant
        List<WebElement> descendants = driver.findElements(By.xpath("//form[@id='userForm']/descendant::*"));
        System.out.println("Total descendants in form: " + descendants.size());

        // Pause for observation
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}

