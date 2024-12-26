package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends PageBase{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_gender1")
    WebElement selectTitle;
    @FindBy(id = "password")
    WebElement passVal;
    @FindBy(id = "newsletter")
    WebElement checkBoxNewsletter;
    @FindBy(id = "optin")
    WebElement checkBoxOptin;
    @FindBy(id = "first_name")
    WebElement fName ;
    @FindBy(id = "last_name")
    WebElement lName;
    @FindBy(id = "address1")
    WebElement add;
    @FindBy(id = "country")
    WebElement countryDropDown;
    @FindBy(id = "state")
    WebElement stateVal;
    @FindBy(id = "city")
    WebElement cityVal;
    @FindBy(id = "zipcode")
    WebElement code;
    @FindBy(id = "mobile_number")
    WebElement mobile;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    WebElement createAccountBtn;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    public WebElement MessageError;

    public void userCanRegister (String pass,String firstName ,String lastName ,String address ,String state, String city ,String zipCode, String phone) throws InterruptedException {
        clickButton(selectTitle);
        sendTxt(passVal,pass);
        sendTxt(fName,firstName);
        sendTxt(lName,lastName);
        sendTxt(add,address);
        Select countrySelect = new Select(countryDropDown);
        countrySelect.selectByIndex(1);
        sendTxt(stateVal,state);
        sendTxt(cityVal,city);
        sendTxt(code,zipCode);
        sendTxt(mobile,phone);
        clickButton(createAccountBtn);
        Thread.sleep(1000);
    }
}
