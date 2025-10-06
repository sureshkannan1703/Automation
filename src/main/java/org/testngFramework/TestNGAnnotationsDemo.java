//package org.testngFramework;
//
//
//
//public class TestNGAnnotationsDemo{
//
//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("1. Before Suite - Runs before all test cases in suite");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("2. After Suite - Runs after all test cases in suite");
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("3. Before Test - Runs before <test> tag in testng.xml");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("4. After Test - Runs after <test> tag in testng.xml");
//    }
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("5. Before Class - Runs before first @Test method in class");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("6. After Class - Runs after all @Test methods in class");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("7. Before Method - Runs before each @Test method");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("8. After Method - Runs after each @Test method");
//    }
//
//    @Test(priority = 1)
//    public void testLogin() {
//        System.out.println("9. Test Case 1 - Login test");
//    }
//
//    @Test(priority = 2, dependsOnMethods = "testLogin")
//    public void testDashboard() {
//        System.out.println("10. Test Case 2 - Dashboard test (runs after login)");
//    }
//
//    @Test(priority = 3, enabled = false)
//    public void testSettings() {
//        System.out.println("11. Test Case 3 - Settings test (disabled)");
//    }
//}
///*
//    TestNG in Selenium
//
//    What is TestNG?
//
//    TestNG stands for Test Next Generation.
//
//    It is a testing framework inspired by JUnit and NUnit but more powerful.
//
//    Widely used in Selenium automation for managing test cases, execution, grouping, reporting, and parallel execution.
//
//    Provides more flexibility, better reporting, and annotations that make test scripts easy to understand and maintain.
//
//    Features of TestNG
//
//    Provides powerful annotations (like @Test, @BeforeTest, etc.)
//
//    Generates HTML and XML reports automatically.
//
//    Allows grouping of test cases.
//
//    Supports parallel execution of tests.
//
//    Supports parameterization (using XML or DataProviders).
//
//    Works seamlessly with build tools like Maven, Gradle and CI/CD tools like Jenkins.
//
//    TestNG Annotations (Most Commonly Used)
//1. @BeforeSuite
//
//Runs once before all tests in the suite.
//
//Example: Setup configurations, load drivers.
//
//2. @AfterSuite
//
//Runs once after all tests in the suite.
//
//Example: Close DB connections, flush reports.
//
//3. @BeforeTest
//
//Runs before all test cases in <test> tag in TestNG XML.
//
//Example: Set environment variables.
//
//4. @AfterTest
//
//Runs after all test cases in <test> tag.
//
//5. @BeforeClass
//
//Runs before the first @Test method of the class.
//
//Example: Initialize browser, open URL.
//
//6. @AfterClass
//
//Runs after all @Test methods in the class.
//
//Example: Close browser.
//
//7. @BeforeMethod
//
//Runs before every @Test method.
//
//Example: Login to app before each test.
//
//8. @AfterMethod
//
//Runs after every @Test method.
//
//Example: Logout or cleanup after each test.
//
//9. @Test
//
//Marks a method as a test case.
//
//Can be grouped, prioritized, enabled/disabled.
//
//Attributes:
//
//priority → execution order
//
//enabled → skip test if false
//
//groups → group test cases
//
//dependsOnMethods → run after another test
// */
