package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	//Personal detail inputs
	@FindBy(id="firstName")
	private WebElement firstNameInput;
	
	@FindBy(id="lastName")
	private WebElement lastNameInput;
	
	@FindBy(id="middleName")
	private WebElement middleNameInput;
	
	@FindBy(id="photofile")
	private WebElement uploadPhoto;
	
	//Check box to open login credential inputs
	@FindBy(id="chkLogin")
	private WebElement loginDetailsCheckbox;
	
	//Log in credential inputs
	@FindBy(id="user_name")
	private WebElement username;
	
	@FindBy(id="user_password")
	private WebElement password;
	
	@FindBy(id="re_password")
	private WebElement confirmPassword;
	
	@FindBy(id="status")
	private WebElement enabledStatus;
	
	//Save button
	@FindBy(id="btnSave")
	private WebElement saveButton;
	
	
	//Inputs personal details including middle name
	public void inputDetails(String fname, String mname, String lname) {
		firstNameInput.sendKeys(fname);
		middleNameInput.sendKeys(mname);
		lastNameInput.sendKeys(lname);
	}
	
	//Inputs personal details NOT including middle name
	public void inputDetails(String fname, String lname) {
		firstNameInput.sendKeys(fname);
		lastNameInput.sendKeys(lname);
	}

	//Selects check box
	public void selectLoginDetails() {
		loginDetailsCheckbox.click();
	}
	
	//Inputs login credentials
	public void inputLoginDetails(WebDriver driver, String user_name, String pass_word, Boolean enabled) {
		username.sendKeys(user_name);
		password.sendKeys(pass_word);
		confirmPassword.sendKeys(pass_word);
		
		//Checks if enabled needs to be true or false
		//If false changes the dropdown list to false
		Actions action = new Actions(driver);
		if (enabled==false) {
			enabledStatus.click();
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
		}
	}
	
	//Presses save button
	public void save() {
		saveButton.click();
	}
	
	//Uploads photo
	public void uploadPhoto(String path) {
		uploadPhoto.sendKeys(path);
	}
}
