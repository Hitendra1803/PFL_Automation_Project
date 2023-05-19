package com.pfl.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class StripePaymentGateway extends BaseClass {
	
	Action action = new Action();
	Actions a = new Actions(driver);
	BuyPricePage bpPage = new BuyPricePage();
		
		public StripePaymentGateway() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".ProductSummary-info span")
		WebElement collectionName;
		
		@FindBy(css=".ProductSummary-totalAmount")
		WebElement collectionPrice;
		
		@FindBy(xpath="//input[@id='email']")
		WebElement stripeEmail;
		
		@FindBy(xpath="//input[@id='cardNumber']")
		WebElement stripeCardNumber;
		
		@FindBy(xpath="//input[@id='cardExpiry']")
		WebElement stripeCardExpiry;
		
		@FindBy(xpath="//input[@id='cardCvc']")
		WebElement stripeCardCvc;
		
		@FindBy(xpath="//input[@id='billingName']")
		WebElement stripeCardName;
		
		@FindBy(css=".Select-source")
		WebElement stripeCountry;
		
		@FindBy(xpath="//div[@class='SubmitButton-IconContainer']")
		WebElement stripePayBtn;
		
		
//		public boolean verifyCollectionDetails() {
//			Assert.assertEquals(collectionName.getText(), prop.getProperty("sTicketName"));
//			Assert.assertEquals(bpPage.totalCollectionPrice(), collectionPrice.getText());
//			return true;
//		}
		
		public void verifyCollectionDetails() {
			if(collectionName.getText() == prop.getProperty("sTicketName")) {
				System.out.println("Collection name on stripe page is correct");
			}
			else {
				System.out.println("Collection name on stripe page is not correct");
			}
			
//			if(bpPage.totalCollectionPrice() == collectionPrice.getText()) {
//				System.out.println("Collection price on stripe page is correct");
//				
//			}
//			else {
//				System.out.println("Collection price on stripe page is not correct");
//			}
			
		}
		
		public BuyPricePage enterCardDetails() {
			action.type(stripeEmail, prop.getProperty("stripeEmail"));
			action.type(stripeCardNumber, prop.getProperty("stripeCardNumber"));
			action.type(stripeCardExpiry, prop.getProperty("stripeCardExpiry"));
			action.type(stripeCardCvc, prop.getProperty("stripeCardCvc"));
			action.type(stripeCardName, prop.getProperty("stripeCardName"));
			
			Select select = new Select(stripeCountry);
			select.selectByVisibleText(prop.getProperty("stripeCountry"));
			action.click(driver, stripePayBtn);
			return new BuyPricePage();
			
			
		}

}
