package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	
	public void loginAsAdmin() {
		username.sendKeys(Constant.adminUsername);
		password.sendKeys(Constant.adminPassword);
		loginButton.click();
	}
}
