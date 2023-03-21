package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DesktopsPage extends BasePageObject {
    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@name='products-pagesize']")
    private WebElement displayButton;

    @FindBy(css = "h2.product-title")
    private List<WebElement> fullItemsField;

    @FindBy(xpath = "//select[@name='products-orderby']")
    private WebElement sortButton;

    @FindBy(xpath = "//option[text()='Price: High to Low']")
    private WebElement sortBySelectHighToLowButton;

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartItemButton;

    public DesktopsPage clickOnFourMenu(){
        wait.visibility(displayButton);
        action.click(displayButton);
        displayButton.click();
        displayButton.sendKeys("4");
        return this;
    }

    public int getAmountItems(){
        return fullItemsField.size();
    }

    public DesktopsPage selectSortHighToLow(){
        wait.visibility(sortButton);
        action.click(sortButton);
        sortButton.sendKeys("Price: High to Low");
        sortButton.click();
        return this;
    }

    public ItemPage selectFirstItem(){
        sleep(3);
        addToCartItemButton.get(0).click();
        return new ItemPage(driver);
    }
}
