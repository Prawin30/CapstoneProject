package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSummaryPage extends CommonFunctions {
    // ✅ Locators for different elements on the Account Summary page
    private By pageHeader = By.tagName("h2");
    private By checkingAccount = By.linkText("Checking");
    private By savingsAccount = By.linkText("Savings");
    private By creditCardAccount = By.linkText("Credit Card");
    private By loanAccount = By.linkText("Loan");
    private By onlineBankingTab = By.id("onlineBankingMenu");
    private By accountSummaryTab = By.id("account_summary_link");
    private By balanceAmount = By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[2]/td[3]");
    private By accountSummaryInFundTransfer = By.cssSelector("#account_summary_tab > a");

    // ✅ Constructor
    public AccountSummaryPage(WebDriver driver) {
        super(driver);
    }

    // ✅ Method to get the page header text
    public String getPageHeader() {
        return getText(pageHeader);
    }

    // ✅ Method to click on Online Banking (before navigating to Account Summary)
    public void clickOnlineBanking() {
        click(onlineBankingTab);
    }

    // ✅ Method to click on Account Summary tab
    public void clickAccountSummary() {
    	click(accountSummaryTab);
    }
    public void clickAccountSummary2() {
    	click(accountSummaryInFundTransfer);
    }
    public String getBalanceAmount() {
		return getText(balanceAmount);
	}

    // ✅ Method to check if a specific account type is displayed
    public boolean isAccountTypeDisplayed(String accountType) {
        switch (accountType) {
            case "Checking":
                return isElementDisplayed(checkingAccount);
            case "Savings":
                return isElementDisplayed(savingsAccount);
            case "Credit Card":
                return isElementDisplayed(creditCardAccount);
            case "Loan":
                return isElementDisplayed(loanAccount);
            default:
                return false;
        }
    }

   
    public void clickAccountLink(String accountType) {
        switch (accountType) {
            case "Checking":
                click(checkingAccount);
                break;
            case "Savings":
                click(savingsAccount);
                break;
            case "Credit Card":
                click(creditCardAccount);
                break;
            case "Loan":
                click(loanAccount);
                break;
            default:
                System.out.println("Invalid account type: " + accountType);
        }
    }
}
