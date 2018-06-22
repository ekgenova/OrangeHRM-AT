package com.qa.quickstart.OrangeHMR;

import cucumber.api.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.And;

public class AddEmployee {
	
	WebDriver driver;
	static ExtentReports report;
	
  @Given("^the Add Employee Tab$")
  public void navToAddEmployee() throws Throwable {
	  
	  //Set property of driver being used
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\chromedriver.exe");
	  
	  //Report created, driver created
	  report = new ExtentReports(Constant.reportPath, true);
	  driver = new ChromeDriver();
	  
	  //Maximise driver window, navigate to appropriate start URL
	  driver.manage().window().maximize();
	  driver.navigate().to(Constant.url);
	  
	  //Initialise elements of login page
	  Loginpage login = PageFactory.initElements(driver, Loginpage.class);
	  //Logs in as admin user
	  login.loginAsAdmin();
	  
	  //Initialise elements of home page
	  Homepage home = PageFactory.initElements(driver, Homepage.class);
	  //Navigates from home page to add employee page
	  home.toAddEmployeePage(driver);
	  
	  //Asserts page is on the correct link - add employee
	  assertEquals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee", driver.getCurrentUrl());
	  
	  //Test created for the report to show the log in and navigation have been done correctly
	  ExtentTest adminlogin = report.startTest("Log in HRM");
		try {
			adminlogin.log(LogStatus.PASS, "Test passed successfully!");
		} catch (AssertionError e) {
			adminlogin.log(LogStatus.FAIL, "Test failed");
			fail();
		} finally {
			adminlogin.log(LogStatus.INFO, "Logs in as Username: Admin. Password: admin.");
			adminlogin.log(LogStatus.INFO, "Simulates hovering over 'PIM' tab then clicking 'Add Employee'." );
			report.endTest(adminlogin);
		}
  }

  @When("^I fill out the Employee Details correctly$")
  public void fillEmpDetails() throws Throwable {
	  
	  //Initialises elements of add employee page
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  
	  //Inputs personal details and photo for a user
	  addEmp.inputDetails("Kate", "Genova");
	  addEmp.uploadPhoto(Constant.imagePath);
  }
  
  @And("^I choose to create Login Details$")
  public void createLoginDetails() throws Throwable {
	  
	  //Initialises elements of add employee page
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  
	  //selects check box to allow for input of login details
	  addEmp.selectLoginDetails();

  }

  @And("^I fill out the Login Details correctly$")
  public void fillLoginDetails() throws Throwable {
	  
	  //Initialises elements of add employee page
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  
	  //Inputs login details for user being created
	  addEmp.inputLoginDetails(driver, "thekate", "password", false);
  }
  
  @And("^I click the Save button$")
  public void save() throws Throwable {
	  
	  //Initialises elements of add employee page
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  
	  //Presses the save button to save the user
	  addEmp.save();

  }
  
  @Then("^I can see information about the user$")
  public void viewInfo() throws Throwable {
	  
	  //Initialises elements of the employee info page
	  EmployeeInfoPage empInfo = PageFactory.initElements(driver, EmployeeInfoPage.class);
	  
	  //Asserts the name above the photo is the same as provided
	  assertEquals("Kate Genova", empInfo.getProfileNameElement().getText());
	  
	  //Test created for the report to show that a user has been created correctly
	  ExtentTest usercreate = report.startTest("Create new user");
		try {
			usercreate.log(LogStatus.PASS, "Test passed successfully!");
		} catch (AssertionError e) {
			usercreate.log(LogStatus.FAIL, "Test failed");
			fail();
		} finally {
			usercreate.log(LogStatus.INFO, "Fills in Employee details then login details and submits.");
			usercreate.log(LogStatus.INFO, "New employees info page opens. Verifies it's correct via the name." );
			report.endTest(usercreate);
		}
  }
  
  
  //Closes driver and flushes report through
  @After
  public void tearDown() {
	  driver.quit();
	  report.flush();
  }

}
