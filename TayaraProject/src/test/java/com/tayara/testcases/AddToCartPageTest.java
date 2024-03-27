package com.tayara.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.tayara.base.BaseClass;
import com.tayara.pageobjects.IndexPage;
import com.tayara.pageobjects.AddToCartPage;
import com.tayara.pageobjects.SearchResultPage;


public class AddToCartPageTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@BeforeMethod
	public void setup() {
		String browser = "Chrome";
		launchApp(browser); 
		
		}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void addToCartTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("montre");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		
	}

}
