package beQualified.steps;

import beQualified.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import  static org.junit.Assert.*;

public class CartStepDef {

    CartPage cartPage = new CartPage();

    @And("the user clicks the remove button at cart page")
    public void the_user_clicks_the_remove_button_at_cart_page() {
        cartPage.allProductRemoveFromCart();
    }

    @Then("the products should no longer visible in the cart")
    public void the_products_should_no_longer_visible_in_the_cart() {
        assertTrue(cartPage.productList.isEmpty());
    }


}
