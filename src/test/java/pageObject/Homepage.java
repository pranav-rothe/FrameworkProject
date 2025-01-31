package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAcc;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	private WebElement registerOption;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	
	public Homepage(WebDriver driver) {
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
	
	

}
