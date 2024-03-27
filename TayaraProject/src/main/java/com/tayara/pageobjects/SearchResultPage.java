package com.tayara.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;


public class SearchResultPage extends BaseClass {
	
	Action action= new Action();

	@FindBy(xpath="//*[@id=\"product-item-info_5722\"]/div[1]/a/span/span/img")
	private WebElement productResult;
	
	@FindBy(xpath="/html/body/div[2]/main/div[4]/div[1]/div[3]/ol/li[1]/div/div[3]/div[2]/div/div[1]/form/button")
	private WebElement addToCartBtn;

	
	public void clickOnAddToCart() throws Throwable {
		

		action.click(getDriver(), addToCartBtn);
	}
	
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	
	

}
