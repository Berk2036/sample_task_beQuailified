package beQualified.pages;

import beQualified.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage {

    Map<String, String> actualRequiredInformation = new HashMap<>();
    // Title
    @FindBy(className = "title")
    public WebElement checkoutPageTitle;

    @FindBy(id = "cancel")
    public WebElement cancelBtn;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "first-name")
    public WebElement firstnameInput;

    @FindBy(id = "last-name")
    public WebElement lastnameInput;

    @FindBy(id = "postal-code")
    public WebElement zipCodeInput;

    @FindBy(className = "checkout_info")
    public List<WebElement> checkoutInputs;



    public void typeRequiredInfoAtCheckoutPage(Map<String, String> requiredInformation){
        firstnameInput.sendKeys(requiredInformation.get("name"));
        lastnameInput.sendKeys(requiredInformation.get("lastname"));
        zipCodeInput.sendKeys(requiredInformation.get("zip_code"));
    }

    public Map<String, String> getActualRequiredInfoAtCheckoutPage(List<WebElement> products){

        BrowserUtils.waitForVisibility(firstnameInput, 5);

        for (WebElement product : products) {

            actualRequiredInformation.put("name", getNameText(product));
            actualRequiredInformation.put("lastname", getLastnameText(product));
            actualRequiredInformation.put("zip_code", getZipCodeText(product));

        }

        return actualRequiredInformation;
    }

    public String getNameText(WebElement product) {

        return product.findElement(By.id("first-name")).getAttribute("value");

    }

    public String getLastnameText(WebElement product) {

        return product.findElement(By.id("last-name")).getAttribute("value");

    }

    public String getZipCodeText(WebElement product) {

        return product.findElement(By.id("postal-code")).getAttribute("value");

    }

}
