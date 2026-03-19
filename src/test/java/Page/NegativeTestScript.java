package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NegativeTestScript {

    WebDriver driver;

    @FindBy(id = "number")
    WebElement inputField;

    @FindBy(id = "getFactorial")
    WebElement calculateButton;

    @FindBy(id = "resultDiv")
    WebElement resultDiv;

    public NegativeTestScript(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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


    public void testNegativeNumber(int number) throws InterruptedException {
        enterInput(String.valueOf(number));
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for negative number " + number + ": " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }


    public void testZero() throws InterruptedException {
        enterInput("0");
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for zero: " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }


    public void testSpecialCharacters(String specialChar) throws InterruptedException {
        enterInput(specialChar);
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for special character '" + specialChar + "': " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }


    public void testEmptyInput() throws InterruptedException {
        enterInput("");
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for empty input: " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }


    public void testDecimalNumber(double number) throws InterruptedException {
        enterInput(String.valueOf(number));
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for decimal number " + number + ": " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }


    public void testLargeNumber(int number) throws InterruptedException {
        enterInput(String.valueOf(number));
        clickCalculateButton();
        Thread.sleep(1000);
        String result = getResultText();
        System.out.println("Result for large number " + number + ": " + result);
        Assert.assertNotNull(result, "Result should not be null");
    }

}