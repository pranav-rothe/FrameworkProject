package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.Registerpage;
import testBase.BaseClass;
import utilities.GenericUtilities;

public class TC01_RegistrationClass extends BaseClass {

	@Test
	public void verify_AccountRegistration() {

		logger.info("**** Starting Test Case: TC01_RegistrationClass ****");

		try {
			logger.info("Navigate to homepage");
			Homepage hp = new Homepage(driver);

			logger.info("click on my account");
			hp.clickOn_Myaccount();

			logger.info("click on register option");
			hp.clickOn_RegisterOption();

			logger.info("create a new account");
			Registerpage rp = new Registerpage(driver);

			String firstname = GenericUtilities.getRandomString().toLowerCase();
			logger.info("Enter first name: " + firstname);
			rp.enter_FirstName(firstname);

			String lastname = GenericUtilities.getRandomString().toLowerCase();
			logger.info("Enter last name: " + lastname);
			rp.enter_LastName(lastname);

			String email = GenericUtilities.getAlphaNumric();
			logger.info("Enter email: " + email+"@gmail.com");
			rp.enter_EmailID(email + "@gmail.com");

			String mobNumber = GenericUtilities.getRandomNumber();
			logger.info("Enter mobile number: " + mobNumber);
			rp.enter_Telephone(mobNumber);

			String password = GenericUtilities.getAlphaNumric();
			logger.info("enter password: [hidden] " + password);
			rp.enter_Password(password);

			logger.info("Enter confirm password: [hidden] " + password);
			rp.enter_ConfirmPassword(password);

			logger.info("Click on privacy policy check box");
			rp.clickOn_PrivacyPolicyCheckBox();

			logger.info("Click on continue button");
			rp.clickOn_Continue();

			logger.info("Validation account creatation message");
			String confirmText = rp.verifyText();
			logger.info("Account creatation message "+confirmText);

			if (confirmText.equals("Your Account Has Been Created!")) {
				logger.info("Account registration successful.");
				Assert.assertTrue(true);
			} 
			else {
				logger.error("Account registration failed. Expected message not found.");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			logger.error("Exception occur during registration: " + e.getMessage());
			Assert.fail("Test case failed due to exception.");
		}

		logger.info("**** Finished Test Case: TC01_RegistrationClass ****");

	}

}
