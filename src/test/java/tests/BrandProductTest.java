package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandProductPage;
import pages.CategoryProductPage;
import pages.HomePage;
import pages.ProductsPage;

public class BrandProductTest extends TestBase{

    HomePage homePage;
    ProductsPage productsPage;
    BrandProductPage brandProductPage;

    @Test
    public void selectBrandName() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openProductsPage();
        productsPage = new ProductsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
        productsPage.selectBrand();
        brandProductPage = new BrandProductPage(driver);
        Assert.assertTrue(brandProductPage.brand.getText().equalsIgnoreCase("H&M"));
    }
}
