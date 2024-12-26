package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor jse ;
    //create constructor
    public PageBase (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    //هنا بدل ما كل شويه عمالين نعمل click , sendkey عملنالهم functions
    protected static void clickButton(WebElement button)
    {
        button.click();
    }
    protected static void sendTxt(WebElement txt ,String value)
    {
        txt.sendKeys(value);
    }
    public void scrollToBottom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void clearText(WebElement element)
    {
        element.clear();
    }

}
//aliikareem@gmail.com 123456


