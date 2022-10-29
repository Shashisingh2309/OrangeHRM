package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.base.TestBase;
import com.orangeHRM.util.TestUtil;

public class PIMPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	WebElement addbutton;
	
	@FindBy(xpath = "//h6[text()='Add Employee']")
	WebElement addEmployeeLable;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	
	
	public PIMPage() {
		try {
			PageFactory.initElements(driver, this);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public String verifyPIMpageTitle() {
		return driver.getTitle();
	}
	
	public String verifyPIMpageURL() {
		return driver.getCurrentUrl();
	}
	
	public AddEmployee addempbutton() {
		addbutton.click();
		return new AddEmployee();
		
	}
	
	public boolean verifyAddEmployeeLable() {
		addbutton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
		return addEmployeeLable.isDisplayed();
	}
	
	public PersonalDetails addEmployee(String fn,String mn,String ln) {
		try {
			addbutton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
			firstName.sendKeys(fn);
			middleName.sendKeys(mn);
			lastName.sendKeys(ln);
			savebutton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return new PersonalDetails();
	}
	
	

}
