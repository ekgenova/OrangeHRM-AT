package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Homepage {

	@FindBy(id="menu_pim_viewPimModule")
	private WebElement PIMButton;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement PIMAddEmployeeButton;
	
	
	public void toAddEmployeePage(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(PIMButton).moveToElement(PIMAddEmployeeButton).click().perform();
	}
}
