package beQualified.pages;



import beQualified.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BasePage {

    List<String> productInfo = new ArrayList<>();

    private By titleLocator = By.className("inventory_item_name");
    private By priceLocator = By.className("inventory_item_price");
    private By descriptionLocator = By.className("inventory_item_desc");
    private By imgLocator = By.cssSelector(".inventory_item_img img");


    @FindBy(className = "app_logo")
    public WebElement pageHeader;


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time to verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear(pageHeader);
//        BrowserUtils.waitForStaleElement(pageHeader);
        return pageHeader.getText();
    }

    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, can be continue in any case.
     */
    public void waitUntilLoaderScreenDisappear(WebElement stableElement) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(stableElement));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // to call Produktpreises
    public String getProductPrice(WebElement product, By priceLocator) {
        return product.findElement(priceLocator).getText();
    }

    // to call Produkttitels
    public String getProductTitle(WebElement product, By titleLocator) {
        return product.findElement(titleLocator).getText();
    }

    // to call Produktbeschreibung
    public String getProductDescription(WebElement product, By descriptionLocator) {
        return product.findElement(descriptionLocator).getText();
    }

    // to call 'src'-Attributs of Produktbildes
    public String getProductSrcAttribute(WebElement product, By imgLocator) {
        return product.findElement(imgLocator).getAttribute("src");
    }

    // Method to retrieve all product information including image, without a global productInfo
    public List<String> getListProductInfo(WebElement product) {
        List<String> productInfo = new ArrayList<>(); // Local variable

        // Retrieve product details and add them to the list
        String productName = getProductTitle(product, titleLocator);
        String productPrice = getProductPrice(product, priceLocator);
        String productDescription = getProductDescription(product, descriptionLocator);
        String productImageAttribute = getProductSrcAttribute(product, imgLocator);

        Collections.addAll(productInfo, productName, productPrice, productDescription, productImageAttribute);

        return productInfo;
    }

    // Method to retrieve all product information without image, without a global productInfo
    public List<String> getListProductInfoWithoutImage(WebElement product) {
        List<String> productInfo = new ArrayList<>(); // Local variable

        // Retrieve product details and add them to the list
        String productName = getProductTitle(product, titleLocator);
        String productPrice = getProductPrice(product, priceLocator);
        String productDescription = getProductDescription(product, descriptionLocator);

        Collections.addAll(productInfo, productName, productPrice, productDescription);

        return productInfo;
    }




}