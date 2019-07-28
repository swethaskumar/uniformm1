package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.UNF_085POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_085 {
  
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UNF_085POM UNF_085POM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		UNF_085POM = new UNF_085POM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 0)
	public void login() throws InterruptedException {
		
		UNF_085POM.sendUserName("admin");
		UNF_085POM.sendPassword("admin@123");
		UNF_085POM.clickLoginBtn();
		UNF_085POM.clickSales();
		UNF_085POM.clickOrders();
		//Thread.sleep(2000);
	}
	
	
	@Test(priority = 1 ,dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String orderId, String statustest, String dateAdd, String customer,String total1 ,String dateModify) throws InterruptedException {
		
		
		UNF_085POM.setOrderId(orderId);
		//Thread.sleep(2000);
		UNF_085POM.setStatustest(statustest);
		//Thread.sleep(2000);
		UNF_085POM.setDateAdded(dateAdd);
		//Thread.sleep(2000);
		UNF_085POM.setCustomer(customer);
		//Thread.sleep(2000);
		UNF_085POM.setTotal(total1);
		//Thread.sleep(2000);
		UNF_085POM.setDateModified(dateModify);
		//Thread.sleep(2000);
		UNF_085POM.clickFilter();
		//Thread.sleep(3000);
}
}
