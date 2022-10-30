package com.orangeHRM.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.base.TestBase;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.pages.PIMPage;
import com.orangeHRM.pages.ResetPasswordPage;


//Testing
public class LoginPageTest extends TestBase {

    LoginPage loginpage;
    PIMPage pimHomepage;
    ResetPasswordPage resetpasswordpage;

    public LoginPageTest() {

        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginpage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String expectedTitle = "OrangeHRM";
        String actualTitle = loginpage.validatePageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void logoTest() {
        boolean flag = loginpage.validatelogo();
        Assert.assertTrue(flag);
    }


    @Test(priority = 3)
    public void loginTest() {
        pimHomepage = loginpage.logIn(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = 4)
    public void forgotPasswordTest() {
        resetpasswordpage = loginpage.forgotPassword();
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
