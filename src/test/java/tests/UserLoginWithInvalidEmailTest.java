package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class UserLoginWithInvalidEmailTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]
                {
                        {"kar@gmail.com","123456"}
                };
    }

    @Test(dataProvider = "testData")
    public void UserCanLoginInSuccessfully(String emailAddress , String password)
    {
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserCanLogin(emailAddress,password);
        Assert.assertTrue(loginPage.errorMessageLogin.getText().equalsIgnoreCase("Your email or password is incorrect!"));
    }
}
