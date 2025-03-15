package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtilities {

	// move to element or hover over
	public static void hoverElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	// click on element
	public static void clickElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	// double click on element
	public static void doubleClickElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	// right click on element
	public static void contextClickElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	// drag and drop for element
	public static void dragAndDropElement(WebDriver driver, WebElement src, WebElement des) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, des).perform();
	}

	// click and hold for element without release
	public static void clickAndHoldElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	// release the element
	public void releaseElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}

	// scroll by value
	public static void scrollingToValue(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	// scroll by element
	public static void scrollByElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

}
