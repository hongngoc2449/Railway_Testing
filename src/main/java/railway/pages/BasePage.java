package railway.pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import railway.constant.Constant;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {

    private By loginTabLocator = By.xpath("//a[span[text()='Login']]");
    private By registerTabLocator = By.xpath("//a[span[text()='Register']]");
    private By bookTicketTabLocator = By.xpath("//a[span[text()='Book ticket']]");
    private By myTicketTabLocator = By.xpath("//a[span[text()='My ticket']]");
    private By changePasswordTabLocator = By.xpath("//a[span[text()='Change password']]");
    private By logoutTabLocator = By.xpath("//a[span[text()='Log out']]");
    private By greetingLabelLocator = By.cssSelector("div.account strong");
    private By headerLocator = By.tagName("h1");

    public String getHeaderText(){
        return Constant.WEBDRIVER.findElement(headerLocator).getText();
    }

    public void gotoLoginPage() {
        Constant.WEBDRIVER.findElement(loginTabLocator).click();
    }
    public void gotoRegisterPage(){
        Constant.WEBDRIVER.findElement(registerTabLocator).click();
    }

    public void gotoBookTicketPage(){
        Constant.WEBDRIVER.findElement(bookTicketTabLocator).click();
    }

    public void gotoMyTicketPage() {
        Constant.WEBDRIVER.findElement(myTicketTabLocator).click();
    }

    public void gotoChangePasswordPage() {
        Constant.WEBDRIVER.findElement(changePasswordTabLocator).click();
    }

    public String getGreetingMessage() {
        return Constant.WEBDRIVER.findElement(greetingLabelLocator).getText();
    }

    public void logout() {
        Constant.WEBDRIVER.findElement(logoutTabLocator).click();
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(5));
        wait.until(driver -> driver.findElement(loginTabLocator).isDisplayed());
    }
}
