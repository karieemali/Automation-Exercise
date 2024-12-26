package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[1]/input")
    WebElement nameTxt;
    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
    WebElement emailTxt;
    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
    WebElement subjectTxt;
    @FindBy(id = "message")
    WebElement msgTxt;
    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    public WebElement successMsg;
    @FindBy(xpath = "//*[@id=\"form-section\"]/a/span")
    WebElement redirectHome;

    public void UserCanContactUs(String name , String email , String sub , String msg)
    {
        sendTxt(nameTxt,name);
        sendTxt(emailTxt,email);
        sendTxt(subjectTxt,sub);
        sendTxt(msgTxt,msg);
        clickButton(submitBtn);
    }
    public void RedirectHomePage()
    {
        clickButton(redirectHome);
    }
}
