package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonFunctions {
    private By usernameField = By.id("user_login");
    private By passwordField = By.id("user_password");
    private By loginButton = By.name("submit");
    private By errorMessage = By.cssSelector(".alert.alert-error");
    private By afterSuccessfulLogin = By.cssSelector("#settingsBox > ul > li:nth-child(3) > a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }
    public String successfulLogin() {
    	return driver.findElement(afterSuccessfulLogin).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
}
