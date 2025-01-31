package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class GenericUtilities extends BaseClass {

	// fetch the configuration file data
	public static String getConfigData(String key) throws IOException {
		String path = "C:\\Users\\Pranav\\eclipse-workspace\\Pranav_Framework\\src\\test\\resources\\Configuration\\config.properties";
		FileInputStream file = new FileInputStream(path);

		Properties prop = new Properties();
		prop.load(file);

		String value = prop.getProperty(key);
		return value;
	}

	// for screenshot
	public static void getScreenShot(String name) throws IOException {
		String timeStamps = new SimpleDateFormat("yyyy-MM-dd_hh-ss-mm").format(new Date());
		String path = ".//Screenshots//";

		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File(path + name + "_" + timeStamps + ".png");

		FileHandler.copy(source, destination);
	}

	// Synchronization wait for element
	public static WebElement waitForElement(WebDriver driver, WebElement locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) locator));
		return driver.findElement((By) locator);
	}

	// Synchronization wait for element to be clickable
	public static void waitForElementClickable(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Synchronization wait for element to be visible
	public static void waitForElementVisible(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Generate a random string
	public static String getRandomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		logger.info("Generated random string: " + generatedString);
		return generatedString;
	}

	// Generate a random number
	public static String getRandomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		logger.info("Generated random number: " + generatedNumber);
		return generatedNumber;
	}

	// Generate a random alphaNumric
	public static String getAlphaNumric() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		String generatedNumber = RandomStringUtils.randomNumeric(3);

		String genratedAlphaNumric = generatedString + generatedNumber;
		logger.info("Generated alpha numric: " + genratedAlphaNumric);
		return genratedAlphaNumric;
	}

}
