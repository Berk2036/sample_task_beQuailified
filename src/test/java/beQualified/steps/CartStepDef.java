package beQualified.steps;

import beQualified.pages.*;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.ArrayList;
import java.util.List;

public class CartStepDef {


    SoftAssertions softAssertions = new SoftAssertions();
;
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();



    @Then("the user clicks the remove button at cart page")
    public void the_user_clicks_the_remove_button_at_cart_page() {

        cartPage.allProductRemoveFromCart();

    }

    @Then("the products should no longer visible in the cart")
    public void the_products_should_no_longer_visible_in_the_cart() {

      softAssertions.assertThat(cartPage.productList).isEmpty();

      softAssertions.assertAll();

    }


}