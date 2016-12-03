package com.suchi.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SignInPage {

	public void FillUserId(WebDriver driver, String userId) {
		WebElement UserIdTextBox = driver.findElement(By.name("uid"));
		UserIdTextBox.sendKeys(userId);
		
	}

	public void FillPassword(WebDriver driver, String password) {
		WebElement PasswordTextBox = driver.findElement(By.name("password"));
		PasswordTextBox.sendKeys(password);
		
	}

	public MgrHomePage clickLoginButton(WebDriver driver) {
		WebElement LoginButton = driver.findElement(By.name("btnLogin"));
		LoginButton.click();
		return PageFactory.initElements(driver, MgrHomePage.class);
	}

	public void verifySuccessLogout(WebDriver driver) {
		WebElement HomePageTitle = driver.findElement(By.cssSelector("body > div:nth-child(1) > h2"));
		Assert.assertEquals("Guru99 Bank", HomePageTitle.getText());
		
	}

}
