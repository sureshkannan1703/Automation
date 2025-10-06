package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * =============================================================
 * FILE UPLOAD IN SELENIUM – DETAILED NOTES
 * =============================================================
 *
 * Why do we need file upload automation?
 * --------------------------------------
 * - In real-life applications (job portals, banking, e-commerce),
 *   users upload resumes, ID proofs, invoices, profile pictures, etc.
 * - Automating file upload is important for regression testing.
 *
 * How file upload is usually designed?
 * ------------------------------------
 * 1. Standard HTML element: <input type="file">
 *    - Selenium can directly interact with this element using sendKeys().
 *
 * 2. Custom-designed button:
 *    - Some applications do not use <input type="file">.
 *    - They open a native OS dialog box instead.
 *    - Selenium cannot interact with OS-level dialogs directly.
 *    - In such cases, we use:
 *        a) Robot Class (Java AWT)
 *        b) AutoIT tool (Windows only)
 *
 * =============================================================
 * METHODS TO HANDLE FILE UPLOAD
 * =============================================================
 *
 * 1. Using sendKeys()   (Preferred and Simple)
 *    - Directly send the absolute path of the file.
 *    - Works only if element has <input type="file">.
 *
 * 2. Using Robot Class  (When non-input elements are used)
 *    - Handles native OS popup by simulating keyboard events.
 *
 * 3. Using AutoIT tool  (Optional, Windows-specific)
 *    - External tool to handle file dialogs.
 *
 * =============================================================
 */
public class HandlingFileUpload{

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sures\\Videos\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            /**
             * =========================================================
             * 1. FILE UPLOAD USING sendKeys()
             * ---------------------------------------------------------
             * - Works with <input type="file"> elements.
             * - Bypasses the Browse button.
             * - Directly uploads file by setting its path.
             * =========================================================
             */
            driver.get("https://demoqa.com/upload-download");
            driver.manage().window().maximize();

            WebElement uploadInput = driver.findElement(By.id("uploadFile"));
            uploadInput.sendKeys("C:\\Users\\Public\\Documents\\samplefile.txt");

            System.out.println("File uploaded successfully using sendKeys");

            Thread.sleep(3000);

            /**
             * =========================================================
             * 2. FILE UPLOAD USING ROBOT CLASS
             * ---------------------------------------------------------
             * - Useful when the upload button is NOT an <input type="file">
             * - Steps:
             *    a) Click on the custom button to open the dialog
             *    b) Copy file path to clipboard
             *    c) Use Robot class to paste (CTRL+V) and press ENTER
             * =========================================================
             */
            driver.get("https://demo.guru99.com/test/upload/");

            // Click on file upload button
            WebElement chooseFileBtn = driver.findElement(By.id("uploadfile_0"));
            chooseFileBtn.click();

            // Copy file path to clipboard
            StringSelection filePath = new StringSelection("C:\\Users\\Public\\Documents\\samplefile.txt");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

            // Robot class to handle dialog
            Robot robot = new Robot();
            robot.delay(2000);

            // Press CTRL + V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press ENTER
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("File uploaded successfully using Robot class");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(4000);
            driver.quit();
        }
    }
}

