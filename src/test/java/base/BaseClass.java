package base; // Package Declaration

//Importing File Class for handling files
import java.io.File; 
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.io.Files;
import utilities.ConfigReader;

public class BaseClass {
    public static WebDriver driver; //WebDriver Instance for browser Automation
    public static ConfigReader config = new ConfigReader(); // ConfigReader instance to read properties file

    public static void initializeBrowser(String browser) { // Modified to accept browser as a parameter
        String url = config.getProperty("url"); // Read URL from properties

        //check which browser is specified and initialize accordingly
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); // launch chrome browser
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(); // launch firefox browser
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); // edge browser
        } else {
            throw new RuntimeException("Invalid browser specified: " + browser);// this throws exception if the browser is invalid
        }

        driver.manage().window().maximize(); // maximize browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // set implicit wait time
        driver.get(url); //navigate to specified url
    }

    public static void screenshot() throws IOException { // Method to take a screenshot
        // Take the screenshot as proof
        File src = null; // declaring a file variable
        src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // capture screenshot
        Files.copy(src, new File("./screenshots/" + "page-" + System.currentTimeMillis() + ".png")); // saving screenshot with timestamp
    }

    public static void closeBrowser() {// Method to close the browser
        if (driver != null) { // check if driver is initialised
            driver.quit(); // Quit browser if driver is not null
        }
    }
}