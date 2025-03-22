package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.FundTransferPage;
import pages.AccountSummaryPage;

public class FundTransferFunctionality {
    WebDriver driver = Hooks.driver;  //  Reusing the WebDriver from Hooks
    FundTransferPage fundTransferPage = new FundTransferPage(driver);
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
    SoftAssert softAssert = new SoftAssert();
    @Given("User is on the Fund Transfer page")
    public void user_is_on_fund_transfer_page() {
        fundTransferPage.goToFundTransfer();//  Navigate to Fund Transfer page
        System.out.println("User is in FundTransfer Page");
    }

    @When("User selects {string} as From Account")
    public void user_selects_from_account(String fromAccount) {
        fundTransferPage.selectFromAccount(fromAccount);
    }

    @When("User selects {string} as To Account")
    public void user_selects_to_account(String toAccount) {
        fundTransferPage.selectToAccount(toAccount);
    }

    @When("User enters {string} as transfer amount")
    public void user_enters_transfer_amount(String amount) {
        fundTransferPage.enterAmount(amount);
    }

    @When("Clicks the submit button")
    public void clicks_submit_button() throws InterruptedException {
    	fundTransferPage.clickContinue();
    	Thread.sleep(1000);
        fundTransferPage.clickSubmit();
    }

    @Then("User should see msg as {string} and balance must be updated {string}")
    public void user_should_see_message(String expectedMessage, String checkBalance) throws InterruptedException {
    	String actualMessage = fundTransferPage.getMessage();
    	System.out.println("This is the Expected msg : "+expectedMessage);
    	System.out.println("This is the Actual msg : "+actualMessage);
    	softAssert.assertEquals(actualMessage,expectedMessage, "Expected message not displayed!");
    	if(checkBalance.equals("yes")) {
    		Thread.sleep(2000);
    		accountSummaryPage.clickAccountSummary2();
    		System.out.println("Account Summary clicked. Fetching balance...");
    		String expectedAmount = "$1048";
    		String actualAmount = accountSummaryPage.getBalanceAmount();
    		System.out.println("Expected Account Balance: " + expectedAmount);
    		System.out.println("Actual Account Balance: " + actualAmount);
            softAssert.assertEquals(actualAmount, expectedAmount, "Account Balance did not Update!");
    	}softAssert.assertAll();

    }

}
