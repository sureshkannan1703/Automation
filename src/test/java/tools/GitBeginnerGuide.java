/**
 * --------------------------------------------------------------------
 *  GIT COMPLETE GUIDE FOR BEGINNERS (With Commands + Explanations)
 * --------------------------------------------------------------------
 *
 * Author  : Suresh Kannan
 * Purpose : To provide detailed Git commands with usage and examples
 *            suitable for Test Automation, Jenkins CI/CD, and Java projects.
 * --------------------------------------------------------------------
 */

package tools;

public class GitBeginnerGuide {

    /*
     * --------------------------------------------------------------------
     * 1. INSTALLATION
     * --------------------------------------------------------------------
     *
     * WINDOWS:
     *   Download Git installer:
     *     https://git-scm.com/download/win
     *   During setup, select "Use Git from command line"
     *
     * UBUNTU:
     *   sudo apt update
     *   sudo apt install git -y
     *
     * MAC:
     *   brew install git
     *
     * Verify installation:
     *   git --version
     *   (Output example: git version 2.45.0)
     *
     * --------------------------------------------------------------------
     * 2. INITIAL SETUP (ONE-TIME)
     * --------------------------------------------------------------------
     *
     * Configure your username and email (used in commit messages):
     *
     *   git config --global user.name "Suresh Kannan"
     *   git config --global user.email "suresh@example.com"
     *
     * Verify your configuration:
     *   git config --list
     *
     * --------------------------------------------------------------------
     * 3. CREATE A LOCAL REPOSITORY
     * --------------------------------------------------------------------
     *
     * Step 1: Create or go to your project folder
     *   cd D:\Projects\Automation
     *
     * Step 2: Initialize Git repository
     *   git init
     *   (Creates a hidden .git folder → means Git is tracking this folder)
     *
     * Step 3: Add files to staging area
     *   git add filename.java       → adds one file
     *   git add .                   → adds all files in the folder
     *
     * Step 4: Commit changes (save in Git history)
     *   git commit -m "Initial commit"
     *
     * Step 5: Check status
     *   git status
     *   (Shows which files are staged, modified, or untracked)
     *
     * --------------------------------------------------------------------
     * 4. CONNECT TO REMOTE REPOSITORY (GITHUB)
     * --------------------------------------------------------------------
     *
     * Step 1: Create a new repository in GitHub (without README)
     * Step 2: Copy the HTTPS URL (example below)
     *         https://github.com/sureshkannan/AutomationProject.git
     *
     * Step 3: Link local Git to remote GitHub repository
     *   git remote add origin https://github.com/sureshkannan/AutomationProject.git
     *
     * Step 4: Verify connection
     *   git remote -v
     *
     * Step 5: Rename default branch (optional)
     *   git branch -M main
     *
     * Step 6: Push your code to GitHub
     *   git push -u origin main
     *
     *   (-u means “set upstream”, so future pushes can use just `git push`)
     *
     * --------------------------------------------------------------------
     * 5. CLONE EXISTING PROJECT
     * --------------------------------------------------------------------
     *
     * To copy someone’s repository into your local machine:
     *   git clone https://github.com/<username>/<repo>.git
     *
     * Example:
     *   git clone https://github.com/sureshkannan/AutomationProject.git
     *
     * This creates a folder “AutomationProject” with all files and Git history.
     *
     * --------------------------------------------------------------------
     * 6. COMMON DAY-TO-DAY COMMANDS
     * --------------------------------------------------------------------
     *
     * View current branch:
     *   git branch
     *
     * Create a new branch:
     *   git branch feature/login
     *
     * Switch to that branch:
     *   git checkout feature/login
     *
     * Create and switch in one step:
     *   git checkout -b feature/login
     *
     * Add and commit changes:
     *   git add .
     *   git commit -m "Added login feature"
     *
     * Push new branch to GitHub:
     *   git push -u origin feature/login
     *
     * Merge branch back into main:
     *   git checkout main
     *   git merge feature/login
     *
     * Delete branch (after merge):
     *   git branch -d feature/login
     *
     * --------------------------------------------------------------------
     * 7. CHECKING HISTORY AND DIFFERENCES
     * --------------------------------------------------------------------
     *
     * View commit history:
     *   git log
     *
     * Compact one-line view:
     *   git log --oneline
     *
     * View changes made to files:
     *   git diff
     *
     * Compare two commits:
     *   git diff <commit1> <commit2>
     *
     * --------------------------------------------------------------------
     * 8. UPDATE CODE FROM GITHUB
     * --------------------------------------------------------------------
     *
     * Pull latest code from main branch:
     *   git pull origin main
     *
     * (Use before pushing to avoid conflicts)
     *
     * --------------------------------------------------------------------
     * 9. UNDO / FIX MISTAKES
     * --------------------------------------------------------------------
     *
     * Undo staged file (move back to unstaged):
     *   git reset filename.java
     *
     * Undo last commit (keep changes):
     *   git reset --soft HEAD~1
     *
     * Undo last commit completely (delete changes):
     *   git reset --hard HEAD~1
     *
     * Revert a specific commit:
     *   git revert <commit-id>
     *
     * --------------------------------------------------------------------
     * 10. GITIGNORE (TO IGNORE UNNECESSARY FILES)
     * --------------------------------------------------------------------
     *
     * Create a file named `.gitignore`
     *
     * Add these lines to ignore:
     *   target/
     *   *.class
     *   .idea/
     *   *.log
     *
     * Commit it once:
     *   git add .gitignore
     *   git commit -m "Added gitignore"
     *
     * --------------------------------------------------------------------
     * 11. TAGGING (FOR VERSION RELEASES)
     * --------------------------------------------------------------------
     *
     * Create a simple tag:
     *   git tag v1.0
     *
     * Create tag with message:
     *   git tag -a v1.0 -m "First stable release"
     *
     * List all tags:
     *   git tag
     *
     * Push tag to GitHub:
     *   git push origin v1.0
     *   (or) git push origin --tags
     *
     * --------------------------------------------------------------------
     * 12. TEMPORARY SAVE (STASH)
     * --------------------------------------------------------------------
     *
     * Save uncommitted changes temporarily:
     *   git stash
     *
     * List stashes:
     *   git stash list
     *
     * Apply saved stash:
     *   git stash apply
     *
     * Delete applied stash:
     *   git stash drop
     *
     * --------------------------------------------------------------------
     * 13. BRANCH MERGE CONFLICT HANDLING
     * --------------------------------------------------------------------
     *
     * If you merge and see conflict messages:
     *   git merge feature/login
     *
     * Open the conflicted file → manually fix between:
     *   <<<<<<< HEAD
     *   =======
     *   >>>>>>>
     *
     * After fixing:
     *   git add .
     *   git commit -m "Resolved merge conflict"
     *
     * --------------------------------------------------------------------
     * 14. GIT + JENKINS AUTOMATION
     * --------------------------------------------------------------------
     *
     * In Jenkins job configuration:
     *   Source Code Management → Git
     *   Repository URL: https://github.com/<username>/<repo>.git
     *   Credentials: (Add token if private)
     *   Branch: */
    /*main
     *
     * Jenkins automatically performs:
     *   git fetch origin
     *   git checkout main
     *   mvn clean test
     *
     * --------------------------------------------------------------------
     * 15. BEST PRACTICES
     * --------------------------------------------------------------------
     *
     * - Always pull before pushing:  git pull origin main
     * - Write clear commit messages
     * - Create feature branches for new work
     * - Use .gitignore to skip unnecessary files
     * - Avoid committing build or log files
     *
     * --------------------------------------------------------------------
     * 16. QUICK WORKFLOW SUMMARY
     * --------------------------------------------------------------------
     *
     * Step 1: git init
     * Step 2: git add .
     * Step 3: git commit -m "Initial commit"
     * Step 4: git remote add origin <repo-url>
     * Step 5: git push -u origin main
     * Step 6: git pull origin main  (before new updates)
     * Step 7: git branch feature/xyz
     * Step 8: git merge feature/xyz
     * Step 9: git log --oneline
     *
     * --------------------------------------------------------------------
     * END OF FILE
     * --------------------------------------------------------------------
     */
    public static void main(String[] args) {
        System.out.println("Refer to this file for beginner Git commands with clear explanations.");
    }
}
