package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_037POM;
import com.training.pom.UNF_038POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_038 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UNF_037POM unf_037POM;
	private UNF_038POM unf_038POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		unf_037POM = new UNF_037POM(driver);
		unf_038POM = new UNF_038POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	

	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(6000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		unf_038POM.sendUserName("admin");
		unf_038POM.sendPassword("admin@123");
		unf_038POM.clickLoginBtn(); 
		unf_038POM.clickCatelog();
		unf_038POM.clickCategories();
		unf_038POM.clickAddItem();
		unf_038POM.validCategoryName();
		unf_038POM.validCategoryDesc();
		unf_038POM.validMetaTagTitle();
		unf_038POM.validMetaTagDesc();
		
	
		//screenShot.captureScreenShot("First");
		
		
		unf_038POM.validSaveIcon();
		
		String Expected1 = "Success: You have modified categories!";
		String Actual1 = unf_038POM.validSuccessMsg();
		Assert.assertTrue(Actual1.contains(Expected1));
	}
}
