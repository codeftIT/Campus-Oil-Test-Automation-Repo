package com.campus.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
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
public class HomePageTest extends TestBase{

	LoginPageTest loginpage;
	HomePage homepage;
	Colorme Consolehandler;
	
	public HomePageTest() {
		super();
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****HomePage Test Started****"+Colorme.RESET);
	}
	
	@BeforeMethod 
	public void setUp() throws Exception {
		intialization();
		//System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****HomePage Test Started****"+Colorme.RESET);
		homepage = new HomePage();	
	}
	
	@Test(priority=1)
	public void verifyLogoTest() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Verifying the Campus Logo Test****"+Colorme.RESET);
		homepage.verifyCampusOilLogo();
	}
	
	@Test(priority=2)
	public void verifyHomepageLinks() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Verifying the Home Page Links Test****"+Colorme.RESET);
		homepage.VerifyLinksOnHomepage();
	}
	
	@Test(priority=3)
	public void verifyPageHeaderBannerLinks() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Verifying the Page Header Banner Links Test****"+Colorme.RESET);
		homepage.verifyLinkOnPageBannerHeader();
	}
	
	@Test(priority=4)
	public void verifyPageFooterLogoTest() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Verifying the Campus footer Logo Test****"+Colorme.RESET);
		homepage.verifyCampusFooterLogo();
	}
	
	@Test(priority=5)
	public void verifyTitle() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Verifying the tile of campus oil Test****"+Colorme.RESET);
		String HomepageTitle = driver.getTitle();
		Assert.assertEquals(HomepageTitle, "Order Heating Oil Online Buy Heating Oil Ireland");
	}
	
	@Test(priority=6)
	public void verifyAboutUSLinkTest() throws InterruptedException {
		homepage.verifyAboutUsLink();
	}
	
	@Test(priority=7)
	public void verifyNewsLinkTest() throws InterruptedException {	
		homepage.verifyNewsLink();
	}
	
	@Test(priority=8)
	public void verifyOrderFormpageLinkTest() throws InterruptedException {
		homepage.VerifyOrderNowLink();
	}
	@AfterMethod
	public void tearDown() {
		System.out.println(Colorme.BLUE_BOLD_BRIGHT+"****Quitting the browser****"+Colorme.RESET);
		driver.quit();
	}
	@AfterSuite
	public void endSuite() {
		Colorme.AfterSuite();
	}
}
