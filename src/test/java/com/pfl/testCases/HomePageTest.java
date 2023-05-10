package com.pfl.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.utilities.Log;
import static com.pfl.utilities.ExtentManager.extent;

public class HomePageTest extends BaseClass{
	
	private HomePage homepage;
	
	
	
	@Test
	public void verifyLogo() {
		extent.createTest("Logo verification");
		Log.startTestCase("Test started - Verify Logo");
		homepage = new HomePage(driver);
		Log.info("User is going to verify the Logo");
		boolean result = homepage.verifylogo();
		Assert.assertEquals(result, true);
		Log.info("User verified the Logo");
		Log.endTestCase("Test Ended - Logo Verified");
		
		
		
	}

}
