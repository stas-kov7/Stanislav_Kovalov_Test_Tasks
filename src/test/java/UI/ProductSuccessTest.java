package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductSuccessTest extends BaseTest {
    @BeforeMethod
    public void goHomePage() {
        setDr();
        driver.navigate().to("http://demowebshop.tricentis.com");
    }

    @Test
    public void productTest() {
         int AllOfItems = new  HomePage(driver)
                .clickComputersCategory()
                .openDesktopCategory()
                .clickOnFourMenu()
                .getAmountItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(AllOfItems, 4);
        String name = new DesktopsPage(driver)
                .selectSortHighToLow()
                .selectFirstItem()
                .addItemToCart()
                .openCartOfProduct()
                .getNameOfProduct();
        String nameOfProduct = "Build your own expensive computer";
        softAssert.assertEquals(name,nameOfProduct);
        String countItemsInCart = new ShoppingCartPage(driver)
                .openPageProduct()
                .selectFastProcessor()
                .selectRam8GB()
                .selectAllOfSoftware()
                .addItemToCart()
                .getCountItemsCart();
        softAssert.assertEquals(countItemsInCart,"(2)");
        String amountSecondItem = new ItemPage(driver)
                .openCartOfProduct()
                .getAmountSecondItem();
        softAssert.assertEquals(amountSecondItem,"2105.00");
        String shoppingCartIsEmpty = new ShoppingCartPage(driver)
                .deleteItems()
                .getCountItemsCart();
        softAssert.assertEquals(shoppingCartIsEmpty,"(0)");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
