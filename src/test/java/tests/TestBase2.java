package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utillities.Helper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase2 {

    public static String BaseUrl ="https://automationexercise.com/";
    protected ThreadLocal<RemoteWebDriver> driver =null;

    @BeforeClass
    @Parameters(value = {"browser"})
    public void SetUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",browser);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps));
        getDriver().get(BaseUrl);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

//    @AfterClass
//    public void stopDriver()
//    {
//        getDriver().quit();
//        driver.remove();
//    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws IOException //ITestResult --> return test case result (pass,fail,block)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking ScreenShot......");
            Helper.captureScreenShot(getDriver(),result.getName());
        }
    }
}
