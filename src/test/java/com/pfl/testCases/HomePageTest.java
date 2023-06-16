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
	public void getTheTicketDetailsOnHomePage() {
		extent.createTest("Ticket on Home Page details information");
		Log.startTestCase("getTheTicketDetails");
		homePage = new HomePage();
		homePage.getAllTicketsInfo();
		Log.endTestCase("getTheTicketDetails");
	}
	
	@Test
	public void verifyVIPTicketDetailsOnHomePage() {
		extent.createTest("Ticket detail verification on Home Page");
		Log.startTestCase("verifyVIPTicketDetailsOnHomePage");
		homePage = new HomePage();
		homePage.verifyPFL_VIPClubTicketDetails();
		Log.endTestCase("verifyVIPTicketDetailsOnHomePage");
	}
	
	@Test
	public void verifyMillionaireTicketDetailsOnHomePage() {
		extent.createTest("Ticket detail verification on Home Page");
		Log.startTestCase("verifyMillionaireTicketDetailsOnHomePage");
		homePage = new HomePage();
		homePage.verifyPFL_MillionaireClubTicketDetails();
		Log.endTestCase("verifyMillionaireTicketDetailsOnHomePage");
	}
	
	@Test
	public void clickOnVIPTicketViewButton() throws InterruptedException {
		extent.createTest("Click on buy button on Ticket on Home Page");
		Log.startTestCase("clickOnVIPTicketViewButton");
		homePage = new HomePage();
		homePage.viewVIPClubTicket();	
		Log.endTestCase("clickOnVIPTicketViewButton");
		
	}
	
	@Test
	public void clickOnMillionaireTicketViewButton() throws InterruptedException {
		extent.createTest("Click on buy button on Ticket on Home Page");
		Log.startTestCase("clickOnMillionaireTicketViewButton");
		homePage = new HomePage();
		homePage.viewMillionaireClubTicket();	
		Log.endTestCase("clickOnMillionaireTicketViewButton");
		
	}
	
	@Test
	public void checkSocialMediaLinks() throws InterruptedException {
		extent.createTest("Check all the social media links available on the footer");
		Log.startTestCase("checkSocialMediaLinks");
		homePage = new HomePage();
		homePage.socialMediaLinks();
		Log.endTestCase("checkSocialMediaLinks");
	}
	
	
	@Test
	public void checkOtherPageLinks() throws InterruptedException {
		extent.createTest("Check all the other page links available on the footer");
		Log.startTestCase("checkOtherPageLinks");
		homePage = new HomePage();
		homePage.otherPageLinks();
		Log.endTestCase("checkOtherPageLinks");
	}
	
	

}
