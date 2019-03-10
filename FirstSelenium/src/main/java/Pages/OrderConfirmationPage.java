package Pages;

import Elements.Button;
import Elements.Labels;
import Elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.lang.management.BufferPoolMXBean;

public class OrderConfirmationPage extends BasePage {

    private Button proceedToCheckoutTab;
    private Labels bagSelect;

    private By proceedToCheckout = By.xpath("//a[text()='Proceed to checkout']");
    private By bag = By.cssSelector("div.row-cart span.nomargin");


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
//        this.driver.get(this.url);
//        url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.proceedToCheckoutTab = new Button(driver, proceedToCheckout);
        this.bagSelect = new Labels(driver, bag);
    }

    public void ChooseProceedToConfirmationPage() {
        this.proceedToCheckoutTab.click();
    }

    public String CompareBag() {
        return this.bagSelect.read();
    }
}
