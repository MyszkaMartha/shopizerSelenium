package Pages;

import Elements.Labels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompleted extends BasePage{
    private Labels orderCompleted;

    private By orderCompleterSelector = By.cssSelector("#main-content h1");


    public OrderCompleted(WebDriver driver) {
        super(driver);

        orderCompleted = new Labels(driver, orderCompleterSelector);
    }

    public String ReadLabel(){
        return orderCompleted.read();
    }
}
