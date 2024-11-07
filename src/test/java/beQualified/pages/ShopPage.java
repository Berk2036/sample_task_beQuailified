package beQualified.pages;

import beQualified.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;

public class ShopPage extends BasePage {

    // title
    @FindBy(xpath = "(//span[@class='title'])[1]")
    public WebElement productPageTitle;

    //menu button
    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    //logout button
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //reset button
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppButton;

    // Name of a product
    @FindBy(className = "inventory_item_name")
    public WebElement productTitle;

    //List of all products
    @FindBy(css = ".inventory_item")
    public List<WebElement> productList;

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

    //list of all add to cart button
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
    public List<WebElement> listOfAllAddToCartBtn;

    //list of all remove button
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory ']")
    public List<WebElement> listOfAllRemoveBtn;

    //Add to cart for Sauce Labs Backpack
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement sauceLabsAddToCartBtn;

    //shopp cart icon
    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCartIcon;

     //shopp cart icon with class
    @FindBy(className = "shopping_cart_container")
    public WebElement CartIcon;



    public void logout() {

        menuButton.click();
        BrowserUtils.clickWithJS(logoutButton);
      //  BrowserUtils.waitForToClickElement(logoutButton, 10);

    }


    public List<String> getListProductInfo(WebElement product){

        // Retrieve product details
        String productName = getProductTitle(product);
        String productPrice = getProductPrice(product);
        String productDescription = getProductDescription(product);
        String productImageAttribute = getProductSrcAttribute(product);
        // Add all details to the list
        Collections.addAll(productInfo, productName, productPrice, productDescription, productImageAttribute);

        // Return the list containing all product information
        return productInfo;
    }

    public List<String> getListProductInfoWithoutImage(WebElement product){

        // Retrieve product details
        String productName = getProductTitle(product);
        String productPrice = getProductPrice(product);
        String productDescription = getProductDescription(product);

        // Add all details to the list
        Collections.addAll(productInfo, productName, productPrice, productDescription);

        // Return the list containing all product information
        return productInfo;
    }

    public List<String> getListAllProductInfo(List<WebElement> products) {

        for (WebElement product : products) {

            // Retrieve product details
            String productName = getProductTitle(product);
            String productPrice = getProductPrice(product);
            String productDescription = getProductDescription(product);
            String productImageAttribute = getProductSrcAttribute(product);

            productInfo.add(productName);
            productInfo.add(productPrice);
            productInfo.add(productDescription);
            productInfo.add(productImageAttribute);

        }
        // Return the list containing all product information
        return productInfo;
    }

    public List<String> getListAllProductInfoWithoutImage(List<WebElement> products) {
        for (WebElement product : products) {

            // Retrieve product details
            String productName = getProductTitle(product);
            String productPrice = getProductPrice(product);
            String productDescription = getProductDescription(product);

            productInfo.add(productName);
            productInfo.add(productPrice);
            productInfo.add(productDescription);

            // Add all details to the list
            //   Collections.addAll(productInfo, productName, productPrice, productDescription);
        }
        // Return the list containing all product information
        return productInfo;
    }

    public String getProductPrice(WebElement product) {
        return product.findElement(By.className("inventory_item_price")).getText();
    }


    public String getProductTitle(WebElement product) {
        return product.findElement(By.className("inventory_item_name")).getText();
    }

    public String getProductDescription(WebElement product) {
        return product.findElement(By.className("inventory_item_desc")).getText();
    }

    public String getProductSrcAttribute(WebElement product){
        return product.findElement(By.cssSelector(".inventory_item_img img")).getAttribute("src");
    }


    public void allProductAddToCart() {
        for (WebElement addToCartBtn : listOfAllAddToCartBtn) {
            addToCartBtn.click();
        }
    }


}
