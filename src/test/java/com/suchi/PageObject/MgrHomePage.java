package com.suchi.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.suchi.UtilPage.WebUtil;

import junit.framework.Assert;

public class MgrHomePage {

	public void verifyBankHomePage(WebDriver driver) {
		// Verify Page Title
		String PageTitle = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Manager HomePage", PageTitle);
		
		//Verify Welcome message
		WebElement Welcomemsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee"));
		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", Welcomemsg.getText() );
		
		//Verify Manager id
		WebElement mngID = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr.heading3 > td"));
		Assert.assertEquals("Manger Id : mngr55876", mngID.getText());
		
	}

	public void clickLogOut(WebDriver driver) {
		WebUtil.clickElement(driver,By.linkText("Log out"));
		
	}

	public void AcceptLogoutAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}

}
