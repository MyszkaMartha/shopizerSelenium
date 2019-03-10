package Pages;

import DataModels.Address;
import DataModels.UserBase;
import Elements.Button;
import Elements.Select;;
import Elements.TextInput;
import Generators.CredentialsGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends BasePage {
    private TextInput firstNameField;
    private TextInput lastNameField;
    private TextInput streetAdress;
    private TextInput city;
    private Select country;
    private TextInput state;
    private TextInput postalCode;
    private TextInput emailInput;
    private TextInput phoneInput;
    private Button submitOrderButton;

    private By firstNameFieldSelector = By.cssSelector("[name='customer.billing.firstName']");
    private By lastNameFieldSelector = By.cssSelector("[name='customer.billing.lastName']");
    private By streetAdressSelector = By.cssSelector("[name='customer.billing.address']");
    private By citySelector = By.cssSelector("[name='customer.billing.city']");
    private By countrySelector = By.cssSelector("[name='customer.billing.country']");
    private By stateSelector = By.cssSelector("[name='customer.billing.stateProvince']");
    private By postalCodeSelector = By.cssSelector("[name='customer.billing.postalCode']");
    private By emailInputSelector = By.cssSelector("[name='customer.emailAddress']");
    private By phoneInputSelector = By.cssSelector("[name='customer.billing.phone']");
    private By submitOrderButtonSelector = By.id("submitOrder");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.firstNameField = new TextInput(driver, firstNameFieldSelector);
        this.lastNameField = new TextInput(driver, lastNameFieldSelector);
        this.streetAdress = new TextInput(driver, streetAdressSelector);
        this.city = new TextInput(driver, citySelector);
        this.country = new Select(driver, countrySelector);
    }

    public void InsertName(UserBase user) {
        firstNameField.type(user.getFirstname());
    }

    public void InsertLastName(UserBase user) {
        lastNameField.type(user.getLastname());
    }

    public void InsertStreetAdress(Address address) {
        streetAdress.type(address.getStreetAddress());
    }

    public void InsertCity(Address address) {
        city.type(address.getCity());
    }

    public void SelectCountry(Address address) {
        country.choose(address.getCountry());
    }

    public void InsertState(Address address) {
        state = new TextInput(driver, stateSelector);
        state.type(address.getState());
    }

    public void InsertPostalCode(Address address) {
        postalCode = new TextInput(driver, postalCodeSelector);
        postalCode.type(address.getPostalCode());
    }

    public void InsertEmailInput(UserBase user) {
        emailInput = new TextInput(driver, emailInputSelector);
        emailInput.type(user.getEmail());
    }

    public void InsertPhoneInput() {
        phoneInput = new TextInput(driver, phoneInputSelector);
        phoneInput.type("000000000");
    }

    public void ClickSubmitButton() {
        submitOrderButton = new Button(driver, submitOrderButtonSelector);
        submitOrderButton.clickWithJs();
    }


}
