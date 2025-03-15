package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionUtilities;
import utilities.GenericUtilities;
import utilities.JavaScriptUtilities;

public class Homepage {

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAcc;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerOption;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(xpath = "(//a[contains(text(),'Logout')])[1]")
	private WebElement logoutButton;
	
	@FindBy(xpath = "(//a[contains(text(),'Logout')])[2]")
	private WebElement logout;
	
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement textMsg;

	private WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOn_Myaccount() {
		myAcc.click();
	}

	public void clickOn_RegisterOption() {
		registerOption.click();
	}

	public void clickOn_LoginOption() {
		loginOption.click();
	}
	
	public void clickOn_LogoutOption() {
		logoutButton.click();
	}
	
	public void clickOn_Logout() {
		logout.click();
	}
	
	public String getMessage() {
		return textMsg.getText();
	}

}
