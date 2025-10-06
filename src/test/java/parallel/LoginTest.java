package parallel;

import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginWithValidUser() {
        System.out.println("loginWithValidUser - Thread ID: " + Thread.currentThread().getId());
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void loginWithInvalidUser() {
        System.out.println("loginWithInvalidUser - Thread ID: " + Thread.currentThread().getId());
        System.out.println(System.currentTimeMillis());

    }

    @Test
    public void loginWithEmptyFields() {
        System.out.println("loginWithEmptyFields - Thread ID: " + Thread.currentThread().getId());
        System.out.println(System.currentTimeMillis());

    }
}
