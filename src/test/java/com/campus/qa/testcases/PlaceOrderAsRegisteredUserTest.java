package com.campus.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import com.campusOil.qa.base.TestBase;
import com.campusOil.qa.pages.HomePage;
import com.campusOil.qa.pages.LoginPage;
import com.campusOil.qa.pages.PlaceOrderAsRegisteredUser;
import com.qa.CampusOil.ReportListeners.AllureReportListener;
import com.qa.coloroutput.com.Colorme;
import com.qa.util.java.ExcelImporter;
import com.qa.util.java.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ AllureReportListener.class })
public class PlaceOrderAsRegisteredUserTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	static Colorme ConsoleHandler;
	ExcelImporter ExcelImport;
	static PlaceOrderAsRegisteredUser OrderPlacer;
	String sheetName2 = "quote";
	String sheetName3 = "Your Details";
	String sheetName4 = "BillingAddress";
	String sheetName5 = "cardDetails";

	public PlaceOrderAsRegisteredUserTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialization();
		OrderPlacer = new PlaceOrderAsRegisteredUser();
		// System.out.println(ConsoleHandler.BLUE_BOLD_BRIGHT+"****Placing Order As a
		// Registered and UnRegistered User Test Started****"+Colorme.RESET);
	}

	@DataProvider
	public Object[][] getquoteTestData() {
		Object data2[][] = TestUtil.getCampusOilTestData(sheetName2);
		return data2;
	}

	@DataProvider
	public Object[][] getYourDetailsData() {
		Object data3[][] = TestUtil.getCampusOilTestData(sheetName3);
		return data3;
	}

	@DataProvider
	public Object[][] getCardDetailsData() {
		Object data5[][] = TestUtil.getCampusOilTestData(sheetName5);
		return data5;
	}

	@DataProvider
	public Object[][] getBillingAddressDetailsData() {
		Object data4[][] = TestUtil.getCampusOilTestData(sheetName4);
		return data4;
	}

	@DataProvider
	public Object[][] getMergedData() {
		List<Object[]> result = Lists.newArrayList();
		result.addAll(Arrays.asList(getYourDetailsData()));
		// result.addAll(Arrays.asList(getBillingAddressDetailsData()));
		result.addAll(Arrays.asList(getCardDetailsData()));
		return result.toArray(new Object[result.size()][]);
	}

	@Test(priority = 1, dataProvider = "getYourDetailsData", description = "Verifying the unregistered user to place the order")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verify the Unregistered user to place the order")
	@Story("Use case : Place and order as an unrgistered user and get the check all the totals with products and totals in all the pages")
	public void ToPlaceOrderAsUnRegisteredUserTest(String Title, String Phone, String Landline) throws Exception {

		System.out.println(ConsoleHandler.GREEN_BOLD_BRIGHT + "*****Place Order As UnRegistered User is intialized****"
				+ ConsoleHandler.RESET);
		// Placing quote
		OrderPlacer.countyDropdown(); // method1
		OrderPlacer.SelectOilTypeDropdown();// m,
		OrderPlacer.SelectLitresDropdown();
		OrderPlacer.GetQuote();

		// verifying the title of the page redirected
		String title = driver.getTitle();
		assertEquals(title, "Order Area - Home Heating Oil");

		OrderPlacer.OrderPage();

		OrderPlacer.countyValidation();
		OrderPlacer.OiltypeValidation();
		OrderPlacer.QuantityValidation();
		OrderPlacer.OrderNow();

		// verifying the title of the page redirected
		String title1 = driver.getTitle();
		assertEquals(title1, "Low Cost Heating Oil From Campus");

		OrderPlacer.RegisterPage();

		String title2 = driver.getTitle();
		assertEquals(title2, "Checkout - Home Heating Oil");

		OrderPlacer.YourDetails(Title, Phone, Landline);
		Thread.sleep(5000);

		// Scroll the screen
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		OrderPlacer.BillingAndDeliveryDetails();
		OrderPlacer.DateInput();
		OrderPlacer.toDeliverDifferentAddress();
		OrderPlacer.passwordInput();
		OrderPlacer.OrderNotesInput();
		OrderPlacer.MarketingPermissions();
		OrderPlacer.toVerifyOrderSummary();
		OrderPlacer.Payment();
		OrderPlacer.OrderConfirmationPage();
		// OrderPlacer.OrderDateVerificationOnOrderConfPage();

	}

	@Test(priority = 2, dataProvider = "getYourDetailsData", description = "Verifying the registered user to place the order")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description : Verify the Registered user to place the order")
	@Story("Use case : Place and order as an Registered user and get the check all the totals with products and totals in all the pages")
	public static void ToPlaceAnOrderAsRegisteredUser(String Title, String Phone, String Landline)
			throws InterruptedException {
		// Placing quote
		System.out.println(ConsoleHandler.GREEN_BOLD_BRIGHT + "*****Place Order As Registered User is intialized****"
				+ ConsoleHandler.RESET);
		OrderPlacer.countyDropdown();
		OrderPlacer.SelectOilTypeDropdown();
		OrderPlacer.SelectLitresDropdown();
		OrderPlacer.GetQuote();

		// verifying the title of the page redirected
		String title = driver.getTitle();
		assertEquals(title, "Order Area - Home Heating Oil");

		OrderPlacer.OrderPage();

		OrderPlacer.countyValidation();
		OrderPlacer.OiltypeValidation();
		OrderPlacer.QuantityValidation();
		OrderPlacer.OrderNow();

		// verifying the title of the page redirected
		String title1 = driver.getTitle();
		assertEquals(title1, "Low Cost Heating Oil From Campus");

		OrderPlacer.RegisterPage();
		String title2 = driver.getTitle();
		assertEquals(title2, "Checkout - Home Heating Oil");
		OrderPlacer.AsRegisteredUser();
		// OrderPlacer.YourDetails(Title, Phone, Landline);
		Thread.sleep(5000);

		// Scroll the screen
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");

		OrderPlacer.BillingAndDeliveryDetails();
		OrderPlacer.toDeliverDifferentAddress();
		OrderPlacer.OrderNotesInput();
		OrderPlacer.MarketingPermissions();
		OrderPlacer.toVerifyOrderSummary();
		OrderPlacer.Payment();

		OrderPlacer.OrderConfirmationPage();
	}

	/*
	 * @Test(priority = 3, dataProvider = "getquoteTestData" ,description =
	 * "To verify the value changes in total amount and inputs of user")
	 * 
	 * @Severity (SeverityLevel.NORMAL)
	 * 
	 * @Description("Test Case Description : Verify the Order totals according the user inputs"
	 * )
	 * 
	 * @Story("Use case : Verify the Order totals by  changing the Order quantities and products "
	 * ) public void VeirfyQuoteValueChanges(String County, String OilType, String
	 * Quantity, String Price) throws Exception {
	 * System.out.println(ConsoleHandler.GREEN_BOLD_BRIGHT +
	 * "*****Validation test for the Value changes for quote****" +
	 * ConsoleHandler.RESET); // Placing quote OrderPlacer.countyDropdown();
	 * OrderPlacer.SelectOilTypeDropdown(); OrderPlacer.SelectLitresDropdown();
	 * OrderPlacer.GetQuote();
	 * 
	 * // verifying the title of the page redirected String title =
	 * driver.getTitle(); assertEquals(title, "Order Area - Home Heating Oil");
	 * 
	 * OrderPlacer.OrderPage(); OrderPlacer.toVerifyTheValuesAfterChange(County,
	 * OilType, Quantity, Price);
	 * 
	 * }
	 */

	@AfterMethod
	public void tearDown() {
		System.out.println(ConsoleHandler.GREEN_BOLD_BRIGHT + "*****Test Completed and quitting the browser****"
				+ ConsoleHandler.RESET);
		driver.quit();
	}

}
