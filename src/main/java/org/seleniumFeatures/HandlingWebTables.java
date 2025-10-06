package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * ===============================
 * HANDLING WEB TABLES IN SELENIUM
 * ===============================
 *
 * Why handle web tables?
 * ----------------------
 * - Tables store structured data in rows and columns.
 * - Test cases may require:
 *      1. Reading values from a table
 *      2. Validating data
 *      3. Clicking a link/button inside a table cell
 *      4. Iterating through rows dynamically
 *
 * Types of Web Tables
 * -------------------
 * 1. Static Table:
 *      - Table size (rows/columns) is fixed.
 *      - Example: Fixed student grade table.
 *
 * 2. Dynamic Table:
 *      - Table size changes based on data.
 *      - Example: Stock market data, order list.
 *
 * HTML Structure of a Web Table
 * -----------------------------
 * <table>
 *    <thead>  → column headers
 *    <tbody>  → table rows (tr)
 *       <tr> → row
 *         <td> → cell data
 *
 * =============================================================
 * COMMON ACTIONS ON WEB TABLES
 * =============================================================
 * 1. Find total rows and columns
 * 2. Read a specific cell value
 * 3. Read entire table
 * 4. Dynamic search (find row by matching text)
 * 5. Click a link/button inside a cell
 *
 * =============================================================
 */
public class HandlingWebTables {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Open demo site
            driver.get("https://demoqa.com/webtables");
            Thread.sleep(2000);

            /**
             * ---------------------------------------------------------
             * 1. FIND TOTAL ROWS AND COLUMNS
             * ---------------------------------------------------------
             */
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
            List<WebElement> cols = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@class='rt-th']"));

            System.out.println("Total Rows: " + rows.size());
            System.out.println("Total Columns: " + cols.size());

            /**
             * ---------------------------------------------------------
             * 2. READ A SPECIFIC CELL VALUE
             * ---------------------------------------------------------
             * Example: 2nd row, 3rd column
             */
            WebElement cellValue = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[2]//div[@class='rt-td'][3]"));
            System.out.println("Cell Value (Row 2, Col 3): " + cellValue.getText());

            /**
             * ---------------------------------------------------------
             * 3. READ ENTIRE TABLE DATA
             * ---------------------------------------------------------
             */
            System.out.println("\nEntire Table Data:");
            for (int i = 1; i <= rows.size(); i++) {
                List<WebElement> rowCells = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td']"));
                for (WebElement cell : rowCells) {
                    System.out.print(cell.getText() + " | ");
                }
                System.out.println();
            }

            /**
             * ---------------------------------------------------------
             * 4. DYNAMIC SEARCH
             * ---------------------------------------------------------
             * Find row where "First Name" = "Cierra"
             */
            for (int i = 1; i <= rows.size(); i++) {
                WebElement firstNameCell = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'][1]"));
                if (firstNameCell.getText().equalsIgnoreCase("Cierra")) {
                    System.out.println("Row with First Name 'Cierra' found at row " + i);
                    break;
                }
            }

            /**
             * ---------------------------------------------------------
             * 5. CLICK BUTTON INSIDE A TABLE CELL
             * ---------------------------------------------------------
             * Example: Click 'Edit' button in row where First Name = "Alden"
             */
            for (int i = 1; i <= rows.size(); i++) {
                WebElement firstNameCell = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//div[@class='rt-td'][1]"));
                if (firstNameCell.getText().equalsIgnoreCase("Alden")) {
                    WebElement editBtn = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]//span[@title='Edit']"));
                    editBtn.click();
                    System.out.println("Clicked Edit button for Alden");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(4000);
            driver.quit();
        }
    }
}

