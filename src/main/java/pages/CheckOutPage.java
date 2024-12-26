package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[2]")
    public WebElement nameAssert;
    @FindBy(xpath = "//*[@id=\"cart_info\"]/table/tbody/tr[4]/td[3]/h4/b")
    public WebElement TotalAmount;
    @FindBy(className = "form-control")
    WebElement textArea;
    @FindBy(linkText = "Place Order")
    WebElement placeOrderBtn;

    public void AddTxtInTxtArea(String txt)
    {
        sendTxt(textArea,txt);
    }
    public void ClickOnPlaceOrderBtn()
    {
        clickButton(placeOrderBtn);
    }

}
