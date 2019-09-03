package com.campus.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.campusOil.qa.base.TestBase;
import com.campusOil.qa.pages.HomePage;
import com.campusOil.qa.pages.LoginPage;
import com.qa.CampusOil.ReportListeners.AllureReportListener;
import com.qa.coloroutput.com.Colorme;

@Listeners({AllureReportListener.class})
public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	Colorme ConsoleHandler;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeSuite
	public void startsuite() {
		ConsoleHandler.BeforeSuite();
	}
	
	@BeforeMethod 
	public void setUp(){
		try {
			 System.out.println("Intialization test"+driver);
			intialization();
			 System.out.println("Intialization test 2"+driver);
			System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****LoginPage Test Started****"+Colorme.RESET);
			loginpage = new LoginPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test(priority=1)
	public void VerifyloginPageTitleTest() {
		System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Verify the login page title Test****"+Colorme.RESET);
		String title = loginpage.validateloginpageTitle();
		Assert.assertEquals(title,"Order Heating Oil Online Buy Heating Oil Ireland");
	}
	
	@Test(priority=2)
	public void VerifycampusLogoTest() {
		System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Verify the campus logo Test****"+Colorme.RESET);
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void VerifyclickLoginnowTest() {
		System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Verify the login button Test****"+Colorme.RESET);
		loginpage.clickLoginnowButton();
	    prop.getProperty("pageloadTimeout");
	}
	
	@Test(priority=4)
	public void VerifyloginTest() {
		System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Verify the login into website Test****"+Colorme.RESET);
		loginpage.clickLoginnowButton();
	    prop.getProperty("pageloadTimeout");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		prop.getProperty("pageloadTimeout");
		loginpage.validateMyAccountTitle();
		loginpage.Logout();
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Quitting the browser****"+Colorme.RESET);
		driver.quit();
	}
}
