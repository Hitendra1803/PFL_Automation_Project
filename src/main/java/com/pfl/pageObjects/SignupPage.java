package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

public class SignupPage extends BaseClass {
	
Action action = new Action();
Actions a = new Actions(driver);

	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='bothBtn']/button[2]")
	WebElement signUpButton;
	
	@FindBy(id="First_Name")
	WebElement firstName ;
	
	@FindBy(id="Last_Name")
	WebElement lastName ;
	
	@FindBy(xpath="//input[@id='react-select-2-input']")
	WebElement countryCode;
	
	@FindBy(css="#mobile")
	WebElement mobileNum;
	
	@FindBy(id="Email")
	WebElement emailField;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="cpassword")
	WebElement cPassword;
	
	@FindBy(xpath="//div[@class='check-box-div']/input")
	WebElement privacyCheckBox;
	
	@FindBy(css="button[type='submit']")
	WebElement submitButton;
	
	@FindBy(css=".cancel-button.m-0")
	WebElement cancelButton;
	
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
	
	public OTPPage newUserSignUp() throws InterruptedException {	
		firstName.sendKeys(prop.getProperty("fName"));
		lastName.sendKeys(prop.getProperty("lName"));	
        countryCode.click();   
        countryCode.sendKeys("India", Keys.ENTER);
		mobileNum.sendKeys(prop.getProperty("mobileNumber"));
		emailField.sendKeys(prop.getProperty("emailId"));
		password.sendKeys(prop.getProperty("pass"));
		cPassword.sendKeys(prop.getProperty("cPass"));
		privacyCheckBox.click();	
		submitButton.click();
		return new OTPPage();
		
	}
	
	public HomePage signupWithoutDetails() {
		submitButton.click();
		action.explicitWait(driver, warningMsg, 10);
		getWarningMsg();
		cancelButton.click();
		return new HomePage();
		
	}
	
	public HomePage trySignupWithUsedMobileNumber() {
		firstName.sendKeys(prop.getProperty("fName"));
		lastName.sendKeys(prop.getProperty("lName"));	
        countryCode.click();   
        countryCode.sendKeys("India", Keys.ENTER);
		mobileNum.sendKeys(prop.getProperty("usedMobileNumber"));
		emailField.sendKeys(prop.getProperty("usedEmailId"));
		password.sendKeys(prop.getProperty("pass"));
		cPassword.sendKeys(prop.getProperty("cPass"));
		privacyCheckBox.click();	
		submitButton.click();
		action.explicitWait(driver, warningMsg, 10);
		getWarningMsg();
		cancelButton.click();
		return new HomePage();
		
	}
	
	public HomePage trySignupWithoutCheckingCheckbox(){	
		firstName.sendKeys(prop.getProperty("fName"));
		lastName.sendKeys(prop.getProperty("lName"));	
        countryCode.click();   
        countryCode.sendKeys("India", Keys.ENTER);
		mobileNum.sendKeys(prop.getProperty("mobileNumber"));
		emailField.sendKeys(prop.getProperty("emailId"));
		password.sendKeys(prop.getProperty("pass"));
		cPassword.sendKeys(prop.getProperty("cPass"));	
		submitButton.click();
		action.explicitWait(driver, warningMsg, 10);
		getWarningMsg();
		cancelButton.click();
		return new HomePage();
		
	}
	
	

}