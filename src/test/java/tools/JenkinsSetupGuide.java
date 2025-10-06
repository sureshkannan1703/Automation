/**
 * --------------------------------------------------------------------
 *  JENKINS COMMANDS & CONFIGURATION STEPS (JAVA + TESTNG + GIT)
 * --------------------------------------------------------------------
 *
 * Use this as a quick command reference for setting up Jenkins
 * for Test Automation projects.
 * --------------------------------------------------------------------
 */

package tools;

class JenkinsSetupCommands {

    /*
     * --------------------------------------------------------------------
     * 1. INSTALLATION
     * --------------------------------------------------------------------
     *
     * WINDOWS:
     *   - Download: https://www.jenkins.io/download/
     *   - Run: jenkins.msi
     *   - Default URL: http://localhost:8080
     *   - Unlock key: C:\Program Files\Jenkins\secrets\initialAdminPassword
     *
     * UBUNTU:
     *   sudo apt update
     *   sudo apt install openjdk-17-jdk
     *   wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
     *   sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
     *   sudo apt update
     *   sudo apt install jenkins
     *   sudo systemctl enable jenkins
     *   sudo systemctl start jenkins
     *   sudo systemctl status jenkins
     *   URL: http://localhost:8080
     *
     * MAC:
     *   brew install jenkins-lts
     *   brew services start jenkins-lts
     *
     * --------------------------------------------------------------------
     * 2. INITIAL SETUP
     * --------------------------------------------------------------------
     *
     * URL: http://localhost:8080
     * Copy admin password from:
     *   C:\Program Files\Jenkins\secrets\initialAdminPassword
     * Select: Install Suggested Plugins
     * Create Admin User
     *
     * --------------------------------------------------------------------
     * 3. TOOL CONFIGURATION
     * --------------------------------------------------------------------
     *
     * Navigate:
     *   Manage Jenkins → Global Tool Configuration
     *
     * JDK:
     *   Name: JDK17
     *   Path: C:\Program Files\Java\jdk-17
     *
     * Maven:
     *   Name: Maven
     *   Path: C:\Program Files\Apache\maven-3.9.6
     *
     * Git:
     *   Path (auto-detected or add manually)
     *
     * --------------------------------------------------------------------
     * 4. CREATE FREESTYLE PROJECT
     * --------------------------------------------------------------------
     *
     * Dashboard → New Item → Freestyle Project
     * Name: AutomationTests
     *
     * Source Code Management → Git
     * Repository URL: https://github.com/<username>/<repo>.git
     * Branches to build: */
    /*main
     * Credentials: Add username/password or token
     *
             * Build → Add Build Step → Invoke top-level Maven targets
     * Goals: clean test
     *
             * Post-build Actions → Publish JUnit test result report
     * Test report XMLs: target/surefire-reports/*.xml
     *
     * Click: Save → Build Now
     *
     * --------------------------------------------------------------------
     * 5. GIT INTEGRATION COMMANDS
     * --------------------------------------------------------------------
     *
     * git init
     * git add .
     * git commit -m "Initial commit"
     * git remote add origin https://github.com/<username>/<repo>.git
     * git branch -M main
     * git push -u origin main
     *
     * --------------------------------------------------------------------
     * 6. MAVEN TEST COMMANDS
     * --------------------------------------------------------------------
     *
     * mvn clean test
     * mvn surefire-report:report
     * mvn site
     *
     * --------------------------------------------------------------------
     * 7. JENKINS PIPELINE CONFIGURATION (JENKINSFILE)
     * --------------------------------------------------------------------
     *
     * pipeline {
     *   agent any
     *   tools {
     *     jdk 'JDK17'
     *     maven 'Maven'
     *   }
     *   stages {
     *     stage('Checkout') {
     *       steps {
     *         git branch: 'main', url: 'https://github.com/<username>/<repo>.git'
     *       }
     *     }
     *     stage('Build & Test') {
     *       steps {
     *         sh 'mvn clean test'
     *       }
     *     }
     *     stage('Report') {
     *       steps {
     *         junit 'target/surefire-reports/*.xml'
     *       }
     *     }
     *   }
     * }
     *
     * --------------------------------------------------------------------
     * 8. JENKINS SERVICE COMMANDS (UBUNTU)
     * --------------------------------------------------------------------
     *
     * sudo systemctl start jenkins
     * sudo systemctl stop jenkins
     * sudo systemctl restart jenkins
     * sudo systemctl enable jenkins
     * sudo systemctl status jenkins
     *
     * --------------------------------------------------------------------
     * 9. JENKINS LOG LOCATION
     * --------------------------------------------------------------------
     *
     * Windows: C:\Program Files\Jenkins\jenkins.err.log
     * Ubuntu : /var/log/jenkins/jenkins.log
     *
     * --------------------------------------------------------------------
     * 10. SCHEDULE BUILDS (CRON)
     * --------------------------------------------------------------------
     *
     * Build Triggers → Build periodically
     * Example:
     *   H/5 * * * *   → every 5 minutes
     *   H 2 * * *     → every day at 2 AM
     *
     * --------------------------------------------------------------------
     * 11. COMMON PLUGINS TO INSTALL
     * --------------------------------------------------------------------
     *
     * - Git Plugin
     * - Maven Integration Plugin
     * - TestNG Results Plugin
     * - JUnit Plugin
     * - Pipeline Plugin
     * - Email Extension Plugin
     * - Allure Jenkins Plugin (optional)
     *
     * --------------------------------------------------------------------
     * 12. WORKSPACE PATH
     * --------------------------------------------------------------------
     *
     * Windows: C:\Program Files\Jenkins\workspace\<JobName>
     * Ubuntu : /var/lib/jenkins/workspace/<JobName>
     *
     * --------------------------------------------------------------------
     * 13. ENVIRONMENT VARIABLES
     * --------------------------------------------------------------------
     *
     * %JENKINS_HOME%
     * Windows: C:\Program Files\Jenkins
     * Ubuntu : /var/lib/jenkins
     *
     * --------------------------------------------------------------------
     * 14. TEST EXECUTION RESULTS
     * --------------------------------------------------------------------
     *
     * Reports stored at:
     *   target/surefire-reports
     * Open in Jenkins:
     *   Job → Build Number → Console Output
     *   Job → Build Number → Test Result
     *
     * --------------------------------------------------------------------
     * END OF COMMAND REFERENCE
     * --------------------------------------------------------------------
     */
    public static void main(String[] args) {
        System.out.println("Refer to the comments in this file for Jenkins command and configuration steps.");
    }
}
