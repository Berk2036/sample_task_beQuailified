package beQualified.steps;

import beQualified.pages.*;
import beQualified.utilities.BrowserUtils;
import beQualified.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ShopStepDef {

    List<String> expectedProductListData = new ArrayList<>();
    List<String> actualProductListData = new ArrayList<>();

    SoftAssertions softAssertions = new SoftAssertions();


    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();


    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {
        shopPage.sauceLabsAddToCartBtn.click();
    }

    @When("the user navigates to the cart page")
    public void the_user_navigates_to_the_cart_page() {
       BrowserUtils.waitForToClickElement(shopPage.shoppingCartIcon, 10).click();
    }

    @When("the user initiates the checkout process")
    public void the_user_initiates_the_checkout_process() {
        BrowserUtils.waitForToClickElement(cartPage.checkoutBtn, 10).click();
    }

    @When("the user enters the required informations")
    public void the_user_enters_the_required_informations(Map<String, String> requiredInformation) {
        checkoutPage.typeRequiredInfoAtCheckoutPage(requiredInformation);
        Map<String, String> actualRequiredInformation = checkoutPage.getActualRequiredInfoAtCheckoutPage(checkoutPage.checkoutInputs);

        assertEquals(requiredInformation, actualRequiredInformation);
        BrowserUtils.waitForToClickElement(checkoutPage.continueBtn, 10).click();
    }

    @When("the user clicks the finish button")
    public void the_user_clicks_the_finish_button() {
        BrowserUtils.waitForToClickElement(checkoutOverviewPage.finishBtn, 10).click();
    }

    @Then("the user should be see the success message")
    public void the_user_should_be_see_the_success_message() {
        String actualMessageTitle = checkoutCompletePage.shoppingSuccessMessageTitle.getText();
        String actualMessageText = checkoutCompletePage.getShoppingSuccessMessageText.getText();
        String expectedMessageTitle = ConfigurationReader.getProperty("success_title_for_shopping");
        String expectedMessageText = ConfigurationReader.getProperty("success_message_for_shopping");

        assertEquals(expectedMessageTitle, actualMessageTitle);
        assertEquals(expectedMessageText, actualMessageText);
    }

    @When("the user clicks the back button")
    public void the_user_clicks_the_back_button() {
        BrowserUtils.waitForToClickElement(checkoutCompletePage.backHomeBtn, 5).click();
    }


    @When("the user clicks all Add to Cart")
    public void the_user_clicks_all_add_to_cart() {
        for (WebElement addToCartBtn : shopPage.listOfAllAddToCartBtn) {
            addToCartBtn.click();
        }
    }
    
    @Then("the button should change to Remove")
    public void the_button_should_change_to_remove() {
      //  Assert.assertEquals(shopPage.productList.size(), shopPage.listOfAllRemoveBtn.size());
        softAssertions.assertThat(shopPage.productList.size()).isEqualTo(shopPage.listOfAllRemoveBtn.size());
    }

    @When("the user clicks the remove button")
    public void the_user_clicks_the_remove_button() {
        for (WebElement removeBtn : shopPage.listOfAllRemoveBtn) {
            removeBtn.click();
        }
    }

    @Then("the button should change to Add to Cart")
    public void the_button_should_change_to_add_to_cart() {
        softAssertions.assertThat(shopPage.productList.size()).isEqualTo(shopPage.listOfAllAddToCartBtn.size());
    }

    @Then("the number in the cart icon should match the number of products in cart")
    public void the_number_in_the_cart_icon_should_match_the_number_of_products_in_cart() {
        String cartText = shopPage.CartIcon.getText();
        int cartValue = cartText.isEmpty() ? 0 : Integer.parseInt(cartText);

        int addCartBtnValue = shopPage.listOfAllRemoveBtn.size();

        //Assert.assertEquals(cartValue, addCartBtnValue);
        softAssertions.assertThat(cartValue).isEqualTo(addCartBtnValue);

        softAssertions.assertAll();
    }

    @When("the user has added first product to the cart")
    public void the_user_has_added_first_product_to_the_cart() {
        expectedProductListData = shopPage.getListProductInfoWithoutImage(shopPage.productList.get(0));
        shopPage.listOfAllAddToCartBtn.get(0).click();
    }

    @Then("the product information in the cart should match the shop page details")
    public void the_product_information_in_the_cart_should_match_the_shop_page_details() {
        actualProductListData = cartPage.getListProductInfo(cartPage.productList.get(0));
        Assert.assertEquals(expectedProductListData, actualProductListData);
    }

    @When("the user has added all product to the cart")
    public void the_user_has_added_all_product_to_the_cart() {
        expectedProductListData = shopPage.getListAllProductInfoWithoutImage(shopPage.productList);
        shopPage.allProductAddToCart();
    }

    @When("the all product information in the cart should match the shop page details")
    public void the_all_product_information_in_the_cart_should_match_the_shop_page_details() {
        actualProductListData = cartPage.getListAllProductInfo(cartPage.productList);
        assertEquals(expectedProductListData, actualProductListData);
    }

    @When("the user clicks the Continue Shopping button")
    public void the_user_clicks_the_continue_shopping_button() {
        cartPage.continueShoppingBtn.click();
    }


}
