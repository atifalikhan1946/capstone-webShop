package testPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    LoginPage loginPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
    	initializeBrowser(browser);
        loginPage = new LoginPage();
    }

    @Test
    public void testUserLogin() {
        loginPage.loginUser();
    }

    @AfterMethod
    public void closeDownbrowser() {
        closeBrowser();
    }
}