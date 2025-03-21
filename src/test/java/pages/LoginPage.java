package pages;

import base.BaseClass;
import utilities.ConfigReader;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass {
    ConfigReader config = new ConfigReader();

    public By loginLink = By.linkText("Log in");
    public By emailField = By.id("Email");
    public By passwordField = By.id("Password");
    public By loginButton = By.cssSelector("input.button-1.login-button");
    
    public void loginUser() {
        driver.findElement(loginLink).click();
        driver.findElement(emailField).sendKeys(config.getProperty("email"));
        driver.findElement(passwordField).sendKeys(config.getProperty("password"));
        driver.findElement(loginButton).click();
        System.out.println("login successful");
       
    }
}