package beQualified.steps;

import beQualified.pages.LoginPage;
import beQualified.pages.ShopPage;
import beQualified.utilities.BrowserUtils;
import beQualified.utilities.ConfigurationReader;
import beQualified.utilities.enums.ErrorMessages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    ShopPage shopPage = new ShopPage();

    @When("the user loges in with  {string} and {string}")
    public void theUserLogesInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the {string} page")
    public void theUserShouldBeRedirectedToThePage(String page) {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty(page));
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String errorMessage) {
        String expectedErrorMessage = ErrorMessages.valueOf(errorMessage).getErrorMessage();

        String actualMessage = loginPage.errorMessage.getText();
        assertEquals(expectedErrorMessage, actualMessage);
    }

    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("login"));
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        shopPage.logout();
    }

    @Given("the user clicks the browser's Back button")
    public void the_user_clicks_the_browser_s_back_button() {
        BrowserUtils.navigateBack();
    }

    @Given("the user clicks the browser's Forward button")
    public void the_user_clicks_the_browser_s_forward_button() {
        BrowserUtils.waitFor(4);
        BrowserUtils.navigateForward();
    }

    @Then("the user should be able to access the Shop page")
    public void the_user_should_be_able_to_access_the_shop_page() {
        BrowserUtils.verifyURLContains(ConfigurationReader.getProperty("shop"));
    }

    @Given("the user tries with {string} and {string}")
    public void the_user_tries_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        String url = ConfigurationReader.getProperty(page);
        BrowserUtils.getUrl(url);
    }


}
