package org.testngFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrates the use of Assertions in TestNG
 * - Hard Assertions: stop execution immediately if failed
 * - Soft Assertions: collect failures and report at the end
 */
public class AssertionDemoTest {

    /**
     * Example of Hard Assertion
     * If any Assert fails, execution will STOP for that test.
     */
    @Test
    public void hardAssertionExample() {
        String expectedTitle = "DemoQA";
        String actualTitle = "DemoQA"; // try changing to "Google" and see failure

        System.out.println("Step 1: Comparing Titles");
        // Hard assert: if mismatch, execution stops here
        Assert.assertEquals(actualTitle, expectedTitle, "Title did not match!");

        System.out.println("Step 2: Checking condition is true");
        // Hard assert: must be true
        Assert.assertTrue(10 > 5, "Condition is not true!");

        System.out.println("Step 3: Checking object is not null");
        // Hard assert: must not be null
        Assert.assertNotNull("Some Value", "Object is null!");

        System.out.println("All hard assertions passed. Test completed.");
    }

    /**
     * Example of Soft Assertion
     * Even if one check fails, execution CONTINUES until the end.
     * At the end we must call assertAll() to report all failures.
     */
    @Test
    public void softAssertionExample() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Step 1: Checking equality");
        softAssert.assertEquals("Hello", "Hi", "Strings are not equal!");

        System.out.println("Step 2: Checking condition is true");
        softAssert.assertTrue(2 > 3, "Condition failed (2 > 3 is false)!");

        System.out.println("Step 3: Checking object is not null");
        softAssert.assertNotNull(null, "Object is null!");

        System.out.println("Step 4: This will run even if above assertions failed");

        // This is mandatory: it reports all collected failures
        softAssert.assertAll();

        System.out.println("If no failure above, this will print (else test fails at assertAll).");
    }
}
