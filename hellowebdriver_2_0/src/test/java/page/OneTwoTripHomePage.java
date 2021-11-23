package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OneTwoTripHomePage extends AbstractPage{
    private static final String PAGE_URL = "https://all.accor.com/russia/index.ru.shtml";


    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement cookieButton;

    @FindBy(xpath = "//*[@id=\"bookingEngine\"]/button[2]")
    private WebElement findButton;

    public OneTwoTripHomePage(WebDriver driver) {
        super(driver);

    }

    public OneTwoTripHomePage openPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")));
        return this;
    }

    public OneTwoTripHomePage acceptCookie(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")));
        cookieButton.click();
        return this;
    }


    public OneTwoTripHomePage pressFindButton() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"bookingEngine\"]/button[2]")));
        findButton.click();
        return this;
    }

    public boolean isPageContainsError(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"error-messages\"]")));
        return driver.findElements(By.xpath("//*[@id=\"error-messages\"]")).size() > 0;
    }
}
