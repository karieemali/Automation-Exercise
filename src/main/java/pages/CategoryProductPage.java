package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryProductPage extends ProductsPage{
    public CategoryProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/section/div/div[1]/ol/li[2]")
    public WebElement categoryName;

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/div[4]/div/div[2]/ul/li/a")
    public WebElement viewProductLink;  // category

    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/div[4]/div/div[1]/div[1]/a")
    public WebElement addCart;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    WebElement continueShoppingBtn;

    public void DetailsOfSelectProduct()
    {
        clickButton(viewProductLink);
    }
    public void AddProdCart()
    {
        clickButton(addCart);
    }
    public void stillContinueShopping()
    {
        clickButton(continueShoppingBtn);
    }
}
