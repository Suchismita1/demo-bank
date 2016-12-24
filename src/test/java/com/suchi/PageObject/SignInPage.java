package com.suchi.PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.suchi.UtilPage.WebUtil;

import junit.framework.Assert;

public class SignInPage {
	
	String actualTitle;
	String actualBoxtitle;

	public void FillUserId(WebDriver driver, String userId) {
		WebUtil.sendInput(driver,By.name("uid"),userId);
		
	}

	public void FillPassword(WebDriver driver, String password) {
		WebUtil.sendInput(driver, By.name("password"), password);
				
	}

	@SuppressWarnings("finally")
	public MgrHomePage clickLoginButton(WebDriver driver,String userId, String Password) {
		WebUtil.clickElement(driver, By.name("btnLogin"));
		try{ 
		    
	       	Alert alt = driver.switchTo().alert();
			actualBoxtitle = alt.getText(); // get content of the Alter Message
			//WebUtil.getScreenShot(driver);
			//Thread.sleep(5000);
			alt.accept();
			if (actualBoxtitle.contains(WebUtil.EXPECT_ERROR)) { // Compare Error Text with Expected Error Value
			    System.out.println(" Failed"); 
			    //driver.close();
			  // return  PageFactory.initElements(driver, MgrHomePage.class);	
			} else {
			    System.out.println("Test case Failed");
			}
		}    
	    catch (NoAlertPresentException Ex){ 
	    	actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
			if (actualTitle.contains(WebUtil.EXPECT_TITLE)) {
			    System.out.println("Test case  Passed");
			    
			} else {
			    System.out.println("Test caseFailed");
			}
						
	    }
		finally{
		return PageFactory.initElements(driver, MgrHomePage.class);	
		}
	}

	public void verifySuccessLogout(WebDriver driver) {
		WebElement HomePageTitle = driver.findElement(By.cssSelector("body > div:nth-child(1) > h2"));
		Assert.assertEquals("Guru99 Bank", HomePageTitle.getText());
		
	}

	public void accpetErrorAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}

}
