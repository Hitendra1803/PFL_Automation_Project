package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

public class LoginPage extends BaseClass{
	
	Action action = new Action();
	Actions a = new Actions(driver);

		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}


		
		@FindBy(id="User-Name")
		WebElement userEmail;
		
		
		@FindBy(id="id_password")
		WebElement userPassword;
		
		@FindBy(xpath="//div[@class='forgot-div']/a")
		WebElement forgetPasswordBtn;
		
		@FindBy(css=".cancel-button.my-0")
		WebElement cancelBtn;
		
		@FindBy(css=".creat-button.px-4.m-0")
		WebElement loginSubmitBtn;
		
		@FindBy(css = ".text-danger")
		WebElement warningMsg;
		
		@FindBy(css = ".text-danger")
		List<WebElement> warningMsgs;
		
		
		public HomePage userLogin(){
			userEmail.sendKeys(prop.getProperty("lUserName"));
			userPassword.sendKeys(prop.getProperty("lPassword"));
			action.click(driver, loginSubmitBtn);
			return new HomePage();
		}
		
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
		
		public HomePage tryLoginWithoutEmail(){
			userPassword.sendKeys(prop.getProperty("lPassword"));
			loginSubmitBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();
			cancelBtn.click();
			return new HomePage();
		}
		
		public HomePage tryLoginWithoutPassword() {
			userEmail.sendKeys(prop.getProperty("lUserName"));
			loginSubmitBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();
			cancelBtn.click();
			return new HomePage();
		}
		
		public HomePage tryLoginWithoutEmailPass() {
			loginSubmitBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();	
			cancelBtn.click();
			return new HomePage();
		}
		
		public HomePage tryLoginWithInvalidEmail() {
			userEmail.sendKeys(prop.getProperty("wrongUserName"));
			userPassword.sendKeys(prop.getProperty("wrongPassword"));
			loginSubmitBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();	
			cancelBtn.click();
			return new HomePage();
		}
		
		public HomePage tryLoginWithInvalidPassword() {
			userEmail.sendKeys(prop.getProperty("lUserName"));
			userPassword.sendKeys(prop.getProperty("wrongPassword"));
			loginSubmitBtn.click();
			action.explicitWait(driver, warningMsg, 10);
			getWarningMsg();	
			cancelBtn.click();
			return new HomePage();
		}
		
		
		
	

}
