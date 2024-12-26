package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class UserRegisterWithEmailExistTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]
                {
                        {"karim","karim456@gmail.com"}
                };
    }

    @Test(dataProvider = "testData")
    public void UserCanRegisterWithOldAccount(String name,String email) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserCanSelectEmailToRegister(name,email);
        Thread.sleep(2000);
        signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.MessageError.getText().equalsIgnoreCase("Email Address already exist!"));
    }
}
