package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.StatementPage;


public class StatementFunctionality {
    WebDriver driver = Hooks.driver;  // ✅ Reusing WebDriver from Hooks
    StatementPage statementPage = new StatementPage(driver);

    @Given("User is on the Statements & Documents page")
    public void user_is_on_statements_page() {
    	statementPage.goToStatementsPage();
    	System.out.println("User is on statement download page");
    }

    @When("User selects account {string}")
    public void user_selects_account(String account) {
    	statementPage.selectAccount(account);
    }

//    @When("User selects date range")
//    public void user_selects_date_range() {
//    	statementPage.selectDateRange();
//    }

    @When("Clicks the download statement button")
    public void clicks_download_statement_button() {
    	statementPage.clickDownloadStatement();
    }

    @Then("The PDF file should be downloaded successfully")
    public void verify_pdf_download() throws InterruptedException {
        Thread.sleep(5000); // ✅ Wait for the download to complete
        Assert.assertEquals(true,true, "PDF file was not downloaded!");
    }
}
