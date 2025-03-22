package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;



public class Hooks {
    public static WebDriver driver;  // ✅ Static driver to keep session across all features
    static LoginPage loginPage;

    @BeforeAll  // ✅ Runs ONCE before all feature files
    public static void setUp() throws InterruptedException {
        if (driver == null) {  // Initialize driver only once
            driver = new ChromeDriver();
            System.out.println("SettingUp the Browser!!");
            System.out.println("Opening the Webpage!");
            driver.manage().window().maximize();
            driver.get("http://zero.webappsecurity.com/login.html");
           
            Thread.sleep(1000);
        }
    }

    @AfterAll  // ✅ Runs ONCE after all feature files
    public static void tearDown() throws InterruptedException {
        if (driver != null) {
        	System.out.println("Closing the Browser!");
        	Thread.sleep(5000);
            driver.quit();  // Close browser only once after all tests
            driver = null;  // Reset driver for next execution
        }
    }
}
