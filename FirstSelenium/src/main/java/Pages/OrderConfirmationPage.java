package Pages;

import Elements.Button;
import Elements.Labels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.management.BufferPoolMXBean;

public class OrderConfirmationPage extends BasePage{

    private Button proceedToCheckoutTab;

    private By proceedToCheckout = By.xpath("//a[text()='Proceed to checkout']");


    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
//        this.driver.get(this.url);
//        url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.proceedToCheckoutTab = new Button(driver, proceedToCheckout);
    }

    public void ChooseProceedToConfirmationPage(){
        this.proceedToCheckoutTab.click();
    }


}
