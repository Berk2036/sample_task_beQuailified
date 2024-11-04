package beQualified.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

    @FindBy(className = "title")
    public WebElement checkoutCompleteTitle;

    @FindBy(className = "complete-header")
    public WebElement shoppingSuccessMessageTitle;

    @FindBy(className = "complete-text")
    public WebElement getShoppingSuccessMessageText;

    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;



}
