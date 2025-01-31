package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Loginpage;
import testBase.BaseClass;
import utilities.GenericUtilities;

public class TC2_LoginClass extends BaseClass {

	@Test
	public void verify_Login() {
		logger.info("**** Starting Test Case: TC02_LoginClass ****");

		try {
			
			logger.info("Navigate to homepage");
			Homepage hp = new Homepage(driver);

			logger.info("click on my account dropdown");
			hp.clickOn_Myaccount();

			logger.info("click on login");
			hp.clickOn_LoginOption();

			logger.info("Navigate to loginpage");
			Loginpage lp = new Loginpage(driver);

			String email = GenericUtilities.getConfigData("emailID");
			logger.info("enter username" + email);
			lp.enter_Username(email);

			String pass = GenericUtilities.getConfigData("password");
			logger.info("enter username" + pass);
			lp.enter_Username(pass);

		} 
		catch (Exception e) {
			logger.error("Exception occur during registration: " + e.getMessage());
			Assert.fail("Test case failed due to exception.");
		}

		logger.info("**** Finished Test Case: TC01_RegistrationClass ****");

	}

}
