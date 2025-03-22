package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginFunctionality {
    WebDriver driver = Hooks.driver;  //  Reusing the WebDriver from Hooks
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        System.out.println("User is on the LoginPage");
    }

    @When("User enters {string} and {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("Clicks the login button")
    public void clicks_login_button() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(2000);
    }

    @Then("User should see their username as {string}")
    public void user_should_see_message(String message) {
        if (message.equals("username")) {
        	driver.navigate().back();
        	Assert.assertTrue(loginPage.successfulLogin().contains(message), "Login Failed!");
        } else {
            Assert.assertTrue(loginPage.getErrorMessage().contains(message), "Error message not displayed!");
        }
       
    }
}
