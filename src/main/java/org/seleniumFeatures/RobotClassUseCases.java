package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * =============================================================
 * ROBOT CLASS IN JAVA (Selenium Use Cases)
 * =============================================================
 *
 * What is Robot Class?
 * --------------------
 * - Java class from java.awt package.
 * - Used to generate native system input events.
 * - Can simulate:
 *      1. Keyboard actions
 *      2. Mouse movements
 *      3. Mouse clicks
 *
 * Why do we use Robot in Selenium?
 * --------------------------------
 * - Selenium cannot handle OS-level popups or windows.
 * - Robot helps in:
 *      a) File upload dialogs
 *      b) Download dialogs
 *      c) Authentication popups
 *      d) Keyboard shortcuts (CTRL+C, CTRL+V)
 *      e) Screenshots (with Robot.createScreenCapture)
 *
 * =============================================================
 * COMMON USE CASES OF ROBOT CLASS
 * =============================================================
 */
public class RobotClassUseCases {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            /**
             * =========================================================
             * 1. FILE UPLOAD DIALOG
             * ---------------------------------------------------------
             * - Upload file using Robot when OS window appears.
             * =========================================================
             */
            driver.get("https://demo.guru99.com/test/upload/");
            WebElement chooseFileBtn = driver.findElement(By.id("uploadfile_0"));
            chooseFileBtn.click();

            StringSelection filePath = new StringSelection("C:\\Users\\Public\\Documents\\samplefile.txt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

            Robot robot = new Robot();
            robot.delay(2000);

            // CTRL + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // ENTER
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("File uploaded using Robot");

            /**
             * =========================================================
             * 2. FILE DOWNLOAD DIALOG
             * ---------------------------------------------------------
             * - Some browsers show Save/Cancel dialog for downloads.
             * - Robot can press LEFT/RIGHT and ENTER keys to confirm.
             * =========================================================
             */
            // Example: simulate pressing ALT+S (Save) in a download dialog
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_ALT);
            System.out.println("Handled file download dialog with Robot");

            /**
             * =========================================================
             * 3. AUTHENTICATION POPUP
             * ---------------------------------------------------------
             * - When site asks for username/password via OS popup.
             * - Robot can type credentials directly.
             * =========================================================
             */
            // Example (pseudo, because auth popups differ):
            robot.keyPress(KeyEvent.VK_U); // simulate typing 'U'
            robot.keyRelease(KeyEvent.VK_U);

            robot.keyPress(KeyEvent.VK_TAB); // move to password field
            robot.keyRelease(KeyEvent.VK_TAB);

            robot.keyPress(KeyEvent.VK_P); // simulate typing 'P'
            robot.keyRelease(KeyEvent.VK_P);

            robot.keyPress(KeyEvent.VK_ENTER); // press ENTER to login
            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("Authentication popup handled");

            /**
             * =========================================================
             * 4. KEYBOARD SHORTCUTS
             * ---------------------------------------------------------
             * - Useful for copy-paste or refreshing page.
             * =========================================================
             */
            // Refresh page with CTRL + R
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Copy text with CTRL + C
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            System.out.println("Keyboard shortcuts simulated");

            /**
             * =========================================================
             * 5. SCREEN CAPTURE
             * ---------------------------------------------------------
             * - Robot can take full desktop screenshot.
             * - Useful for non-browser elements or OS dialogs.
             * =========================================================
             */
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            java.awt.image.BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            javax.imageio.ImageIO.write(screenFullImage, "png", new java.io.File("C:\\Users\\Public\\screenshot.png"));
            System.out.println("Desktop screenshot captured");

            /**
             * =========================================================
             * 6. MOUSE MOVEMENTS AND CLICKS
             * ---------------------------------------------------------
             * - Move mouse to coordinates and click.
             * =========================================================
             */
            robot.mouseMove(200, 300); // move to screen coordinates (x=200, y=300)
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK); // left click press
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK); // release
            System.out.println("Mouse moved and clicked using Robot");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}

