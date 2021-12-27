package page;

import model.Currency;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class ResultPage extends AbstractPage{

    private static final String RESULT_HOTEL_NAME="//*[@id=\"rates\"]//h3[@class=\"basket-hotel-info__title\"]";
    private static final String CURRENCY_SELECT = "//*[@id=\"-currency-selector\"]";
    private static final String ACTUAL_CURRENCY = "//*[@id=\"rates\"]//span[@class=\"booking-price__symbol booking-price__symbol--capped\"]";

    @FindBy(xpath = RESULT_HOTEL_NAME)
    private WebElement resultName;

    @FindBy(xpath = CURRENCY_SELECT)
    private WebElement currencySelect;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public ResultPage selectCurrency(Currency currency){
        new Select(currencySelect).selectByVisibleText(currency.getCurrency());
        return this;
    }

    public String getActualCurrency(){
        return Waits.getWebElementUntilWait(driver, ACTUAL_CURRENCY).getText();
    }

    public String getResultHotelName(){
        return new String(resultName.getText().getBytes(StandardCharsets.UTF_8));
    }
}
