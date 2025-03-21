package stepDeff;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import base.BaseClass;
import pages.RegistrationPageBdd;
import java.util.List;
import java.util.Map;

public class RegisterBdd extends BaseClass {
    private RegistrationPageBdd registrationPage;

    @Given("I am on the Demo Web Shop registration page")
    public void iAmOnTheDemoWebShopRegistrationPage() {
        driver.get("https://demowebshop.tricentis.com/register");
        registrationPage = new RegistrationPageBdd(driver);
    }

    @When("I enter {string} as the first name")
    public void iEnterAsTheFirstName(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @When("I enter {string} as the last name")
    public void iEnterAsTheLastName(String lastName) {
        registrationPage.enterLastName(lastName);
    }

    @When("I select {string} as the gender")
    public void iSelectAsTheGender(String gender) {
        registrationPage.selectGender(gender);
    }

    @When("I enter the following credentials:")
    public void iEnterCredentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : credentials) {
            registrationPage.enterEmail(row.get("Email"));
            registrationPage.enterPassword(row.get("Password"));
            registrationPage.enterConfirmPassword(row.get("Confirm Password"));
        }
    }

    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        if (buttonName.equalsIgnoreCase("Register")) {
            registrationPage.clickRegisterButton();
        }
    }
}
