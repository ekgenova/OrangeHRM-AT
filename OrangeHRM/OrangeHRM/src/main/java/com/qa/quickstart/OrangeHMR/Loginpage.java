package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	//User name input field
	@FindBy(id="txtUsername")
	private WebElement username;
	
	//Password input field
	@FindBy(id="txtPassword")
	private WebElement password;
	
	//Button to log in 
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	//Inputs the admin user and pass and logs in
	public void loginAsAdmin() {
		username.sendKeys(Constant.adminUsername);
		password.sendKeys(Constant.adminPassword);
		loginButton.click();
	}
}
