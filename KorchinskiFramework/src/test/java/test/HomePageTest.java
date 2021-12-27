package test;

import model.Route;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.RouteCreator;


public class HomePageTest extends CommonConditions{
    private static final String EXPECTED_ERROR_WITHOUT_DATA = "Укажите свой пункт назначения (пример Париж)";
    private static final int ADDED_PEOPLE = 3;
    private static final String EXPECTED_ERROR_INCORRECT_DATE = "Введите даты пребывания в формате дд.мм.гггг, либо выбрав даты в календаре (пример 05.05.2020)";

    @Test
    public void findRouteWithoutDataTest() {

        HomePage homePage = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .pressFindButton();

        Assert.assertEquals(homePage.getErrorText(),EXPECTED_ERROR_WITHOUT_DATA);
    }

    @Test
    public void findRouteWithIncorrectPointToTest(){
        Route route = RouteCreator.createIncorrectPointForm();
        String actualError = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .fillRouteFormWithoutHint(route)
                .pressFindButton()
                .getErrorText();
        Assert.assertEquals(actualError, EXPECTED_ERROR_WITHOUT_DATA);
    }
    @Test
    public void findRouteWithIncorrectDateTest(){
        Route route  = RouteCreator.createIncorrectDateForm();
        String actualError = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .fillRouteForm(route)
                .pressFindButton()
                .getErrorText();
        Assert.assertEquals(actualError, EXPECTED_ERROR_INCORRECT_DATE);
    }

    @Test
    public void checkButtonAddPersonTest(){
        int adultsAmount = new HomePage(driver)
                .openPage()
                .acceptCookie()
                .pressAddPeopleButton()
                .pressAddAdultButton(ADDED_PEOPLE)
                .getAdultsBooked();
        Assert.assertEquals(adultsAmount, ADDED_PEOPLE + 1);
    }



}