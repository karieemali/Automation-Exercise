package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductsToCartTest extends TestBase{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;

    @Test()
    public void UserCanAddProductsToYourCart() throws InterruptedException {

        //Add The First Product
        homePage = new HomePage(driver);
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

        //View Cart
        cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.nameOfFirstProd.getText().equalsIgnoreCase("Sleeveless Dress"));
        Assert.assertTrue(cartPage.salaryOfThirdProd.getText().contains("Rs."));

        cartPage.DeleteOfProduct1();
        Thread.sleep(1000);
        cartPage.DeleteOfProduct2();
        Thread.sleep(1000);
        cartPage.DeleteOfProduct3();
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.emptyCart.getText().equalsIgnoreCase("Cart is empty!"));
    }
}
