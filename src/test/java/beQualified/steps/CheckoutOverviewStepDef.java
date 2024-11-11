package beQualified.steps;

import beQualified.pages.*;
import beQualified.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheckoutOverviewStepDef {

    LoginPage loginPage = new LoginPage();
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    List<String> expectedProductListData = new ArrayList<>();
    List<String> actualProductListData = new ArrayList<>();

    double totalItemPrice = 0;
    double tax = 0;


    @Given("the user sees the product information")
    public void the_user_sees_the_product_information() {
        expectedProductListData = shopPage.getListProductInfoWithoutImage(shopPage.productList);
    }

    @Then("the user should be redirected to the checkout overview with click continue button")
    public void the_user_should_be_redirected_to_the_checkout_overview_with_click_continue_button() {
        checkoutPage.continueBtn.click();
    }

    @Then("product information on the checkout overview page should match in the shop page")
    public void product_information_on_the_checkout_overview_page_should_match_in_the_shop_page() {
        BrowserUtils.waitForVisibility(checkoutOverviewPage.finishBtn, 5);
        // product information from checkout overview page
        actualProductListData = checkoutOverviewPage.getListProductInfoWithoutImage(checkoutOverviewPage.productList);

        assertEquals(expectedProductListData, actualProductListData);
    }



}


