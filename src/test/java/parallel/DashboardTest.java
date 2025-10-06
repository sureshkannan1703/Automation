package parallel;

import org.testng.annotations.Test;

public class DashboardTest {

    @Test
    public void dashboardTest() {
        System.out.println("DashboardTest executed on Thread ID: " + Thread.currentThread().getId());
    }
}
