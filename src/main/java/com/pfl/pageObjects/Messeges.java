package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class Messeges extends BaseClass{
	
	Action action = new Action();
	Actions a = new Actions(driver);

		
		public Messeges() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css = ".text-danger")
		WebElement warningMsg;
		
		@FindBy(css = ".text-danger")
		List<WebElement> warningMsgs;
		
		public void getWarningMsg() {
			if(warningMsgs.size()==1) {
				for(WebElement msgs:warningMsgs) {
					System.out.println(msgs.getText());
				}
			}
			else if(warningMsgs.size()>1){
				for(WebElement msgs:warningMsgs) {
					System.out.println(msgs.getText());
				}
			}
		}

}
