package com.orangeHRM.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Page Objects
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement loginbutton;

	@FindBy(className = "oxd-text oxd-text--p orangehrm-login-forgot-header") WebElement forgotpassword;
	@FindBy(className = "orangehrm-login-branding") WebElement logo;
	
	
	//initializing the Page Objects 
	public LoginPage() {
		try {
			PageFactory.initElements(driver, this);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}	
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		return logo.isEnabled();
	}

	public PIMPage logIn(String un, String pws) {
		username.sendKeys(un);
		password.sendKeys(pws);
		loginbutton.click();

		return new PIMPage();
	}

	public ResetPasswordPage forgotPassword() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		forgotpassword.click();

		return new ResetPasswordPage();
	}

}
