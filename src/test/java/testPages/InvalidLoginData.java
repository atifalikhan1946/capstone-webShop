package testPages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ExcelUtils;

public class InvalidLoginData extends BaseClass {
    //WebDriver driver;

    @BeforeMethod
    public void setUp() {
        initializeBrowser("chrome");
    }

    @Test(dataProvider = "InvalidCredentialsProvider", dataProviderClass = ExcelUtils.class)
    public void testInvalidLogin(String email, String password) {
        try {
        	driver.findElement(By.linkText("Log in")).click();
        	Thread.sleep(3000);
        	BaseClass.driver.findElement(By.id("Email")).click();
        	BaseClass.driver.findElement(By.id("Email")).clear();
            driver.findElement(By.id("Email")).sendKeys(email);
            driver.findElement(By.id("Password")).click();
            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys(password);

            driver.findElement(By.cssSelector("input.button-1.login-button")).click();

            String errorMessage = driver.findElement(By.cssSelector(".validation-summary-errors")).getText();
            Assert.assertTrue(errorMessage.contains("Login was unsuccessful. Please correct the errors and try again."),
                    "Expected error message not displayed!");
            System.out.println("Test Passed - Invalid Login: " + email + " | " + (password.isEmpty() ? "[BLANK]" : password));
        } catch (Exception e) {
            System.out.println("Test Failed for Email: " + email + " | Password: " + password);
            System.out.println("Error: " + e.getMessage());
        }
    }
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}