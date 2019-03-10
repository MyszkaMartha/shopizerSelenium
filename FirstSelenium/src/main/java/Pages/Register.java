package Pages;

import DataModels.Address;
import DataModels.UserBase;
import Elements.Button;
import Elements.Select;
import Elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends BasePage  {

    private TextInput firstName;
    private TextInput lastName;
    private Select country;
    private TextInput state;

    private TextInput emailAddress;
    private TextInput password;
    private TextInput repeatPassword;

    private Button createAnAccButton;

    private By firstNameSelector = By.cssSelector("div.form-group input[title='First name is required']");
    private By lastNameSelector = By.cssSelector("div.form-group input[title='Last name is required']");
    private By countrySelecotr = By.cssSelector("div.form-group select#registration_country");
    private By stateSelector = By.cssSelector("div.form-group input[title='State / Province is required']");
    private By emailAddressSelector = By.cssSelector("div.form-group input[title='Email address is required']");
    private By passwordSelector = By.cssSelector("div.form-group input[title='A password is required']");
//    private By repeatPasswordSelector

    private By createAnAccSelector = By.cssSelector("button.btn.btn-default.login-btn");

    public Register(WebDriver driver) {
        super(driver);
        this.firstName = new TextInput(driver, firstNameSelector);
        this.lastName = new TextInput(driver, lastNameSelector);
        this.country = new Select(driver, countrySelecotr);
        this.state = new TextInput(driver, stateSelector);
        this.emailAddress = new TextInput(driver, emailAddressSelector);
        this.password = new TextInput(driver, passwordSelector);
    }

    public void insertFirstName(UserBase user){
        this.firstName.type(user.getFirstname());
    }
    public void insertLastName(UserBase user){
        this.lastName.type(user.getLastname());
    }
    public void insertCountry(Address address){
        this.country.choose(address.getCountry());
    }
    public void insertState(Address address){
        this.state.type(address.getState());
    }

    public void insertEmail(UserBase user){
        this.emailAddress.type(user.getEmail());
    }

    public void insertPassword(UserBase user){
        this.password.type(user.)
    }


}
