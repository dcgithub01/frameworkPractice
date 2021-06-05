package com.qa.dropbox.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.dropbox.base.BasePage;

public class JavaScriptUtils  {

	WebDriver driver;
	
	public JavaScriptUtils(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	public void flash(WebElement element)
	{
		JavascriptExecutor js = (( JavascriptExecutor) driver) ;
			String bgColor = element.getCssValue("backgroundColor");
			for(int i=0;i<20;i++)
			{
				changeColor("rgb(0,200,0)",element);
				changeColor(bgColor,element);
			
			}
	}
			private void changeColor(String color,WebElement element)
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				js.executeScript("arguments[0].style.backgroundColor='"+color+"'"+element);
				
			}
			
			public void drawBroder(WebElement element)
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				js.executeScript("arguments[0].style.border='3px solid red'",element);
			}
			public void generateAlert(String message)
			
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				js.executeScript("alert('"+message+"')");
				
			}
		
			public void refreshBrowserByJS()
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				js.executeScript("history.go(0)");
				
			}
			public void clickElementByJS(WebElement element)
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				js.executeScript("argument[0].click()", element);
				
			}
			public String getTitleByJS()
			{
				JavascriptExecutor js =((JavascriptExecutor) driver );
				return js.executeScript("return docuement.title;").toString();
				
			}
			public String getPageInnerText()
			{
				JavascriptExecutor js = ((JavascriptExecutor)driver );
				String pageText= js.executeScript("document.documentElement.innerText;").toString();
				return pageText;
				
			}
			
			public void scrollToBottom()
			{
				JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("windows.scrollTo(0,document.body.scrollHeight)");	
			}
			public void scrollToTop()
			{
				JavascriptExecutor js = ((JavascriptExecutor) driver);
			 js.executeScript("windows.scrollTo(document.body.scrollHeight,0)");	
			}
			
			public void sendkeysUsingJS(String id,String value)
			{
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("document.getElementById('"+id+"').value='"+value+"'" );
			}
	

}

