package beQualified.steps;

import beQualified.pages.CheckoutPage;
import beQualified.utilities.BrowserUtils;
import beQualified.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;

import java.util.Map;

import static org.junit.Assert.*;

public class CheckoutStepDef {

    CheckoutPage checkoutPage = new CheckoutPage();


    @Then("the user enters the required information")
    public void the_user_enters_the_required_information(Map<String, String> requiredInformation) {
        //type value in input
        checkoutPage.typeRequiredInfoAtCheckoutPage(requiredInformation);

        // if the entered text in the input matches the expected text
        assertEquals(requiredInformation, checkoutPage.getActualRequiredInfoAtCheckoutPage(checkoutPage.checkoutInputs));
    }

    @Then("the user should be redirected to the cart page with click cancel button")
    public void the_user_should_be_redirected_to_the_cart_page_with_click_cancel_button() {
        checkoutPage.cancelBtn.click();
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("cart"));
    }


}
