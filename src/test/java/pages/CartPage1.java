package pages;

import base.BaseClass;
import utilities.ConfigReader;
import utilities.ReportManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

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
	public By Book1AddToCart = By
			.xpath("//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
	public By shoppingcart = By.linkText("Shopping cart");
	
//  Required for Updating the cart
	
	public By searchTab = By.xpath("//input[@id='small-searchterms']");
	public By searchButton = By.xpath("//input[@value='Search']");
	public By viewProductAs = By.xpath("//select[@id='products-viewmode']");
	public By productDetails = By.xpath("//div[@class='product-item']//img[@title='Show details for Fiction']");
	public By quantity = By.xpath("//input[@id='addtocart_45_EnteredQuantity']");
	public By addToCart = By.xpath("(//input[@id='add-to-cart-button-45'])[1]");
//	public By shoppingcart = By.linkText("Shopping cart");
	public By shoppingcart1 = By.linkText("Shopping cart");
	public By removeCheckbox = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]");
	public By updateCart = By.xpath("//input[@name='updatecart']");

	
	
//  Required for checkout
	public By shoppingcart2 = By.linkText("Shopping cart");
	public By termsService = By.id("termsofservice");
	public By checkout = By.xpath("//button[@id='checkout']");
	public By selectAddressDropDown = By.xpath("//select[@id='billing-address-select']");
	public By companyname = By.xpath("//input[@id='BillingNewAddress_Company']");
	public By Country = By.xpath("//select[@id='BillingNewAddress_CountryId']");
	public By city = By.xpath("//input[@id='BillingNewAddress_City']");
	public By Address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	public By ZipCode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public By phoneNumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public By ContinueBilling = By.xpath("//input[@onclick='Billing.save()']");
	public By pickInStoreCheckBox = By.xpath("//input[@id='PickUpInStore']");
	public By ContinueShipping = By.xpath("//input[@onclick='Shipping.save()']");
	public By PaymentContinue = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]");
	public By PaymentInfoContinue = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]");
	public By confirm = By.xpath("//input[@value='Confirm']");
	
	
	// purchase details
	public By HomePage = By.xpath("//img[@alt='Tricentis Demo Web Shop']");
	public By RegisteredEmail = By.xpath("//a[normalize-space()='atifkhan1234@gmail.com']");
	public By Orders = By.xpath("//a[@class='inactive'][normalize-space()='Orders']");
	public By OrderDetails = By.xpath("//div[@class='order-list']//div[1]//div[2]//input[1]");
	
	

	// logout
	public By logoutButton = By.xpath("//a[normalize-space()='Log out']");
	
	
	
	
	
	

	public void BooksCategory() {
		try {
			ReportManager.createTest("Register"); // Starting the report
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
			System.out.println("registration successful");

			ReportManager.createTest("login-Functionality"); // Starting the report
			driver.findElement(loginLink).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on Login link");
			driver.findElement(emailField).sendKeys(config.getProperty("email"));
			ReportManager.getTest().log(Status.INFO, "Entered Email");
			driver.findElement(passwordField).sendKeys(config.getProperty("password"));
			ReportManager.getTest().log(Status.INFO, "Entered Password");
			driver.findElement(loginButton).click();
			ReportManager.getTest().pass("Login Successful");
			System.out.println("Login successful");

			ReportManager.createTest("Add Books to Cart"); // Starting the report
			driver.findElement(Books).click();
			ReportManager.getTest().log(Status.INFO, "Navigated to Books Category");
			driver.findElement(Book1AddToCart).click();
			ReportManager.getTest().pass("First Product Added to Cart");
			driver.findElement(shoppingcart).click();
			ReportManager.getTest().pass("Successfully Entered Shopping Cart");
			System.out.println("Entered into cart successful");
			
			
			ReportManager.createTest("CartListUpdate");// starting report
			driver.findElement(searchTab).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on search tab");
			driver.findElement(searchTab).sendKeys("Fiction");
			driver.findElement(searchButton).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on search button");
			driver.findElement(viewProductAs).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on View AS");
			driver.findElement(productDetails).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on image to get product details");
			driver.findElement(quantity).click();
			driver.findElement(quantity).clear();
			driver.findElement(quantity).sendKeys("5");
//			driver.findElement(quantity).click();
			ReportManager.getTest().log(Status.INFO, "selecting quantity");
			driver.findElement(addToCart).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on add to cart");
			driver.findElement(shoppingcart1).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on shopping cart");
			driver.findElement(removeCheckbox).click();
			
			ReportManager.getTest().log(Status.INFO, "marked the checkbox");
			driver.findElement(updateCart).click();
			ReportManager.getTest().pass("Clicked on update the cart");
			System.out.println("Updated the cart successful");
			
			
			
			ReportManager.createTest("Checkout");// starting report
			driver.findElement(shoppingcart2).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on shopping cart");
			driver.findElement(termsService).click();
			ReportManager.getTest().log(Status.INFO, "marked on check box");
			driver.findElement(checkout).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on checkout");
			Select select = new Select(driver.findElement(selectAddressDropDown));
		    select.selectByVisibleText("New Address");
			ReportManager.getTest().log(Status.INFO, "Clicked on new address");
			driver.findElement(companyname).click();
			driver.findElement(companyname).sendKeys(config.getProperty("company"));
			ReportManager.getTest().log(Status.INFO, "Clicked on shopping cart");
			Select country = new Select(driver.findElement(Country));
		    country.selectByVisibleText("United States");
			ReportManager.getTest().log(Status.INFO, "Clicked on united states");
			driver.findElement(city).click();
			driver.findElement(city).sendKeys(config.getProperty("city"));
			ReportManager.getTest().log(Status.INFO, "Clicked on city");
			
			driver.findElement(Address1).click();
			driver.findElement(Address1).sendKeys(config.getProperty("address"));
			ReportManager.getTest().log(Status.INFO, "Clicked on address");
			
			driver.findElement(ZipCode).click();
			driver.findElement(ZipCode).sendKeys(config.getProperty("zipcode"));
			ReportManager.getTest().log(Status.INFO, "Clicked on zipcode");
			
			driver.findElement(phoneNumber).click();
			driver.findElement(phoneNumber).sendKeys(config.getProperty("phonenumber"));
			ReportManager.getTest().log(Status.INFO, "added phone number");
			
			driver.findElement(ContinueBilling).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on continue billing");
			
			driver.findElement(pickInStoreCheckBox).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on checkbox");
			
			Thread.sleep(2000);
			driver.findElement(ContinueShipping).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on continue");
			
			Thread.sleep(2000);
			driver.findElement(PaymentContinue).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on continue payment");
			
			Thread.sleep(2000);
			driver.findElement(PaymentInfoContinue).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on continue");
			
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 600);");
			Thread.sleep(2000);
			driver.findElement(confirm).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on continue");
			System.out.println("Checkout successful");
			
			
			
			
			ReportManager.createTest("checkDetails");// starting report
			driver.findElement(HomePage).click();
			ReportManager.getTest().log(Status.INFO, "On home page");
			
			driver.findElement(RegisteredEmail).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on email");
			
			driver.findElement(Orders).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on the orders");
			
			driver.findElement(OrderDetails).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on recent order to see details about shipment");
			
			Thread.sleep(2000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0, 200);");
			System.out.println("Checked the Details of product");
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			ReportManager.createTest("Invalid login data");
			driver.findElement(logoutButton).click();
			ReportManager.getTest().pass(" Logout Successful");
			Thread.sleep(2000);
			driver.findElement(loginLink).click();
			ReportManager.getTest().log(Status.INFO, "Clicked on Login link");
//			no elements added
			driver.findElement(loginButton).click();
			Thread.sleep(2000);
			ReportManager.getTest().pass(" Login failed!");
			System.out.println("Login Failed");


		} catch (Exception e) {
			ReportManager.getTest().fail("Test Failed: " + e.getMessage());
		}
	}
}
