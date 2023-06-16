package com.pfl.testCases;

import static com.pfl.utilities.ExtentManager.extent;

import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.BuyPricePage;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.LoginPage;
import com.pfl.pageObjects.OTPPage;
import com.pfl.pageObjects.TicketDetailPage;
import com.pfl.utilities.Log;

public class BuyTicketTest extends BaseClass{
	
	TicketDetailPage ticketDetailPage;
	HomePage homePage;
	OTPPage otpPage;
	BuyPricePage buyPricePage;
	LoginPage loginPage;
	
	
	@Test
	public void buyMillionaireClubTicket() throws InterruptedException {
		extent.createTest("Buy Millionaire Club Ticket");
		Log.startTestCase("buyMillionaireClubTicket");
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage=homePage.clickOnLoginBtn();
		homePage=loginPage.userLogin();
		ticketDetailPage = new TicketDetailPage();
		ticketDetailPage = homePage.viewVIPClubTicket();
		otpPage = new OTPPage();
		otpPage = ticketDetailPage.buyTicket();
		buyPricePage = new BuyPricePage();
		buyPricePage=otpPage.verifyBuyOTP();
		buyPricePage.verifyTicketPriceDetails();
		
		
		Log.endTestCase("buyMillionaireClubTicket");
	}
	

}
