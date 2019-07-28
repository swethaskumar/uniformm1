package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_085POM {

	private WebDriver driver;

	public UNF_085POM(WebDriver driver) {
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
	
	

	/* 1. Click on Sales icon */
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fa-fw']")
	private WebElement sales; 
	
	public void clickSales() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(sales).click().build().perform();
		
	}
	
	/* 2. click on Orders link */
	@FindBy(xpath="//a[text()='Orders']")
	private WebElement orders; 
	
	public void clickOrders() {
		
		this.orders.click(); 
		
	}
	
	/* 3.  Enter valid credentials in Order ID textbox */
	@FindBy(id="input-order-id")
	private WebElement orderId; 
	
	public void setOrderId(String Id) {
		
		this.orderId.clear();
		this.orderId.sendKeys(Id);
		
	}
	
	/* 4.  Select Valid credentials in Order Status textbox */
	@FindBy(id="input-order-status")
	private WebElement status; 
	
	public void setStatustest(String statustest) {
		
		
		Select select = new Select(this.status); 
		select.selectByVisibleText(statustest);
	}
	
	/*   Click on Date icon of Date Added list box */
	@FindBy(id="input-date-added")
	private WebElement dateAdd; 
	
	public void setDateAdded(String dateAdd) {
		
		this.dateAdd.clear();
		this.dateAdd.sendKeys(dateAdd);
		
	}

	
	
	/*  Enter Valid credentials in Customer textbox */
	@FindBy(id="input-customer")
	private WebElement cust; 
	
	public void setCustomer(String customer) {
		
		this.cust.clear();
		this.cust.sendKeys(customer);
		
	}
	
	/*  Enter Valid credentials in Total textbox */
	@FindBy(id="input-total")
	private WebElement total; 
	
	public void setTotal(String total1) {
		
		this.total.clear();
		this.total.sendKeys(total1);
		
	}
	
	
	/* Click on Calendar icon in the Date Modified list box  */
	@FindBy(id="input-date-modified")
	private WebElement dateModified; 
	
	public void setDateModified(String dateModify) {
		
		this.dateModified.clear();
		this.dateModified .sendKeys(dateModify);
		
		
	}
	
	
	
	/* Click on Filter button */
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	public void clickFilter() {
		
		this.filter.click(); 
		
	}
	
}
