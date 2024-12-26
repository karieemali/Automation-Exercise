package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductsPage extends PageBase{
    public SearchProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/h2")
    public WebElement PageName;
    @FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/p")
    public WebElement prodName;
}
