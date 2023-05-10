package com.pfl.pageObjects;

import com.pfl.base.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;

public class HomePage extends BaseClass{
	
	Action action = new Action();

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/']/img")
	WebElement appLogo;
	
	@FindBy(css = ".bothBtn")
	WebElement loginSignupBtn;
	
	@FindBy(css = ".text-center img")
	WebElement bannerImg;
	
	@FindBy(xpath = "//section[@class='ticketExp']/div/h3")
	WebElement ticketSection;
	
	@FindBy(xpath = "//div[@class='row']//div[1]//div[1]//div[2]//ul[1]//a[1]//li[1]//button[1]")
	WebElement buyBtnonTicket;
	
	public boolean verifylogo() {
		return action.isDisplayed(driver, appLogo);
	}
	public TicketDetailPage clickBuyBtn() {
		action.click(driver, buyBtnonTicket);
		return new TicketDetailPage();
	}
	
	
	
	
	
	

}
