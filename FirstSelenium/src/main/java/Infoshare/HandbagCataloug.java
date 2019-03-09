package Infoshare;

import DataModels.RegisteredUser;
import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandbagCataloug {
    private WebDriver driver;
    private MainPage mainPage;
    private HandbagCataloguePage handbagCataloguePage;
    private OrderConfirmationPage orderConfirmationPage;
    private CheckoutPage checkoutPage;
    private OrderCompleted orderCompletedPage;


    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    public void test() {
        mainPage.ChooseHandbagsCategory();
        handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.ChooseAddToCard();
        handbagCataloguePage.ProceedToCheckou();
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.ChooseProceedToConfirmationPage();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.InsertName();
        checkoutPage.InsertLastName();
        checkoutPage.InsertStreetAdress();
        checkoutPage.InsertCity();
        checkoutPage.SelectCountry();
        checkoutPage.InsertState();
        checkoutPage.InsertPostalCode();
        checkoutPage.InsertPhoneInput();
        checkoutPage.InsertEmailInput();
        checkoutPage.ClickSubmitButton();
        orderCompletedPage = new OrderCompleted(driver);
        Assert.assertEquals(orderCompletedPage.ReadLabel(), "Order completed");
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }
}
