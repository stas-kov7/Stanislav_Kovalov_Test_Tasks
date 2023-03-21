package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePageObject{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-name")
    private WebElement nameOfProduct;

    @FindBy(css = "span.product-subtotal")
    private List<WebElement> totalItemList;

    @FindBy(name = "removefromcart")
    private List<WebElement> removeButton;

    @FindBy(name = "updatecart")
    private WebElement updateShoppingCartButton;

    public String getNameOfProduct() {
        return nameOfProduct.getText();
    }

    public ItemPage openPageProduct(){
        nameOfProduct.click();
        return new ItemPage(driver);
    }

    public String getAmountSecondItem(){
        return totalItemList.get(1).getText();
    }

    public ItemPage deleteItems(){
        removeButton.get(0).click();
        removeButton.get(1).click();
        updateShoppingCartButton.click();
        return new ItemPage(driver);
    }

}
