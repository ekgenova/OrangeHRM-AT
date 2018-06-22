package com.qa.quickstart.OrangeHMR;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

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
	String path = "http://www.practiceselenium.com/welcome.html";
	static ExtentReports report;
	
  @Given("^the Add Employee Tab$")
  public void navToAddEmployee() throws Throwable {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\chromedriver.exe");
	  report = new ExtentReports("C:\\Users\\Admin\\Assessment\\OrangeHRM\\OrangeHRM\\reports\\testReport.html", true);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to("http://opensource.demo.orangehrmlive.com/index.php/dashboard");
	  Loginpage login = PageFactory.initElements(driver, Loginpage.class);
	  login.loginAsAdmin(driver);
	  Homepage home = PageFactory.initElements(driver, Homepage.class);
	  home.toAddEmployeePage(driver);
	  assertEquals("http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee", driver.getCurrentUrl());
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
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  addEmp.inputDetails(driver);
	  addEmp.uploadPhoto();
  }
  
  @And("^I choose to create Login Details$")
  public void createLoginDetails() throws Throwable {
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  addEmp.selectLoginDetails(driver);

  }

  @And("^I fill out the Login Details correctly$")
  public void fillLoginDetails() throws Throwable {
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  addEmp.inputLoginDetails(driver);
  }
  
  @And("^I click the Save button$")
  public void save() throws Throwable {
	  AddEmployeePage addEmp = PageFactory.initElements(driver, AddEmployeePage.class);
	  addEmp.save(driver);

  }
  
  @Then("^I can see information about the user$")
  public void viewInfo() throws Throwable {
	  EmployeeInfoPage empInfo = PageFactory.initElements(driver, EmployeeInfoPage.class);
	  assertEquals("Kate Genova", empInfo.getProfileNameElement().getText());
	  
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
  
  @After
  public void tearDown() {
	  driver.quit();
	  report.flush();
  }



}
