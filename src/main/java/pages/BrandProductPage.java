package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandProductPage extends PageBase{
    public BrandProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/section/div/div[1]/ol/li[2]")
    public WebElement brand;
    @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/div[4]/div/div[2]/ul/li/a")
    public WebElement viewProdLink;

    public void DetailsOfSelectProduct()
    {
        clickButton(viewProdLink);
    }
}
