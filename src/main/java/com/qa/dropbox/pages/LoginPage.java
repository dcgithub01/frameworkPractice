package com.qa.dropbox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dropbox.base.BasePage;

public class LoginPage extends BasePage{
private WebDriver driver ;
	By userName= By.id("login-email");
	By nextBtn = By.id("login-submit");
	By password = By.id("password-login");
	By signIn = By.id("login-submit-password");
	By signUp = By.id("webapp-signup-button");
	By resetPassword = By.linkText("Reset Password");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public HomePage doLogin(String username,String password)
	{
		driver.findElement(this.userName).sendKeys(username);
		driver.findElement(nextBtn).click();
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(signIn).click();
		return new HomePage(driver);
		
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean doVerifyCreateAccLink() {
		return driver.findElement(signUp).isDisplayed();
	}
}
