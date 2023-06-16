package com.pfl.testCases;

import org.testng.annotations.Test;
import static com.pfl.utilities.ExtentManager.extent;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pfl.base.BaseClass;
import com.pfl.pageObjects.HomePage;
import com.pfl.pageObjects.TicketDetailPage;
import com.pfl.utilities.Log;

public class TicketDetailsPageTest extends BaseClass{
	
	TicketDetailPage ticketDetailPage;
	HomePage homePage;
	
	
	@Test
	public void verifyDetailsOnTicketDetailPage() throws InterruptedException {
		extent.createTest("Ticket details on Ticket Detail Page");
		Log.startTestCase("verifyDetailsOnTicketDetailPage");
		homePage = new HomePage();
		ticketDetailPage = new TicketDetailPage();
		ticketDetailPage = homePage.viewMillionaireClubTicket();
		ticketDetailPage.verifyAllDetailsOnTicketDetailPage();
		Log.endTestCase("verifyDetailsOnTicketDetailPage");
		
	}
	
	@Test
	public void getDetailsOnTicketDetailPage() throws InterruptedException {
		extent.createTest("Ticket details on Ticket Detail Page");
		Log.startTestCase("getDetailsOnTicketDetailPage");
		homePage = new HomePage();
		ticketDetailPage = new TicketDetailPage();
		ticketDetailPage = homePage.viewMillionaireClubTicket();
		ticketDetailPage.getAllTicketDetailsOnTicketDetailPage();
		Log.endTestCase("getDetailsOnTicketDetailPage");
		
	}

}
