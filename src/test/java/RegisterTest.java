import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.model.RegisterForm;
import railway.pages.HomePage;
import railway.pages.LoginPage;
import railway.pages.RegisterPage;

public class RegisterTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    RegisterForm registerForm;
    LoginPage loginPage;
    Faker faker;
    String password;
    String pid;


    @BeforeMethod
    public void initData(){
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        faker = new Faker();


        password = faker.numerify("########");
        pid = faker.numerify("########");

        registerForm = new RegisterForm(faker.internet().emailAddress(), password, password, pid);
    }
    @Test
    public void verifyRegisterSuccessfully() {
        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(registerForm);
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "You're here");
        registerPage.gotoLoginPage();
        loginPage.login(registerForm.toUser());
        Assert.assertEquals(homePage.getGreetingMessage(), "Welcome " + registerForm.getEmail());
    }
}
