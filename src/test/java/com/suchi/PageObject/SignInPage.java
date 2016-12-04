package com.suchi.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.suchi.UtilPage.WebUtil;

import junit.framework.Assert;

public class SignInPage {

	public void FillUserId(WebDriver driver, String userId) {
		WebUtil.sendInput(driver,By.name("uid"),userId);
		
	}

	public void FillPassword(WebDriver driver, String password) {
		WebUtil.sendInput(driver, By.name("password"), password);
				
	}

	public MgrHomePage clickLoginButton(WebDriver driver) {
		WebUtil.clickElement(driver, By.name("btnLogin"));
		return PageFactory.initElements(driver, MgrHomePage.class);
	}

	public void verifySuccessLogout(WebDriver driver) {
		WebElement HomePageTitle = driver.findElement(By.cssSelector("body > div:nth-child(1) > h2"));
		Assert.assertEquals("Guru99 Bank", HomePageTitle.getText());
		
	}

}
