package com.pfl.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.pfl.utilities.ExtentManager;
import com.pfl.utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;

	// Declare ThreadLocal Driver
	public static WebDriver driver;
	

	//loadConfig method is to load the configuration
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j2.xml");
		//PropertyConfigurator.configure("log4j.properties");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@BeforeMethod
	public void launchApp() throws InterruptedException {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		
		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((Integer.parseInt(prop.getProperty("implicitWait")))));
		
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds((Integer.parseInt(prop.getProperty("pageLoadTimeOut")))));
		//Launching the URL
		driver.get(prop.getProperty("uatUrl"));
		
		//Implicit TimeOuts
				Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite()
	public void afterSuite() {
		ExtentManager.endReport();
	}
	

}
