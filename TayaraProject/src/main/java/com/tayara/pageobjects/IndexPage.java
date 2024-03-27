package com.tayara.pageobjects;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;


public class IndexPage extends BaseClass{	
	Action action= new Action();

	
	@FindBy(xpath="//a[@href='https://www.mytek.tn/customer/account/login/referer/aHR0cHM6Ly93d3cubXl0ZWsudG4v/']")
	private WebElement signInBtn;
	
	@FindBy(xpath="//img[@title='Logo Mytek']")
	private WebElement mylogo;
	
	@FindBy(id="minisearch-input-top-search")
	private WebElement searchInput;

	
	@FindBy(xpath="//button[@class='action search']")
	private WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}


	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), mylogo);
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchInput, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchBtn);
		action.click(getDriver(), searchBtn);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
}
