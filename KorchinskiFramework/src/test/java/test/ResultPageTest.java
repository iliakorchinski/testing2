package test;

import model.Currency;
import model.Route;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.CurrencyCreator;
import service.RouteCreator;

public class ResultPageTest extends CommonConditions{

    @Test
    public void findCorrectRouteWithoutDate(){
        Route route = RouteCreator.createFormWithDate();
        String actualHotelName = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .fillRouteForm(route)
                .pressFindButton()
                .redirectResultPage()
                .getResultHotelName();
        Assert.assertTrue(actualHotelName.indexOf(route.getPointTo()) != 1);
    }

    @Test
    public void checkOtherCurrencyPriceTest(){
        Currency currency = CurrencyCreator.createCurrency();
        Route route = RouteCreator.createFormWithDate();
        String actualCurrency = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .fillRouteForm(route)
                .pressFindButton()
                .redirectResultPage()
                .selectCurrency(currency)
                .getActualCurrency();
        Assert.assertEquals(actualCurrency,currency.getCurrency());
    }
}
