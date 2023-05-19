package com.pfl.testCases;

import org.testng.annotations.Test;
import static com.pfl.utilities.ExtentManager.extent;

import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.LoginPage;
import com.pfl.pageObjects.ProfilePage;
import com.pfl.utilities.Log;

public class ProfilePageTest extends BaseClass{
	
	HomePage homePage;
	LoginPage loginPage;
	ProfilePage profilePage;
	
	@Test
	public void getCollectedTicketsInfo() throws InterruptedException {
		extent.createTest("User login test");
		Log.startTestCase("getCollectedTicketsInfo");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User clicked on the Login button");
		loginPage = new LoginPage();
		homePage = loginPage.userLogin();
		Log.info("User logged into the Application");
		profilePage = new ProfilePage();
		profilePage = homePage.usersProfilePage();
		Log.info("User came on the Profile Page");
		Log.info("Available collected ticket information - ");
		profilePage.verifyCardsCountOnProfilePage();
		profilePage.getCardInfo();
		Log.info("User verified all the collected ticket information");
		Log.endTestCase("getCollectedTicketsInfo");
	}
	
	
	

}
