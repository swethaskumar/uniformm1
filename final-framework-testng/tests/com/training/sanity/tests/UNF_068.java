package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.UNF_068POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_068 {
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private UNF_068POM UNF_068POM;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		UNF_068POM = new UNF_068POM(driver);
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
		
		UNF_068POM.sendUserName("admin");
		UNF_068POM.sendPassword("admin@123");
		UNF_068POM.clickLoginBtn();
		UNF_068POM.clickCatelog();
		UNF_068POM.clickProducts();
		UNF_068POM.clickAddItem();
		
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 1 ,dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String productName, String metaTag1, String modelName,String price,String quantity) throws InterruptedException {
		
		UNF_068POM.setProductName(productName);
	
		UNF_068POM.setMetaTag(metaTag1);

		UNF_068POM.clickDataTab();
		
		UNF_068POM.setModelName(modelName);
	
		UNF_068POM.setPrice(price);

		UNF_068POM.setQuantity(quantity);

		UNF_068POM.clickLink();
		UNF_068POM.clickCategory();
	
		UNF_068POM.clickSave();
		UNF_068POM.clickCatelog();
		UNF_068POM.clickProducts();
		UNF_068POM.clickAddItem();
		//screenShot.captureScreenShot(userName);

	}
}
