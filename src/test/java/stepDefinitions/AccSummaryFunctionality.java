package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountSummaryPage;

public class AccSummaryFunctionality {
    WebDriver driver = Hooks.driver;  // ✅ Reuse the same WebDriver from Hooks
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);

    @Given("User is Navigating to the Account Summary page")
    public void user_is_navigating_to_the_account_summary_page() {
        accountSummaryPage.clickOnlineBanking();  // ✅ Click Online Banking first
        accountSummaryPage.clickAccountSummary();  // ✅ Navigate to Account Summary page

    }

    @Then("User should see {string}")
    public void user_should_see_message(String expectedText) {
        String actualHeader = accountSummaryPage.getPageHeader();
        Assert.assertTrue(actualHeader.contains(expectedText), "Account Summary Page did not Open!");
        System.out.println("User has been successfully navigated to the Account Summary Page! ");

    }
    @Given("User is on the Account Summary page")
    public void user_is_on_account_summary_page() {
    	System.out.println("User is on the Account Summary Page");
	}
    
    @Then("User should see all account types displayed")
    public void user_should_see_all_account_types() throws InterruptedException {
        Assert.assertTrue(accountSummaryPage.isAccountTypeDisplayed("Checking"), "Checking account is missing!");
        System.out.println("Checking account type displayed");
        Assert.assertTrue(accountSummaryPage.isAccountTypeDisplayed("Savings"), "Savings account is missing!");
        System.out.println("Savings account type displayed");
        Assert.assertTrue(accountSummaryPage.isAccountTypeDisplayed("Credit Card"), "Credit Card account is missing!");
        System.out.println("Credit account type displayed");
        Assert.assertTrue(accountSummaryPage.isAccountTypeDisplayed("Loan"), "Loan account is missing!");
        System.out.println("Loan account type displayed");
        Thread.sleep(2000);

    }
}
