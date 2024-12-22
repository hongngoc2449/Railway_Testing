import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.constant.Constant;
import railway.model.User;
import railway.pages.HomePage;
import railway.pages.LoginPage;

public class RailwayTest {
    HomePage homePage;
    LoginPage loginPage;
    User user;

    @BeforeMethod
    public void setUp(){
        System.out.print("Init Data\n");
        Constant.WEBDRIVER = new ChromeDriver();

        homePage = new HomePage();
        loginPage = new LoginPage();
        user = new User("hongngoc2449@gmail.com", "123456789");
    }

    @AfterMethod
    public void testDown(){
        System.out.print("Clean up driver");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void testSelenium() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(user);
        Assert.assertEquals(homePage.getGreetingMessage(), "Welcome " + user.getEmail());
    }
}
