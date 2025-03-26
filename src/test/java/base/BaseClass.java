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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
    
    @BeforeSuite
    public void clearAllureResults() {
    	String[] allurePaths = {"allure-results", "/allure-results/"};

        for (String path : allurePaths) {
            File allureResults = new File(path);
            if (allureResults.exists() && allureResults.isDirectory()) {
                for (File file : allureResults.listFiles()) {
                    file.delete();
                }
            }
        }
    }

    // Generate Allure Report after test execution (Runs in Background)
    @AfterSuite
    public void generateAllureReport() 
    {

        
        try 
        {
            ProcessBuilder reportBuilder = new ProcessBuilder("cmd.exe", "/c", "mvn allure:report");
            reportBuilder.redirectErrorStream(true);
            Process reportProcess = reportBuilder.start();
            reportProcess.waitFor(); // Wait until report is generated

            String reportPath = System.getProperty("user.dir") + "/allure-results/";
            File reportDir = new File(reportPath);

            if (reportDir.exists() && reportDir.isDirectory()) 
            {
                System.out.println("Allure Report generated successfully in: " + reportPath);
            } 
            else 
            {
                System.out.println("Allure Report generation failed. Check Maven logs.");
            }

        } 
        catch (IOException | InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}