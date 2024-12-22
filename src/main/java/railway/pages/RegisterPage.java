package railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import railway.constant.Constant;
import railway.model.RegisterForm;
import railway.utils.DriverUtils;

public class RegisterPage extends BasePage {

    By emailTextLocator = By.id("email");
    By passwordTextLocator = By.id("password");
    By confirmPasswordTextLocator = By.id("confirmPassword");
    By pidTextLocator = By.id("pid");
    By registerButtonLocator = By.cssSelector("input[type='submit']");
    By registerSuccessMessageLocator = By.cssSelector("#content p");


    public String getRegisterSuccessMessage(){
        return Constant.WEBDRIVER.findElement(registerSuccessMessageLocator).getText();
    }

   public void register(RegisterForm form){
       enterEmail(form.getEmail());
       enterPassword(form.getPassword());
       enterConfirmPassword(form.getConfirmPassword());
       enterPid(form.getPid());
       DriverUtils.scrollIntoView(getRegisterButton());
       clickRegisterButton();
   }

   private void enterEmail(String email){
       Constant.WEBDRIVER.findElement(emailTextLocator).sendKeys(email);
   }

    private void enterPassword(String password){
         Constant.WEBDRIVER.findElement(passwordTextLocator).sendKeys(password);
    }

    private void enterConfirmPassword(String confirmPassword){
         Constant.WEBDRIVER.findElement(confirmPasswordTextLocator).sendKeys(confirmPassword);
    }

    private void enterPid(String pid){
         Constant.WEBDRIVER.findElement(pidTextLocator).sendKeys(pid);
    }

    private WebElement getRegisterButton(){
        return Constant.WEBDRIVER.findElement(registerButtonLocator);
    }

    private void clickRegisterButton(){
        Constant.WEBDRIVER.findElement(registerButtonLocator).click();
    }
}
