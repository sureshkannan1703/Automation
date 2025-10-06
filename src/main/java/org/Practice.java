package org;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {




    static void fillForm(String name,String usrEmail,String useAddress,String parentAdd) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        Thread.sleep(5000);

        WebElement element = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
        element.click();
        Thread.sleep(5000);

        WebElement textBox = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textBox.click();
        Thread.sleep(5000);

        WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
        username.sendKeys(name);

        username.clear();
        username.sendKeys("Automation Student");

        // (C) Entering email ID into textbox
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(usrEmail);

        // (D) Entering address (multiline textbox)
        WebElement address = driver.findElement(By.id("currentAddress"));
        address.sendKeys(useAddress);

        // (E) Using keyboard keys with textbox (Tab / Enter)
        email.sendKeys(Keys.TAB);  // moves to next field
        address.sendKeys(Keys.CONTROL + "a"); // select all
        address.sendKeys(Keys.DELETE);        // delete all content
        address.sendKeys("Updated Address after delete");

        // (F) Appending text without clearing
        username.sendKeys(" - Appended Value");

        // (G) Handling numeric input (simulate PIN or OTP)
        WebElement otpField = driver.findElement(By.id("permanentAddress"));
        otpField.sendKeys(parentAdd);

        // (H) Submitting form with Enter key
        otpField.sendKeys(Keys.ENTER);

    }


    int age = 20;

    String name = "Suresh";


    static String[] names = new String[]{"Suresh","Kannan","SK"};
    static String[] subjects = new String[]{"Science","Maths","History"};

    static String[][] arr = new String[][]{
            names,
            subjects,
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println(arr[1][1]);
    }

    static int add(int num1, int num2){
        int res = num1 + num2;
        return res;
    }





}
