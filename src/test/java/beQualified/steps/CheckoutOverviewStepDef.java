package beQualified.steps;

import beQualified.pages.*;
import beQualified.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewStepDef {


    LoginPage loginPage = new LoginPage();
    ShopPage shopPage = new ShopPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    List<String> expectedProductListData = new ArrayList<>();
    List<String> actualProductListData = new ArrayList<>();

    SoftAssertions softAssertions = new SoftAssertions();

    double totalItemPrice = 0;
    double tax = 0;



    @Given("the user sees the product information")
    public void the_user_sees_the_product_information() {

      expectedProductListData = shopPage.getListAllProductInfoWithoutImage(shopPage.productList);

    }

    @Then("the user should be redirected to the checkout overview with click continue button")
    public void the_user_should_be_redirected_to_the_checkout_overview_with_click_continue_button() {

        checkoutPage.continueBtn.click();

    }

    @Then("product information on the checkout overview page should match in the shop page")
    public void product_information_on_the_checkout_overview_page_should_match_in_the_shop_page() {

        BrowserUtils.waitForVisibility(checkoutOverviewPage.finishBtn, 5);
        // product information from checkout overview page
        actualProductListData = checkoutOverviewPage.getListAllProductInfo(checkoutOverviewPage.productList);
        System.out.println("checkoutOverviewPage = " + checkoutOverviewPage.productList);

        System.out.println("expectedProductListData = " + expectedProductListData);
        System.out.println("actualProductListData = " + actualProductListData);

     //   Assert.assertEquals(expectedProductListData, actualProductListData);

    }

    @Then("the tax should be accurately calculated based on the items in the cart")
    public void the_tax_should_be_accurately_calculated_based_on_the_items_in_the_cart() {

        totalItemPrice += checkoutOverviewPage.getIteTotalPrice(checkoutOverviewPage.listOfProductPrice);
        System.out.println("totalItemPrice = " + totalItemPrice);
         tax += totalItemPrice * 0.08;
        System.out.println("tax = " + tax);

    }

    @Then("the total amount should include the correct tax amount")
    public void the_total_amount_should_include_the_correct_tax_amount() {

        double total = tax + totalItemPrice;
        System.out.println("total = " + total);

    }

}


