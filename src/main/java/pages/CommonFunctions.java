package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import org.openqa.selenium.By;

public class CommonFunctions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;  // Return false if the element is not found
        }
    }
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByContainsVisibleText(visibleText);
    }
    
    public void enterText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}