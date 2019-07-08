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
import com.training.pom.UNF_039POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_039 {
  
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	//private UNF_037POM unf_037POM;
	//private UNF_038POM unf_038POM;
	private UNF_039POM unf_039POM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver); 
		//unf_037POM = new UNF_037POM(driver);
		//unf_038POM = new UNF_038POM(driver);
		unf_039POM = new UNF_039POM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	

	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(6000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		unf_039POM.sendUserName("admin");
		unf_039POM.sendPassword("admin@123");
		unf_039POM.clickLoginBtn(); 
		unf_039POM.clickCatelog();
		unf_039POM.clickCategories();
		unf_039POM.clickEditItem();
		unf_039POM.validMetaTagTitle();
		unf_039POM.validMetaTagDesc();
		//screenShot.captureScreenShot("First");
		
	
		unf_039POM.validSaveIcon();
		
		String Expected1 = "Success: You have modified categories!";
		String Actual1 = unf_039POM.validSuccessMsg();
		Assert.assertTrue(Actual1.contains(Expected1));
		 
	}
}
