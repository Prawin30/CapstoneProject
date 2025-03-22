package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.PayBillsPage;

public class PayBillsFunctionality {
    WebDriver driver = Hooks.driver;  // ✅ Reuse WebDriver from Hooks
    PayBillsPage payBillsPage = new PayBillsPage(driver);

    @Given("User is on the Pay Bills page")
    public void user_is_on_pay_bills_page() throws InterruptedException {
    	Thread.sleep(2000);
    	payBillsPage.clickPayBill();
    	Thread.sleep(1000);
    	System.out.println("User in on Paybill page");
    }

    @When("User selects {string} as payee")
    public void user_selects_payee(String payee) {
        payBillsPage.selectPayee(payee);
    }

    @When("User enters {string} as amount")
    public void user_enters_amount(String amount) {
        payBillsPage.enterAmount(amount);
    }

    @When("User enters {string} as payment date")
    public void user_enters_payment_date(String date) {
        payBillsPage.enterDate(date);
    }

    @When("Clicks the pay button")
    public void clicks_pay_button() {
        payBillsPage.clickPay();
    }

    @Then("User should see the {string}")
    public void user_should_see_the_message(String expectedMessage) {
        String actualMessage;

        // ✅ Check if it's a success or error message
        if (expectedMessage.contains("successfully submitted")) {
            actualMessage = payBillsPage.getSuccessMessage();
            System.out.println("The expected msg: "+expectedMessage);
            System.out.println("The Actual msg : "+actualMessage);
        } else {
            actualMessage = payBillsPage.getAmountFieldValidationMessage();
            System.out.println("The expected msg: "+expectedMessage);
            System.out.println("The Actual msg : "+actualMessage);
        }

        Assert.assertEquals(actualMessage,expectedMessage, "Expected message not displayed!");
    }
}
