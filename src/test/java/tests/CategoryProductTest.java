package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductPage;
import pages.HomePage;
import pages.PageBase;
import pages.ProductsPage;


public class CategoryProductTest extends TestBase{
    HomePage homePage;
    ProductsPage productsPage;
    CategoryProductPage categoryProductPage;

    @Test
    public void selectCategoryName() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.openProductsPage();
        productsPage = new ProductsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
        productsPage.selectCategory();
        categoryProductPage = new CategoryProductPage(driver);
        Assert.assertTrue(categoryProductPage.categoryName.getText().contains("Dress"));
    }
}
