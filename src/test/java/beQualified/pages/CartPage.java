package beQualified.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {


    // title "Your Cart"
    @FindBy(className = "title")
    public WebElement cartPageTitle;

    //Button "Continue Shopping"
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingBtn;

    //checkout button
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    //List of all products
    @FindBy(css = ".cart_item")
    public List<WebElement> productList;


    @FindBy(className = "inventory_item_name")
    public List<WebElement> listOfProductName;

    @FindBy(className = "inventory_item_desc")
    public List<WebElement> listOfProductDescription;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> listOfProductPrice;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public List<WebElement> listOfAllRemoveButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;


    public List<String> getListProductInfo(WebElement product) {

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

            // Add all details to the list
            Collections.addAll(productInfo, productName, productPrice, productDescription);
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


    public void allProductRemoveFromCart() {
        for (WebElement removeButton : listOfAllRemoveButton) {
            removeButton.click();
        }
    }

}