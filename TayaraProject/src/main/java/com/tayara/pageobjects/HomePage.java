package com.tayara.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;


public class HomePage extends BaseClass {
	
	Action action= new Action();

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}
	
	////div[contains(text(), "Merci de vous être enregistré avec Mytek")]



}
