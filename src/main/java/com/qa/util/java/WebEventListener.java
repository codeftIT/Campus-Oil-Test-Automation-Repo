package com.qa.util.java;

/*************************************** PURPOSE **********************************
- This class implements the WebDriverEventListener, which is included under events.
The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
which would be displayed/logged as the application under test is being run.
Do not call any of these methods, instead these methods will be invoked automatically
as an when the action done (click, findBy etc). 
*/

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.campusOil.qa.base.TestBase;
import com.qa.coloroutput.com.Colorme;


public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	Colorme conhan;
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Before navigating to: '" + url + "'"+conhan.RESET);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Navigated to:'" + url + "'"+conhan.RESET);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Value of the:" + element.toString() + " before any changes made"+conhan.RESET);
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Element value changed to: " + element.toString()+conhan.RESET);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Trying to click on: " + element.toString()+conhan.RESET);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Clicked on: " + element.toString()+conhan.RESET);
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Navigating back to previous page"+conhan.RESET);
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Navigated back to previous page"+conhan.RESET);
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Navigating forward to next page"+conhan.RESET);
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Navigated forward to next page"+conhan.RESET);
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println(conhan.RED_BOLD_BRIGHT+"Exception occured: " + error+conhan.RESET);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			System.out.println(conhan.RED_BOLD_BRIGHT+"Took Screenshot of error  "+conhan.RESET);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Trying to find Element By : " + by.toString()+conhan.RESET);
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(conhan.PURPLE_BOLD_BRIGHT+"Found Element By : " + by.toString()+conhan.RESET);
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
