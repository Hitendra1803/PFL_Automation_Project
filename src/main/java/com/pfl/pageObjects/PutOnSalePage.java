package com.pfl.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class PutOnSalePage extends BaseClass {
	
	Action action = new Action();
	
	public PutOnSalePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='ticketContent']/div/div/div/button")
	WebElement putOnSaleBtnOnTicket;
	
	@FindBy(xpath="//div[@class='tktDetail_2']/button")
	WebElement putOnSaleBtnOnTicketDetainPage;
	
	
	//put on sale Pop-up
	
	@FindBy(css=".modal-content > div > h2")
	WebElement putOnSalePopupHeading;
	
	@FindBy(xpath="//div[@class='login-section']/form/div[1]/div[1]/input")
	WebElement amountField;
	
	@FindBy(xpath="//div[@class='login-section']/form/div[1]/div[2]/div[2]/div/input")
	WebElement datepickerField;

	@FindBy(css=".react-datepicker__current-month")
	WebElement datepicker_currentMonthYear;

	@FindBy(css=".react-datepicker__navigation.react-datepicker__navigation--next")
	WebElement datepicker_NextBtn;
	
	String datepicker_Day = prop.getProperty("datepicker_day");
	WebElement datepicker_day = driver.findElement(By.xpath("//div[@class='react-datepicker__week']/div[text()='"+datepicker_Day+"']"));
	
	@FindBy(css=".check-box-div > span")
	WebElement sellAnonymouslyText;
	
	@FindBy(css=".check-box-div > input")
	WebElement sellAnonymouslyCheckBox;
	
	@FindBy(xpath="//div[@class='login-section']/form/div[2]/div[1]/button")
	WebElement cancelBtn;
	
	@FindBy(xpath="//div[@class='login-section']/form/div[2]/div[2]/button")
	WebElement continueBtn1;
	
	
	//put on sale confirmation Pop-up
	
	@FindBy(xpath="//div[@class='login-section']/div[1]/div[2]/p[2]")
	WebElement desiredAmount;
	
	@FindBy(xpath="//div[@class='login-section']/div[1]/div[3]/p[2]")
	WebElement expirationDate;
	
	@FindBy(xpath="//div[@class='login-section']/div[1]/div[4]/p[2]")
	WebElement selAnonymouslyStatus;
	
	@FindBy(xpath="//div[@class='login-section']/div[2]/div[1]/button")
	WebElement backBtn;
	
	@FindBy(xpath="//div[@class='login-section']/div[2]/div[2]/button")
	WebElement continueBtn2;
	
	
	
	//Listed successful Pop-up
	
	@FindBy(css=".login-section > form > div > h2")
	WebElement listedSuccessfullyPopupText;
	
	@FindBy(css=".login-section > form > div > p")
	WebElement listedSuccessfullyPopupDetailText;
	
	@FindBy(xpath="//div[@class='login-section']/form/div[2]/a/button")
	WebElement goToProfileBtn;
	
	
	
	

}
