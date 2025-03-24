package testPages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CheckoutPage;

public class CheckoutTest extends BaseClass {
    CheckoutPage checkout;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
    	initializeBrowser(browser);
        checkout = new CheckoutPage();
    }

    @Test
    public void UpdateCartList() throws InterruptedException, IOException {
    	checkout.CheckOutCart();
        
    }

    @AfterMethod
    public void closeDownbrowser() {
        closeBrowser();
    }
}