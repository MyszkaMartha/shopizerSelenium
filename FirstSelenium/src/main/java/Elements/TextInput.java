package Elements;

import Generators.CredentialsGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextInput{

    private int timeout = 10;
    private WebElement element;
    private WebDriver driver;
    private CredentialsGenerator text;

    public TextInput(WebDriver driver, By by) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
        text = new CredentialsGenerator();
    }

    public TextInput type(String text) {
        this.element.sendKeys(text);
        return this;
    }

    public String read() {
        return this.element.getText();
    }
}
