package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;

public class PaymentDonePage extends PageBase{
    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p")
    public WebElement messageSuccessful;
    @FindBy(linkText = "Download Invoice")
    static
    WebElement downloadInvoiceBtn;
    @FindBy(linkText = "Continue")
    static
    WebElement continueBtn;

    public static ChromeOptions DownloadPayment() throws InterruptedException {
        String downloadPath = System.getProperty("user.dir")+"/src/Downloads"; // Ensure this directory exists

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<String,Object>();
        prefs.put("profile.default.content_settings.popups",0);
        prefs.put("download.default_directory", downloadPath);
        // prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs",prefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        clickButton(downloadInvoiceBtn);
        Thread.sleep(1000);
        clickButton(continueBtn);
        return options;
    }

}
