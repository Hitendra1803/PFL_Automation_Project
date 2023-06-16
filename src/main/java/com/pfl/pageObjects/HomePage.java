package com.pfl.pageObjects;

import com.pfl.base.BaseClass;
import com.pfl.utilities.Log;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Verify;
import com.pfl.actionDriver.Action;

public class HomePage extends BaseClass{
	
	Action action = new Action();
	Actions actions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='topLogo']/a)[1]")
	WebElement crosstowerLogo;
	
	@FindBy(xpath = "(//div[@class='topLogo']/a)[2]")
	WebElement ticketverseLogo;
	
	@FindBy(css = ".pflLoginBtn > div > button")
	WebElement loginSignupBtn;
	
	@FindBy(xpath="//*[contains(text(), 'Signup')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//div[@class='bothBtn']/button[1]")
	WebElement loginBtn;
	
	@FindBy(css="p[class='regLnk'] a")
	WebElement signupBtnOnLoginPage;
	
	@FindBy(xpath="//button[@id='dropdown-basic']/img")
	WebElement userProfileImg;
	
//	@FindBy(css = ".loginBtn.userLogin.dropdown > button")
//	WebElement userProfileName;
	
	@FindBy(css = ".text-center img")
	WebElement bannerImg;
	
	//ticket details
	
	@FindBy(xpath = "//section[@class='ticketExp']/div/h3")
	WebElement ticketSectionTitle;
	
	@FindBy(xpath="//div[@class='ticketBox']")
	List<WebElement> noOfTickets;
	
	
	
	//=========for all common ticket=========
	@FindBy(css=".ticketBox")
	List<WebElement> allTickets;
	
	@FindBy(css=".ticketBox > div > h3")
	List<WebElement> allTicketName;
	
	@FindBy(xpath="//div[@class='ticketBox']/div/p[1]")
	List<WebElement> allTicketCategory;
	
	@FindBy(xpath="//div[@class='ticketBox']/div/p[2]")
	List<WebElement> allTicketSeassion;
	
	@FindBy(xpath="//div[@class='ticketBox']/div/div[2]/div[2]")
	List<WebElement> allTicketLocation;
	
	@FindBy(xpath="//div[@class='ticketBox']/div[2]/ul/li[1]")
	List<WebElement> allTicketPrice;
	
	@FindBy(xpath="//div[@class='ticketBox']/div[1]/div[1]/div")
	List<WebElement> allTicektDate;
	
	@FindBy(xpath="//div[@class='ticketBox']/div[2]/ul/li[2]/a/button")
	List<WebElement> allTicektViewBtn;
	
	
	
	
	
	
	
	//========PFL VIP Club===========
	
	
	@FindBy(xpath = "(//div[@class='pricBtn']/ul/li[2])[1]")
	WebElement vipClubViewBun;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div/h3)[1]")
	WebElement vipClubTicketName;

	@FindBy(xpath="(//div[@class='ticketBox']/div/p)[1]")
	WebElement vipClubTicketCategory;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div/p)[2]")
	WebElement vipClubTicketSeason;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div/div[2]/div[2])[1]")
	WebElement vipClubTicketLocation;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div/div[1]/div[1])[1]")
	WebElement vipClubTicketDate;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div[2]/ul/li[1])[1]")
	WebElement vipClubTicketPrice;
	
	@FindBy(xpath="(//div[@class='ticketBox']/div[2]/ul/li[2]/a/button)[2]")
	WebElement viewBtnOnVIPClubTicket;
	
	//========PFL Millionire Club===========
	
	
	@FindBy(xpath = "(//div[@class='pricBtn']/ul/li[2])[2]")
	WebElement millionaireClubViewBun;
		
	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[1]/h3")
	WebElement millionaireClubTicketName;

	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[1]/p[1]")
	WebElement millionaireClubTicketCategory;
		
	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[1]/p[2]")
	WebElement millionaireClubTicketSeason;
	
	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[1]/div[2]/div[2]/h4")
	WebElement millionaireClubTicketLocation;
		
	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[1]/div[1]/div")
	WebElement millionaireClubTicketDate;
		
	@FindBy(xpath="(//div[@class='ticketBox'])[2]/div[2]/ul/li[1]")
	WebElement millionaireClubTicketPrice;
	
	@FindBy(xpath="(//div[@class='ticketBox'])[1]/div[2]/ul/li[2]")
	WebElement viewBtnOnMillionaireClubTicket1;
	
	@FindBy(xpath="(//div[@class='ticketBox'])[1]/div[2]/ul/li[2]/a")
	WebElement viewBtnOnMillionaireClubTicket;
	
	
	
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
	
	//footer links
	
	@FindBy(xpath="(//div[@class='container'])[4]")
	WebElement footer;
	
	//Social links
	@FindBy(xpath="(//div[@class='container'])[4]/div/div[1]/ul/li")
	List<WebElement> socialLinks;
	
	//other links
	@FindBy(xpath="(//div[@class='container'])[4]/div/div[2]/ul/li/a")
	List<WebElement> otherLinks;
	
	
	
	
	
	
	public boolean verifylogo() {
		if((action.isDisplayed(driver, crosstowerLogo) == true) && (action.isDisplayed(driver, ticketverseLogo) == true) ) {
			return true;
		}
		
		else {
			return false;
		}	
	}
	
	public void verifyUserName() {
		System.out.println(userProfileName.getText());
	}
	
	public void getAllTicketsInfo() {
		int ticektCount = allTickets.size();
		Log.info("No of tickets availabe = "+ticektCount);
//		actions.scrollByAmount(0, 100);
		for(int i = 0; i<allTickets.size(); i++) {
			
			actions.scrollToElement(allTicketPrice.get(i));
			
			
			
			Log.info("Ticket = "+ (i+1));
			Log.info(allTicketName.get(i).getText().trim());
			Log.info(allTicketCategory.get(i).getText().trim());
			Log.info(allTicketSeassion.get(i).getText().trim());
			Log.info(allTicketLocation.get(i).getText().trim());
			Log.info(allTicketPrice.get(i).getText().trim());
			Log.info(allTicektDate.get(i).getText().replaceAll("\\r?\\n", " ").trim());
			
		}
	}
	
