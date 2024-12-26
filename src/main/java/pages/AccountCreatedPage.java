package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends PageBase{
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement messageCreated;
    @FindBy(linkText = "Continue")
    public WebElement continueBtn;

    public void ClickOnContinueButton()
    {
        clickButton(continueBtn);
    }
}
