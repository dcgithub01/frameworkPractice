package com.dropbox.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.dropbox.base.BaseTest;
import com.qa.dropbox.pages.HomePage;
import com.qa.dropbox.utils.Constants;

public class HomePageTest extends BaseTest {
	HomePage hp;
	@BeforeClass
	public void homePageSetup()
	{
		
	hp=	lp.doLogin("nancydhingra131@gmail.com", "nancy131");
			}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String title=hp.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE,"Home page title not matched");
	}
	@Test(priority=2)
	public void verifytitleTest()
	{
		String title=hp.doGetElementTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_ELEMENT_TITLE,"title is not matched");
	}
	@Test(priority=3)
	public void verifyClickLinkTest()
	{
		Assert.assertTrue(hp.getIsDisplayed());
		
	}
	@Test(priority=4)
	public void checkClickLink()
	{
		hp.doClickLink();
	}
	
}
