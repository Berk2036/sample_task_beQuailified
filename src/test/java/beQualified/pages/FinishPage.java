package beQualified.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage{

    @FindBy(className = "complete-header")
    public WebElement successTitle;

    @FindBy(className = "complete-text")
    public WebElement successMessage;

     @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;




}
