package Utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.open;


public class ChromeRunner {

    @BeforeMethod (description = "Configure before browser test")
    public void setUp(){
        Configuration.browserSize = "1920x1080";
        open("https://officemart.ge/ge");
    }
    @AfterMethod (description = "Close browser and cookies")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}
