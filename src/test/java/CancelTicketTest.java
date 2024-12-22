import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.model.Ticket;
import railway.model.User;
import railway.pages.BookTicketPage;
import railway.pages.HomePage;
import railway.pages.LoginPage;
import railway.pages.MyTicketPage;
import railway.types.SeatType;
import railway.types.Station;

import java.time.LocalDate;

public class CancelTicketTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyTicketPage myTicketPage;
    BookTicketPage bookTicketPage;
    User user;
    Ticket ticket;
    int id;

    @BeforeMethod
    public void initData() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        myTicketPage = new MyTicketPage();
        bookTicketPage = new BookTicketPage();

        user = new User("hongngoc2449@gmail.com", "123123123123");
        ticket = new Ticket(
                LocalDate.now().plusDays(5),
                Station.SAI_GON,
                Station.NHA_TRANG,
                SeatType.SOFT_SEAT,
                1
        );

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(user);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket(ticket);
        id = bookTicketPage.getTicketID();
    }

    @Test
    public void testCancelTicket() {
        bookTicketPage.gotoMyTicketPage();
        myTicketPage.cancelTicketByID(id);
        Assert.assertFalse(myTicketPage.isCancelTicketButtonDisplayed(id));
    }
}