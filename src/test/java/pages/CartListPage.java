package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;
import utilities.ConfigReader;

public class CartListPage extends BaseClass {
	ConfigReader config = new ConfigReader();

	public By loginLink = By.linkText("Log in");
	public By emailField = By.id("Email");
	public By passwordField = By.id("Password");
	public By loginButton = By.cssSelector("input.button-1.login-button");
	public By shoppingcart = By.linkText("Shopping cart");
	public By searchTab = By.xpath("//input[@id='small-searchterms']");
	public By searchButton = By.xpath("//input[@value='Search']");
	public By viewProductAs = By.xpath("//select[@id='products-viewmode']");
	public By productDetails = By.xpath("//div[@class='product-item']//img[@title='Show details for Fiction']");
	public By quantity = By.xpath("//input[@id='addtocart_45_EnteredQuantity']");
	public By addToCart = By.xpath("//input[@id='add-to-cart-button-45']");
	public By removeCheckbox = By.xpath("(//input[@value='5185364'])[1]");
	public By updateCart = By.xpath("//input[@name='updatecart']");

	public void FinalizeCart() throws InterruptedException, IOException {
		driver.findElement(loginLink).click();
		driver.findElement(emailField).sendKeys(config.getProperty("email"));
		driver.findElement(passwordField).sendKeys(config.getProperty("password"));
		driver.findElement(loginButton).click();
		driver.findElement(searchTab).sendKeys("Fiction");
		Thread.sleep(3000);
		driver.findElement(searchButton).click();
		driver.findElement(viewProductAs).click();
		Thread.sleep(2000);
		// Create Actions class object
		Actions actions = new Actions(driver);

		// Simulate pressing Down Arrow Key
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(1000);
		driver.findElement(productDetails).click();
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("5");
		Thread.sleep(3000);
		driver.findElement(addToCart).click();
		driver.findElement(shoppingcart).click();
		System.out.println("successfully entered into cart");

		driver.findElement(removeCheckbox).click();
		Thread.sleep(3000);
		driver.findElement(updateCart).click();
		Thread.sleep(3000);
		screenshot();

	}

}
