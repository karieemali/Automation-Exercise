package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Signup / Login")
    WebElement loginLink;
    @FindBy(linkText = "Logout")
    public WebElement logoutLink;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement nameLogged;
    @FindBy(linkText = "Delete Account")
    public WebElement deleteAccount;
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    public WebElement productsLink;

    //Subscription
    @FindBy(id = "susbscribe_email")
    WebElement emailTxt;
    @FindBy(id = "subscribe")
    WebElement Btn;
    @FindBy(xpath = "//*[@id=\"success-subscribe\"]/div")
    public WebElement confirmMsg;
    @FindBy(linkText = "Contact us")
    WebElement contactUsBtn;

    public void openLoginPage()
    {
        clickButton(loginLink);
    }
    public void UserCanLogout()
    {
        clickButton(logoutLink);
    }
    public void UserCanDeleteAccount()
    {
        clickButton(deleteAccount);
    }
    public void openProductsPage()
    {
        clickButton(productsLink);
    }
    public void AddSubscriptionEmail(String email)
    {
        sendTxt(emailTxt,email);
        clickButton(Btn);
    }
    public void openContactUS()
    {
        clickButton(contactUsBtn);
    }
}
