package com.tayara.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.tayara.base.BaseClass;
import com.tayara.pageobjects.HomePage;
import com.tayara.pageobjects.IndexPage;
import com.tayara.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp("Chrome"); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="https://www.mytek.tn/";
	    Assert.assertEquals(actualURL, expectedURL);
	   
	}


}
