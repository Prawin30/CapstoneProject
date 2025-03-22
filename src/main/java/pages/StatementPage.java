package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StatementPage extends CommonFunctions {
    // ✅ Locators for Statements & Documents elements
    private By statementsTab = By.id("online_statements_tab");
    private By accountDropdown = By.id("os_accountId");
    private By downloadButton = By.cssSelector("#os_2012 > table > tbody > tr > td:nth-child(1) > a");
    private By afterSuccessfulLogin = By.cssSelector("#settingsBox > ul > li:nth-child(3) > a");
    private By logoutBtn = By.id("logout_link");
    private By signinBtn = By.id("signin_button");

    // ✅ Constructor
    public StatementPage(WebDriver driver) {
        super(driver);
    }

    // ✅ Navigate to Statements & Documents page
    public void goToStatementsPage() {
        click(statementsTab);
    }

    // ✅ Select Account from Dropdown
    public void selectAccount(String account) {
        selectDropdownByVisibleText(accountDropdown, account);
    }

 
    // ✅ Click Download PDF Button
    public void clickDownloadStatement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        downloadBtn.click();
    }
    public void logout() {
    	click(afterSuccessfulLogin);
    	click(logoutBtn);
	}
    public String checkLogout() {
    	return driver.findElement(signinBtn).getText();
    }
}
