package com.suchi.UtilPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.suchi.PageObject.SignInPage;

public class WebUtil {
	
	// Setting Base URL
	public static final String BASE_URL = "http://www.demo.guru99.com/";
	    
	// Time to wait when searching for a GUI element 
	public static final int WAIT_TIME = 30; 
												
	// Valid account for login
	public static final String USER_NAME = "mngr55876";
	public static final String PASSWD = "EbujYhE";
	
	// Expected output
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";


	public static SignInPage gotoSigninPage(WebDriver driver) {
		driver.get(BASE_URL + "/V4/");
		//driver.get("http://www.demo.guru99.com/V4/");
		return PageFactory.initElements(driver, SignInPage.class);
	}

	public static void clickElement(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();
		
	}

	public static void sendInput(WebDriver driver, By by, String value) {
		WebElement UserIdTextBox = driver.findElement(by);
		UserIdTextBox.sendKeys(value);
		
		
	}

}
