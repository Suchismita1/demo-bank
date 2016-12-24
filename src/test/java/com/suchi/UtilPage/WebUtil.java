package com.suchi.UtilPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

	public static final String FILE_PATH = "C:\\Users\\Suchi\\workspace\\demo-bank\\testData.xlsx";

	public static final String SHEET_NAME = "Data";

	//public static final String TABLE_NAME = null;


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

	public static String[][] getDataFromExcel(String filePath, String sheetName) throws Exception {
		
		String[][] dataArray=null;
		Workbook workbook = null;
		Sheet sheet;
		try{
			String fType=filePath.substring(filePath.indexOf("."));
		
		File xlFile = new File(filePath);
		FileInputStream Input = new FileInputStream(xlFile);
		if(fType.equalsIgnoreCase(".xls"))
		{
			workbook=new HSSFWorkbook(Input);
		}
		else if(fType.equalsIgnoreCase(".xlsx"))
		{
			workbook=new XSSFWorkbook(Input);
		}
	
		
		sheet=workbook.getSheet(sheetName);
	
		int rowcount=sheet.getPhysicalNumberOfRows();
		//int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		int columncount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(columncount);
		dataArray= new String[rowcount][columncount];
		
		int ci = 0;
		
		for(int i=1;i<rowcount;i++,ci++)
		{
			int cj = 0;
			for(int j=1;j<columncount;j++,cj++)
			{
				dataArray[ci][cj]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
		return dataArray;
	}
	
	

}
