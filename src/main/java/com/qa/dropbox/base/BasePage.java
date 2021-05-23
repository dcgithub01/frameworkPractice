package com.qa.dropbox.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	/**\
	 * This method is used to initialize the webdriver on the basics of browser 
	 * @param browserName
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop) {
		String browserName=  prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	}
		else if(browserName.equalsIgnoreCase("safari"))
		{
	WebDriverManager.getInstance(SafariDriver.class).setup();
	  driver = new SafariDriver();
}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;	
}
	/**
	 * This method is used initialize properties from the configuration.properties files.
	 * @return properties 
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip= new FileInputStream("..\\src\\main\\java\\com\\qa\\dropbox\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	
}

