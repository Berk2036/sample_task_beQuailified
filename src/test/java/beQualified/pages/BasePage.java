package beQualified.pages;



import beQualified.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public abstract class BasePage {

    private By titleLocator = By.cssSelector("[data-test='inventory-item-name']");
    private By priceLocator = By.cssSelector("[data-test='inventory-item-price']");
    private By descriptionLocator = By.cssSelector("[data-test='inventory-item-desc']");
    private By imgLocator = By.cssSelector(".inventory_item_img");

    @FindBy(className = "app_logo")
    public WebElement pageHeader;

    //menu button
    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    //logout button
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    //reset button
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppButton;

    // list of products
    @FindBy(css = "[data-test='inventory-item']")
    public List<WebElement> productList;

    //List of product name
    @FindBy(css = "[data-test='inventory-item-name']")
    public List<WebElement> listOfAllProductTitles;

    // product name
    @FindBy(css = "[data-test='inventory-item-name']")
    public WebElement productTitle;

    // list of product description
    @FindBy(css = "[data-test='inventory-item']")
    public List<WebElement> listOfAllProductDescriptions;

    // product name
    @FindBy(css = "[data-test='inventory-item-description']")
    public List<WebElement> inventoryItemNameElements;

    // list of product price
    @FindBy(css = "[data-test='inventory-item-price']")
    public List<WebElement> listOfAllPrices;

    //list of all add to cart button at shop page
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")
    public List<WebElement> listOfAllAddToCartBtn;

    //list of all remove button
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory ']")
    public List<WebElement> listOfAllRemoveBtn;

    /**
     *
     */
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

    /**
     * to get product price
     * @param product
     * @return
     */
    public String getProductPrice(WebElement product) {
        return product.findElement(priceLocator).getText();
    }

    /**
     * to get product title
     * @param product
     * @return
     */
    public String getProductTitle(WebElement product) {
      //  return product.findElement(titleLocator).getText();
        return product.findElement(titleLocator).getText();

    }

    /**
     * to get product description
     * @param product
     * @return
     */
    public String getProductDescription(WebElement product) {
        return product.findElement(descriptionLocator).getText();
    }

    /**
     * to get src attribute
     * @param product
     * @return
     */
    public String getProductSrcAttribute(WebElement product) {
        return product.findElement(imgLocator).getAttribute("src");
    }


    /**
     * Method to retrieve all product information without image
     * @param products
     * @return
     */
    public List<String> getListProductInfoWithoutImage(List<WebElement> products) {
        List<String> productInfo = new ArrayList<>(); // Local variable
        for (WebElement product : products) {
            // Retrieve product details and add them to the list
            String productName = getProductTitle(product);
            String productPrice = getProductPrice(product);
            String productDescription = getProductDescription(product);

            Collections.addAll(productInfo, productName, productPrice, productDescription);
        }
        return productInfo;
    }

    /**
     * Method to retrieve all product information without image
     * @param product
     * @return
     */
    public List<String> getListProductInfoWithoutImage(WebElement product) {
        List<String> productInfo = new ArrayList<>(); // Local variable

        // Retrieve product details and add them to the list
        String productName = getProductTitle(product);
        System.out.println("productName = " + productName);
        String productPrice = getProductPrice(product);
        String productDescription = getProductDescription(product);

        Collections.addAll(productInfo, productName, productPrice, productDescription);

        return productInfo;
    }

    /**
     * Method to retrieve all product information
     * @param products
     * @return
     */
    public List<String> getListProductInfo(List<WebElement> products) {
        List<String> productInfo = new ArrayList<>(); // Local variable

        for (WebElement product : products) {

            // Retrieve product details
            String productName = getProductTitle(product);
            String productPrice = getProductPrice(product);
            String productDescription = getProductDescription(product);
            String productImageAttribute = getProductSrcAttribute(product);

            Collections.addAll(productInfo, productName, productPrice, productDescription, productImageAttribute);

        }
        // Return the list containing all product information
        return productInfo;
    }

    /**
     * Method to retrieve all product information
     * @param product
     * @return
     */
    public List<String> getListProductInfo(WebElement product) {
        List<String> productInfo = new ArrayList<>(); // Local variable
        // Retrieve product details
        String productName = getProductTitle(product);
        String productPrice = getProductPrice(product);
        String productDescription = getProductDescription(product);

        // Add all details to the list
        Collections.addAll(productInfo, productName, productPrice, productDescription);

        // Return the list containing all product information
        return productInfo;
    }

    /**
     * Method to retrieve all product information
     * @param product
     * @return
     */
    public Map<String, String> getProductInfo(WebElement product){
        Map<String, String> mapProductInfo = new HashMap<>();

        mapProductInfo.put("name", getProductTitle(product));
        mapProductInfo.put("price", getProductPrice(product));
        mapProductInfo.put("description", getProductDescription(product));
        mapProductInfo.put("image", getProductSrcAttribute(product));

        return mapProductInfo;
    }

    /**
     * to get src attribute
     * @param product
     * @return
     */
    public String getAttributeSrc(WebElement product){
        return product.getAttribute("src");
    }


}