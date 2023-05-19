package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class TicketDetailPage extends BaseClass {
	
	Action action = new Action();
	
	public TicketDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "//div[@class='textCont']/h3")
	WebElement ticketName;
	
	@FindBy(xpath = "//div[@class='textCont']/p")
	WebElement ticketCategory;
	
	@FindBy(xpath = "//div[@class='textCont']/div/div[2]/h4")
	WebElement ticketLocation;
	
	@FindBy(css = ".roundDate span")
	WebElement ticketDate;
	
	@FindBy(css = ".price")
	WebElement ticketPrice;
	
	@FindBy(xpath = "//div[@class='ticktDisc']/p[1]")
	WebElement ticketDescription;
	
	@FindBy(css = ".explorBtn")
	WebElement ticketBuyBtn;
	
	@FindBy(css = ".shareBtn button")
	WebElement ticketShareBtn;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']/li/a")
	List<WebElement> shareOptions;
	
	@FindBy(xpath = "//div[@class='marquee']/div/div/img")
	List<WebElement> ticektBenifits;
	
	@FindBy(xpath = "//section[@class='perkSectn']/div/div[1]/div")
	List<WebElement> specialPerks;
	
	@FindBy(xpath = "//section[@class='perkSectn']/div/div[2]/div")
	List<WebElement> generalPerks;
	
	
	
	
	public void verifyAllDetailsOnTicketDetailPage() throws InterruptedException {
		
		Assert.assertEquals(ticketName.getText(), prop.getProperty("TDP_ticketName"));
		Assert.assertEquals(ticketCategory.getText(), prop.getProperty("TDP_ticketCategory"));
		Assert.assertEquals(ticketLocation.getText(), prop.getProperty("TDP_ticketLocation"));
		Assert.assertEquals(ticketDate.getText(), prop.getProperty("TDP_ticketDate"));
		Assert.assertEquals(ticketPrice.getText(), prop.getProperty("TDP_ticketPrice"));
		Assert.assertEquals(ticketDescription.getText(), prop.getProperty("TDP_ticketDescription"));
		
		ticketShareBtn.click();
		
		int shareOptionsCount = shareOptions.size();
		System.out.println("Available social media options - "+shareOptionsCount);
		Thread.sleep(2000);
		
		for(WebElement sOptions:shareOptions) {
			System.out.println(sOptions.getText());
		}
		ticketShareBtn.click();
		Thread.sleep(2000);
		
		int benefitsCount = ticektBenifits.size();
		System.out.println("Available benifit for the collection - "+benefitsCount);
		Thread.sleep(2000);
		
		int specialPerkserksCounts = specialPerks.size();
		System.out.println("Available Special perks for the collection - "+specialPerkserksCounts);
		Thread.sleep(2000);
		
		int generalPerkserksCounts = generalPerks.size();
		System.out.println("Available general perks for the collection - "+generalPerkserksCounts);
		Thread.sleep(2000);
		
	}
	
	public OTPPage buyTicket() throws InterruptedException {
		action.click(driver, ticketBuyBtn);
		Thread.sleep(6000);
		return new OTPPage();
		
	}
	
	
	

}
