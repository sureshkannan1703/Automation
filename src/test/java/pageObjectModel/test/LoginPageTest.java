package pageObjectModel.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjectModel.base.BaseTest;
import pageObjectModel.base.ExtentReportListener;
import pageObjectModel.base.TestListener;
import pageObjectModel.dataproviders.LoginPageDataProvider;
import pageObjectModel.page.LoginPage;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest {

    Properties prop = null;

    @BeforeMethod
    public void refresh() {
        driver.navigate().refresh();
    }

    @AfterMethod
    public void endtest() {
        System.out.println("test case ended!");
    }


    @Test(dataProvider = "loginData", dataProviderClass = LoginPageDataProvider.class)
    public void runTest(String name, String password) throws InterruptedException, IOException {

        LoginPage loginPage = new LoginPage(driver);
        System.out.println(Thread.currentThread().getId());
        System.out.println(System.currentTimeMillis());
        loginPage.loginAs(name, password);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
      //  Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

    }

    @Test(dataProvider = "listData", dataProviderClass = LoginPageDataProvider.class)
    public void test2(List<String> arr) throws IOException {
        System.out.println("test2");
      //  Assert.assertTrue(prop != null, "Property file not loaded please check....");
      //  String[] arr = prop.getProperty("users").split(",");
//        System.out.println(arr.get(0));
//        System.out.println(arr.get(1));
        System.out.println(Thread.currentThread().getId());
        System.out.println(System.currentTimeMillis());


    }

    public void test3(String userData) throws IOException {

        System.out.println(userData);
    }
}

