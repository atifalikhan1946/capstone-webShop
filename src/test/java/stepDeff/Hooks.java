package stepDeff;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.BaseClass;

public class Hooks extends BaseClass {

	@Before
	public void setUp() {
		System.out.println("Before scenario: Initializing browser...");
		initializeBrowser("chrome"); // Change to desired browser
	}

	@After
	public void tearDown() {
		System.out.println("After scenario: Closing browser...");
		closeBrowser(); // Call method from BaseClass to quit the driver
	}
}
