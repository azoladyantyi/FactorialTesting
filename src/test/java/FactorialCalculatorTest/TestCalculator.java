package FactorialCalculatorTest;

import BaseTest.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator extends Base {

    @Test
    public void testHeadingDisplayed() {
        factorialCalculatorScreen.headingDisplayed();
        screenshots.takesSnapShot(driver, "HeadingDisplayed");
    }

    private String calculateFactorial(int number) {
        if (number < 0) {
            return "Invalid input";
        }
        java.math.BigInteger result = java.math.BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(java.math.BigInteger.valueOf(i));
        }
        return result.toString();
    }

    @Test
    public void verifyFactorialForPositiveNumbers() throws InterruptedException {
        int[] testNumbers = {123};
        for (int number : testNumbers) {
            try {
                factorialCalculatorScreen.enterInput("");
                factorialCalculatorScreen.enterInput(String.valueOf(number));
                factorialCalculatorScreen.clickCalculateButton();
                String expectedResult = "The factorial of " + number + " is: " + calculateFactorial(number);
                Thread.sleep(2000);
                factorialCalculatorScreen.verifyResult(expectedResult);
                screenshots.takesSnapShot(driver, "FactorialInput" + number);
            } catch (AssertionError e) {
                screenshots.takesSnapShot(driver, "FactorialInput" + number + "_FAILED");
                System.out.println("Test failed for number: " + number + " - " + e.getMessage());
                throw e;
            }
        }
    }

    @Test
    public void testNegativeNumber() throws InterruptedException {
        int number = -5;
        try {
            factorialCalculatorScreen.enterInput(String.valueOf(number));
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for negative number " + number + ": " + result);
            screenshots.takesSnapShot(driver, "NegativeNumber_" + number);
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "NegativeNumber_" + number + "_FAILED");
            System.out.println("Test failed for negative number: " + number + " - " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testZero() throws InterruptedException {
        try {
            factorialCalculatorScreen.enterInput("0");
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for zero: " + result);
            screenshots.takesSnapShot(driver, "TestZero");
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "TestZero_FAILED");
            System.out.println("Test failed for zero: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testSpecialCharacters() throws InterruptedException {
        String specialChar = "@";
        try {
            factorialCalculatorScreen.enterInput(specialChar);
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for special character '" + specialChar + "': " + result);
            screenshots.takesSnapShot(driver, "SpecialCharacter_" + specialChar);
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "SpecialCharacter_" + specialChar + "_FAILED");
            System.out.println("Test failed for special character: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testEmptyInput() throws InterruptedException {
        try {
            factorialCalculatorScreen.enterInput("");
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for empty input: " + result);
            screenshots.takesSnapShot(driver, "EmptyInput");
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "EmptyInput_FAILED");
            System.out.println("Test failed for empty input: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testDecimalNumber() throws InterruptedException {
        double number = 5.5;
        try {
            factorialCalculatorScreen.enterInput(String.valueOf(number));
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for decimal number " + number + ": " + result);
            screenshots.takesSnapShot(driver, "DecimalNumber_" + number);
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "DecimalNumber_" + number + "_FAILED");
            System.out.println("Test failed for decimal number: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void testLargeNumber() throws InterruptedException {
        int number = 1000;
        try {
            factorialCalculatorScreen.enterInput(String.valueOf(number));
            factorialCalculatorScreen.clickCalculateButton();
            Thread.sleep(1000);
            String result = factorialCalculatorScreen.getResultText();
            System.out.println("Result for large number " + number + ": " + result);
            screenshots.takesSnapShot(driver, "LargeNumber" + number);
            Assert.assertNotNull(result, "Result should not be null");
        } catch (Exception e) {
            screenshots.takesSnapShot(driver, "LargeNumber_" + number + "_FAILED");
            System.out.println("Test failed for large number: " + e.getMessage());
            throw e;
        }
    }

}