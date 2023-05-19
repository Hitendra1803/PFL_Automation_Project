package com.pfl.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class BuyPricePage extends BaseClass{
Action action = new Action();
Actions a = new Actions(driver);
	
	public BuyPricePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".single_collection_price_currency ")
	WebElement collectionPrice;
	
	@FindBy(css="body > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > p:nth-child(2) > span:nth-child(1)")
	WebElement collectionProcessingFee;
	
	@FindBy(css="body > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > p:nth-child(2) > span:nth-child(1)")
	WebElement collectionServiceFee;
	
	@FindBy(css="body > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(4) > p:nth-child(2) > span:nth-child(1)")
	WebElement collectionSalesTax;
	
	@FindBy(css="p[id='current_balance'] span h6")
	WebElement cllectionTotalValue;
	
	@FindBy(xpath="//div[@class='pop_content']/div[3]/div[2]/button")
	WebElement colectionBuyButton;
	
	//=====================After Payment Success=================================
	
	@FindBy(css=".mt-4.mb-2")
	WebElement paymentSuccessText;
	
	@FindBy(css=".creat-button.w-60")
	WebElement goToProfilePage;
	
	
	public void verifyTicketPriceDetails() {
		String colPrice = collectionPrice.getText().replace("$", " ");
		double colPriceInt = Double.parseDouble(colPrice);
		
		String colProcessingFee = collectionProcessingFee.getText().replace("$", " ");
		double colProcessingFeeInt = Double.parseDouble(colProcessingFee);
		
		String colServiceFee = collectionServiceFee.getText().replace("$", " ");
		double colServiceFeeInt = Double.parseDouble(colServiceFee);
		
		String colSalesTax = collectionSalesTax.getText().replace("$", " ");
		double colSalesTaxInt = Double.parseDouble(colSalesTax);
		
		String clTotalValue = cllectionTotalValue.getText().replace("$", " ");
		double clTotalValueInt = Double.parseDouble(colSalesTax);
		
		double totalSum = colPriceInt + colProcessingFeeInt + colServiceFeeInt + colSalesTaxInt + clTotalValueInt;
		
		//Assert.assertEquals(clTotalValue, totalSum);
		
		if(clTotalValueInt == totalSum) {
			System.out.println("Calculations are correct ");
		}
		else {
			System.out.println("Calculations are not correct ");
		}

	}
	
	public String totalCollectionPrice() {
		return cllectionTotalValue.getText();
	}
	
	public StripePaymentGateway clickOnCollectionBuyBtn() {
		colectionBuyButton.click();
		return new StripePaymentGateway();
	}
	
	
	
	//=====================After Payment Success=================================
	public String verifySucessMsg() {
		return paymentSuccessText.getText();
		
		}
	
	public ProfilePage gotoProfileAfterSuccessPayment() {
		goToProfilePage.click();
		return new ProfilePage();
	}


}
