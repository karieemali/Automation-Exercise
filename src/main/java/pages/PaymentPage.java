package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "name_on_card")
    WebElement nameOnCardTxt;
    @FindBy(name = "card_number")
    WebElement cardNum;
    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[1]/input")
    WebElement cvc;
    @FindBy(name = "expiry_month")
    WebElement expiryMonth;
    @FindBy(name = "expiry_year")
    WebElement expiryYear;
    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement confirmOrderBtn;

    public void PaymentMethod(String name , String num , String Cvc , String month , String year )
    {
        sendTxt(nameOnCardTxt,name);
        sendTxt(cardNum, String.valueOf(num));
        sendTxt(cvc, String.valueOf(Cvc));
        sendTxt(expiryMonth, String.valueOf(month));
        sendTxt(expiryYear, String.valueOf(year));
        clickButton(confirmOrderBtn);
    }
}
