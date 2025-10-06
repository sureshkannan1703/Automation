package pageObjectModel.dataproviders;

import org.testng.annotations.DataProvider;
import pageObjectModel.base.ConfigReader;
import pageObjectModel.page.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPageDataProvider {


    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() throws IOException {

            ConfigReader reader = new ConfigReader();
            return new Object[][]{
                    { reader.getProperty("username"), reader.getProperty("password")}
            };
        }

    @DataProvider(name = "listData")
    public Object[][] provideListData() throws IOException {

        ConfigReader reader = new ConfigReader();
        return new Object[][]{
                { reader.getProperty("usrs")}
        };
    }




}
