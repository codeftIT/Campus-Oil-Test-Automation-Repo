package com.campusOil.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.campusOil.qa.base.TestBase;

public class AboutUsPage extends TestBase{
	
	@FindBy(xpath="//div[@id='billing_autoaddresswrap']//input[@placeholder='"
			+ "Enter first line of address or Eircode & press search']")
	static WebElement SearchElementText;
	
	public void just() {
	System.out.println("About Us");
	
	
	}
}
