package org.testngFramework;

import org.testng.annotations.*;

public class TestNGExample {

    //Annotation Hierarchy:
    //@BeforeSuite
    //BeforeClass
    //@BeforeTest
    //@Test - test function/case
    //@AfterTest
    //@AfterClass
    //@AfterSuite


    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>> BeforeSuite: Setup system property / DB connection");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">>> AfterSuite: Cleanup system property / Close DB connection");
    }

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(@Optional("chrome") String browser) {
        System.out.println(">>> BeforeTest: Launch browser = " + browser);
    }

    @AfterTest
    public void afterTest() {
        System.out.println(">>> AfterTest: Close browser");
    }


    @Parameters({"url", "username"})
    @BeforeClass
    public void beforeClass(@Optional("https://default.com") String url, String username) {
        System.out.println(">>> BeforeClass: Login to application at URL = " + url + " with user = " + username);
    }

    @AfterClass
    public void afterClass() {
        System.out.println(">>> AfterClass: Logout from application");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(">>> BeforeMethod: Navigate to Home Page");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(">>> AfterMethod: Clear cookies");
    }

    // 5 Test Cases with Groups
    @Test(priority = 1, groups = {"sanity", "smoke"})
    public void testCase1() {
        System.out.println("Test Case 1: Verify Home Page Title [Group: sanity, smoke]");
    }

    @Test(priority = 2, groups = {"sanity"})
    public void testCase2() {
        System.out.println("Test Case 2: Verify Login Functionality [Group: sanity]");
    }

    @Test(priority = 3, groups = {"regression"})
    public void testCase3() {
        System.out.println("Test Case 3: Verify User Profile Update [Group: regression]");
    }

    @Test(priority = 4, groups = {"regression"})
    public void testCase4() {
        System.out.println("Test Case 4: Verify Search Functionality [Group: regression]");
    }

    @Test(priority = 5, groups = {"smoke"})
    public void testCase5() {
        System.out.println("Test Case 5: Verify Logout Functionality [Group: smoke]");
    }
}
