
package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PositiveTestScripts {

    WebDriver driver;

    @FindBy(xpath = "//h1[contains(@class,'text-center') and contains(text(),'factorial')]")
    WebElement TitleXpath;
    @FindBy(id = "number")
    WebElement inputField;

    @FindBy(id = "getFactorial")
    WebElement calculateButton;

    @FindBy(id = "resultDiv")
    WebElement resultDiv;

    public PositiveTestScripts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void headingDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(TitleXpath));
        String expectedHeading = "The greatest factorial calculator!";
        String actualHeading = TitleXpath.getText();
        Assert.assertEquals(actualHeading, expectedHeading, "Heading is not displayed correctly");
    }

    public void clearInputField() {
        inputField.click();
        inputField.clear();
    }

    public void enterInput(String input) {
        clearInputField();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(inputField));
        inputField.sendKeys(input);
    }

    public void clickCalculateButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(calculateButton));

        calculateButton.click();
    }

    public String getResultText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultDiv));
        return resultDiv.getText();
    }

    public void verifyResult(String expectedResult) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultDiv));
        String actualResult = getResultText();
        Assert.assertEquals(actualResult, expectedResult, "Result is not as expected");
    }

    public void verifyFactorialNumericValue(int number) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultDiv));
        String actualResult = getResultText();
        String expectedPrefix = "The factorial of " + number + " is: ";
        String actualValueStr = actualResult.replace(expectedPrefix, "").trim();
        java.math.BigInteger expectedValue = java.math.BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            expectedValue = expectedValue.multiply(java.math.BigInteger.valueOf(i));
        }
        java.math.BigInteger actualValue;
        try {
            // Try parsing as BigInteger
            actualValue = new java.math.BigInteger(actualValueStr);
        } catch (NumberFormatException e) {
            // If scientific notation, parse as double and convert to BigInteger
            java.math.BigDecimal bd = new java.math.BigDecimal(actualValueStr);
            actualValue = bd.toBigInteger();
        }
        Assert.assertEquals(actualValue, expectedValue, "Numeric factorial value is not as expected");
    }

    /**
     * Calculate factorial of a number using BigInteger
     * @param number the number to calculate factorial for
     * @return factorial as BigInteger string
     */
    public String calculateFactorialValue(int number) {
        if (number < 0) {
            return "Invalid input";
        }
        java.math.BigInteger result = java.math.BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(java.math.BigInteger.valueOf(i));
        }
        return result.toString();
    }

    /**
     * Get the actual result text from the result div
     * @return the result text displayed on the page
     */
    public String getActualResultText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(resultDiv));
        return getResultText();
    }

    /**
     * Compare expected and actual factorial results
     * @param number the number for which factorial was calculated
     * @param expectedFactorial the expected factorial value
     */
    public void compareFactorialResults(int number, String expectedFactorial) {
        String actualResult = getActualResultText();
        String expectedResult = "The factorial of " + number + " is: " + expectedFactorial;
        Assert.assertEquals(actualResult, expectedResult, "Factorial result does not match for number: " + number);
    }

    /**
     * Process multiple numbers in sequence for testing 3-digit factorials
     * @param testNumbers array of numbers to test
     */
    public void processMultipleNumbers(int[] testNumbers) throws InterruptedException {
        for (int number : testNumbers) {
            clearInputField();
            enterInput(String.valueOf(number));
            clickCalculateButton();
            Thread.sleep(1500); // Wait for calculation to complete
        }
    }

}