package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver startBrowser(String browserChoice, String url) {
        if (browserChoice.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserChoice.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        } else {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}