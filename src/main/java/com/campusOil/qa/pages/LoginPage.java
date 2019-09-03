package com.campusOil.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.campusOil.qa.base.TestBase;

public class LoginPage extends TestBase  {

	//Page Factory = Object Repository
	
			@FindBy(xpath = "//div[@class='main-menu desktop']//a[contains(text(),'Login')]")
			WebElement Loginlink;
			
			@FindBy(xpath = "//input[@id='username']")
			WebElement username;
			
			@FindBy(xpath = "//input[@id='password']")
			WebElement password;
			
			@FindBy(xpath = "//button[@name='login']")
			WebElement loginbutton;
			
			@FindBy(xpath = "//div[@class='logo']//a//img")
			WebElement campusOilLogo;
			
			@FindBy(xpath = "//div[contains(@class,'page-header-background')]//p[contains(@class,'pseudo-h1')][contains(text(),'MY ACCOUNT')]")
			WebElement pageVerifyMyAccount;
			
			@FindBy(xpath="//a[contains(text(),'Log out')]")
			WebElement Logoutlink;
	
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions - to -do
	public String validateloginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return campusOilLogo.isDisplayed();
	}
	
	public void clickLoginnowButton() {
		Loginlink.click();
		return;
	}
	
	public boolean validateMyAccountTitle() {
		return pageVerifyMyAccount.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	
	public void Logout() {
		 Logoutlink.click();
	}
}
