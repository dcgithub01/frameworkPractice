package com.dropbox.qa.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.dropbox.base.BaseTest;
import com.qa.dropbox.pages.HomePage;
import com.qa.dropbox.utils.Constants;
import com.qa.dropbox.utils.ExcelUtils;

public class HomePageTest extends BaseTest {
	HomePage hp;
	ExcelUtils excelutil;

	
	@BeforeClass
	public void homePageSetup()
	{
		
	hp=	lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

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
	
	@DataProvider
	public Object[][] datacreate() {
		Object [][] data=ExcelUtils.getTestData(Constants.SHEET_NAME);
		return data;
	}
	
	@Test(priority=5,dataProvider="datacreate")
	public void createFolderTest(String folderName,String AdditionalInvite, String permission)
	{
		hp.createFolder(folderName, AdditionalInvite, permission);
	}
	
	
}
