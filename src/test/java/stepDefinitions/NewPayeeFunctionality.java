package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.NewPayeePage;

public class NewPayeeFunctionality {
    WebDriver driver = Hooks.driver;  // ✅ Reusing WebDriver from Hooks
    NewPayeePage newPayeePage = new NewPayeePage(driver);

    @Given("User is on the Add New Payee page")
    public void user_is_on_the_add_new_payee_page() {
    	newPayeePage.clickNewPayee();
    	System.out.println("User is about to enter a new payee");
    }

    @When("User enters Payee Name as {string}")
    public void user_enters_payee_name(String payeeName) {
    	newPayeePage.enterPayeeName(payeeName);
    }

    @When("User enters Address as {string}")
    public void user_enters_address(String address) {
    	newPayeePage.enterPayeeAddress(address);
    }

    @When("User enters Account Number as {string}")
    public void user_enters_account_number(String accountNumber) {
    	newPayeePage.enterPayeeAcc(accountNumber);
    }

    @When("Clicks the Add button")
    public void clicks_the_add_button() throws InterruptedException {
    	newPayeePage.clickAdd();
    	Thread.sleep(2000);
    }

    @Then("User should see Payee Added {string}")
    public void user_should_see_payee_added_message(String expectedMessage) {
    	String actualMessage;
    	if(expectedMessage.contains("successfully created")) {
    		actualMessage = newPayeePage.getAddedSuccessMsg();
    		System.out.println("expected Msg : "+expectedMessage);
    		System.out.println("Actual Msg :"+actualMessage);
    	}else {
    		actualMessage = newPayeePage.getPayeeFieldValidationMessage();
    		System.out.println("expected Msg : "+expectedMessage);
    		System.out.println("Actual Msg :"+actualMessage);
    	}
        
        Assert.assertEquals(actualMessage, expectedMessage, "Message mismatch!");
    }
}