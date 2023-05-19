package com.pfl.testCases;

import org.testng.annotations.Test;
import static com.pfl.utilities.ExtentManager.extent;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.LoginPage;
import com.pfl.utilities.Log;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void userLogin(){
		extent.createTest("User login test");
		Log.startTestCase("userLogin");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User clicked on Login button");
		loginPage = new LoginPage();
		homePage = loginPage.userLogin();
		Log.info("User login to the application");
		homePage.verifyUserIsLogin();
		homePage.verifyUserName();
		Log.info("User profile image and name displayed on Home Page");
		Log.endTestCase("userLogin");
		
	}
	
	@Test
	public void verifyLoginWithoutEmail() {
		extent.createTest("User login test without Email");
		Log.startTestCase("verifyLoginWithoutEmail");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User click on login button on Home Page");
		loginPage = new LoginPage();
		Log.info("User clicked on Login button without email");
		homePage = loginPage.tryLoginWithoutEmail();
		Log.info("User is not able to login without Email");
		Log.endTestCase("verifyLoginWithoutEmail");
	}
	
	
	@Test
	public void verifyLoginWithoutPass() {
		extent.createTest("User login test without Password");
		Log.startTestCase("verifyLoginWithoutPass");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User click on login button on Home Page");
		loginPage = new LoginPage();
		Log.info("User clicked on Login button without Password");
		homePage = loginPage.tryLoginWithoutPassword();
		Log.info("User is not able to login without email");
		Log.endTestCase("verifyLoginWithoutEmail");
	}
	
	@Test
	public void verifyLoginWithoutEmailPass() {
		extent.createTest("User login test without Email & Password");
		Log.startTestCase("verifyLoginWithoutEmailPass");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User click on login button on Home Page");
		loginPage = new LoginPage();
		Log.info("User clicked on Login button without Email & Password");
		homePage = loginPage.tryLoginWithoutEmailPass();
		Log.info("User is not able to login without Email & Password");
		Log.endTestCase("verifyLoginWithoutEmailPass");
	}
	
	@Test
	public void verifyLoginWithInvalidEmail() {
		extent.createTest("User login test with Invalid Email");
		Log.startTestCase("verifyLoginWithInvalidEmail");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User click on login button on Home Page");
		loginPage = new LoginPage();
		Log.info("User clicked on Login button with Invalid Email");
		homePage = loginPage.tryLoginWithInvalidEmail();		
		Log.info("User is not able to login with Invalid Email");
		Log.endTestCase("verifyLoginWithInvalidEmail");
	}
	
	@Test
	public void verifyLoginWithInvalidPass() {
		extent.createTest("User login test with Invalid Password");
		Log.startTestCase("verifyLoginWithInvalidPass");
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginBtn();
		Log.info("User click on login button on Home Page");
		loginPage = new LoginPage();
		Log.info("User clicked on Login button with Invalid Password");
		homePage = loginPage.tryLoginWithInvalidPassword();		
		Log.info("User is not able to login with Invalid Password");
		Log.endTestCase("verifyLoginWithInvalidPass");
	}
	
	
		

}
