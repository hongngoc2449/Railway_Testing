import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.model.User;
import railway.pages.ChangePasswordPage;
import railway.pages.HomePage;
import railway.pages.LoginPage;

public class ChangePasswordTest extends TestBase {

    HomePage homePage;
    ChangePasswordPage changePasswordPage;
    LoginPage loginPage;
    String newPass;
    User user, newUser;


    @BeforeMethod
    public void initData() {
        homePage = new HomePage();
        changePasswordPage = new ChangePasswordPage();
        loginPage = new LoginPage();

        user = new User("hongngoc2449@gmail.com", "12345678");
        newPass = "123456789";
        newUser = new User(user.getEmail(), newPass);
    }

    @Test
    public void verifyChangePasswordSuccessfully() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(user);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(user.getPassword(), newPass, newPass);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), "Your password has been updated!");
        homePage.logout();
        homePage.gotoLoginPage();
        loginPage.login(newUser);
        Assert.assertEquals(homePage.getGreetingMessage(), "Welcome " + user.getEmail());
    }
}
