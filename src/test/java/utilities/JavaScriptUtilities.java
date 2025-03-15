package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {

	// send a value by javaScriptExecutor
	public static void sendKeysUsingJS(WebDriver driver, String message, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value'" + message + "';", element);
	}

	// click by javaScriptExecutor
	public static void clickUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// scroll to particular element
	public static void scrollByElementUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// user generated alert
	public static void userAlertByJS(WebDriver driver, WebElement element, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert'(" + message + ")'", element);
	}

	// highlight element
	public static void highlightElementUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].style.border='5px solid red'", element);
	}

}
