package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.pages.HomePage;
import com.ohrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();   //to call base class TestBase constructor
	}
	
	@BeforeSuite
	public void setUp(){
	    initialization(); //before this super() is called
	    loginpage=new LoginPage();
		}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage=loginpage.login("admin","admin123");
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
