package beQualified.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage{
    // success title
    @FindBy(className = "complete-header")
    public WebElement successTitle;

    // success message
    @FindBy(className = "complete-text")
    public WebElement successMessage;

    //button back home
    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;




}
