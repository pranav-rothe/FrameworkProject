package testBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.GenericUtilities;

public class BaseClass {

	public static WebDriver driver;
	public static Logger logger;

	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws IOException {

		// Initialize logger and configure log4j properties
		logger = Logger.getLogger("Pranav_Framework");
		PropertyConfigurator.configure("./src/test/resources/Configuration/log4j.properties");
		logger.info("Logger initialized");
		
		//Browser setup
		logger.info("Setting up browser");
		switch(browser.toLowerCase()) {
		
		case "chrome":
			logger.info("Open chrome browser");
			driver = new ChromeDriver();
			break;
		
		case "edge":
			logger.info("Open edge browser");
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			logger.info("Open firefox browser");
			driver=new FirefoxDriver();
			break;
			
		default:
			logger.error("Open invalid browser: "+browser);
			throw new IllegalArgumentException("Invalid Browser Name");
		}
		
		logger.info("Browser open successfully");
		
		//browser maximize
		logger.info("Browser maximize");
		driver.manage().window().maximize();
		
		//browser implicitly wait
		logger.info("Setting up implicitly wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open application
		logger.info("Open application: ");
		driver.get(GenericUtilities.getConfigData("URL"));
	}
	
	@AfterClass
	public void teardown() {
		//close browser
		if(driver!=null) {
			logger.info("Close application");
			driver.quit();
			logger.info("Browser close successfully");
		}
		else {
			logger.warn("Driver is already null. Skipping browser teardown");
		}
	}

}
