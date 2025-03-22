package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsPage extends CommonFunctions {
    // ✅ Locators for Pay Bills elements
    private By payBillButton = By.cssSelector("#pay_bills_tab > a");
    private By payeeDropdown = By.xpath("//*[@id=\"sp_payee\"]");
    private By amountField = By.id("sp_amount");
    private By dateField = By.id("sp_date");
    private By payButton = By.id("pay_saved_payees");
    private By successMessage = By.id("alert_content");
   


    // ✅ Constructor
    public PayBillsPage(WebDriver driver) {
        super(driver);
    }
    public void clickPayBill() {
    	click(payBillButton);
	}
    // ✅ Select Payee from Dropdown
    public void selectPayee(String payeeName) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(payeeDropdown)); // Wait until dropdown is clickable
        selectDropdownByVisibleText(payeeDropdown, payeeName);    }

    // ✅ Enter Payment Amount
    public void enterAmount(String amount) {
        enterText(amountField, amount);
    }

    // ✅ Enter Payment Date
    public void enterDate(String date) {
        enterText(dateField, date);
    }

    // ✅ Click Pay Button
    public void clickPay() {
        click(payButton);
    }

    // ✅ Get Success Message
    public String getSuccessMessage() {
        return getText(successMessage);
    }
   
    public String getAmountFieldValidationMessage() {
        WebElement amountInput = driver.findElement(amountField); // Get WebElement

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", amountInput);
    }
   
   
}
