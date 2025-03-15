package testClasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Loginpage;
import testBase.BaseClass;
import utilities.ExcelUtilities;

public class TC04_LoginClassDTT extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void verifyLoginDDT(String email, String pass) {

		logger.info("**** Starting Test Case: TC04_LoginClassDTT ****");

		try {
			logger.info("Navigate to homepage");
			Homepage hp = new Homepage(driver);

			logger.info("Click on MyAccount");
			hp.clickOn_Myaccount();

			logger.info("Click on login option");
			hp.clickOn_LoginOption();

			logger.info("Navigate to loginpage");
			Loginpage lp = new Loginpage(driver);

			logger.info("Attempting multiple login with email: " + email + " and password: " + pass);
			lp.enter_Username(email);
			lp.enter_Password(pass);
			lp.clickOn_LoginButton();

			String message = hp.getMessage();

			if(message.equalsIgnoreCase(message)) {
				
			}

		} catch (Exception e) {
			logger.error("An exception occurred during the login test: " + e.getMessage());
			Assert.fail("Test case execution failed due to an exception");
		}

		logger.info("**** Finished Test Case: TC04_LoginClassDTT ****");

	}

	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		Object[][] data = ExcelUtilities.getTestDataFromExcel("LoginSheet");
		return data;
	}

}
