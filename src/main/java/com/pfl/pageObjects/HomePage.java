package com.pfl.pageObjects;

import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pfl.actionDriver.Action;

public class HomePage extends BaseClass{
	
	Action action = new Action();

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/']/img")
	WebElement appLogo;
	
	@FindBy(css = ".bothBtn")
	WebElement loginSignupBtn;
	
	@FindBy(xpath="//*[contains(text(), 'Signup')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//div[@class='bothBtn']/button[1]")
	WebElement loginBtn;
	
	@FindBy(css="p[class='regLnk'] a")
	WebElement signupBtnOnLoginPage;
	
	@FindBy(xpath="//button[@id='dropdown-basic']//img")
	WebElement userProfileImg;
	
	@FindBy(css = ".loginBtn.userLogin.dropdown > button")
	WebElement userProfileName1;
	
	@FindBy(css = ".text-center img")
	WebElement bannerImg;
	
	//ticket details
	
	@FindBy(xpath = "//section[@class='ticketExp']/div/h3")
	WebElement ticketSectionTitle;
	
	
	@FindBy(id = "645e236855b5c3510f5c1df4")
	WebElement buyBtnonTicket;
	
	@FindBy(xpath="//div[@class='ticketBox']")
	List<WebElement> noOfTickets;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/h3")
	WebElement superPremiumTicketName;

	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/p")
	WebElement superPremiumTicketCategory;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/p[2]")
	WebElement superPremiumTicketSeason;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/div/div[2]")
	WebElement superPremiumTicketLocation;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/div[2]/div/span")
	WebElement superPremiumTicketDateDay;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div/div[2]/div")
	WebElement superPremiumTicketDateMonth;
	
	@FindBy(xpath="//section[@class='ticketExp']/div/div/div[1]/div/div[2]/ul/li")
	WebElement superPremiumTicketPrice;
	
	//Profile options for login users
	
	@FindBy(css=".userProfile img")
	WebElement userProfileIcon;
	
	@FindBy(css=".userProfile")
	WebElement userProfileName;
	
	@FindBy(css=".userProfile i")
	WebElement userProfileDropdown;
	
	@FindBy(xpath="//div[@class='pflLoginBtn']/div/div/li[1]")
	WebElement userProfileDropdownProfile;
	
	@FindBy(xpath="//div[@class='pflLoginBtn']/div/div/li[2]")
	WebElement userProfileDropdownChangePass;
	
	@FindBy(xpath="//div[@class='pflLoginBtn']/div/div/li[3]")
	WebElement userProfileDropdownLogout;
	
	
	
	
	
	public boolean verifylogo() {
		return action.isDisplayed(driver, appLogo);
	}
	
	public void verifyUserName() {
		System.out.println(userProfileName1.getText());
	}
	
	
	
	public boolean verifyTicketDetails() {
		int num = noOfTickets.size();
		System.out.println("Total Tickets: " + num);
		Assert.assertEquals(superPremiumTicketName.getText(), prop.getProperty("sTicketName"));
		Assert.assertEquals(superPremiumTicketCategory.getText(), prop.getProperty("sTickeCategory"));
		Assert.assertEquals(superPremiumTicketLocation.getText(), prop.getProperty("sTickeLocation"));
		Assert.assertEquals(superPremiumTicketDateDay.getText(), prop.getProperty("sTickeDate"));
		Assert.assertEquals(superPremiumTicketPrice.getText(), prop.getProperty("sTickePrice"));
		
		return true;
	}
	
	public void getTicketDetails() {
		
		int num = noOfTickets.size();
		System.out.println("Total Tickets available on Home Page - "+num);
		Integer.toString(num);
		Log.info(Integer.toString(num));
		Log.info(superPremiumTicketName.getText());
		Log.info(superPremiumTicketCategory.getText());
		Log.info(superPremiumTicketSeason.getText());
		Log.info(superPremiumTicketLocation.getText());
		Log.info(superPremiumTicketDateDay.getText()+" "+superPremiumTicketDateMonth.getText());
		Log.info(superPremiumTicketPrice.getText());	
		
		
		
	}
	
	public TicketDetailPage clickBuyBtn() throws InterruptedException {
		action.explicitWait(driver, buyBtnonTicket, 10);
		action.scrollByVisibilityOfElement(driver, buyBtnonTicket);
		Thread.sleep(2000);
		buyBtnonTicket.click();
		return new TicketDetailPage();
	}
	
	public SignupPage clickOnSignupBtn(){
		signupBtn.click();
		return new SignupPage();
	}
	
	public LoginPage clickOnLoginBtn() {
		action.click(driver, loginBtn);
		return new LoginPage();
	}
	
	
	public boolean verifyUserIsLogin() {
		return action.isDisplayed(driver, userProfileIcon);
	}
	
	public void verifyUserNameAfterLogin() {
		String userName = userProfileName.getText();
		System.out.println("The user name displayed is- "+userName);
	}
	
	public ProfilePage usersProfilePage() {
		userProfileDropdown.click();
		action.click(driver, userProfileDropdownProfile);
		return new ProfilePage();
	}
	
	public void changePassword() {
		//code
	}
	
	public boolean userLogout() {
		userProfileDropdown.click();
		action.click(driver, userProfileDropdownLogout);
		return action.isDisplayed(driver, loginSignupBtn);
	}
	
	
	
	
	

}
