package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubscriptionEmailTest extends TestBase{

    HomePage homePage;

    @Test
    public void UserCanSubscriptionEmail()
    {
        homePage = new HomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2500)");
        homePage.AddSubscriptionEmail("aliikareem57@gmail.com");
        Assert.assertTrue(homePage.confirmMsg.getText().contains("successfully"));
    }
}
