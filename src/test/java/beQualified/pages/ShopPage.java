package beQualified.pages;

import beQualified.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class ShopPage extends BasePage {

    // title
    @FindBy(xpath = "(//span[@class='title'])[1]")
    public WebElement productPageTitle;

    // Name of a product
    @FindBy(className = "inventory_item_name")
    public WebElement productTitle;

    //Names of all products
    @FindBy(className = "inventory_item_name")
    public List<WebElement> listOfAllProductTitles;

    // description of all products
    @FindBy(className = "inventory_item_desc")
    public List<WebElement> listOfAllProductDescriptions;

    //Prices of all products
    @FindBy(className = "inventory_item_description")
    public List<WebElement> listOfAllPrices;

    //List of all images
    @FindBy(css = ".inventory_item .inventory_item_img img")
    public List<WebElement> listOfAllProductImages;

    //list of all add to cart button at shop page
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
    public List<WebElement> listOfAllAddToCartBtn;

    //Add to cart for Sauce Labs Backpack
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement sauceLabsAddToCartBtn;

    //shopp cart icon
    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartIcon;

     //shopp cart icon with class
    @FindBy(className = "shopping_cart_container")
    public WebElement CartIcon;

    /**
     * to add all product at cart
     */
    public void allProductAddToCart() {
        for (WebElement addToCartBtn : listOfAllAddToCartBtn) {
            addToCartBtn.click();
        }
    }

    /**
     * logout
     */
    public void logout() {
        menuButton.click();
        BrowserUtils.clickWithJS(logoutButton);
    }


}
