package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.SearchProductsPage;

public class SearchProductTest extends TestBase{

    HomePage homePage;
    ProductsPage productsPage;
    SearchProductsPage searchProductsPage;
    String productName ="Blue Top";

    @Test
    public void UserCanSearchToProduct()
    {
        homePage = new HomePage(driver);
        homePage.openProductsPage();
        productsPage = new ProductsPage(driver);
        productsPage.searchOneProduct(productName);
        searchProductsPage = new SearchProductsPage(driver);
        Assert.assertTrue(searchProductsPage.PageName.getText().equalsIgnoreCase("Searched Products"));
        Assert.assertTrue(searchProductsPage.prodName.getText().equalsIgnoreCase(productName));
    }
}
