package com.orangeHRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.orangeHRM.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		try {
			prop =new Properties();
			FileInputStream ip= new FileInputStream("/Users/shashikrsingh/eclipse-workspace/Selenium.maven/src/main/java/com/orangeHRM/config/config.properties");
			prop.load(ip);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String nameofbrowser= prop.getProperty("browser");
		
		if(nameofbrowser.equalsIgnoreCase("chrome"))
		{
		ChromeOptions chromeoptions =new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver(chromeoptions);
		}
		else if(nameofbrowser.equalsIgnoreCase("firefox"))
		{
			 FirefoxOptions firefoxoptions =new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver(firefoxoptions);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_load_timeOut));
		
		driver.get(prop.getProperty("url"));
	}

}
