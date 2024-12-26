package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageBase{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_product")
    WebElement searchProdTxt;
    @FindBy(id = "submit_search")
    WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[3]/div[1]/h4/a/span")
    public WebElement superCategory;
    @FindBy(xpath = "//*[@id=\"Kids\"]/div/ul/li[1]/a")
    public WebElement supCategory;
    @FindBy(css = "body > section > div > div.row > div.col-sm-3 > div.left-sidebar > div.brands_products > div > ul > li:nth-child(2) > a")
    public WebElement brandName;
    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[4]/div/div[2]/ul/li/a")
    public WebElement viewProduct1Link; //Sleeveless Dress

    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    public WebElement viewProduct2Link;

    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[6]/div/div[2]/ul/li/a")
    public WebElement viewProduct3Link;


    public void searchOneProduct(String prodName)
    {
        sendTxt(searchProdTxt,prodName);
        clickButton(searchBtn);
    }
    public void selectCategory() throws InterruptedException {
        clickButton(superCategory);
        Thread.sleep(1000);
        clickButton(supCategory);
    }
    public void selectBrand()
    {
        clickButton(brandName);
    }
    public void openDetailProduct1Selected()
    {
        clickButton(viewProduct1Link);
    }
    public void openDetailProduct2Selected()
    {
        clickButton(viewProduct2Link);
    }
    public void openDetailProduct3Selected()
    {
        clickButton(viewProduct3Link);
    }
}
