package beQualified.pages;

import beQualified.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(css = ".inventory_details_name")
    public WebElement productName;
    @FindBy(css = ".inventory_details_desc")
    public WebElement productDescription;

    @FindBy(css = ".inventory_details_price")
    public WebElement productPrice;

    @FindBy(id = "back-to-products")
    public WebElement backToShopPageBtn;

    @FindBy(id = "add-to-cart")
    public WebElement addToCartBtn;


    public String getAttributeSrc(WebElement product){

        return product.getAttribute("src");

    }

    public String getProductPrice(WebElement product) {

        return product.findElement(By.className("inventory_details_price")).getText();

    }

    public String getProductTitle(WebElement product) {

        return product.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();

    }

    public String getProductDescription(WebElement product) {

        return product.findElement(By.className("inventory_details_desc")).getText();

    }

    public void backToShopPage(){

        BrowserUtils.waitForVisibility(backToShopPageBtn, 10);
        backToShopPageBtn.click();

    }


}
