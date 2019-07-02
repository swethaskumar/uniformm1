package com.training.sanity.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPagePOM {

private WebDriver driver; 
	
	public MainPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//img[@class='img-responsive'])[4]")
	private WebElement shopUniforms;
	
	public void clickShopUniforms() {
		
		this.shopUniforms.click();
	
	}
	
	@FindBy(xpath="//img[@title='REGULAR T-SHIRTS (Rust)']")
	private WebElement selectTshirt;
	
	public void clickTshirt() {
		
		this.selectTshirt.click();
	
	}
	
	@FindBy(id="input-option376")
	private WebElement dropDown1;
	
	public void selectDropDown1() {
		
		
		Select size = new Select(dropDown1);
		size.selectByIndex(3);
		
	
	}
	@FindBy(id="button-cart")
    private WebElement addCart;
	
	public void clickAddCart() {
		
		this.addCart.click();
	
	} 
	
	@FindBy(xpath="//button[@data-toggle='dropdown']")
	private WebElement viewCart;
		
		public void clickViewCart() {
			
			this.viewCart.click();
			
		
		}
		
	@FindBy(xpath="//p[@class='text-right']//a//strong[contains(text(),' View Cart')]")	
	private WebElement viewCart1;
	
		public void clickViewCart1() {
			
			Actions actions = new Actions(driver);
			actions.moveToElement(viewCart1).click().build().perform();
			//this.viewCart1.click();
			
		}

		@FindBy(xpath="//button[@class='btn btn-danger']")
		private WebElement removeTshirt;
			
			public void clickRemove() {
				
				this.removeTshirt.click();
			
			}	
			
		@FindBy(xpath="//p[text()='Your shopping cart is empty!']")
	    private WebElement successMsg;
			
			public String validSuccessMsg() {
				
				return this.successMsg.getText();
			
			} 
			
}
