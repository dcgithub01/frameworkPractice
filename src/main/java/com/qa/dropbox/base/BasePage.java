package com.qa.dropbox.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.dropbox.utils.ElementUtils;
import com.qa.dropbox.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	public ElementUtils elementutils;
	public OptionsManager OptionsManager;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	/**\
	 * This method is used to initialize the webdriver on the basics of browser 
	 * @param browserName
	 * @return 
	 * @return driver
	 */
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}
	
	public WebDriver init_driver(Properties prop) {
		OptionsManager = new OptionsManager(prop);
		String browserName=  prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 // driver = new ChromeDriver();
			tldriver.set(new ChromeDriver(OptionsManager.getchromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
		 // driver = new FirefoxDriver();
		tldriver.set(new FirefoxDriver(OptionsManager.fo));
	}
		else if(browserName.equalsIgnoreCase("safari"))
		{
	WebDriverManager.getInstance(SafariDriver.class).setup();
	 // driver = new SafariDriver();
	tldriver.set(new SafariDriver());
}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return 	getDriver();	
}
	/**
	 * This method is used initialize properties from the configuration.properties files.
	 * @return properties 
	 */
	public Properties init_prop() {
		String env=null;
		String path=null;
		prop = new Properties();
		try
		{
			env=System.getProperty("env");
			System.out.println("Env value is " +env);
		if(env==null)
		{
			path = ".\\src\\main\\java\\com\\qa\\dropbox\\config\\config.properties";
		}
		else
		{
			switch(env)
			{
			case "qa":
			path = ".\\src\\main\\java\\com\\qa\\dropbox\\config\\config.qa.properties";
			break;
			case "dev":
				path = ".\\src\\main\\java\\com\\qa\\dropbox\\config\\config.dev.properties";
				break;
				
				default :
					System.out.println("Please enter correct value of env    " + env);
					break;
			}
		}
		
			FileInputStream ip= new FileInputStream(path);
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
	
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/Screenshots/" +System.currentTimeMillis() +".png";
		File Dest = new File(path);
		try {
			FileUtils.copyFile(src, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
	
}

