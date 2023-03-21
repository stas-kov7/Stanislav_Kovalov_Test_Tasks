package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputersPage extends  BasePageObject{
    public ComputersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2//a[@title='Show products in category Desktops']")
    private WebElement desktopButton;

    public DesktopsPage openDesktopCategory(){
        wait.visibility(desktopButton);
        desktopButton.click();
        return new DesktopsPage(driver);
    }
}
