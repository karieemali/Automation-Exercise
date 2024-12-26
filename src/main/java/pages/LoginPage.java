package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //SignUp Elements
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    WebElement nameTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement emailTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signUpBtn;

    //Login Elements
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    WebElement emailAddTxt ;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    WebElement passwordTxt;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    public WebElement errorMessageLogin;

    public void UserCanSelectEmailToRegister(String name,String Email)
    {
        sendTxt(nameTxt,name);
        sendTxt(emailTxt,Email);
        clickButton(signUpBtn);
    }
    public void UserCanLogin(String email ,String pass)
    {
        sendTxt(emailAddTxt,email);
        sendTxt(passwordTxt, pass);
        clickButton(loginBtn);
    }
}
