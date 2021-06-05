package com.dropbox.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.dropbox.base.BaseTest;
import com.qa.dropbox.pages.ContactPage;
import com.qa.dropbox.pages.HomePage;
import com.qa.dropbox.pages.LoginPage;
import com.qa.dropbox.utils.Constants;

import junit.framework.Assert;

public class ContactPageTest extends BaseTest{
	

	 HomePage hm;
	 ContactPage cp;
	
	@BeforeClass
	public void contactPageSetup()
	{    
		hm=	lp.doLogin("qacult.demo@gmail.com", "testing123");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cp= hm.doNavigateToContact();
		
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest()
	{
		String title = cp.getPageTitle();
		Assert.assertEquals(Constants.CONTACT_PAGE_TITLE, title);
		System.out.println("Contact page title is  "+ title);
	}

	@Test(priority=2)
	public void verifyheaderTitleTest()
	{
		String title1 =cp.getHeaderTitle();
		Assert.assertEquals(Constants.CONTACT_HEADER_TITLE, title1);
		System.out.println("Contact header title is " + title1);
	}
	
	@Test(priority=3)
	public void doSaveChangesTest()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cp.doSaveChanges("XYZ", "Street1234");
	}
}
