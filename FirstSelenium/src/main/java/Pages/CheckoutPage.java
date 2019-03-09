package Pages;

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
    private CredentialsGenerator generator = new CredentialsGenerator();

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

    public void InsertName() {
        firstNameField.type("Name");
    }

    public void InsertLastName() {
        lastNameField.type("Last Name");
    }

    public void InsertStreetAdress() {
        streetAdress.type("Street");
    }

    public void InsertCity() {
        city.type("city");
    }

    public void SelectCountry() {
        country.choose("Brazil");
    }

    public void InsertState() {
        state = new TextInput(driver, stateSelector);
        state.type("State");
    }

    public void InsertPostalCode() {
        postalCode = new TextInput(driver, postalCodeSelector);
        postalCode.type("00-000");
    }

    public void InsertEmailInput() {
        emailInput = new TextInput(driver, emailInputSelector);
        emailInput.type("aaa@aaa.aaa");
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
