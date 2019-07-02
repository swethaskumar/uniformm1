package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_007 {
  
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminHomePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		adminHomePOM = new AdminHomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}


	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(6000);
		driver.quit();
	}
	
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {
		loginPOM.clickDropDwon();
		Thread.sleep(2000);
		loginPOM.clickLogin();
		Thread.sleep(2000);
		loginPOM.sendUserName("neha@gmail.com");
		Thread.sleep(2000);
		loginPOM.sendPassword("Neha123");
		Thread.sleep(2000);
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}
	
	@Test(priority=1)
	public void validChangePassword() throws InterruptedException {
		adminHomePOM.clickForgottenPassword();
		Thread.sleep(2000);
		adminHomePOM.sendPassword1("sneha");
		Thread.sleep(2000);
		adminHomePOM.confirmPassword("mneha");
		Thread.sleep(2000);
		adminHomePOM.clickContinueBtn(); 
		//screenShot.captureScreenShot("First");
	}
	
}
