package org.debugging;

public class MavenSetup {

    /**
     * ===========================================
     * WHAT IS MAVEN?
     * ===========================================
     *
     *  Maven is a build automation and project management tool.
     *  It is based on the concept of POM (Project Object Model).
     *  It helps manage:
     *    - Project builds (compile, test, package, deploy)
     *    - Dependencies (JARs & libraries from central repository)
     *    - Documentation & Reporting
     *
     * ===========================================
     *  WHY USE MAVEN?
     * ===========================================
     * 1. Dependency Management
     *    - No need to download JAR files manually.
     *    - Maven automatically downloads required libraries from repositories.
     *
     * 2. Standard Project Structure
     *    - Every Maven project follows a common directory layout.
     *
     * 3. Easy Build Process
     *    - Compile, test, and package projects with simple commands.
     *
     * 4. Integration
     *    - Works with CI/CD pipelines (Jenkins, GitHub Actions, etc.).
     *
     * ===========================================
     *  MAVEN STANDARD DIRECTORY STRUCTURE
     * ===========================================
     * project-name/
     * ├── src/
     * │   ├── main/
     * │   │   └── java/         -> source code
     * │   ├── test/
     * │   │   └── java/         -> test cases
     * ├── target/               -> compiled bytecode + packaged files
     * └── pom.xml               -> Project Object Model (dependencies & build config)
     *
     * ===========================================
     *  IMPORTANT FILE: pom.xml
     * ===========================================
     * Example:
     *
     * <project xmlns="http://maven.apache.org/POM/4.0.0"
     *          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
     *          http://maven.apache.org/xsd/maven-4.0.0.xsd">
     *
     *   <modelVersion>4.0.0</modelVersion>
     *   <groupId>com.example</groupId>
     *   <artifactId>selenium-demo</artifactId>
     *   <version>1.0-SNAPSHOT</version>
     *
     *   <dependencies>
     *      <!-- Selenium Dependency -->
     *      <dependency>
     *          <groupId>org.seleniumhq.selenium</groupId>
     *          <artifactId>selenium-java</artifactId>
     *          <version>4.23.0</version>
     *      </dependency>
     *   </dependencies>
     * </project>
     /**
     * ===========================================
     *  SETUP MAVEN IN WINDOWS
     * ===========================================
     *
     * 1. DOWNLOAD MAVEN
     *    - Open browser → Go to: https://maven.apache.org/download.cgi
     *    - Find "Binary zip archive" (e.g., apache-maven-3.9.9-bin.zip).
     *    - Download this file to your computer.
     *         Note: Always choose "binary zip", not "source zip".
     *
     * 2. EXTRACT MAVEN
     *    - Locate the downloaded file (apache-maven-3.9.9-bin.zip).
     *    - Right-click → "Extract All" (or use WinRAR/7-Zip).
     *    - Extract to a folder (recommended: C:\apache-maven-3.9.9).
     *    - After extraction, you will see folders:
     *         bin   → contains mvn.cmd (used for commands)
     *         boot  → bootstrap libraries
     *         conf  → configuration files (settings.xml)
     *         lib   → required JAR libraries
     *
     * 3. SET ENVIRONMENT VARIABLES
     *    - Right-click This PC → Properties → Advanced System Settings → Environment Variables
     *    - Add System Variable:
     *         Name: M2_HOME
     *         Value: C:\apache-maven-3.9.9
     *    - Add System Variable:
     *         Name: MAVEN_HOME
     *         Value: C:\apache-maven-3.9.9
     *    - Edit "Path" → Add:
     *         C:\apache-maven-3.9.9\bin
     *
     * 4. VERIFY INSTALLATION
     *    - Open CMD and run:
     *         mvn -version
     *    - Expected output example:
     *         Apache Maven 3.9.9
     *         Java version: 17
     *         OS: Windows 10/11
     *

     * ===========================================
     * MAVEN COMMON COMMANDS
     * ===========================================
     *
     * mvn clean         → Cleans target folder
     * mvn compile       → Compiles source code
     * mvn test          → Runs test cases
     * mvn package       → Creates JAR/WAR file in target folder
     * mvn install       → Installs JAR into local repository
     * mvn dependency:tree → Shows dependency hierarchy
     *
     * ===========================================
     * REAL LIFE USE CASES
     * ===========================================
     * Managing Selenium, TestNG, JUnit dependencies
     * Building large enterprise projects
     * Automating testing frameworks
     * Integration with CI/CD tools like Jenkins
     */
}
