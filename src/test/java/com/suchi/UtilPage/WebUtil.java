package com.suchi.UtilPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.suchi.PageObject.SignInPage;

public class WebUtil {

	public static SignInPage gotoSigninPage(WebDriver driver) {
		driver.get("http://www.demo.guru99.com/V4/");
		return PageFactory.initElements(driver, SignInPage.class);
	}

}
