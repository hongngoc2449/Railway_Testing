import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railway.model.Ticket;
import railway.model.User;
import railway.pages.BookTicketPage;
import railway.pages.HomePage;
import railway.pages.LoginPage;
import railway.types.SeatType;
import railway.types.Station;

import java.time.LocalDate;

public class BookTicketTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    BookTicketPage bookTicketPage;
    User user;
    Ticket ticket;

    @BeforeMethod
    public void initData(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        bookTicketPage = new BookTicketPage();

        user = new User("hongngoc2449@gmail.com", "123123123123");
        ticket = new Ticket(
                LocalDate.now().plusDays(5),
                Station.SAI_GON,
                Station.NHA_TRANG,
                SeatType.SOFT_SEAT,
                1
        );
    }

    @Test
    public void verifyBookTicketSuccessfully(){
        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(user);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(ticket);
        Assert.assertEquals(bookTicketPage.getHeaderText(), "Ticket Booked Successfully!");

        Assert.assertEquals(bookTicketPage.getBookedTicket(), ticket, "Booked ticket info is not correct");
    }
}
