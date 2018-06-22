package com.qa.quickstart.OrangeHMR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeInfoPage {

	
	@FindBy(css="#profile-pic > h1")
	private WebElement profileName;
	
	public WebElement getProfileNameElement() {
		return profileName;
	}
}
