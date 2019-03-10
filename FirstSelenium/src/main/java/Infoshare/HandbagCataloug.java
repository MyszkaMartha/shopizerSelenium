package Infoshare;

import categories.OrderRevue;
import categories.PurchaseTests;
import DataModels.Address;
import DataModels.UserBase;
import Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HandbagCataloug {
    private WebDriver driver;
    private MainPage mainPage;
    private HandbagCataloguePage handbagCataloguePage;
    private OrderConfirmationPage orderConfirmationPage;
    private CheckoutPage checkoutPage;
    private OrderCompleted orderCompletedPage;
    private UserBase user;
    private Address address;


    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        user = new UserBase();
        address = new Address(true);
    }

    @Category(PurchaseTests.class)
    @Test
    public void purchase() {
        mainPage.ChooseHandbagsCategory();
        handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.ChooseAddToCard();
        handbagCataloguePage.ProceedToCheckou();
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.ChooseProceedToConfirmationPage();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.InsertName(user);
        checkoutPage.InsertLastName(user);
        checkoutPage.InsertStreetAdress(address);
        checkoutPage.InsertCity(address);
        checkoutPage.SelectCountry(address);
        checkoutPage.InsertState(address);
        checkoutPage.InsertPostalCode(address);
        checkoutPage.InsertPhoneInput();
        checkoutPage.InsertEmailInput(user);
        checkoutPage.ClickSubmitButton();
        orderCompletedPage = new OrderCompleted(driver);
        assertEquals("Order complited message does not match", orderCompletedPage.ReadLabel(), "Order completed");
    }

    @Test
    public void purchase2() {
        mainPage.ChooseHandbagsCategory();
        handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.ChooseAddToCard();
        handbagCataloguePage.ProceedToCheckou();
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.ChooseProceedToConfirmationPage();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.InsertName(user);
        checkoutPage.InsertLastName(user);
        checkoutPage.InsertStreetAdress(address);
        checkoutPage.InsertCity(address);
        checkoutPage.SelectCountry(address);
        checkoutPage.InsertState(address);
        checkoutPage.InsertPostalCode(address);
        checkoutPage.InsertPhoneInput();
        checkoutPage.InsertEmailInput(user);
        checkoutPage.ClickSubmitButton();
        orderCompletedPage = new OrderCompleted(driver);
        Assert.assertEquals("Order complited message does not match", orderCompletedPage.ReadLabel(), "Order completed");
    }

    @Category(OrderRevue.class)
    @Test
    public void reviueOrder() {
        mainPage.ChooseHandbagsCategory();
        handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.ChooseAddToCard();
        handbagCataloguePage.ProceedToCheckou();
        orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertEquals("bag does not match", orderConfirmationPage.CompareBag(), "Chic vintage DeVille");
    }

    @Test
    public void register(){
        mainPage.Register();
        Register registerPage = new Register(driver);
        registerPage.insertFirstName(user);
        registerPage.insertLastName(user);
        registerPage.insertCountry(address);
        registerPage.insertState(address);
        registerPage.insertEmail(user);
    }

//    @After
//    public void closeBrowser() {
//        mainPage.close();
//    }
}
