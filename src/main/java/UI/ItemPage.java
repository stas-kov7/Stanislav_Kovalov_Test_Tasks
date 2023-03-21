package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePageObject{
    public ItemPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@id='product_attribute_74_5_26_82']")
    private WebElement fastProcessorButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div/form/div/div[1]/div[2]/div[8]/div/input[2]")
    private WebElement addItemToCartButton;

    @FindBy(id = "product_attribute_74_6_27_85")
    private WebElement ram8GBButton;

    @FindBy(id = "product_attribute_74_8_29_88")
    private WebElement imageViewerButton;

    @FindBy(id = "product_attribute_74_8_29_89")
    private WebElement officeSuiteButton;

    @FindBy(id = "product_attribute_74_8_29_90")
    private WebElement otherOfficeSuiteButton;

    @FindBy(className = "cart-qty")
    private WebElement shoppingCartButton;

    public ShoppingCartPage openCartOfProduct(){
        wait.visibility(shoppingCartButton);
        action.click(shoppingCartButton);
        return new ShoppingCartPage (driver);
    }

    public ItemPage addItemToCart(){
        wait.visibility(addItemToCartButton);
        action.click(addItemToCartButton);
        sleep(3);
        return this;
    }

    public ItemPage selectFastProcessor (){
        fastProcessorButton.click();
        return this;
    }

    public ItemPage selectRam8GB(){
        wait.visibility(ram8GBButton);
        action.click(ram8GBButton);
        return this;
    }

    public ItemPage selectAllOfSoftware(){
        imageViewerButton.click();
        officeSuiteButton.click();
        otherOfficeSuiteButton.click();
        return this;
    }

    public String getCountItemsCart(){
        wait.visibility(shoppingCartButton);
        return shoppingCartButton.getText();
    }



}
