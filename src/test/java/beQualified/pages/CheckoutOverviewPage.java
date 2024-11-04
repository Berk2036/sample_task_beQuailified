package beQualified.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckoutOverviewPage extends BasePage {


    double price = 0;

    //List of all products
    @FindBy(css = ".cart_item")
    public List<WebElement> productList;

    //product name
    @FindBy(className = "inventory_item_name")
    public List<WebElement> listOfProductName;

    //product description
    @FindBy(className = "inventory_item_desc")
    public List<WebElement> listOfProductDescription;

    //product price
    @FindBy(className = "inventory_item_price")
    public List<WebElement> listOfProductPrice;

    //payment information
    @FindBy(xpath = "(//div[@class='summary_value_label'])[1]")
    public WebElement paymentInformation;

    //shipping information
    @FindBy(xpath = "(//div[@class='summary_value_label'])[2]")
    public WebElement shippingInformation;

    //total price without tax
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement sunTotalPrice;

    //tax value
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement taxValue;

    //total price with tax
    @FindBy(xpath = "//div[@class='summary_total_label']")
    public WebElement totalPriceValue;

    //cancel button
    @FindBy(id = "cancel")
    public WebElement cancelBtn;

    //finish button
    @FindBy(id = "finish")
    public WebElement finishBtn;


    public List<String> getListProductInfo(WebElement product){

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

    public void openProduct(WebElement product) {

        WebElement title = product.findElement(By.className("inventory_item_name"));
        title.click();

    }

    public double getIteTotalPrice(List<WebElement> products) {

        for (WebElement product : products) {

            price += Double.parseDouble(getProductPrice(product));

        }
        return price;
    }

}
