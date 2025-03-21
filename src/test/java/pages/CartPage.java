package pages;

import base.BaseClass;
import utilities.ConfigReader;
import org.openqa.selenium.By;

public class CartPage extends BaseClass {
	 ConfigReader config = new ConfigReader();

	    public By loginLink = By.linkText("Log in");
	    public By emailField = By.id("Email");
	    public By passwordField = By.id("Password");
	    public By loginButton = By.cssSelector("input.button-1.login-button");
	    public By Books = By.linkText("Books");
	    public By Book1AddToCart = By.xpath("//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
	    
	    public By shoppingcart =By.linkText("Shopping cart");

	public void BooksCategory() throws InterruptedException {
		driver.findElement(loginLink).click();
        driver.findElement(emailField).sendKeys(config.getProperty("email"));
        driver.findElement(passwordField).sendKeys(config.getProperty("password"));
        driver.findElement(loginButton).click();
        System.out.println("login successful");
        driver.findElement(Books).click();
        driver.findElement(Book1AddToCart).click();
        System.out.println("added to cart successful");
        Thread.sleep(3000);
        driver.findElement(shoppingcart).click();
        System.out.println("successfully entered into cart");
	}
	
}
