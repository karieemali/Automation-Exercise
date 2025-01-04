package tests;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

import static java.sql.DriverManager.getDriver;

public class UserRegisterParallelTesting extends TestBase2
{
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
        homePage = new HomePage(getDriver());
        homePage.openLoginPage();
        loginPage = new LoginPage(getDriver());
        loginPage.UserCanSelectEmailToRegister(firstname,email);
        signUpPage = new SignUpPage(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("scrollBy(0,1500)");
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(getDriver().findElement(By.tagName("body"))).sendKeys(Keys.PAGE_DOWN).perform();
        signUpPage.userCanRegister(password,firstname,lastname,address,state,city,zipCode,phoneNumber);
        accountCreatedPage = new AccountCreatedPage(getDriver());
        Assert.assertTrue(accountCreatedPage.messageCreated.getText().equalsIgnoreCase("Account Created!"));
        accountCreatedPage.ClickOnContinueButton();
        homePage.UserCanLogout();
    }
}
