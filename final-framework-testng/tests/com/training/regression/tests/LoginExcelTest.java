	package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UNF_067POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private UNF_067POM UNF_067POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		UNF_067POM = new UNF_067POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 0)
	public void login() throws InterruptedException {
		
		UNF_067POM.sendUserName("admin");
		UNF_067POM.sendPassword("admin@123");
		UNF_067POM.clickLoginBtn();
		UNF_067POM.clickCatelog();
		UNF_067POM.clickProducts();
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 1 ,dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String productName, String price, String status,String model,String quantity) throws InterruptedException {
		
		
		UNF_067POM.setProductnametest(productName);
		Thread.sleep(2000);
		UNF_067POM.setPricetest(price);
		Thread.sleep(2000);
		UNF_067POM.setStatustest(status);
		Thread.sleep(2000);
		UNF_067POM.setModeltest(model);
		Thread.sleep(2000);
		UNF_067POM.setQuantitytest(quantity);
		Thread.sleep(2000);
		UNF_067POM.clickFilter();
		
		//screenShot.captureScreenShot(userName);

	}

}