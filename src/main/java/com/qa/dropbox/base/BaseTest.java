package com.qa.dropbox.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.dropbox.pages.LoginPage;

public class BaseTest {
	public BasePage bp;
	public LoginPage lp;
	public WebDriver driver;
	public Properties prop;
	@BeforeTest
	public void setup()
	{
	 bp = new BasePage();
	driver=bp.init_driver(prop);
	lp= new LoginPage(driver);

	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
