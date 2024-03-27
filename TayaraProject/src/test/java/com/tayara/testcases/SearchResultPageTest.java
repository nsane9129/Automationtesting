package com.tayara.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tayara.base.BaseClass;
import com.tayara.pageobjects.IndexPage;
import com.tayara.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setup() {
		String browser = "Chrome";
		launchApp(browser); 	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("montre");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}

}
