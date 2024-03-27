package com.tayara.testcases;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tayara.base.BaseClass;
import com.tayara.pageobjects.AddToCartPage;
import com.tayara.pageobjects.IndexPage;
import com.tayara.pageobjects.OrderPage;
import com.tayara.pageobjects.SearchResultPage;
public class OrderPageTest extends BaseClass{
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	@BeforeMethod()
	public void setup() {
		String browser = "Chrome";
		launchApp(browser); 
			}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test()
	public void verifyTotalPrice() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("montre");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble("2")))+1;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
	

}
