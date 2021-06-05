package com.qa.dropbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dropbox.base.BasePage;
import com.qa.dropbox.utils.Constants;
import com.qa.dropbox.utils.ElementUtils;

public class HomePage extends BasePage{
	private WebDriver driver;

	By header = By.xpath("(//span[contains(text(),'All Files')])[2]");
	By uploadBtn = By.xpath("//span[contains(text(),'Upload')]");
	By options=By.xpath("//button[@data-resin-target='accountmenu']");
	By editInfo = By.xpath("//span[text()='Edit Information']");
	By viewProfile= By.xpath("//a[@data-resin-target='viewprofile']");
	By newBtn = By.xpath("//span[text()='New']");
	By folder = By.xpath("//span[text()='Folder']");
	By foldername= By.name("folder-name");
	By invitepeople =By.xpath("//textarea[@placeholder='Enter email addresses to invite users']");
	By permssion = By.name("invite-permission");
	By createBtn = By.xpath("//span[text()='Create']");
public HomePage(WebDriver driver)
{
	this.driver=driver;
	elementutils= new ElementUtils( this.driver);
}
public String getHomePageTitle()
{
	//String homeTitle =driver.getTitle();
	String homeTitle=elementutils.doWaitForTitleIs(Constants.HOME_PAGE_TITLE, 10);
	return homeTitle;
	
}
public String doGetElementTitle() {
	//String title = driver.findElement(header).getText();
	String title =	elementutils.doGetText(header);
	return title;
}

public boolean getIsDisplayed() {
	//return driver.findElement(uploadBtn).isDisplayed();
	return elementutils.doIsDisplayed(uploadBtn);
}
public void doClickLink() {
	//driver.findElement(uploadBtn).click();
	elementutils.doClick(uploadBtn);
}
public ContactPage doNavigateToContact()
{   elementutils.doWaitForElementToBeLocated(options, 10);
	elementutils.doClick(options);
	elementutils.doWaitForElementToBeLocated(viewProfile, 5);
    elementutils.doClick(viewProfile);
  //  elementutils.doWaitForElementToBeLocated(editInfo, 5);
	elementutils.doClick(editInfo);
	return new ContactPage(driver);
	
}

public void createFolder (String folderName,String AdditionalInvite, String permission)
{   elementutils.doClick(newBtn);
    elementutils.doClick(folder);
	elementutils.doWaitForElementToBeLocated(foldername, 10);
	elementutils.doSendKeys(foldername, folderName);
	elementutils.doSendKeys(invitepeople, AdditionalInvite);
	elementutils.doSelectDropdownbyText(permssion, permission);
	elementutils.doClick(createBtn);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
