package pages;

import base.BaseClass;
import utilities.ConfigReader;
import utilities.ReportManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class CartPage1 extends BaseClass {
	
	ConfigReader config = new ConfigReader();
	
//	Required for Register
    public By registerLink = By.linkText("Register");
    public By genderMale = By.id("gender-male");
    public By firstNameField = By.id("FirstName");
    public By lastNameField = By.id("LastName");
    public By emailField1 = By.id("Email");
    public By passwordField1 = By.id("Password");
    public By confirmPasswordField = By.id("ConfirmPassword");
    public By registerButton = By.id("register-button");
    public By errorMessage = By.xpath("//li[normalize-space()='The specified email already exists']");

    
//    Required for Login
	public By loginLink = By.linkText("Log in");
	public By emailField = By.id("Email");
	public By passwordField = By.id("Password");
	public By loginButton = By.cssSelector("input.button-1.login-button");
	
//	Required for Adding Book To Cart
	public By Books = By.linkText("Books");
	public By Book1AddToCart = By.xpath("//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
	public By shoppingcart = By.linkText("Shopping cart");

	
	
	
	public void BooksCategory() {
		try {
			ReportManager.createTest("Register");  // Starting the report
	        driver.findElement(registerLink).click();
	        ReportManager.getTest().log(Status.INFO, "Clicked on Register link");
	        driver.findElement(genderMale).click();
	        ReportManager.getTest().log(Status.INFO, "Selecting Gender Field");
	        driver.findElement(firstNameField).sendKeys(config.getProperty("firstname"));
	        ReportManager.getTest().log(Status.INFO, "Entered The First Name");
	        driver.findElement(lastNameField).sendKeys(config.getProperty("lastname"));
	        ReportManager.getTest().log(Status.INFO, "Entered The Last Name");
	        driver.findElement(emailField1).sendKeys(config.getProperty("email"));
	        ReportManager.getTest().log(Status.INFO, "Entered The Email");
	        driver.findElement(passwordField1).sendKeys(config.getProperty("password"));
	        ReportManager.getTest().log(Status.INFO, "Entered The Password");
	        driver.findElement(confirmPasswordField).sendKeys(config.getProperty("password"));
	        ReportManager.getTest().log(Status.INFO, "ReEntered The Password");
	        driver.findElement(registerButton).click();
	        ReportManager.getTest().pass("Registratin Successful");
	        
	        
			ReportManager.createTest("login-Functionality"); // Starting the report
			driver.findElement(loginLink).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on Login link");
			driver.findElement(emailField).sendKeys(config.getProperty("email"));
			ReportManager.getTest().log(Status.INFO, "Entered Email");
			driver.findElement(passwordField).sendKeys(config.getProperty("password"));
			ReportManager.getTest().log(Status.INFO, "Entered Password");
			driver.findElement(loginButton).click();
			ReportManager.getTest().pass("Login Successful");
			
			

			ReportManager.createTest("Add Books to Cart"); // Starting the report
			driver.findElement(Books).click();
			ReportManager.getTest().log(Status.INFO, "Navigated to Books Category");
			driver.findElement(Book1AddToCart).click();
			ReportManager.getTest().pass("First Product Added to Cart");
			driver.findElement(shoppingcart).click();
			ReportManager.getTest().pass("Successfully Entered Shopping Cart");
		} catch (Exception e) {
			ReportManager.getTest().fail("Test Failed: " + e.getMessage());
		}
	}
}
