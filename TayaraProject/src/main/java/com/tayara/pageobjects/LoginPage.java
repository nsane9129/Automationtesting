
package com.tayara.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="email")
    private WebElement email;
	
	@FindBy(id="pass")
    private WebElement password;
	
	@FindBy(xpath="//button[@class='action login primary' or @name='send']")
    private WebElement signInBtn;

	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	public HomePage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), email);
		action.type(email, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		return new HomePage();
	}
	
}