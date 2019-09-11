package com.campusOil.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
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

import com.qa.coloroutput.com.Colorme;
import com.qa.util.java.ExcelImporter;
import com.qa.util.java.TestUtil;

import com.qa.util.java.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	private String browserType;
	// public static String inputbrowser;
	public static ExcelImporter ExcelData;
	public static Colorme conhan;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "//src//main//java//com//campusOil//qa//config//config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/// Intialization...
	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\dell\\Desktop\\Test Base files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(driver);
			EventFireCopy();

		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\dell\\Desktop\\Test Base files\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			EventFireCopy();
		} else if (browserName.equals(("Mobile"))) {
			
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\dell\\Desktop\\Test Base files\\chromedriver_win32\\chromedriver.exe");
			Map<String, String> mobileEmulation = new HashMap<String, String>();

			/*
			 * case 1 : Device = "Nexus 5"; 
			 * case 2 : Device ="Galaxy S5"; 
			 * case 3 : Device = "Pixel 2"; 
			 * case 4 : Device = "Pixel 2 XL";
			 * case 5 : Device = "iPhone 5/SE"; 
			 * case 6 : Device = "iPhone 6/7/8"; 
			 * case 7 : Device = "iPhone 6/7/8 Plus"; 
			 * case 8 : Device = "iPhone X"; 
			 * case 9 : Device = "iPad"; 
			 * case 10: Device = "iPad Pro"; 
			 * case 11: Device = "Galaxy Note 3"; 
			 * case 12: Device = "Nexus 10"; 
			 * case 13 :Device = "JioPhone 2";
			 */

			mobileEmulation.put("deviceName", "iPhone X");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

			driver = new ChromeDriver(chromeOptions);

			EventFireCopy();
		}

		ExcelData = new ExcelImporter();

	}

	// Declaration of Implicit and Pageload timeouts

	public void pageTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void implicitTimeOut() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void EventFireCopy() {
		// WebDriver Event Listener Invokes here
		e_driver = new EventFiringWebDriver(driver);
		System.out.println(e_driver);
		// System.out.println("Intialization 5"+driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		Timeouts pageloadTimeout = driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,
				TimeUnit.SECONDS);
		Timeouts implicitTimeout = driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,
				TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	public static void MobileDevice() {
		
		String Device ;
		int inputDevice;
		Scanner UserInput = new Scanner(System.in);
		
		System.out.println(conhan.GREEN_BOLD_BRIGHT+"****Please Enter the Device option in the below list for Testing****\n1. Nexus 5\n2. Galaxy S5\n+"
				+ "3. Pixel 2\n4. Pixel 2 XL\n5.iPhone 5/SE\n6. iPhone 6/7/8\n7. iPhone 6/7/8 Plus\n8.iPhone X\n9. iPad"
				+ "\n10. iPad Pro\n11. Galaxy Note 3\n12. Nexus 10\n13. JioPhone 2"+conhan.RESET);
		inputDevice = UserInput.nextInt();
		
		switch(inputDevice) {
		 case 1 : Device = "Nexus 5"; 
		 case 2 : Device ="Galaxy S5"; 
		 case 3 : Device = "Pixel 2"; 
		 case 4 : Device = "Pixel 2 XL";
		 case 5 : Device = "iPhone 5/SE"; 
		 case 6 : Device = "iPhone 6/7/8"; 
		 case 7 : Device = "iPhone 6/7/8 Plus"; 
		 case 8 : Device = "iPhone X"; 
		 case 9 : Device = "iPad"; 
		 case 10: Device = "iPad Pro"; 
		 case 11: Device = "Galaxy Note 3"; 
		 case 12: Device = "Nexus 10"; 
		 case 13 :Device = "JioPhone 2";
		}
	}
}