package Pages;

import Elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandbagCataloguePage extends BasePage{

    private Button addToCardTab;
    private Button shoppingCardTab;
    private Button checkOutTab;
    private By addToCard = By.cssSelector("div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private By shoppingCard = By.cssSelector("div#miniCartSummary span");
    private By checkOut = By.cssSelector("li.checkout-bg a");


    public HandbagCataloguePage(WebDriver driver) {
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1";
        this.driver.get(this.url);

        this.addToCardTab = new Button(driver, this.addToCard);
    }

    public void ChooseAddToCard(){
        this.addToCardTab.click();
    }

    public void ProceedToCheckou(){
        this.shoppingCardTab = new Button(driver, this.shoppingCard);
        this.shoppingCardTab.safeClick();
        this.checkOutTab = new Button(driver, this.checkOut);
        this.checkOutTab.clickWithJs();
    }
}
