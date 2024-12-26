package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ReviewProductTest extends TestBase{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]
                {
                        {"karem","kareem@gmail.com","it is good product"}
                };
    }

    @Test(dataProvider = "testData")
    public void UserCanAddReviewProd(String name,String email ,String txt)
    {
        homePage = new HomePage(driver);
        homePage.openProductsPage();
        productsPage = new ProductsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
        productsPage.openDetailProduct1Selected();
        productDetailsPage = new ProductDetailsPage(driver);
        js.executeScript("scrollBy(0,500)");
        productDetailsPage.AddReviewToProd(name,email,txt);
        Assert.assertTrue(productDetailsPage.thankMsg.getText().contains("Thank"));
    }
}
