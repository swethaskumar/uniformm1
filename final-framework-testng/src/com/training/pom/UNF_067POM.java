package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_067POM {

	
private WebDriver driver; 
	
	public UNF_067POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	/* enter credentials in Username textbox */
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
	
	
	/* 2. Click on Products link */
	@FindBy(xpath="//a[text()='Products']")
	private WebElement products; 
	
	public void clickProducts() {
		
		this.products.click(); 
		
	}
	
	
	/* 3. Enter valid credentials in Product Name textbox */
	@FindBy(id="input-name")
	private WebElement productName; 
	
	public void setProductnametest(String productname) {
		
		this.productName.clear();
		this.productName.sendKeys(productname); 
		
	}
	
	/*  4. Enter Valid credentials in Price textbox */
	@FindBy(id="input-price")
	private WebElement price; 
	
	public void setPricetest(String price) {
		
		this.price.clear();
		this.price.sendKeys(price); 
		
	}
	
	/*  5.  Select values from Status list box */
	@FindBy(id="input-status")
	private WebElement status; 
	
	public void setStatustest(String statustest) {
		
		//this.status.clear();
		Select select = new Select(this.status); 
		select.selectByVisibleText(statustest);
	}
	
	 

	
	/*  6. Enter Valid credentials in Model textbox */
	@FindBy(id="input-model")
	private WebElement model; 
	
	public void setModeltest(String model) {
		
		this.model.clear();
		this.model.sendKeys(model); 
		
	}
	
	/*  7. Enter Valid credentials in Quantity textbox */
	@FindBy(id="input-quantity")
	private WebElement quantity; 
	
	public void setQuantitytest(String quantity) {
		
		this.quantity.clear();
		this.quantity.sendKeys(quantity); 
		
	}

   /*  Click on Filter button */
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	public void clickFilter() {
		
		this.filter.click(); 
		
	}

}
