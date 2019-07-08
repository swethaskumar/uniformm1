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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_037 {
 
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UNF_037POM unf_037POM;
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
	public void validLoginTest()  {
		unf_037POM.sendUserName("Nha");
		unf_037POM.sendPassword("neha2345");
		unf_037POM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
		
		String Expected = "No match for Username and/or Password.";
		String Actual = unf_037POM.validErrMsg();
		Assert.assertTrue(Actual.contains(Expected));
	}
}
