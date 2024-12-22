package railway.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import railway.constant.Constant;
import railway.model.Filter;
import railway.types.Station;
import railway.types.Status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyTicketPage extends BasePage {

    By departStationLocator = By.name("FilterDpStation");
    By arriveStationLocator = By.name("FilterArStation");
    By departDateLocator = By.name("FilterDpDate");
    By statusLocator = By.name("FilterStatus");
    By applyButtonLocator = By.cssSelector("input[type='submit']");

    public void cancelTicketByID(int id) {
        By cancelButton = By.xpath(String.format("//input[@value='Cancel'][@onclick='DeleteTicket(%d);']", id));
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].click();", Constant.WEBDRIVER.findElement(cancelButton));
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }

    public boolean isCancelTicketButtonDisplayed(int id) {
        By cancelButton = By.xpath(String.format("//input[@value='Cancel'][@onclick='DeleteTicket(%d);']", id));
        return !Constant.WEBDRIVER.findElements(cancelButton).isEmpty();
    }

    public void selectDepartStation(Station station){
        Select select = new Select(Constant.WEBDRIVER.findElement(departStationLocator));
        select.selectByVisibleText(station.getText());
    }

    public void selectArriveStation(Station station){
        Select select = new Select(Constant.WEBDRIVER.findElement(arriveStationLocator));
        select.selectByVisibleText(station.getText());
    }

    public void selectDepartDate(LocalDate date) {
        Constant.WEBDRIVER.findElement(departDateLocator).sendKeys(date.format(Constant.FORMATTER));
    }

    public void selectStatus(Status status){
        Select select = new Select(Constant.WEBDRIVER.findElement(statusLocator));
        select.selectByVisibleText(status.getText());
    }

    public void clickApplyButton(){
        Constant.WEBDRIVER.findElement(applyButtonLocator).click();
    }

    public void filterTicket(Filter filter){
        selectDepartStation(filter.getDepartStation());
        selectArriveStation(filter.getArriveStation());
        selectDepartDate(LocalDate.parse(filter.getDepartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        selectStatus(filter.getStatus());
        clickApplyButton();
    }

    private int getColumnIndex(String column) {
        return Constant.WEBDRIVER.findElements(By.xpath(String.format("//tr/th[text()='%s']/preceding-sibling::th", column))).size() + 1;
    }

    private String getColumnText(String columnName) {
        By cell = By.xpath(String.format("//tr/td[%d]", getColumnIndex(columnName)));
        return Constant.WEBDRIVER.findElement(cell).getText();
    }

    private Station getDepartStation(){
        return Station.fromText(getColumnText("Depart Station"));
    }

    private Station getArriveStation(){
        return Station.fromText(getColumnText("Arrive Station"));
    }

    private String getDepartDate() {
        return LocalDate.parse(getColumnText("Depart Date"), DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private Status getStatus(){
        return Status.fromText(getColumnText("Status"));
    }

    public Filter getFilterTicketResult() {
        return new Filter(
                getDepartStation(),
                getArriveStation(),
                getDepartDate(),
                getStatus()
        );
    }
}