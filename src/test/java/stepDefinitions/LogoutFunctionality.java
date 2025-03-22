package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.StatementPage;

public class LogoutFunctionality {
    WebDriver driver = Hooks.driver;  // ✅ Reusing WebDriver from Hooks
    StatementPage logoutPage = new StatementPage(driver);

    @Given("User is logged into the application")
    public void user_is_logged_in() {
    	System.out.println("User is about to logout");
    }

    @When("User clicks on the Logout button")
    public void user_clicks_logout_button() {
        logoutPage.logout();
    }

    @Then("User should be redirected to the login page")
    public void user_should_be_redirected_to_login_page() {
    	System.out.println("User logged out!");
    	String expectedSignin = "Signin";
    	String actualSignin = logoutPage.checkLogout();
    	System.out.println("Expected: "+expectedSignin);
    	System.out.println("Actual: "+actualSignin);
    	Assert.assertEquals(actualSignin,expectedSignin, "Logout Failed!");
        String expectedURL = "http://zero.webappsecurity.com/login.html";
        
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Logout Successful, But user not directed to login page !");
    }

    @Given("User logs out of the application")
    public void user_logs_out() {
        System.out.println("User loggedout");
    }

    @When("User clicks the Back button in the browser")
    public void user_clicks_back_button() {
        driver.navigate().back();
    }

    @Then("User should not be able to access the previous page")
    public void user_should_not_access_previous_page() {
        String expectedURL = "http://zero.webappsecurity.com/login.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Session is still active after logout!");
    }
}
