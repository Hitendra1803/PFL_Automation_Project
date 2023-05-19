package com.pfl.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

public class ProfilePage extends BaseClass{
	
	Action action = new Action();
	Actions a = new Actions(driver);

		
		public ProfilePage() {
			PageFactory.initElements(driver, this);
		}
		
		//(//div[@class='cardBox nft-box-img-box'])[2]
		
		@FindBy(xpath="(//div[@class='cardBox nft-box-img-box'])")
		List<WebElement> collectedTickets;
		
		@FindBy(css = ".cardBox.nft-box-img-box > div")
		WebElement parentCard;
		
		@FindBy(css = ".cardBox.nft-box-img-box > div > h2")
		List<WebElement> cardName;
		
		@FindBy(css = ".cardBox.nft-box-img-box > figure > figcaption")
		List<WebElement> countofTickets;
		
		public void verifyCardsCountOnProfilePage() {
			int cardsCount = collectedTickets.size();
			Log.info("Total collected cards are - "+ cardsCount);
		}
		
//		public void verifyNumberofTicketsofSameEvent() {
//			String cName = cardName.getText();
//			if(cName == prop.getProperty("SPcName")) {
//				System.out.println(cName+" = "+countofTickets.getText());
//			}
//			else if(cName == prop.getProperty("PcName")) {
//				System.out.println(cName+" = "+countofTickets.getText());
//			}
//			else {
//				System.out.println("No cards found");
//			}
//		}
		
		/*
		public void getCardInfo() {
			for(WebElement cards:cardName) {
				System.out.println(cards.getText());
				for(WebElement cardsNum:countofTickets) {
					System.out.println(cardsNum.getText());	
				}
			}
		}
		*/
		
		public void getCardInfo() {
			for(int i = 0; i<cardName.size(); i++) {
				Log.info("Ticket name = "+cardName.get(i).getText());
				 Log.info("No. of tickets = "+countofTickets.get(i).getText());
			}
		}

		
		
		


}
