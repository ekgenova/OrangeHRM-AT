package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	
	public void loginAsAdmin(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(username).sendKeys("Admin").click(password).sendKeys("admin").click(loginButton).perform();
	}
}
