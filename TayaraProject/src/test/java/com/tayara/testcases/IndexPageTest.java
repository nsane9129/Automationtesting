package com.tayara.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.tayara.base.BaseClass;
import com.tayara.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{

	private IndexPage indexPage;
	
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
	public void verifyLogo() throws Throwable {
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	

}