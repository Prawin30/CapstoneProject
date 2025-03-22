package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferPage extends CommonFunctions {
    // ✅ Locators for Fund Transfer elements
	private By fundTransfer = By.xpath("//*[@id=\"transfer_funds_tab\"]/a");
    private By fromAccountDropdown = By.id("tf_fromAccountId");
    private By toAccountDropdown = By.id("tf_toAccountId");
    private By amountField = By.id("tf_amount");
    private By continueButton = By.xpath("//*[@id=\"btn_submit\"]");
    private By submitButton = By.xpath("//*[@id=\"btn_submit\"]");
    private By statusMessage = By.cssSelector("#transfer_funds_content > div > div > div.alert.alert-success");

    // ✅ Constructor
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }
    public void goToFundTransfer() {
    	click(fundTransfer);
    }
    // ✅ Select "From Account"
    public void selectFromAccount(String account) {
        selectDropdownByVisibleText(fromAccountDropdown, account);
    }

    // ✅ Select "To Account"
    public void selectToAccount(String account) {
        selectDropdownByVisibleText(toAccountDropdown, account);
    }

    // ✅ Enter transfer amount
    public void enterAmount(String amount) {
        enterText(amountField, amount);
    }
    public void clickContinue() {
    	click(continueButton);
		// TODO Auto-generated method stub

	}
    // ✅ Click Submit button
    public void clickSubmit() {
        click(submitButton);
    }

    // ✅ Get success message after fund transfer
    public String getMessage() {
        return getText(statusMessage);
    }
   

}
