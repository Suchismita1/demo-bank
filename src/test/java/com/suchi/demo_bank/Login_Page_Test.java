package com.suchi.demo_bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.Assert;

public class Login_Page_Test {
	
	public WebDriver driver;
	@BeforeClass
	public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }
	@BeforeTest
	 public void setupTest() {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
	@Test
	public void BankLoginTest()
	{
		//Goto to the bank url
		driver.get("http://www.demo.guru99.com/V4/");
		
		//Enetr userId
		WebElement UserIdTextBox = driver.findElement(By.name("uid"));
		UserIdTextBox.sendKeys("mngr55876");
		
		//Enter Password
		WebElement PasswordTextBox = driver.findElement(By.name("password"));
		PasswordTextBox.sendKeys("EbujYhE");
		
		//Click Login Button
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();
		
		//Verify the bank home page
		String PageTitle = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Manager HomePage", PageTitle);
		WebElement Welcomemsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee"));
		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", Welcomemsg.getText() );
		
		//Verify Manager id
		WebElement mngID = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr.heading3 > td"));
		Assert.assertEquals("Manger Id : mngr55876", mngID.getText());
		
		//Click Logout 
		WebElement LogOutLink = driver.findElement(By.linkText("Log out"));
		LogOutLink.click();
		
		//Accept the alert
		driver.switchTo().alert().accept();
		
		//Verify successful logout
		WebElement HomePageTitle = driver.findElement(By.cssSelector("body > div:nth-child(1) > h2"));
		Assert.assertEquals("Guru99 Bank", HomePageTitle.getText());
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
