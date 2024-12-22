import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import railway.constant.Constant;

public class TestBase {

    @BeforeMethod
    public void setUp(){
        Constant.WEBDRIVER = new ChromeDriver();
    }

    @AfterMethod
    public void cleanUp(){
        Constant.WEBDRIVER.quit();
    }
}
