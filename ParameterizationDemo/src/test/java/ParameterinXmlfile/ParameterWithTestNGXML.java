package ParameterinXmlfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParameterWithTestNGXML {
	
	WebDriver driver;
	String baseurl="https://google.co.in";
	
	@BeforeMethod
	  public void beforeMethod() {
		System.setProperty("webdriver.driver.chrome","E:\\SFT_YK\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseurl);
	  }
	
  @Test
  @Parameters({"author","searchKey"})
  public void testParameterWithXML(@Optional("abc")String author,String searchKey)throws InterruptedException {
	  
	  WebElement searchText = driver.findElement(By.name("q"));
      //Searching text in google text box
      searchText.sendKeys(searchKey);

      System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
      System.out.println("Thread will sleep now");
      Thread.sleep(3000);
      System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
      //verifying the value in google search box
      AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
