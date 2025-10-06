package pageObjectModel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sures\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

/*
    selenium-pom-demo/
                             ├── src/main/java/
                             │    ├── base/
                             │    │    └── BaseTest.java
                             │    ├── enums/
                             │    │    └── LoginPageLocators.java
                             │    ├── pages/
                             │    │    └── LoginPage.java
                             │    └── tests/
                             │         └── LoginPageTest.java
                             ├── pom.xml

    Enum (LoginPageLocators) → stores locators in one place, makes them easy to maintain.

    LoginPage → contains only functions (actions) like enterUsername(), clickLogin().

    LoginPageTest → calls those functions, contains test logic.

    BaseTest → handles WebDriver setup and quit.

 */
