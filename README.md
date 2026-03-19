# Factorial Application - Test Automation Framework

A comprehensive test automation framework for testing a Factorial Calculator application using Selenium WebDriver, TestNG, and ExtentReports.

## 📋 Table of Contents

- [Prerequisites](#prerequisites)
- [How to Clone](#how-to-clone)
- [Project Structure](#project-structure)
- [Important Tools & Technologies](#important-tools--technologies)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Generating & Viewing Reports](#generating--viewing-reports)
- [Screenshots](#screenshots)
- [Project Features](#project-features)

---

## Prerequisites

Before getting started, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 21 or higher
- **Apache Maven**: Version 3.6.0 or higher
- **Git**: For cloning the repository
- **Google Chrome Browser**: Latest version (for Selenium WebDriver tests)
- **ChromeDriver**: Compatible with your Chrome version (automatically handled by Selenium)

---

## How to Clone

### Step 1: Open Command Prompt or PowerShell

Navigate to the directory where you want to clone the project:

```powershell
cd C:\Users\YourUsername\Documents
```

### Step 2: Clone the Repository

```powershell
git clone https://github.com/azoladyantyi/FactorialApplication.git
```

### Step 3: Navigate to Project Directory

```powershell
cd FactorialApplication
```

### Step 4: Verify Maven Installation

```powershell
mvn --version
```

You should see Maven version information displayed.

---

## Project Structure

```
FactorialApplication/
│
├── pom.xml                                 # Maven configuration file with dependencies
├── README.md                               # Project documentation
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/
│   │   │       └── Main.java              # Main application class
│   │   └── resources/                     # Application resources
│   │
│   └── test/
│       ├── java/
│       │   ├── BaseTest/
│       │   │   └── Base.java              # Base class with @BeforeClass and @AfterClass setup
│       │   │
│       │   ├── ExtentReports/
│       │   │   ├── ExtentReportManager.java   # Manages ExtentReports configuration
│       │   │   └── Listener.java              # TestNG listener for report generation
│       │   │
│       │   ├── FactorialCalculatorTest/
│       │   │   └── TestCalculator.java    # Main test cases for factorial calculation
│       │   │
│       │   ├── Page/
│       │   │   ├── PositiveTestScripts.java   # Page Object Model for positive tests
│       │   │   └── NegativeTestScript.java    # Page Object Model for negative tests
│       │   │
│       │   └── Utilities/
│       │       ├── BrowserFactory.java    # Initializes WebDriver instances
│       │       └── Screenshots.java       # Captures screenshots for reports
│       │
│       └── testng.xml                     # TestNG configuration file
│
├── target/                                 # Compiled classes and reports (generated)
│   ├── classes/
│   ├── test-classes/
│   └── surefire-reports/                  # Test execution reports
│
└── test-output/
    └── emailable-report.html              # ExtentReports HTML report
```

### Directory Descriptions

| Directory | Purpose |
|-----------|---------|
| `src/main/java` | Main application source code |
| `src/test/java` | All test automation code |
| `BaseTest` | Base class with browser initialization and teardown |
| `ExtentReports` | Report generation and listener configuration |
| `FactorialCalculatorTest` | Test case implementations |
| `Page` | Page Object Model classes for UI interactions |
| `Utilities` | Helper classes for browser and screenshot management |
| `target` | Build output and compiled classes |
| `test-output` | Generated test reports |

---

## Important Tools & Technologies

### 🔧 Core Testing Tools

| Tool | Version | Purpose |
|------|---------|---------|
| **Selenium WebDriver** | 4.41.0 | Browser automation and UI interaction testing |
| **TestNG** | 7.12.0 | Test framework for organizing and executing tests |
| **ExtentReports** | 5.1.2 | Professional HTML test report generation with screenshots |
| **Apache POI** | 5.5.1 | Excel file handling (if needed for data-driven testing) |
| **Maven** | 3.6.0+ | Build automation and dependency management |
| **Java** | 21+ | Programming language |

### Why These Tools?

- **Selenium WebDriver**: Industry-standard for web automation across all browsers
- **TestNG**: Powerful test framework with annotations, parallel execution, and data-driven testing
- **ExtentReports**: Creates visually appealing, interactive HTML reports with screenshot attachments
- **Apache POI**: Allows reading/writing Excel data for parameterized tests
- **Maven**: Simplifies dependency management and build processes

---

## Setup & Installation

### Step 1: Install Dependencies

Navigate to your project directory and run:

```powershell
mvn clean install
```

This command will:
- Clean previous build artifacts
- Download all required dependencies from Maven Central Repository
- Compile the source code
- Run any tests (can be skipped with `-DskipTests`)

### Step 2: Verify Installation

```powershell
mvn dependency:tree
```

This displays all project dependencies in a tree format.

### Step 3: Update WebDriver (Optional)

If you want to use WebDriverManager for automatic ChromeDriver management, add this dependency to `pom.xml`:

```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.3</version>
</dependency>
```

---

## Running Tests

### Run All Tests

```powershell
mvn test
```

### Run Specific Test Class

```powershell
mvn test -Dtest=TestCalculator
```

### Run Specific Test Method

```powershell
mvn test -Dtest=TestCalculator#verifyFactorialForPositiveNumbers
```

### Run Tests Without Screenshots

```powershell
mvn test -DskipScreenshots=true
```

### Run Tests from testng.xml (Recommended)

```powershell
mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
```

### Run Tests with Maven Surefire Plugin

```powershell
mvn clean verify
```

---

## Generating & Viewing Reports

### Automatic Report Generation

Reports are automatically generated when tests run. The framework uses:

1. **ExtentReports** - For detailed HTML reports with screenshots
2. **Surefire Reports** - For Maven test result reports

### Locate the Reports

#### ExtentReports (Recommended)

After running tests, the report is located at:

```
target/test-output/emailable-report.html
```

**To view:**
1. Navigate to the file location
2. Right-click on `emailable-report.html`
3. Select "Open with" → Your preferred browser
4. Or use PowerShell:
   ```powershell
   Start-Process "target/test-output/emailable-report.html"
   ```

#### Surefire Reports

Located at:

```
target/surefire-reports/
```

Contains:
- `index.html` - Test execution summary
- XML files - Detailed test results

### Report Features

The ExtentReports HTML report includes:

✅ **Test Execution Summary**
- Total tests run
- Pass/Fail counts
- Execution duration
- Pass percentage

✅ **Detailed Test Information**
- Test name and status (Pass/Fail)
- Execution time
- Error messages and stack traces
- Test logs and information

✅ **Screenshots**
- Captured at each step
- Full-page screenshots on test failure
- Embedded in the HTML report
- Click-to-expand for detailed view

✅ **Interactive Dashboard**
- Filter by status (Passed/Failed)
- Search functionality
- Timeline view
- Category grouping

---

## Screenshots

### How Screenshots Work in This Framework

#### **Screenshot Capture Points**

Screenshots are captured at critical test steps:

```java
// Example from test code
factorialCalculatorScreen.headingDisplayed();
screenshots.takesSnapShot(driver, "HeadingDisplayed");  // Captures screenshot
```

#### **Screenshot Storage**

All screenshots are saved in:

```
test-output/screenshots/
```

Example naming convention:
- `HeadingDisplayed_2024-03-18_14-35-22.png`
- `FactorialCalculation_PASS_2024-03-18_14-36-01.png`
- `InputField_FAIL_2024-03-18_14-36-45.png`

#### **Screenshots in Reports**

- **Embedded in HTML Report**: All screenshots are automatically embedded in the ExtentReports HTML
- **Easy Navigation**: Click on screenshot thumbnails to view full-size images
- **Failure Evidence**: Automatic screenshots on test failure
- **Step-by-Step Proof**: Shows application state at each test step

#### **Capturing Screenshots Manually**

In your test code:

```java
@Test
public void myTest() {
    // Perform actions
    factorialCalculatorScreen.enterNumber(123);
    
    // Capture screenshot
    screenshots.takesSnapShot(driver, "AfterNumberEntry");
    
    // Continue testing
    factorialCalculatorScreen.clickCalculate();
    screenshots.takesSnapShot(driver, "AfterCalculation");
}
```

#### **Automatic Screenshot on Failure**

The Listener class automatically captures screenshots when tests fail:

```java
// Automatically triggered
screenshots.takesSnapShot(driver, "TestFailure_" + result.getName());
```

---

## Project Features

### ✨ Test Automation Features

1. **Factorial Calculator Testing**
   - Tests for positive numbers (1-4 digits)
   - Input validation
   - Result verification
   - Multi-step testing with clean fields

2. **Page Object Model (POM)**
   - Separation of test logic and UI interactions
   - Easy maintenance and reusability
   - Located in `Page/` directory

3. **Data-Driven Testing**
   - Test multiple values in single test
   - Support for Excel files (Apache POI)
   - Parameterized test cases

4. **Comprehensive Reporting**
   - ExtentReports with visual dashboard
   - Screenshot attachments
   - Detailed test logs
   - Execution timeline

5. **Browser Automation**
   - Selenium WebDriver integration
   - Chrome browser support
   - Automatic driver management

6. **Test Organization**
   - BaseTest class for common setup
   - TestNG annotations for test management
   - testng.xml for test suite configuration

---

## Quick Start Guide

```powershell
# 1. Clone the repository
git clone https://github.com/your-username/FactorialApplication.git
cd FactorialApplication

# 2. Install dependencies
mvn clean install

# 3. Run all tests
mvn test

# 4. Open the HTML report
Start-Process "target/test-output/emailable-report.html"
```

---

## Troubleshooting

### Issue: Tests not running

**Solution:**
```powershell
mvn clean test -DskipTests=false
```

### Issue: ChromeDriver not found

**Solution:**
- Ensure Chrome browser is installed
- Or add WebDriverManager dependency (see Setup section)

### Issue: Report not generated

**Solution:**
```powershell
mvn clean test -e
```
This generates error logs for debugging

### Issue: Screenshots not appearing in report

**Solution:**
- Check if screenshot directory exists: `target/test-output/screenshots/`
- Ensure `takesSnapShot()` method is being called
- Verify file permissions in the target directory

---

## Additional Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [ExtentReports Documentation](https://www.extentreports.com/)
- [Apache Maven Guide](https://maven.apache.org/guides/)

---

## Support

For issues or questions:

1. Check the troubleshooting section
2. Review test execution logs in `target/surefire-reports/`
3. Check ExtentReports HTML for detailed failure information
4. Review screenshots in `test-output/screenshots/`

---

**Last Updated:** March 18, 2026  
**Project Version:** 1.0-SNAPSHOT

