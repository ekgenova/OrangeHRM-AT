package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployeePage {
	
	@FindBy(id="firstName")
	private WebElement firstNameInput;
	
	@FindBy(id="lastName")
	private WebElement lastNameInput;
	
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
	
	String path = "C:\\Users\\Admin\\Assessment\\OrangeHRM\\OrangeHRM\\resources\\peace.jpg";
	
	
	public void inputDetails(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(firstNameInput).sendKeys("Kate").click(lastNameInput).sendKeys("Genova").perform();
	}

	public void selectLoginDetails(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(loginDetailsCheckbox).perform();
	}
	
	public void inputLoginDetails(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(username).sendKeys("thekate").click(password).sendKeys("password").click(confirmPassword).sendKeys("password").perform();
	}
	
	public void save(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(saveButton).perform();
	}
	
	public void uploadPhoto() {
		uploadPhoto.sendKeys(path);
	}
}
