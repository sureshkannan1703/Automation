package org.testngFramework;

import org.testng.annotations.*;

public class FirstTest {

    @Test
    public void testHello() {
        System.out.println("Hello, TestNG is working!");
    }

    @Test
    public void  test3(){
        System.out.println("test3");
    }

    @Test
    public void test4(){
        System.out.println("test4");
    }

    @AfterMethod
    public void afterEachTest(){
        System.out.println("I'm for afterEachTest");
    }

    @AfterClass
    public void setUpAfterClass() throws Exception {
        System.out.println("I run After Class");
    }

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
        System.out.println("I run Before Class");
    }

    @BeforeMethod
    public void beforeEachTest(){
        System.out.println("I'm for beforeEachTest");
    }
}
