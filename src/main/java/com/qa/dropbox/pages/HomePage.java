package com.qa.dropbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dropbox.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	
	By header = By.xpath("(//span[contains(text(),'All Files')])[2]");
	By uploadBtn = By.xpath("//span[contains(text(),'Upload')]");
	
public HomePage(WebDriver driver)
{
	this.driver=driver;
	
}
public String getHomePageTitle()
{
	String homeTitle =driver.getTitle();
	return homeTitle;
	
}
public String doGetElementTitle() {
	String title = driver.findElement(header).getText();
	return title;
}

public boolean getIsDisplayed() {
	return driver.findElement(uploadBtn).isDisplayed();
}
public void doClickLink() {
	driver.findElement(uploadBtn).click();
}
}
