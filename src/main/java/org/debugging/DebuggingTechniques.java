package org.debugging;

public class DebuggingTechniques {

    public static void main(String[] args) {
        System.out.println("Debugging Demo Started...");

        int a = 10;
        int b = 0;

        // Example of Debugging: Division by zero
        try {
            int result = a / b; // Put BREAKPOINT here
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Debugging Demo Finished...");
    }
}

/**
 * ===========================================
 * 🔹 DEBUGGING TECHNIQUES & SHORTCUTS (INTELLIJ IDEA)
 * ===========================================
 *
 * 1. ADDING BREAKPOINTS
 *    - CLICK LEFT GUTTER or PRESS CTRL+F8
 *    - Execution will pause at that line.
 *
 * 2. RUNNING IN DEBUG MODE
 *    - SHIFT+F9 → Run program in Debug mode.
 *
 * 3. STEP OVER (F8)
 *    - Executes the current line and moves to the next.
 *    - Example: If current line is a = add(5,3), it will NOT go inside add().
 *
 * 4. STEP INTO (F7)
 *    - Goes inside the method call.
 *    - Example: Goes inside add(5,3) method to debug line by line.
 *
 * 5. STEP OUT (SHIFT+F8)
 *    - Comes out of the current method and returns to the caller.
 *
 * 6. RESUME PROGRAM (F9)
 *    - Continue execution until the next breakpoint.
 *
 * 7. EVALUATE EXPRESSION
 *    - ALT+F8 (during debug)
 *    - Allows you to test custom code snippets while debugging.
 *    - Example: type a+b in Evaluate → see result instantly.
 *
 * 8. WATCH VARIABLES
 *    - Right-click a variable → "Add to Watches"
 *    - Keeps tracking variable values during execution.
 *
 * 9. CONDITIONAL BREAKPOINTS
 *    - Right-click breakpoint → "More"
 *    - Add condition → Example: stop only when a > 50.
 *
 * 10. LOG BREAKPOINTS
 *    - Instead of stopping, log variable values at runtime.
 *    - Example: Print "Value of count is: " + count.
 *
 * 11. INLINE DEBUGGING
 *    - ENABLE INLINE DEBUG (ALT+SHIFT+F8)
 *    - Shows values of variables directly inside the editor.
 *
 * 12. DROP FRAME
 *    - CTRL+ALT+F9
 *    - Re-run a method without restarting the entire program.
 *
 * 13. FORCE RETURN
 *    - Right-click on method frame → "Force Return"
 *    - Exit method instantly with a custom value.
 *
 * 14. FORCE STEP INTO
 *    - ALT+SHIFT+F7
 *    - Steps into JDK/library methods (like System.out.println).
 *
 * 15. EXCEPTION BREAKPOINTS
 *    - CTRL+SHIFT+F8 → Add "Any Exception"
 *    - Debugger stops wherever exception occurs.
 *
 * ===========================================
 * 🔹 GENERAL DEBUGGING BEST PRACTICES
 * ===========================================
 * ✅ Always use MEANINGFUL BREAKPOINTS (not on every line).
 * ✅ Use PRINTLN or LOGGER for simple flow debugging.
 * ✅ For big projects → prefer DEBUGGER over print statements.
 * ✅ Use CONDITIONAL BREAKPOINTS to save time.
 * ✅ Use WATCHES to monitor values across iterations.
 * ✅ For Selenium:
 *    - Debug element locators step by step.
 *    - Pause after driver.get() to ensure page load.
 *    - Watch values of WebElement variables.
 *
 * ===========================================
 * 🔹 REAL LIFE USE CASES
 * ===========================================
 * 🔸 Checking NullPointerException → Add Exception Breakpoint.
 * 🔸 Debugging Selenium Test → Watch Xpath / CSS selectors.
 * 🔸 Debugging API Response → Evaluate JSON strings live.
 * 🔸 Debugging Loops → Use Conditional Breakpoint for count==100.
 */
