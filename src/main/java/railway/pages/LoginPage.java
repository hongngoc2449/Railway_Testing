package railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import railway.constant.Constant;
import railway.model.User;
import railway.utils.DriverUtils;

public class LoginPage extends BasePage {

    private By emailTextLocator = By.id("username");
    private By passwordTextLocator = By.id("password");
    private By loginButtonLocator = By.cssSelector("input[value='Login']");

    private WebElement getLoginButton(){
        return Constant.WEBDRIVER.findElement(loginButtonLocator);
    }

    public void login(User user){
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        DriverUtils.scrollIntoView(getLoginButton());
        clickLoginButton();

    }

    private void enterEmail(String email){
        Constant.WEBDRIVER.findElement(emailTextLocator).sendKeys(email);
    }

    private void enterPassword(String password){
        Constant.WEBDRIVER.findElement(passwordTextLocator).sendKeys(password);
    }

    private void clickLoginButton(){
        Constant.WEBDRIVER.findElement(loginButtonLocator).click();
    }

}
