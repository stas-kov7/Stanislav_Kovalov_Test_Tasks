package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageObject{
    public HomePage(WebDriver driver) {super(driver);
    }

    @FindBy(xpath = "//a[contains(text(), 'Computers')]")
    private WebElement computersCategoryButton;


    public ComputersPage clickComputersCategory(){
        computersCategoryButton.click();
        return new ComputersPage(driver);
    }

}
