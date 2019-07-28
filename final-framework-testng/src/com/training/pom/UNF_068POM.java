package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UNF_068POM {

	private WebDriver driver;

	public UNF_068POM(WebDriver driver) {
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
	

	/*  Click on Add New icon */
	@FindBy(xpath="//a[@data-original-title ='Add New']")
	private WebElement addItem; 
	
	public void clickAddItem() {
		
		this.addItem.click(); 
		
	}
	
	/*   Enter Valid credentials in Product Name of General tab */
	@FindBy(id="input-name1")
	private WebElement prodName; 
	
	public void setProductName(String productName) {
		
		this.prodName.clear();
		this.prodName.sendKeys(productName);
		
	}
	
	/*    Enter Valid credentials in Meta Tag Title of General tab */
	@FindBy(id="input-meta-title1")
	private WebElement metaTag; 
	
	public void setMetaTag(String metaTag1) {
		
		this.metaTag.clear();
		this.metaTag.sendKeys(metaTag1);
		
	}

	/*    Click on Data tab */
	@FindBy(xpath="//a[text() ='Data']")
	private WebElement dataTab; 
	
	public void clickDataTab() {
		
		
		this.dataTab.click();
		
	}
	
	/*     Enter valid credentials in Model textbox */
	@FindBy(id="input-model")
	private WebElement model; 
	
	public void setModelName(String modelName) {
		

		this.model.clear();
		this.model.sendKeys(modelName);
		
	}
	
	/*     Enter valid credentials in Price textbox */
	@FindBy(id="input-price")
	private WebElement price1; 
	
	public void setPrice(String price) {
		

		this.price1.clear();
		this.price1.sendKeys(price);
		
	}
	
	/*  Enter valid credentials in Quantity textbox */
	@FindBy(id="input-quantity")
	private WebElement quantity1; 
	
	public void setQuantity(String quantity) {
		
		this.quantity1.clear();
		this.quantity1.sendKeys(quantity);
		
	}
	
	
	/*  Click on Links tab */
	 
	 @FindBy(xpath="//a[text() ='Links']")
		private WebElement link; 
		
		public void clickLink() {
			
			this.link.click();
			
		}
	 
	/* Click on Categories textbox */
	 
	 @FindBy(id="input-category")
		private WebElement category; 
		
		public void clickCategory() {
			
			this.category.click();				
			//Select select = new Select(this.category); 
			//select.selectByValue("369");
			
			
		}
		
	
		/*  Select Category from displayed category list */
		 
		 @FindBy(xpath="//ul[@class='dropdown-menu']")
			private WebElement category1; 
			public void clickCategory1() {
				
							
				Select select = new Select(this.category1); 
				select.selectByValue("369");
						
			}
			
		/*  Click on Save icon */
		
		 @FindBy(xpath="//button[@data-original-title ='Save']")
			private WebElement save; 
			
			public void clickSave() {
				
				this.save.click();
				
			}
}