public boolean verifyPFL_MillionaireClubTicketDetails() {
		
		Assert.assertEquals(allTicketName.get(0).getText(), prop.getProperty("mTicketName"));
		Assert.assertEquals(allTicketCategory.get(0).getText(), prop.getProperty("mTickeCategory"));
		Assert.assertEquals(allTicketSeassion.get(0).getText(), prop.getProperty("mTickeSeason"));
		Assert.assertEquals(allTicketLocation.get(0).getText(), prop.getProperty("mTickeLocation"));
		Assert.assertEquals(allTicketPrice.get(0).getText(), prop.getProperty("mTickeDate"));
		Assert.assertEquals(allTicektDate.get(0).getText().replaceAll("\\r?\\n", " ").trim(), prop.getProperty("mTickePrice"));
		
		return true;
	}
	
	
	
	public boolean verifyPFL_VIPClubTicketDetails() {
		
		Assert.assertEquals(allTicketName.get(1).getText(), prop.getProperty("vTicketName"));
		Assert.assertEquals(allTicketCategory.get(1).getText(), prop.getProperty("vTickeCategory"));
		Assert.assertEquals(allTicketSeassion.get(1).getText(), prop.getProperty("vSeason"));
		Assert.assertEquals(allTicketLocation.get(1).getText(), prop.getProperty("sTickeLocation"));
		Assert.assertEquals(allTicketPrice.get(1).getText(), prop.getProperty("sTickeDate"));
		Assert.assertEquals(allTicektDate.get(1).getText().replaceAll("\\r?\\n", " ").trim(), prop.getProperty("sTickePrice"));
		
		return true;
	}
	
	
	
	public TicketDetailPage viewMillionaireClubTicket() throws InterruptedException {
		Thread.sleep(2000);
		action.explicitWait(driver, viewBtnOnMillionaireClubTicket1, 10);
		action.scrollByVisibilityOfElement(driver, viewBtnOnMillionaireClubTicket1);
		Thread.sleep(3000);
		viewBtnOnMillionaireClubTicket.click();
		return new TicketDetailPage();
	}
	
	public TicketDetailPage viewVIPClubTicket() throws InterruptedException {
		action.explicitWait(driver, viewBtnOnVIPClubTicket, 10);
		action.scrollByVisibilityOfElement(driver, viewBtnOnVIPClubTicket);
		Thread.sleep(2000);
		viewBtnOnVIPClubTicket.click();
		return new TicketDetailPage();
	}
	
	public SignupPage clickOnSignupBtn(){
		loginSignupBtn.click();
		action.explicitWait(driver, signupBtnOnLoginPage, 10);
		signupBtnOnLoginPage.click();
		return new SignupPage();
	}
	
	public LoginPage clickOnLoginBtn() {
		action.click(driver, loginSignupBtn);
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
	
	
	
	
	
	public void socialMediaLinks() throws InterruptedException {
		action.scrollByVisibilityOfElement(driver, footer);
		Thread.sleep(2000);
		action.pageLoadTimeOut(driver, 20);
		Log.info("No of other links available on the footer are = "+socialLinks.size() );
		
		for(int i = 0; i<socialLinks.size(); i++) {
			
			
			action.explicitWait(driver, socialLinks.get(i), 10);
			
			String mainWindowHandle = driver.getWindowHandle();
			
			String socialLinksNmae = socialLinks.get(i).getText();
			socialLinks.get(i).click();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			
			// Get the main window handle
//			String mainWindowHandle = driver.getWindowHandle();

			// Open a new tab or window
			// ...

			// Switch to the next available tab or window
			Set<String> windowHandles = driver.getWindowHandles();
			for (String handle : windowHandles) {
			    if (!handle.equals(mainWindowHandle)) {
			        driver.switchTo().window(handle);
			        //break;
			    }
			}

			// Perform actions on the new tab or window
			String newTabUrl = driver.getCurrentUrl();
			Log.info("URL for "+socialLinksNmae+ " is = "+newTabUrl);
			// ...
			
			switch (i) {
	        case 0:
	            Assert.assertEquals(prop.getProperty("Facebook").trim(), newTabUrl);
	            break;
	        case 1:
	            Assert.assertEquals(prop.getProperty("Twitter").trim(), newTabUrl);
	            break;
	        case 2:
	            Assert.assertEquals(prop.getProperty("Instagram").trim(), newTabUrl);
	            break;
	        case 3:
	        	Verify.verify(false, prop.getProperty("Linkedin").trim(), newTabUrl);
//	            Assert.assertEquals(prop.getProperty("Linkedin").trim(), newTabUrl);
	            break;
			case 4:
	            Assert.assertEquals(prop.getProperty("YouTuube").trim(), newTabUrl);
	            break;
	        case 5:
	            Assert.assertEquals(prop.getProperty("Telegram").trim(), newTabUrl);
	            break;
	        case 6:
	            Assert.assertEquals(prop.getProperty("Discord").trim(), newTabUrl);
	            break;
	        
	        default:
	            Assert.fail("Unexpected link index");
	    }

			// Switch back to the main window
			driver.switchTo().window(mainWindowHandle);

			// Close the newly opened tab
//			driver.close();
		
		    

		}
	}

	
	
	
	
	
	
	
	
	////
	
	public void otherPageLinks() throws InterruptedException {
		action.scrollByVisibilityOfElement(driver, footer);
		Thread.sleep(2000);
		Log.info("No of other links available on the footer are = "+otherLinks.size() );
		
		for(int i = 0; i<otherLinks.size(); i++) {
			
			action.explicitWait(driver, otherLinks.get(i), 10);
			
			String mainWindowHandle = driver.getWindowHandle();
			
			String otherLinksNmae = otherLinks.get(i).getText();
			otherLinks.get(i).click();
			
			
			// Get the main window handle
//			String mainWindowHandle = driver.getWindowHandle();

			// Open a new tab or window
			// ...

			// Switch to the next available tab or window
			Set<String> windowHandles = driver.getWindowHandles();
			for (String handle : windowHandles) {
			    if (!handle.equals(mainWindowHandle)) {
			        driver.switchTo().window(handle);
			        break;
			    }
			}

			// Perform actions on the new tab or window
			String newTabUrl = driver.getCurrentUrl();
			Log.info("URL for "+otherLinksNmae+ " is = "+newTabUrl);
			
			switch (i) {
	        case 0:
	            Assert.assertEquals(prop.getProperty("About_Us"), newTabUrl);
	            break;
	        case 1:
	            Assert.assertEquals(prop.getProperty("Contact_Us"), newTabUrl);
	            break;
	        case 2:
	            Assert.assertEquals(prop.getProperty("Terms_and_Condations"), newTabUrl);
	            break;
	        case 3:
	            Assert.assertEquals(prop.getProperty("Privacy_Policy"), newTabUrl);
	            break;
	        
	        default:
	            Assert.fail("Unexpected link index");
	    }
			
			// ...

			// Switch back to the main window
			driver.switchTo().window(mainWindowHandle);

			// Close the newly opened tab
//			driver.close();
			
			// Switch back to the main window
		    driver.switchTo().window(mainWindowHandle);

		}
	}
	
	
	
	
	

}
