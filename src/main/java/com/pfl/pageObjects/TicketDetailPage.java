package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

public class TicketDetailPage extends BaseClass {
	
	Action action = new Action();
	
	public TicketDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(xpath = "//div[@class='textCont']/h3")
	WebElement ticketName;
	
	@FindBy(xpath = "//div[@class='textCont']/p")
	WebElement ticketCategory;
	
	@FindBy(xpath = "//div[@class='textCont']/p[2]")
	WebElement ticketSeason;
	
	@FindBy(xpath = "//div[@class='textCont']/div/div[2]/h4")
	WebElement ticketLocation;
	
	@FindBy(css = ".roundDate span")
	WebElement ticketDate;
	
	@FindBy(css = ".price")
	WebElement ticketPrice;
	
	@FindBy(xpath = "//div[@class='pricBtn']/ul/li[2]/form/button[1]")
	WebElement qtyMinus;
	
	@FindBy(css = "//div[@class='pricBtn']/ul/li[2]/form/input")
	WebElement qtyAmount;
	
	@FindBy(css = "//div[@class=\"pricBtn\"]/ul/li[2]/form/button[2]")
	WebElement qtyPlus;
	
	@FindBy(xpath = "//div[@class='pricBtn']/ul/li[3]/button")
	WebElement ticketBuyBtn;
	
	@FindBy(css = ".shareBtn button")
	WebElement ticketShareBtn;
	
	@FindBy(xpath = "//div[@class='dropdown-menu show']/li/a")
	List<WebElement> shareOptions;
	
	@FindBy(xpath = "//section[@class='millonare']/div/div/div/div")
	WebElement ticketDescription;
	
	@FindBy(xpath = "//section[@class='excBenefit']/div/div/div[1]/div")
	List<WebElement> ticektExclusiveBenifits;
	
	@FindBy(xpath = "//section[@class='excBenefit']/div/div/div[2]/div")
	List<WebElement> ticektDayofEventsBenifits;
	
	@FindBy(xpath = "//section[@class='perksSection']/div/div[1]/div")
	List<WebElement> extraPerks;
	
	@FindBy(xpath = "//div[@class='joinBox']/div[1]")
	WebElement joinBoxText;
	
	@FindBy(xpath = "//div[@class = 'joinBox']/div[2]/p")
	WebElement joinBoxPrice;
	
	@FindBy(xpath = "//div[@class = 'joinBox']/div[2]/button")
	WebElement joinBoxBuyBtn;
	
	
	
	
	public void getAllTicketDetailsOnTicketDetailPage() {
		Log.info(ticketName.getText());
		Log.info(ticketCategory.getText());
		Log.info(ticketSeason.getText());
		Log.info(ticketLocation.getText());
		Log.info(ticketDate.getText().replaceAll("\\r?\\n", " ").trim());
		Log.info(ticketPrice.getText());
		Log.info(ticketDescription.getText().replaceAll("\\r?\\n", " = ").trim());
		for(int i =0; i<ticektExclusiveBenifits.size(); i++) {
			Log.info(ticektExclusiveBenifits.get(i).getText().replaceAll("\\r?\\n", " = ").trim());
		}
		for(int i =0; i<ticektDayofEventsBenifits.size(); i++) {
			Log.info(ticektDayofEventsBenifits.get(i).getText().replaceAll("\\r?\\n", " = ").trim());
		}
		System.out.println("Extra Perks");
		for(int i =0; i<extraPerks.size(); i++) {
			Log.info(extraPerks.get(i).getText().replaceAll("\\r?\\n", " = ").trim());
		}
		Log.info("Join Box Text = "+joinBoxText.getText());
		Log.info("Join Box Price = "+joinBoxPrice.getText());
		
	}
	
	public void verifyAllDetailsOnTicketDetailPage() throws InterruptedException {
		
		Assert.assertEquals(ticketName.getText(), prop.getProperty("TDP_ticketName"));
		Assert.assertEquals(ticketCategory.getText(), prop.getProperty("TDP_ticketCategory"));
		Assert.assertEquals(ticketSeason.getText(), prop.getProperty("TDP_ticketSeason"));
		Assert.assertEquals(ticketLocation.getText(), prop.getProperty("TDP_ticketLocation"));
		Assert.assertEquals(ticketDate.getText().replaceAll("\\r?\\n", " ").trim(), prop.getProperty("TDP_ticketDate"));
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
		
		int exclusiveBenifitsCount = ticektExclusiveBenifits.size();
		System.out.println("Available Exclusive benifits for the collection - "+exclusiveBenifitsCount);
		Thread.sleep(2000);
		
		int dayofEventsBenifitsCounts = ticektDayofEventsBenifits.size();
		System.out.println("Available Day of Events benifits for the collection - "+dayofEventsBenifitsCounts);
		Thread.sleep(2000);
		
		int extraPerkserksCounts = extraPerks.size();
		System.out.println("Available Extra perks for the collection - "+extraPerkserksCounts);
		Thread.sleep(2000);
		
	}
	
	public OTPPage buyTicket() throws InterruptedException {
		action.explicitWait(driver, ticketBuyBtn, 10);
		Thread.sleep(2000);
		return new OTPPage();
		
	}
	
	
	

}
