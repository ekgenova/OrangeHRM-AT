package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	@FindBy(id="firstName")
	private WebElement firstNameInput;
	
	@FindBy(id="lastName")
	private WebElement lastNameInput;
	
	@FindBy(id="middleName")
	private WebElement middleNameInput;
	
	@FindBy(id="chkLogin")
	private WebElement loginDetailsCheckbox;
	
	@FindBy(id="user_name")
	private WebElement username;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(id="re_password")
	private WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	private WebElement saveButton;
	
	@FindBy(id="photofile")
	private WebElement uploadPhoto;
	
	@FindBy(id="status")
	private WebElement enabledStatus;
	
	
	public void inputDetails(String fname, String mname, String lname) {
		firstNameInput.sendKeys(fname);
		middleNameInput.sendKeys(mname);
		lastNameInput.sendKeys(lname);
	}
	
	public void inputDetails(String fname, String lname) {
		firstNameInput.sendKeys(fname);
		lastNameInput.sendKeys(lname);
	}

	public void selectLoginDetails() {
		loginDetailsCheckbox.click();
	}
	
	public void inputLoginDetails(WebDriver driver, String user_name, String pass_word, Boolean enabled) {
		username.sendKeys(user_name);
		password.sendKeys(pass_word);
		confirmPassword.sendKeys(pass_word);
		
		Actions action = new Actions(driver);
		if (enabled==false) {
			enabledStatus.click();
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		}
	}
	
	
	public void save() {
		saveButton.click();
	}
	
	public void uploadPhoto(String path) {
		uploadPhoto.sendKeys(path);
	}
}
