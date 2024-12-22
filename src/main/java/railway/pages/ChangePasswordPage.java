package railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import railway.constant.Constant;
import railway.utils.DriverUtils;

public class ChangePasswordPage extends BasePage {

    By currentPassLocator = By.id("currentPassword");
    By newPassLocator = By.id("newPassword");
    By confirmPassLocator = By.id("confirmPassword");
    By changePassButtonLocator = By.cssSelector("input[value='Change Password']");
    By changePassSuccessMessageLocator = By.cssSelector("#ChangePW p");

    public WebElement getChangePasswordButton(){
        return Constant.WEBDRIVER.findElement(changePassButtonLocator);
    }

    public void clickChangePasswordButton(){
        Constant.WEBDRIVER.findElement(changePassButtonLocator).click();
    }

    private void enterCurrentPass(String password){
        Constant.WEBDRIVER.findElement(currentPassLocator).sendKeys(password);
    }

    private void enterNewPass(String newPass){
        Constant.WEBDRIVER.findElement(newPassLocator).sendKeys(newPass);
    }

    private void enterConfirmPass(String confirmPass){
        Constant.WEBDRIVER.findElement(confirmPassLocator).sendKeys(confirmPass);
    }

    public String getChangePasswordSuccessMessage(){
        return Constant.WEBDRIVER.findElement(changePassSuccessMessageLocator).getText();
    }

    public void changePassword(String currentPass, String newPass, String confirmPass){
        enterCurrentPass(currentPass);
        enterNewPass(newPass);
        enterConfirmPass(confirmPass);
        DriverUtils.scrollIntoView(getChangePasswordButton());
        clickChangePasswordButton();
    }
}
