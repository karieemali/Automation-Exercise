package tests;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class UserRegisterTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountCreatedPage accountCreatedPage;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String address = fakeData.address().streetAddress();
    String city = fakeData.address().city();
    String state = fakeData.address().state();
    String zipCode = fakeData.address().zipCode();
    String phoneNumber = fakeData.phoneNumber().phoneNumber();


    @Test()
    public void UserCanRegisterSucessfully() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserCanSelectEmailToRegister(firstname,email);
        signUpPage = new SignUpPage(driver);
        signUpPage.userCanRegister(password,firstname,lastname,address,state,city,zipCode,phoneNumber);
        accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.messageCreated.getText().equalsIgnoreCase("Account Created!"));
        accountCreatedPage.ClickOnContinueButton();
        homePage.UserCanLogout();
    }
}
