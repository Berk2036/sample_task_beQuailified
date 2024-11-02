package beQualified.pages;


import beQualified.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //for username
    @FindBy(id = "user-name")
    public WebElement usernameField;

    //for password
    @FindBy(id = "password")
    public WebElement passwordField;

    //Login button
    @FindBy(id = "login-button")
    public WebElement loginButton;

    //for error messages
    @FindBy(className = "error-message-container")
    public WebElement errorMessage;

    public void login(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

}