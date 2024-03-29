package Pages;
import Elements.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {


    private By handbagsSelector = By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private Button handBagsCategoryTab;

    private By myAccountSelector = By.cssSelector("li.click_menu");
    private Button myAccountButton;

    private By registerSelector = By.xpath("//div[contains(@class, 'header-top-left')]//a[text()='Register']");
    private Button registerButton;

    public MainPage(WebDriver driver) {
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.handBagsCategoryTab = new Button(this.driver, this.handbagsSelector);
    }

    public void ChooseHandbagsCategory() {
        this.handBagsCategoryTab.click();
    }

    public void ChooseMyAccount(){
        this.myAccountButton = new Button(driver, myAccountSelector);
        myAccountButton.safeClick();
    }

    public void ChooseRegisterButton(){
        this.registerButton = new Button(driver, registerSelector);
        registerButton.clickWithJs();

    }

    public void Register(){
        ChooseMyAccount();
        ChooseRegisterButton();
    }
}
