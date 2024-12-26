package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sleeveless Dress")
    public WebElement nameOfFirstProd;
    @FindBy(xpath = "//*[@id=\"product-20\"]/td[4]/button")
    public WebElement quantityOfSecondProd;
    @FindBy(xpath = "//*[@id=\"product-5\"]/td[5]/p")
    public WebElement salaryOfThirdProd;
    @FindBy(xpath = "//*[@id=\"product-3\"]/td[6]/a")
    public WebElement removeOfProd1;
    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a")
    public WebElement removeOfProd2;
    @FindBy(xpath = "//*[@id=\"product-5\"]/td[6]/a")
    public WebElement removeOfProd3;
    @FindBy(xpath = "//*[@id=\"empty_cart\"]/p/b")
    public WebElement emptyCart;
    @FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    public WebElement checkOutBtn;


    public void DeleteOfProduct1()
    {
        clickButton(removeOfProd1);
    }
    public void DeleteOfProduct2()
    {
        clickButton(removeOfProd2);
    }
    public void DeleteOfProduct3()
    {
        clickButton(removeOfProd3);
    }
    public void ClickOnCheckOut()
    {
        clickButton(checkOutBtn);
    }


}
