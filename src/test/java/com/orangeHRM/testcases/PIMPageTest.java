package com.orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.TestBase;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.PIMPage;

public class PIMPageTest extends TestBase{
	
	LoginPage loginpage;
	PIMPage PIMpage;
	
	public PIMPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		PIMpage= loginpage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority =1)
	public void verfiyPIMPageTitle() {
		String expectedTitle= "OrangeHRM";
		String actualTitle=PIMpage.verifyPIMpageTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void verifyPIMPageURL() {
		String actualURL=PIMpage.verifyPIMpageURL();
		Assert.assertEquals(true, actualURL.contains("viewEmployeeList"));
	}
	
	@Test(priority = 3)
	public void verifyAddButton() {
		PIMpage.addempbutton();
	}
	
	@Test(priority = 4)
	public void verifyaddEmployeeLeable() {
		PIMpage.verifyAddEmployeeLable();
	}
	
	@Test(priority = 5)
	public void addEmployee() {
		PIMpage.addEmployee("A1", "A2", "A3");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
