package com.pfl.pageObjects;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import com.pfl.actionDriver.Action;
import com.pfl.base.BaseClass;

public class BuyPricePage extends BaseClass{
Action action = new Action();
Actions a = new Actions(driver);
Pattern pattern;
Matcher matcher;
	
	public BuyPricePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//=====================Details on Purchase Information Popup=================================
	
	@FindBy(xpath="//div[@class='pop_content']/div[2]/div/input")
	WebElement collectionQty;
	
	@FindBy(xpath="//div[@class='pop_content']/div[2]/div/button[2]")
	WebElement collectionQtyPlus;
	
	@FindBy(xpath="//div[@class='pop_content']/div[2]/div/button[1]")
	WebElement collectionQtyMinus;
	
	@FindBy(xpath="//div[@class='bid-details']/p/span/span")
	WebElement collectionPrice;
	
	@FindBy(xpath="//div[@class='bid-details'][2]/p/span")
	WebElement collectionProcessingFee;
	
	@FindBy(xpath="//div[@class='bid-details'][3]/p/span")
	WebElement collectionSalesTax;
	
	@FindBy(xpath="//div[@class='bid-details'][4]/p/span/h6")
	WebElement cllectionTotalValue;
	
	@FindBy(xpath="//div[@class='pop_content']/div[4]/div[2]/button")
	WebElement colectionBuyButton;
	
	@FindBy(xpath="//div[@class='pop_content']/div[4]/div[1]/button")
	WebElement colectionCancelButton;
	
	//=====================After Payment Success=================================
	
	@FindBy(css=".mt-4.mb-2")
	WebElement paymentSuccessText;
	
	@FindBy(css=".creat-button.w-60")
	WebElement goToProfilePage;
	
	
	public void verifyTicketPriceDetails() {
		int qtyToBuy = Integer.parseInt(collectionQty.getAttribute("value"));
		System.out.println("Ticket qty to buy = "+qtyToBuy);
		
		int quantityToBuy = Integer.parseInt(prop.getProperty("buyQty"));
		
		if(quantityToBuy>1) {
			for(int i = 0; i<quantityToBuy; i++) {
				collectionQtyPlus.click();
			}
		}
		int qtyToBuy1 = Integer.parseInt(collectionQty.getAttribute("value"));
		System.out.println("Ticket qty to buy = "+qtyToBuy1);
		
			
			
		
		String colPrice = collectionPrice.getText();
		pattern = Pattern.compile("\\d+\\.\\d+");
        matcher = pattern.matcher(colPrice);
        
        double colPriceInt = 0;
        // Extracting numbers from the string
        while (matcher.find()) {
            String tPrice = matcher.group();
            colPriceInt = Double.parseDouble(tPrice);       
            break;
        }
        System.out.println("clPrice = "+colPriceInt);
	
		
		
		
		
		String colProcessingFee = collectionProcessingFee.getText();
		pattern = Pattern.compile("\\d+\\.\\d+");
        matcher = pattern.matcher(colProcessingFee);
        
        double colProcessingFeeInt = 0;
        // Extracting numbers from the string
        while (matcher.find()) {
            String tPrice = matcher.group();
            colProcessingFeeInt = Double.parseDouble(tPrice);       
            break;
        }
        System.out.println("clProcessingFee = "+colProcessingFeeInt);
		
		
		
		
		String colSalesTax = collectionSalesTax.getText();
		pattern = Pattern.compile("\\d+\\.\\d+");
        matcher = pattern.matcher(colSalesTax);
        
        double colSalesTaxInt = 0;
        // Extracting numbers from the string
        while (matcher.find()) {
            String tPrice = matcher.group();
            colSalesTaxInt = Double.parseDouble(tPrice);       
            break;
        }
        System.out.println("clSalesTax = "+colSalesTaxInt);
		
		
		
		
		String clTotalValue = cllectionTotalValue.getText();
        pattern = Pattern.compile("\\d+\\.\\d+");
        matcher = pattern.matcher(clTotalValue);
        
        double clTotalValueInt = 0;
        // Extracting numbers from the string
        while (matcher.find()) {
            String tPrice = matcher.group();
            clTotalValueInt = Double.parseDouble(tPrice);       
            break;
        }
        System.out.println("clTotalValueInt = "+clTotalValueInt);
		
		double totalSum = colPriceInt + colProcessingFeeInt + colSalesTaxInt;
		System.out.println("totalSum = "+totalSum);
		
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
