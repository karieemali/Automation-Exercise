package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    PaymentPage paymentPage;
    PaymentDonePage paymentDonePage;
    String emailAddress ="aliikareem@gmail.com";
    String password ="123456";
    String name ="karim";



    @Test(priority = 1)
    public void UserCanLogin()
    {
        //Login
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserCanLogin(emailAddress, password);
        Assert.assertTrue(homePage.nameLogged.getText().contains(name));
    }

    @Test(priority = 2)
    public void UserCanAddProducts()
    {
        //Add The First Product
        homePage.openProductsPage();
        productsPage = new ProductsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
        productsPage.openDetailProduct1Selected();
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.UserCanAddProdToCart();
        productDetailsPage.stillContinueShopping();
        homePage.openProductsPage();
        js.executeScript("scrollBy(0,500)");

        //Add The Second Product
        productsPage.openDetailProduct2Selected();
        productDetailsPage.UserCanChangeQuantity("2");
        productDetailsPage.UserCanAddProdToCart();
        productDetailsPage.stillContinueShopping();
        homePage.openProductsPage();
        js.executeScript("scrollBy(0,1000)");

        //Add The Third Product
        productsPage.openDetailProduct3Selected();
        productDetailsPage.UserCanChangeQuantity("3");
        productDetailsPage.UserCanAddProdToCart();
        productDetailsPage.openCartPage();
    }

    @Test(priority = 3)
    public void UserCanCheckOutPayment() throws InterruptedException {
        //View Cart
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.nameOfFirstProd.getText().equalsIgnoreCase("Sleeveless Dress"));
        Assert.assertTrue(cartPage.salaryOfThirdProd.getText().contains("Rs."));
        cartPage.ClickOnCheckOut();
        checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(checkOutPage.nameAssert.getText().equalsIgnoreCase(". karim abdalsalam"));
        Assert.assertTrue(checkOutPage.TotalAmount.getText().contains("Total"));
        checkOutPage.AddTxtInTxtArea("Very Good Order Details");
        checkOutPage.ClickOnPlaceOrderBtn();

        paymentPage = new PaymentPage(driver);
        paymentPage.PaymentMethod("karem","2468","131","1","2025");

        paymentDonePage = new PaymentDonePage(driver);
        Assert.assertTrue(paymentDonePage.messageSuccessful.getText().contains("order has been confirmed"));
        paymentDonePage.DownloadPayment();

        //Logout
        homePage.UserCanLogout();
    }
}

