package BaseTest;

import Page.NegativeTestScript;
import Page.PositiveTestScripts;
import Utilities.BrowserFactory;
import Utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://qainterview.pythonanywhere.com/";
    public final String browserChoice = "chrome";

    public WebDriver driver;
    public PositiveTestScripts factorialCalculatorScreen;
    public NegativeTestScript negativeTestScript;
    public Screenshots screenshots;


    @BeforeClass
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        factorialCalculatorScreen  =new PositiveTestScripts(driver);
        screenshots = new Screenshots();
    }

    @AfterClass
    public void tearDown() {
        browserFactory.closeBrowser();
    }

}