package ParameterByDataProvider;

/* ----testing.xml----------
 * <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="ParameterByDataProvider.ParameterbyDataprovider"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ParameterbyDataprovider {
	WebDriver driver;
	String baseurl="https://google.co.in";
	
	@BeforeTest
	public void befortest()
	{
		System.setProperty("webdriver.chrome.driver","E:\\SFT_YK\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException
    {
        WebElement searchText = driver.findElement(By.name("q"));
        //search value in google searchbox
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }
    
    /**
     * @return Object[][] where first column contains 'author'
     * and second column contains 'searchKey'
     */

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };

    }
}
