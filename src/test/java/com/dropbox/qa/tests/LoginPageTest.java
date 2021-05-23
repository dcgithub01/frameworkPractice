package com.dropbox.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dropbox.base.BaseTest;
import com.qa.dropbox.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest()
	{
		String title =lp.getLoginPageTitle();
		System.out.println("login page title is   "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE,"Login title is not matched");
	}
	
	@Test(priority = 2)
	public void verifyCreateAccountLinkTest(){
		Assert.assertTrue(lp.doVerifyCreateAccLink(),"Signup link is not displayed");
		
	}
	@Test(priority = 3)
	public void signInTest()
	{
		lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
