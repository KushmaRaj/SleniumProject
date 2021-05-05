package com.qa.testscript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class EndToEndFlow extends TestBase_01  {


@Test(dataProvider="getData1")


	public  void FlipKart(String PhNo,String Password,String Product) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "E:\\data\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.get("https://www.flipkart.com/");
	Thread.sleep(8000);
	EndToFlowPage Fp=new EndToFlowPage(driver);
	Fp.getPhNo().sendKeys(PhNo);
	Thread.sleep(3000);
	Fp.getPassword().sendKeys(Password);
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
	Reporter.log("login to the page successfully", true);
	Thread.sleep(3000);
	Fp.getSearchForProduct().sendKeys(Product);
	Thread.sleep(5000);
	Fp.getSearchForProduct().submit();
	Thread.sleep(5000);
	driver.getTitle().contains("oppoF17pro");
	Reporter.log("product is serached successfully", true);
	Thread.sleep(5000);
	Fp.getClickOnTheProduct().click();
	//Fp.getClickOnAddToCart().click();
	//Fp.getClickOnAddToCart().submit();
	Thread.sleep(3000);
	//Reporter.log("product is added to cart successfully",true);
	String parent=driver.getWindowHandle();
    Set<String>s=driver.getWindowHandles();
    Iterator<String> I1= s.iterator();
    while(I1.hasNext())
    {

    String child_window=I1.next();


    if(!parent.equals(child_window))
    {
    driver.switchTo().window(child_window);
	Fp.getBuyNowBtn().click();
    }
    }
    Thread.sleep(3000);
    String title1 = driver.getTitle();
	Assert.assertEquals(title1, "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
	Reporter.log("order placed successfully",true);
    driver.navigate().back();
    String xp="//div[contains(text(),'My Account')]";
    WebElement MyAccount=driver.findElement(By.xpath(xp));
    Actions action=new Actions(driver);
    Thread.sleep(3000);
    action.moveToElement(MyAccount).perform();
    Fp.getLogout().click();
    Thread.sleep(3000);
     boolean title2=driver.getTitle().contains("Online Shopping Site for Mobiles");
	  Assert.assertTrue(title2);
	   Reporter.log("logged out",true);
 	}


@DataProvider
public String[][] getData1() throws IOException{
	 
	 String xlPath = "C:\\Users\\kushmaraj\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\com\\qa\\testData\\meesho.xlsx";
	 String xlSheet = "Sheet1";
	 
	 int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
	 int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
	 
	 String[][] data = new String[rowCount][cellCount];
	 
	 for(int i=1; i<=rowCount; i++) {
		 for(int j=0; j<cellCount;j++) {
			 data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);
		 }
	 }
	return data;
 }

}
