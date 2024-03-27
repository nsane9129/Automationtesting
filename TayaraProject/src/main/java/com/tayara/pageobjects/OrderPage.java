package com.tayara.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tayara.actiondriver.Action;
import com.tayara.base.BaseClass;

public class OrderPage extends BaseClass {

	
Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[4]/span/span/span")
	private WebElement unitPrice;
	
	@FindBy(xpath="//*[@id=\"cart-totals\"]/div/table/tbody/tr[2]/td/strong/span")
	private WebElement totalPrice;
	

	@FindBy(xpath="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")
	private WebElement proceedToCheckOut;
	
	
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.fluentWait(getDriver(), proceedToCheckOut, 20);
		action.JSClick(getDriver(), proceedToCheckOut);
		return new OrderPage();
	}

	
}
