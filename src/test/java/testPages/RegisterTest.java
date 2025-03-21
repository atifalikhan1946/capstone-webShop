package testPages;

import base.BaseClass;
import pages.CartPage;
import pages.LoginPage;
import pages.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTest extends BaseClass {
    RegisterPage registerPage;
    LoginPage loginPage;
    CartPage cartpage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        initializeBrowser(browser);
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        cartpage = new CartPage();
    }

    @Test(priority = 1)
    public void testUserRegistration() {
        registerPage.registerUser();
    }
    

    @Test(priority = 2, enabled = true)
    public void testUserLogin() {
        loginPage.loginUser();
    }

    @Test(priority = 3, enabled = true)
    public void testingthecart() throws InterruptedException {
        cartpage.BooksCategory();
    }

    @AfterMethod
    public void closeDown() {
        closeBrowser();
    }
}
