package page;

import model.Route;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;


public class HomePage extends AbstractPage{
    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://all.accor.com/russia/index.ru.shtml";
    private static final String RESULT_URL_PART = "https://all.accor.com/ssr/app/accor";
    private static final String COOKIE_BUTTON = "//*[@id=\"onetrust-accept-btn-handler\"]";
    private static final String FIND_BUTTON = "//*[@id=\"bookingEngine\"]/button[@class=\"tSubmit roundButton roundButton--accent\"]";
    private static final String ERROR_MESSAGE = "//*[@id=\"error-messages\"]//a[@class=\"anchorToError\"]";
    private static final String DATE_CHECK_IN = "//*[@id=\"search-dateIn-boo\"]";
    private static final String POINT_TO = "//*[@id=\"search-destination\"]";
    private static final String DATE_CHECK_OUT = "//*[@id=\"search-dateout-boo\"]";
    private static final String HINT = "//div[@class=\"buttonAutocomplete\"]";
    private static final String PEOPLE_ADD_BUTTON = "//*[@id=\"bookingEngine\"]//button[@class=\"fakeInput\"]";
    private static final String ADD_ADULT_BUTTON = "//*[@id=\"roomsPopin\"]//div[@class=\"guests\"]//button[@class=\"plus\"]";
    private static final String ADULT_AMOUNT = "//*[@id=\"bookingEngine\"]//button[@class=\"fakeInput\"]//span[3]";



    @FindBy(xpath = COOKIE_BUTTON)
    private WebElement cookieButton;

    @FindBy(xpath = DATE_CHECK_IN)
    private WebElement dateCheckIn;

    @FindBy(xpath = FIND_BUTTON)
    private WebElement findButton;

    @FindBy(xpath = DATE_CHECK_OUT)
    private WebElement dateCheckOut;

    @FindBy(xpath = ERROR_MESSAGE)
    private WebElement errorMessage;

    @FindBy(xpath = POINT_TO)
    private WebElement pointTo;

    @FindBy(xpath = PEOPLE_ADD_BUTTON)
    private WebElement peopleAddButton;

    @FindBy(xpath = ADD_ADULT_BUTTON)
    private WebElement adultAddButton;

    @FindBy(xpath = ADULT_AMOUNT)
    private WebElement adultAmount;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public HomePage acceptCookie(){

        cookieButton.click();
        return this;
    }

    public HomePage fillRouteForm(Route route){
        pointTo.sendKeys(route.getPointTo());
        Waits.getWebElementUntilWait(driver, HINT).click();
        dateCheckIn.sendKeys(route.getCheckInDate());
        dateCheckOut.click();
        dateCheckOut.sendKeys(route.getCheckOutDate());
        return this;
    }

    public HomePage fillRouteFormWithoutHint(Route route){
        pointTo.sendKeys(route.getPointTo());
        dateCheckIn.sendKeys(route.getCheckInDate());
        dateCheckOut.click();
        dateCheckOut.sendKeys(route.getCheckOutDate());
        return this;
    }

    public ResultPage redirectResultPage(){
        Waits.isPageUrlContains(driver, RESULT_URL_PART);
        logger.info("Redirect to result page");
        return new ResultPage(driver);
    }


    public HomePage pressFindButton() {
        findButton.click();
        return this;
    }

    public HomePage pressAddPeopleButton(){
        peopleAddButton.click();
        return this;
    }

    public HomePage pressAddAdultButton(int times){
        for(int i = 0; i < times;i++)
            adultAddButton.click();
        return this;
    }

    public int getAdultsBooked(){
        return Integer.parseInt(adultAmount.getText());
    }

    public String getErrorText(){

        return new String(errorMessage.getText().getBytes(StandardCharsets.UTF_8));
    }
}