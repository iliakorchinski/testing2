package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.OneTwoTripHomePage;

public class WebDriverOneTwoTrip {
    private WebDriver driver;

    //выполняется до самого теста
    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        driver = new ChromeDriver();
    }
    @Test
    public void findIncorrectRoute() throws InterruptedException {
        String pointFrom = "Минск";
        String pointTo = "Нова-Сири-Ротонделла";
        String expectedMessage = "Некорректная станция отправления или назначения";

        OneTwoTripHomePage homePage = new OneTwoTripHomePage(driver)
                .openPage()
                .fillFromInput(pointFrom)
                .fillToInput(pointTo)
                .pressFindButton();

        String actualMessage = homePage.getFailMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }

}
