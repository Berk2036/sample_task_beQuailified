package beQualified.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public List<WebElement> listOfAllRemoveButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeButton;

    /**
     * to remove all element from cart
     */
    public void allProductRemoveFromCart() {
        for (WebElement removeButton : listOfAllRemoveButton) {
            removeButton.click();
        }
    }

}