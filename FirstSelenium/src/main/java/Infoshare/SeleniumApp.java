package Infoshare;

import Elements.Button;
import Elements.Select;
import Elements.Labels;
import Elements.TextInput;
import Utils.PurchaseSelectorsBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;

public class SeleniumApp {

    private WebDriver driver;
    private PurchaseSelectorsBy inventoryOfElements;

    @Before
    public void startBrowser(){
        inventoryOfElements = new PurchaseSelectorsBy();
        String url = "http://demo.shopizer.com:8080/shop/";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor runner = (JavascriptExecutor) driver;
        wait.until((ExpectedCondition<Boolean>) driver -> (runner.executeScript("return document.readyState").equals("complete")));

        Button handbagMenu = new Button(driver, inventoryOfElements.getHandbagsLink());
//        Button bag = new Button(driver, inventoryOfElements.getChicVinategDeVillleBag());
//        Button checkout = new Button(driver, inventoryOfElements.getCheckoutButton());

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void purchase(){
        Button handbagMenu = new Button(driver, inventoryOfElements.getHandbagsLink());
        Button btn = handbagMenu.click();

        Button bag = new Button(driver, inventoryOfElements.getChicVinategDeVillleBag());
        bag.click();

        Button cart = new Button(driver, inventoryOfElements.getCartLink());
        cart.safeClick();


        Button checkout = new Button(driver, inventoryOfElements.getCheckoutButton());
        checkout.clickWithJs();


        Button proceedToCheckout = new Button(driver, inventoryOfElements.getProceedToCheckoutButton());
        proceedToCheckout.click();

        TextInput firstname = new TextInput(driver, inventoryOfElements.getFirstnameInput());
        firstname.type("Auto");

        TextInput lastname = new TextInput(driver, inventoryOfElements.getLastnameInput());
        lastname.type("Test");

        TextInput street = new TextInput(driver, inventoryOfElements.getStreetAddressInput());
        street.type("123 Street");

        TextInput city = new TextInput(driver, inventoryOfElements.getCityInput());
        city.type("Oslo");

        Select country;
        country = new Select(driver, inventoryOfElements.getCountrySelect());
        country.choose("Brazil");

        TextInput state = new TextInput(driver, inventoryOfElements.getStateInput());
        state.type("North Cumberland");

        TextInput postalCode = new TextInput(driver, inventoryOfElements.getPostalCodeInput());
        postalCode.type("AB123TL");

        TextInput email = new TextInput(driver, inventoryOfElements.getEmailInput());
        email.type("example@example.com");

        TextInput phone = new TextInput(driver, inventoryOfElements.getPhoneInput());
        phone.type("123465789");

        Button submit = new Button(driver, inventoryOfElements.getSubmitOrderButton());
        submit.clickWithJs();

        Labels confirmation;
        confirmation = new Labels(driver, inventoryOfElements.getConfirmationLabel());
        Assert.assertEquals(confirmation.read(), "Order completed");
    }
}