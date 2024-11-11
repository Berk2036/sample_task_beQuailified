package beQualified.pages;

import beQualified.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    //product name for product page
    @FindBy(css = ".inventory_details_name")
    public WebElement productName;

    //product description for product page
    @FindBy(css = ".inventory_details_desc")
    public WebElement productDescription;

    //product price for product page
    @FindBy(css = ".inventory_details_price")
    public WebElement productPrice;

    //button back to shop page
    @FindBy(id = "back-to-products")
    public WebElement backToShopPageBtn;

    //button add to cart for product page
    @FindBy(id = "add-to-cart")
    public WebElement addToCartBtn;

    /**
     * to redirect shop page
     */
    public void backToShopPage(){
        BrowserUtils.waitForVisibility(backToShopPageBtn, 10);
        backToShopPageBtn.click();
    }


}
