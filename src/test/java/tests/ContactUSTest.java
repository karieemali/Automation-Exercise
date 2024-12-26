package tests;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUSTest extends TestBase{
    HomePage homePage;
    ContactUsPage contactUsPage;

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]
                {
                        {"karem","kareem@gmail.com","Software Testing","i am a software testing engineer"}
                };
    }

    @Test(dataProvider = "testData")
    public void UserCanDoContactUs(String name,String email,String title ,String msg) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openContactUS();
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.UserCanContactUs(name,email,title,msg);
        Alert alert =driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
        Assert.assertTrue(contactUsPage.successMsg.getText().contains("submitted"));
        contactUsPage.RedirectHomePage();
    }
}
