package testPages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartListPage;

public class CartListTest extends BaseClass {
    CartListPage cartlist;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
    	initializeBrowser(browser);
        cartlist = new CartListPage();
    }

    @Test
    public void UpdateCartList() throws InterruptedException, IOException {
    	cartlist.FinalizeCart();
        
    }

    @AfterMethod
    public void closeDownbrowser() {
        closeBrowser();
    }
}