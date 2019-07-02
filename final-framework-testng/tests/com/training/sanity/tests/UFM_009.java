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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_009 {
  
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MainPagePOM mainPagePOM; 
	private ViewCartPOM viewCartPOM;
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
		mainPagePOM = new MainPagePOM(driver);
		viewCartPOM= new ViewCartPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(6000);
		driver.quit();
	}
	@Test
	public void validAddProducts() throws InterruptedException {
		viewCartPOM.clickShopUniforms();
		Thread.sleep(2000);
		viewCartPOM.clickTshirt();
		Thread.sleep(2000);
		viewCartPOM.selectDropDown1();
		Thread.sleep(2000);
		viewCartPOM.clickAddCart();
		Thread.sleep(2000);
		viewCartPOM.clickViewCart();
		Thread.sleep(2000);
		viewCartPOM.clickViewCart1();
		Thread.sleep(2000);
		viewCartPOM.clickRemove();
		//screenShot.captureScreenShot("First");
		
		String Expected = "Your shopping cart is empty!";
		String Actual = viewCartPOM.validMsg();
		Assert.assertTrue(Actual.contains(Expected));
		
	}
	
}
