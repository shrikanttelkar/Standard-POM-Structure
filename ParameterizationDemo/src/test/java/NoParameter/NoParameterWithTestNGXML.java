package NoParameter;

/* -------testng.xml--------
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="NoParameter.NoParameterWithTestNGXML"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NoParameterWithTestNGXML {
	WebDriver driver;
	String baseurl="https://google.co.in";
	
	@BeforeTest
	public void befortest()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SFT_YK\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
  @Test
  public void testNoParameter() throws InterruptedException{
	  String author="guru99";
	  String searchkey="India";
	  
	  WebElement searchtext=driver.findElement(By.name("q"));
	  searchtext.sendKeys(searchkey);
	  
	  System.out.println("welcome   "+author+"searchkey is  "+searchkey);
	  Thread.sleep(3000);
      System.out.println("Value in Google Search Box = "+searchtext.getAttribute("value") +" ::: Value given by input = "+searchkey);
      //verifying the value in google search box
      AssertJUnit.assertTrue(searchtext.getAttribute("value").equalsIgnoreCase(searchkey));
      
      driver.close();
  }
}
