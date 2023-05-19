package com.pfl.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.utilities.Log;
import static com.pfl.utilities.ExtentManager.extent;

public class HomePageTest extends BaseClass{
	
	private HomePage homePage;
	
	
	
	@Test
	public void verifyLogo() {
		extent.createTest("Logo verification");
		Log.startTestCase("verifyLogo ");
		homePage = new HomePage();
		Log.info("User is going to verify the Logo");
		boolean result = homePage.verifylogo();
		AssertJUnit.assertEquals(result, true);
		Log.info("User verified the Logo");
		Log.endTestCase("verifyLogo ");
		
		
	}
	
	@Test
	public void verifyTheDetailsOfTicketOnHomePage() {
		extent.createTest("Ticket on Home Page details verification");
		Log.startTestCase("verifyTheDetailsOfTicketOnHomePage");
		homePage = new HomePage();
		homePage.verifyTicketDetails();
		Log.endTestCase("verifyTheDetailsOfTicketOnHomePage");
	}
	
	@Test
	public void getTheTicketDetails() {
		extent.createTest("Ticket on Home Page details information");
		Log.startTestCase("getTheTicketDetails");
		homePage = new HomePage();
		homePage.getTicketDetails();
		Log.endTestCase("getTheTicketDetails");
	}
	
	@Test
	public void clickOnViewButtonOnTicket() throws InterruptedException {
		extent.createTest("Click on buy button on Ticket on Home Page");
		Log.startTestCase("ticketdetailpage");
		homePage = new HomePage();
		homePage.clickBuyBtn();	
		Log.endTestCase("ticketdetailpage");
		
	}

}
