package com.suchi.UtilPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.suchi.PageObject.SignInPage;

public class WebUtil {

	public static SignInPage gotoSigninPage(WebDriver driver) {
		driver.get("http://www.demo.guru99.com/V4/");
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
