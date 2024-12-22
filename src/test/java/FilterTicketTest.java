import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.model.Filter;
import railway.model.User;
import railway.pages.HomePage;
import railway.pages.LoginPage;
import railway.pages.MyTicketPage;
import railway.types.Station;
import railway.types.Status;

public class FilterTicketTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyTicketPage myTicketPage;
    User user;
    Filter filter;

    @BeforeMethod
    public void initData() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        myTicketPage = new MyTicketPage();

        user = new User("hongngoc2449@gmail.com", "123456789");
        filter = new Filter(
                Station.SAI_GON,
                Station.NHA_TRANG,
                "2024-12-27",
                Status.IGNORE);
    }

    @Test
    public void verifyFilterTicketSuccessfully() {
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(user);
        loginPage.gotoMyTicketPage();
        myTicketPage.filterTicket(filter);
        Assert.assertEquals(myTicketPage.getFilterTicketResult(), filter, "Filter result is not correct");
    }

}
