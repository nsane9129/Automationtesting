package com.tayara.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;


public class AddToCartPage extends BaseClass {
	

    Action action= new Action();
    
    @FindBy(xpath = "//*[@id='qty']")
	private WebElement quantity;

    //@FindBy(css="#product-addtocart-button")
	//@FindBy(xpath="//*[@id=\"product_addtocart_form\"]/div/div/div[2]/button/span")
    @FindBy(xpath="//*[@id=\"product-addtocart-button\"]")
    private WebElement addToCartBtn;

	@FindBy(xpath="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/div/a")
	private WebElement addToCartMessag;

	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")
	private WebElement proceedToCheckOutBtn;
	
	
	@FindBy(xpath="//*[@id=\"product_addtocart_form\"]/div/div/div[2]/div[2]/div[1]/a[2]")
	private WebElement compare;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);

	}

	public void clickOnAddToCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartBtn, 10);
	    WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		// Click on the button
		action.click(getDriver(), addToCartBtn);

	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartMessag, 10);
		return action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.fluentWait(getDriver(), proceedToCheckOutBtn, 20);
		action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
