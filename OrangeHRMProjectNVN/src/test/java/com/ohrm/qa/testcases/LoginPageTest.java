package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
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
	
	@Test(priority=2)
	public void validateLogoTest(){
		boolean b=loginpage.validateLogo();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3,dataProvider="getData")
	public void loginTest(String un,String pwd,String errmsg) throws InterruptedException{
		homePage=loginpage.login(un,pwd);
		
		assert driver.getPageSource().contains(errmsg);
		}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] credentials={{"Admin","","Password cannot be empty"},
				{"","admin123","Username cannot be empty"},
		{"invalidUN","InvalidPwd","Invalid credentials"},
		{"","","Username cannot be empty"},
		{"Admin","admin123",""}    //need to verify homepage entry
	};
		return credentials;
	}
	
	/*@Test(priority=3)
	public void loginTest(){
		homePage=loginpage.login("Admin","admin123");
	}*/
	
	/*@Test(priority=4)
	public void verifyUsernameErrormessageTest(){
		String s=loginpage.verifyUsernameErrormessage();
		//Assert.assertEquals(s, "Username cannot be empty");
		Assert.assertEquals(s, "Username cannot be empty", "Username is not correct");
	}*/
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
