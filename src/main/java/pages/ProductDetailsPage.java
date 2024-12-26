package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    WebElement addToCartBtn;
    @FindBy(id = "quantity")
    WebElement quantity;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    WebElement viewCartLink;
    @FindBy(css = "button.btn.btn-success.close-modal.btn-block")
    WebElement continueShoppingBtn;

    //Review Product
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "review")
    WebElement reviewTxt;
    @FindBy(id = "button-review")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id=\"review-section\"]/div/div/span")
    public WebElement thankMsg;

    public void UserCanAddProdToCart()
    {
        clickButton(addToCartBtn);
    }
    public void UserCanChangeQuantity(String val)
    {
        clickButton(quantity);
        clearText(quantity);
        sendTxt(quantity,val);
    }
    public void openCartPage()
    {
        clickButton(viewCartLink);
    }
    public void stillContinueShopping()
    {
        clickButton(continueShoppingBtn);
    }
    public void AddReviewToProd(String Name , String Email ,String Txt)
    {
        sendTxt(name,Name);
        sendTxt(email,Email);
        sendTxt(reviewTxt,Txt);
        clickButton(submitBtn);
    }




}
