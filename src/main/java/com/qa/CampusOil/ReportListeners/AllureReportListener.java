package com.qa.CampusOil.ReportListeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.campusOil.qa.base.TestBase;
import com.qa.coloroutput.com.Colorme;

import io.qameta.allure.Attachment;

public class AllureReportListener implements ITestListener  {
	public static Colorme conhan;
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println(conhan.GREEN_UNDERLINED+"I am in onStart method " + iTestContext.getName()+conhan.RESET);
		iTestContext.setAttribute("WebDriver", TestBase.driver);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println(conhan.YELLOW_UNDERLINED+"I am in onFinish method " + iTestContext.getName()+conhan.RESET);
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println(conhan.BLACK_BOLD_BRIGHT+"I am in onTestStart method " + getTestMethodName(iTestResult) + " start"+conhan.RESET);
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(conhan.GREEN_BACKGROUND_BRIGHT+"I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed"+conhan.RESET);
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println(conhan.RED_UNDERLINED+"I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed"+conhan.RESET);
		Object testClass = iTestResult.getInstance();
		WebDriver driver = TestBase.driver;
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println(conhan.RED_BOLD_BRIGHT+"Screenshot captured for test case:" + getTestMethodName(iTestResult)+ conhan.RESET);
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");		
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println(conhan.YELLOW_BRIGHT+"I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped"+conhan.RESET);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println(conhan.RED_BOLD+"Test failed but it is in defined success ratio " + getTestMethodName(iTestResult)+conhan.RESET);
	}

}
