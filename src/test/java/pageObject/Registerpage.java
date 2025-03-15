package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	@FindBy(id = "input-firstname")
	private WebElement setFirstName;
	
	@FindBy(id = "input-lastname")
	private WebElement setLastName;
	
	@FindBy(id = "input-email")
	private WebElement setEmail;
	
	@FindBy(id = "input-telephone")
	private WebElement setTelephone;
	
	@FindBy(id = "input-password")
	private WebElement setPassword;
	
	@FindBy(id = "input-confirm")
	private WebElement setconfirmPassword;
	
	@FindBy(name = "agree")
	private WebElement policyCheckBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement text;
	
	public Registerpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enter_FirstName(String first) {
		setFirstName.sendKeys(first);
	}
	
	public void enter_LastName(String last) {
		setLastName.sendKeys(last);
	}
	
	public void enter_EmailID(String email) {
		setEmail.sendKeys(email);
	}
	
	public void enter_Telephone(String number) {
		setTelephone.sendKeys(number);
	}
	
	public void enter_Password(String pass) {
		setPassword.sendKeys(pass);
	}
	
	public void enter_ConfirmPassword(String confirsPass) {
		setconfirmPassword.sendKeys(confirsPass);
	}
	
	public void clickOn_PrivacyPolicyCheckBox() {
		policyCheckBox.click();
	}
	
	public void clickOn_Continue() {
		continueButton.click();
	}
	
	public String verifyText() {
		try {
			return (text.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
	
	

}
