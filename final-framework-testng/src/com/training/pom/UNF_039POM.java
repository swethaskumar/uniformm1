package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UNF_039POM  {

private WebDriver driver; 
	
	public UNF_039POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	/*  enter credentials in Username textbox */
	@FindBy(id="input-username")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	/*  enter credentials in Password textbox */
	@FindBy(id="input-password")
	private WebElement password;
	
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
	}
	
		/*  click on Login button */
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	/* 1. Click on Catelog icon */
	@FindBy(xpath="//i[@class='fa fa-tags fa-fw']")
	private WebElement catelog; 
	
	public void clickCatelog() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(catelog).click().build().perform();
		
	}
	
	/* 2. Click on Categories link */
	@FindBy(xpath="//a[text()='Categories']")
	private WebElement categories; 
	
	public void clickCategories() {
		
		this.categories.click(); 
		
	}
	
	/* 3. Click on Edit icon of the category to modify */
	@FindBy(xpath="//a[@data-original-title='Edit']")
	private WebElement editItem; 
	
	public void clickEditItem() {
		
		this.editItem.click(); 
		
	}
		
	/* 4. Clear the values present in Meta tag Title textbox
	   5. Enter Valid credentials in Meta tag Title textbox of General tab */
	@FindBy(id="input-meta-title1")
	private WebElement validTagTitle; 
	
	public void validMetaTagTitle() {
		this.validTagTitle.clear();
		this.validTagTitle.sendKeys("BLZ 05");
		
	}
	
	/* 6. Enter Valid credentials in Meta tag Description textbox of General tab */
	@FindBy(id="input-meta-description1")
	private WebElement metaTagDesc; 
	
	public void validMetaTagDesc() {
		this.metaTagDesc.clear();
		this.metaTagDesc.sendKeys("Uniform for students");
		
	}
	
	/* 8. Click on Save icon */
	@FindBy(xpath="//button[@data-original-title='Save']")
	private WebElement saveIcon; 
	
	public void validSaveIcon() {
		
		this.saveIcon.click();
		
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMsg; 
	
	public String validSuccessMsg() {
		
	return 	this.successMsg.getText();
		
	}
}
