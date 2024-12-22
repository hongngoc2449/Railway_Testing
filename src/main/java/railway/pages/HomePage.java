package railway.pages;

import org.openqa.selenium.By;
import railway.constant.Constant;

public class HomePage extends BasePage {
    public void open() {
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
    }

    public void gotoRegisterPage(){
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL + "Account/Register.cshtml");
    }

    public void gotoLoginPage(){
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL + "Account/Login.cshtml");
    }




}
