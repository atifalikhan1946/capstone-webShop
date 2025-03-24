package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import utilities.ConfigReader;

public class CheckoutPage extends BaseClass {
	ConfigReader config = new ConfigReader();

	public By loginLink = By.linkText("Log in");
	public By emailField = By.id("Email");
	public By passwordField = By.id("Password");
	public By loginButton = By.cssSelector("input.button-1.login-button");
	public By shoppingcart = By.linkText("Shopping cart");
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
	
	
	
	//input[@id='BillingNewAddress_Address2']
	
	
	
	
	
	public void CheckOutCart() throws InterruptedException, IOException {
		driver.findElement(loginLink).click();
		driver.findElement(emailField).sendKeys(config.getProperty("email"));
		driver.findElement(passwordField).sendKeys(config.getProperty("password"));
		driver.findElement(loginButton).click();
		driver.findElement(shoppingcart).click();
		driver.findElement(termsService).click();
		driver.findElement(checkout).click();
		Thread.sleep(3000);
		Select select = new Select(driver.findElement(selectAddressDropDown));
	    select.selectByVisibleText("New Address");
	
		
		driver.findElement(companyname).sendKeys(config.getProperty("company"));
		
		Select country = new Select(driver.findElement(Country));
	    country.selectByVisibleText("United States");
		
		
		driver.findElement(city).sendKeys(config.getProperty("city"));
		driver.findElement(Address1).sendKeys(config.getProperty("address"));
		driver.findElement(ZipCode).sendKeys(config.getProperty("zipcode"));
		driver.findElement(phoneNumber).sendKeys(config.getProperty("phonenumber"));
		
		driver.findElement(ContinueBilling).click();
		Thread.sleep(3000);
		driver.findElement(pickInStoreCheckBox).click();
		Thread.sleep(3000);
		driver.findElement(ContinueShipping).click();
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 300);");
		driver.findElement(PaymentContinue).click();
		Thread.sleep(3000);
		driver.findElement(PaymentInfoContinue).click();
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(3000);
		driver.findElement(confirm).click();
		screenshot();
		
	
}
}