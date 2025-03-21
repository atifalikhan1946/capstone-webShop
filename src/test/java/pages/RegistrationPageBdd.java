package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageBdd {
    public WebDriver driver;

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "LastName")
    private WebElement lastNameInput;

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement successMessage;

    public RegistrationPageBdd(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderMaleRadioButton.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            genderFemaleRadioButton.click();
        }
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordInput.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
