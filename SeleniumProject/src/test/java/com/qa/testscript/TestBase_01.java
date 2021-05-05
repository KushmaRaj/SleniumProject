package com.qa.testscript;

//import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class  TestBase_01 {
@Test
public class TestBase 
{
	WebDriver driver;
	EndToEndFlow login;
	EndToFlowPage Ct;
	public EndToEndFlow EndToFlowPage;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser,String Url) throws InterruptedException
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\data\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().window().maximize();
		}
		if(Browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "E:\\data\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get("https://meesho.com/");
			
			}
		//EndToFlowPage=new EndToEndFlow();
		//workingwithJspopup hiddenPopup = new workingwithJspopup();
		//driver.get(Url);
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
}

