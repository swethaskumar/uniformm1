package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_037POM {
	
private WebDriver driver; 
	
	public UNF_037POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	/* 1. enter credentials in Username textbox */
	@FindBy(id="input-username")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	/* 2. enter credentials in Password textbox */
	@FindBy(id="input-password")
	private WebElement password;
	
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
	}
	
	/* 3. click on Login button */
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement verifyErrMsg;
		
		public String validErrMsg() {
			
			return this.verifyErrMsg.getText();
		
		} 

}
