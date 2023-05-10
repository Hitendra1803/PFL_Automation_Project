package com.pfl.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class TicketDetailPage extends BaseClass {
	
	Action action = new Action();
	
	public TicketDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='textCont']/h3")
	WebElement ticketName;
	
	@FindBy(xpath = "//div[@class='col-10']/h3")
	WebElement location;
	
	@FindBy(css = ".price")
	WebElement ticketPrice;
	
	@FindBy(css = ".explorBtn")
	WebElement ticketBuyBtn;
	
	public String ticketName() {
		return ticketName.getText();
	}
	
	public String location() {
		return location.getText();
	}
	
	public String price() {
		return ticketPrice.getText();
	}
	public void clickBuyBtn() {
		action.click(driver, ticketBuyBtn);
	}
	

}
