package org.testngFramework;

import org.testng.annotations.*;

public class HomePageTest {

    @BeforeSuite
    public void checkInternetConnection() {
        System.out.println("Checking Internet Connection");
        System.out.println("Checking Data base  Connection");
    }

    @BeforeClass
    public void LoginAndnavigateToHomePage(){
        System.out.println("Login And navigate to Homepage");
    }

    @BeforeMethod
    public void checkHomePage(){
        System.out.println("Checking home page... loaded or not");
    }

    @Test
    public void sendEmailTest() {
        System.out.println("sendEmailTest running...sending ");
    }

    @Test
    public void fillForm(){
        System.out.println("fillForm running...filling form");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod running..refresh homepage");
    }

    @AfterClass
    public void afterAlltestExecution(){
        System.out.println("After All test Execution");
    }

    @AfterSuite
    public void closeConnection() {
        System.out.println("Close Internet Connection");
        System.out.println("Close Data base  Connection");
    }

}
