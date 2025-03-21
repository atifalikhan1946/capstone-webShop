package pages;

import base.BaseClass;
import utilities.ConfigReader;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BaseClass {
	ConfigReader config = new ConfigReader();

	public By registerLink = By.linkText("Register");
	public By genderMale = By.id("gender-male");
	public By firstNameField = By.id("FirstName");
	public By lastNameField = By.id("LastName");
	public By emailField = By.id("Email");
	public By passwordField = By.id("Password");
	public By confirmPasswordField = By.id("ConfirmPassword");
	public By registerButton = By.id("register-button");
	public By errorMessage = By.xpath("//li[normalize-space()='The specified email already exists']");
	public By loginLink = By.linkText("Log in");

	public void registerUser() {
		driver.findElement(registerLink).click();
		driver.findElement(genderMale).click();
		driver.findElement(firstNameField).sendKeys(config.getProperty("firstname"));
		driver.findElement(lastNameField).sendKeys(config.getProperty("lastname"));
		driver.findElement(emailField).sendKeys(config.getProperty("email"));
		driver.findElement(passwordField).sendKeys(config.getProperty("password"));
		driver.findElement(confirmPasswordField).sendKeys(config.getProperty("password"));
		driver.findElement(registerButton).click();

		try {
			WebElement errorElement = driver.findElement(errorMessage);
			if (errorElement.isDisplayed()) {
				System.out.println("Email already exists...");
				driver.findElement(loginLink).click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Registration successful.");
		}
	}
}
