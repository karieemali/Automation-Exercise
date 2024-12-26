package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utillities.Helper;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    //Initialize drivers
    public static WebDriver driver;

    @BeforeSuite()
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) //هنا لو لقيت ال browser فاضيه بتروح تحط ال قيمه ال موجوده فى testng.xml
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        else if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }

        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.get("https://automationexercise.com");
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }

    //take screenshot when test case fail and add it in the screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException //ITestResult --> return test case result (pass,fail,block)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking ScreenShot......");
            Helper.captureScreenShot(driver,result.getName());
        }
    }
}
