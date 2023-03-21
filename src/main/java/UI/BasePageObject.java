package UI;

import UI.helpers.ElementActions;
import UI.helpers.ElementWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {
    protected WebDriver driver;
    protected ElementWait wait;
    protected ElementActions action;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new ElementWait(driver);
        action = new ElementActions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
