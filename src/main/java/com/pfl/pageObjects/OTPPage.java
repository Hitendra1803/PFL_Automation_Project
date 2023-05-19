package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

public class OTPPage extends BaseClass{
	
	Action action = new Action();
	Actions a = new Actions(driver);

		
		public OTPPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//input[@id='OTP']")
		WebElement otpField;
		
		
		@FindBy(xpath="//button[@id='submitOTP']")
		WebElement verifyOTPBtn;
		
		@FindBy(xpath = "//button[normalize-space()='Cancel']")
		WebElement cancelButton;
		
//		@FindBy(xpath="/html/body/div[5]/div/div/div/div[2]/form/div[1]/input[1]")
//		WebElement buyOTPField;
		
//		@FindBy(id="OTP")
//		WebElement buyOTPField;
		
		@FindBy(css="body > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)")
		WebElement buyOTPField;
		
//		@FindBy(xpath = "(//div[@class='login-section'])[1]/div[1]/div/input")
//		WebElement buyOTPField;
		
		@FindBy(id="submitOTP")
		WebElement submitBUyOTP;
		
		
		//Warning messages
		
		@FindBy(css = ".text-danger")
		WebElement warningMsg;
		
		@FindBy(css = ".text-danger")
		List<WebElement> warningMsgs;
		
		
		
		

		public void getWarningMsg() {
			if(warningMsgs.size()==1) {
				for(WebElement msgs:warningMsgs) {
					Log.info("Warning msg displayed is - "+msgs.getText());
					System.out.println(msgs.getText());
				}
			}
			else if(warningMsgs.size()>1){
				for(WebElement msgs:warningMsgs) {
					Log.info("Warning msg displayed is - "+msgs.getText());
					System.out.println(msgs.getText());
				}
			}
		}
		
		public HomePage verifySignupOTP() throws InterruptedException {
			otpField.sendKeys(prop.getProperty("signupOTP"));
			action.click(driver, verifyOTPBtn);
			Thread.sleep(2000);
			return new HomePage();
		}
		
		public BuyPricePage verifyBuyOTP() throws InterruptedException {
			buyOTPField.click();
			buyOTPField.sendKeys(prop.getProperty("signupOTP"));
			action.click(driver, submitBUyOTP);
			Thread.sleep(2000);
			return new BuyPricePage();
		}
		
		public HomePage verifySignupWithoutOTP() {
			verifyOTPBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();
			cancelButton.click();
			return new HomePage();
			
		}
		
		public HomePage verifySignupWithWrongOTP() {
			otpField.click();
			otpField.sendKeys(prop.getProperty("wrongOTP"));
			action.click(driver, verifyOTPBtn);
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();
			return new HomePage();
			
		}
		
		


}
