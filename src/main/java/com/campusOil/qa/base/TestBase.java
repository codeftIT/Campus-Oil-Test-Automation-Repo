package com.campusOil.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.java.ExcelImporter;
import com.qa.util.java.TestUtil;

import com.qa.util.java.WebEventListener;


public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	private String browserType;
	//public static String inputbrowser;
	public static ExcelImporter ExcelData;
	

	public TestBase() {
		try {
			 prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//src//main//java//com//campusOil//qa//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	///Intialization...
	public static void intialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Desktop\\Test Base files\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			System.out.println(driver);
			EventFireCopy();
			
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dell\\Desktop\\Test Base files\\geckodriver-v0.24.0-win64\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
			EventFireCopy();
		}
		else if(browserName.equals(("Mobile"))){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Desktop\\Test Base files\\chromedriver_win32\\chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<String, String>();

			mobileEmulation.put("deviceName", "Nexus 5");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

			driver = new ChromeDriver(chromeOptions);
		   
			EventFireCopy();
		}
		
		
		
		ExcelData = new ExcelImporter();
		
		
		
	}
	
	
	
	//Declaration of Implicit and Pageload timeouts


	public void pageTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
	}
	
	public static void implicitTimeOut() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
	}

	public static void EventFireCopy() {
		//WebDriver Event Listener Invokes here
		e_driver = new EventFiringWebDriver(driver);
		System.out.println(e_driver);
		 //System.out.println("Intialization 5"+driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Timeouts pageloadTimeout = driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		Timeouts implicitTimeout = driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		}
	
}
