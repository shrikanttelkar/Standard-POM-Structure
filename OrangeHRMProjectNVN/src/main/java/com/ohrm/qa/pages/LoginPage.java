package com.ohrm.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page factory or Object Repository :
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='divLogo']")
	WebElement logo;
	
	@FindBy(xpath="//span[@id='spanMessage']")
	WebElement usernameerrormessage;
	
	//Initialize Page Object :
	public LoginPage(){
		PageFactory.initElements(driver, this);   // OR
		//PageFactory.initElements(driver, LoginPage.class); 
	}
	
	//Actions :
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public String verifyUsernameErrormessage(){
		return usernameerrormessage.getTagName();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();      //after click it redirect to HomePage so we write return HomePage
		
		return new HomePage();
	}
}

