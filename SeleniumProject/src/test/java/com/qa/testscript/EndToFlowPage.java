package com.qa.testscript;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndToFlowPage {
	WebDriver driver;
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement PhNo;
	public WebElement getPhNo() {
		
		return PhNo;
	}
	@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
	WebElement Password;
    public WebElement getPassword()
    {
		return Password;
    }
    @FindBy(tagName="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")
    WebElement LoginButton;
	public WebElement getClickOnLoginbutton()
	{
		return LoginButton;	
	}
	
	@FindBy(xpath="/html/body/div/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement Product;
	public WebElement getSearchForProduct() {
		
		return Product;
	}
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement ClickOnTheProduct;
	public WebElement getClickOnTheProduct() {
		// TODO Auto-generated method stub
		return ClickOnTheProduct;
	}
	
	@FindBy(xpath="//div[contains(text(),'Logout')]")
	WebElement Logout;
	public WebElement getLogout() {
		
		return Logout;
	}
	@FindBy(xpath="//button[@type='button']")
	WebElement BuyNowBtn;
	public WebElement getBuyNowBtn() {
		
		return BuyNowBtn;
	}

	public EndToFlowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
