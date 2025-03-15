package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import testBase.BaseClass;

public class TC03_LoginActionUtils extends BaseClass {

	@Test
	public void verifyActionsOnLoginPage() {

		try {

			Homepage hp = new Homepage(driver);

			hp.clickOn_Myaccount();
			hp.clickOn_RegisterOption();

		} 
		catch (Exception e) {
			Assert.fail("Test case failed due to exception.");
		}

	}

}
