package com.pfl.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.BuyPricePage;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.LoginPage;
import com.pfl.pageObjects.OTPPage;
import com.pfl.pageObjects.ProfilePage;
import com.pfl.pageObjects.StripePaymentGateway;
import com.pfl.pageObjects.TicketDetailPage;

public class EndToEndTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	TicketDetailPage ticketDetailPage;
	OTPPage otpPage;
	BuyPricePage buyPricePage;
	StripePaymentGateway stripePaymentGateway;
	ProfilePage profilePage;
	
	@Test
	public void endToEndTest() throws InterruptedException {
		homePage = new HomePage();
		
		loginPage= new LoginPage();
		loginPage = homePage.clickOnLoginBtn();
		homePage = loginPage.userLogin();
		ticketDetailPage = new TicketDetailPage();
		ticketDetailPage = homePage.clickBuyBtn();
		//ticketDetailPage.verifyAllDetailsOnTicketDetailPage();
		otpPage = new OTPPage();
		otpPage = ticketDetailPage.buyTicket();
		buyPricePage = new BuyPricePage();
		buyPricePage = otpPage.verifyBuyOTP();
		buyPricePage.verifyTicketPriceDetails();
		stripePaymentGateway = new StripePaymentGateway();
		stripePaymentGateway = buyPricePage.clickOnCollectionBuyBtn();
		stripePaymentGateway.verifyCollectionDetails();
		buyPricePage = stripePaymentGateway.enterCardDetails();
		buyPricePage.verifySucessMsg();
		profilePage = new ProfilePage();
		profilePage = buyPricePage.gotoProfileAfterSuccessPayment();
		//profilePage.verifyNumberofTicketsofSameEvent();
		profilePage.verifyCardsCountOnProfilePage();
		
		
		
		
		
	}

}
