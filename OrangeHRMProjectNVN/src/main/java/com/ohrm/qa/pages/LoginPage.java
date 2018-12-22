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
	
	//Initialize Page Object :
	public LoginPage(){
		PageFactory.initElements(driver, this); 
	}
	
	//Actions :
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();      //after click it redirect to HomePage so we write return HomePage
		
		return new HomePage();
	}
}

