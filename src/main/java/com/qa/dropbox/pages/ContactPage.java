package com.qa.dropbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dropbox.base.BasePage;
import com.qa.dropbox.utils.Constants;
import com.qa.dropbox.utils.ElementUtils;

public class ContactPage extends BasePage{

	private WebDriver driver;
	
	public ContactPage(WebDriver driver)
	{
	this.driver=driver;
	 elementutils= new ElementUtils(this.driver);
	}

	By companyName= By.xpath("//input[@name='companyName']");
	By header = By.xpath("//span[text()='Account Settings']");
	By address = By.name("address");
	By saveChanges = By.xpath("//button[@data-resin-target='savechanges']");
	
	public String getPageTitle()
	{
		return elementutils.doWaitForTitleIs(Constants.CONTACT_PAGE_TITLE, 10);
		
	}
	
	public String getHeaderTitle()
	{
		return elementutils.doGetText(header);
		
	}
	
	public boolean isDisplayed()
	{
		return elementutils.doIsDisplayed(saveChanges);
	}
	public void doSaveChanges(String companyname,String addres)
	{   elementutils.doWaitForElementToBeVisible(companyName, 5);
		elementutils.doSendKeys(companyName, companyname);
		elementutils.doSendKeys(address, addres);
		elementutils.doClick(saveChanges);
	}
}
