package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneTwoTripHomePage extends AbstractPage{
    private static final String PAGE_URL = "http://onetwotrip.com/ru/poezda/";

    @FindBy(xpath = "//*[@id=\"RailwaysSearchForm\"]/div[2]/div/div/div/label/input")
    private WebElement pointFrom;

    @FindBy(xpath = "//*[@id=\"RailwaysSearchForm\"]/div[4]/div/div/div/label/input")
    private WebElement pointTo;

    @FindBy(xpath = "//*[@id=\"RailwaysSearchForm\"]/div[7]/button")
    private WebElement findButton;

    public OneTwoTripHomePage(WebDriver driver) {
        super(driver);
    }

    public OneTwoTripHomePage openPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"RailwaysSearchForm\"]/div[2]/div/div/div/label/input")));
        return this;
    }


    public OneTwoTripHomePage fillFromInput(String fromPoint) throws InterruptedException {

        pointFrom.sendKeys(fromPoint);
        return this;
    }

    public OneTwoTripHomePage fillToInput(String toPoint) throws InterruptedException {
        pointTo.sendKeys(toPoint);
        return this;
    }

    public OneTwoTripHomePage pressFindButton() throws InterruptedException {
        findButton.click();
        return this;
    }

    public String getFailMessage() throws InterruptedException {

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"railways-search-page\"]/div[2]/div/div/div[3]/div/div[2]")));

        return driver.findElement(By.xpath("//*[@id=\"railways-search-page\"]/div[2]/div/div/div[3]/div/div[2]")).getText();
    }
}
