package com.pfl.testCases;

import org.testng.annotations.Test;
import static com.pfl.utilities.ExtentManager.extent;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.LoginPage;
import com.pfl.pageObjects.Messeges;
import com.pfl.pageObjects.OTPPage;
import com.pfl.pageObjects.SignupPage;
import com.pfl.utilities.Log;

public class SignupTest extends BaseClass{
	
	SignupPage signupPage;
	HomePage homePage;
	OTPPage signupOTPPage;
	Messeges msg;
	
	@Test(enabled = false)
	public void newUserSignupTest() throws InterruptedException {
		extent.createTest("New User Signup test");
		Log.startTestCase("newUserSignupTest");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User clicked on Signup button");
		signupPage = new SignupPage();
		signupOTPPage = signupPage.newUserSignUp();
		Log.info("User entered all the valid details and Submit");
		homePage = signupOTPPage.verifySignupOTP();
		Log.info("User verified the OPT");
		Log.endTestCase("newUserSignupTest");
	}
	
	@Test
	public void signupWithoutDetails(){
		extent.getReport();
		extent.createTest("New User Signup test");
		Log.startTestCase("signupWithoutDetails");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User clicked on Signup button");
		signupPage = new SignupPage();
		signupPage.signupWithoutDetails();
//		msg = new Messeges();
//		msg.getWarningMsg();
		Log.info("User click on signup button without details");
		Log.info("User is not able to proceed without details");
		Log.endTestCase("signupWithoutDetails");
		extent.getReport();
		
	}
	
	@Test
	public void verifySignupWithUsedMobileNoEmail(){
		extent.createTest("User Signup test with Used Mobile no. & Email");
		Log.startTestCase("verifySignupWithUsedMobileNoEmail");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User click on Signup button on Home Page");
		homePage = signupPage.trySignupWithUsedMobileNumber();
		Log.info("User entered all the details with used mobile number and email");	
		Log.info("User is not able to signup with used Email and mobile number");
		Log.endTestCase("verifySignupWithUsedMobileNoEmail");
	}
	
	@Test
	public void verifySignupWithoutCheckingCheckbox(){
		extent.getReport();
		extent.getStats();
		extent.createTest("User Signup test without checking the chekcbox");
		Log.startTestCase("verifySignupWithoutCheckingCheckbox");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User click on Signup button on Home Page");
		homePage = signupPage.trySignupWithoutCheckingCheckbox();
		Log.info("User entered all the details but didn't check the checkbox");	
		Log.info("User is not able to signup without checking the check box");
		Log.endTestCase("verifySignupWithoutCheckingCheckbox");
		extent.getReport();
		extent.getStats();
	}
	
	
	@Test
	public void verifySignupWithoutOTP() throws InterruptedException{
		extent.createTest("New User Signup with wrong OTP test");
		Log.startTestCase("verifySignupWithoutOTP");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User clicked on Signup button");
		signupPage = new SignupPage();
		signupOTPPage = signupPage.newUserSignUp();
		Log.info("User entered all the valid details and Submit");
		homePage = signupOTPPage.verifySignupWithoutOTP();
		Log.info("User clicked on Submit button without OTP");
		Log.info("User not able to submit the blank OPT");
		Log.endTestCase("verifySignupWithoutOTP");
	}
	
	@Test
	public void verifySignupWithWrongOTP() throws InterruptedException {
		extent.createTest("New User Signup with wrong OTP test");
		Log.startTestCase("verifySignupWithWrongOTP");
		homePage = new HomePage();
		signupPage = homePage.clickOnSignupBtn();
		Log.info("User clicked on Signup button");
		signupPage = new SignupPage();
		signupOTPPage = signupPage.newUserSignUp();
		Log.info("User entered all the valid details and Submit");
		homePage = signupOTPPage.verifySignupWithWrongOTP();
		Log.info("User verifieng the wrong OTP");
		Log.info("User not able to submit the wrong OPT");
		Log.endTestCase("verifySignupWithWrongOTP");
	}
	
	
	

}
