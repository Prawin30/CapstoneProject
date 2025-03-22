package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPayeePage extends CommonFunctions{
	private By addNewPayee = By.cssSelector("a[href='#ui-tabs-2']");
	private By payeeName = By.id("np_new_payee_name");
	private By payeeAddress = By.id("np_new_payee_address");
	private By payeeAccNum = By.id("np_new_payee_account");
	private By addBtn = By.id("add_new_payee");
	private By addedMsg = By.id("alert_content");

	public NewPayeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickNewPayee() {

		click(addNewPayee);
	}
	public void enterPayeeName(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(payeeName)); // Wait until dropdown is clickable
		enterText(payeeName,name);
	}
	public void enterPayeeAddress(String address) {
		enterText(payeeAddress,address);

	}
	public void enterPayeeAcc(String accNum) {
		enterText(payeeAccNum,accNum);

	}
	public void clickAdd() {
		click(addBtn);
	}
	public String getAddedSuccessMsg() {
		return getText(addedMsg);
	}
	public String getPayeeFieldValidationMessage() {
		WebElement payeeNameField = driver.findElement(payeeName); // Get WebElement

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage;", payeeNameField);
	}

}
