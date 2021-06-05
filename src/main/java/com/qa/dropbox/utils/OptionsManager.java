package com.qa.dropbox.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	public Properties prop;
	public ChromeOptions co;
	public FirefoxOptions fo;
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
		
	}
	
	
	public ChromeOptions getchromeOptions()
	{
		co = new ChromeOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless")))
			
				{
			        co.addArguments("--headless");
			 
				}
		if(Boolean.parseBoolean(prop.getProperty("incognito")))
			
		{
	              co.addArguments("--incognito");
	
		}
		return co;
	}
	public FirefoxOptions getfirefoxOptions()
	{
		fo = new FirefoxOptions();
		
		if(Boolean.parseBoolean(prop.getProperty("headless")))
			
				{
			         fo.addArguments("--headless");
			 
				}
		if(Boolean.parseBoolean(prop.getProperty("incognito")))
			
		{
	              fo.addArguments("--incognito");
	
		}
		return fo;
	}
}
