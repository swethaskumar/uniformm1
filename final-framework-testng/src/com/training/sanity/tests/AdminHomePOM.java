package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePOM {
	private WebDriver driver; 
	
	public AdminHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Change your password']")
	private WebElement ChangePass;
	
	public void clickForgottenPassword() {
		
		this.ChangePass.click();
	
	}

	@FindBy(id="input-password")
	private WebElement password1;
	
	public void sendPassword1(String password) {
		
		this.password1.clear();
		this.password1.sendKeys(password);
	}
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueBtn;
	
	public void clickContinueBtn() {
		this.continueBtn.click();
	}
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement verifyError;
	
	public String validErrorMsg() {
		
		return this.verifyError.getText();
	
	} 
	
}




