package com.suchi.demo_bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.suchi.PageObject.MgrHomePage;
import com.suchi.PageObject.SignInPage;
import com.suchi.UtilPage.WebUtil;

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
        driver.manage().timeouts().implicitlyWait(WebUtil.WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
	
	@Parameters({"userId","Password"})
	@Test
	public void BankLoginTest(String userId, String Password)
	{
		//Goto to the bank url
		SignInPage signInpage = WebUtil.gotoSigninPage(driver);
				
		//Enetr userId
		//String userId = WebUtil.USER_NAME;
		signInpage.FillUserId(driver,userId);
				
		//Enter Password
		//String Password = WebUtil.PASSWD;
		signInpage.FillPassword(driver,Password);
		
		//Click Login Button
		//MgrHomePage mgrhome = signInpage.clickLoginButton(driver,userId,Password);
		MgrHomePage mgrhome = signInpage.clickLoginButton(driver,userId,Password);				
		//Verify the bank home page
		
		mgrhome.verifyBankHomePage(driver);
				
		//Click Logout 
		mgrhome.clickLogOut(driver);
				
		//Accept the alert
		mgrhome.AcceptLogoutAlert(driver);
				
		//Verify successful logout
		signInpage.verifySuccessLogout(driver);
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
