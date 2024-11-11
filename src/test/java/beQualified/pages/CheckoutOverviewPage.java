package beQualified.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     *
     * @param products
     * @return
     */
    public double getIteTotalPrice(List<WebElement> products) {
        for (WebElement product : products) {
            price += Double.parseDouble(getProductPrice(product));
        }
        return price;
    }

}
