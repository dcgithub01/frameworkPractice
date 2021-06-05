package com.qa.dropbox.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement doGetElement(By locator) {
		WebElement element = null;
		try {

			element = driver.findElement(locator);
			System.out.println("WebElement found successfully " + element);
		} catch (Exception e) {
			System.out.println("Some error got occurred with this locator   " + element);
		}
		return element;
	}

	public List<WebElement> doGetAllElement(By locator) {
		List<WebElement> elements = null;
		try {

			elements = driver.findElements(locator);
			System.out.println("WebElements found successfully " + elements);
		} catch (Exception e) {
			System.out.println("Some error got occurred with this locator   " + elements);
		}
		return elements;
	}

	public void doClick(By locator)

	{
		doGetElement(locator).click();
	}

	public void doSendKeys(By locator, String value)

	{
		doGetElement(locator).sendKeys(value);

	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return doGetElement(locator).isDisplayed();

	}

	public void doSelectDropdownbyText(By locator, String value) {

		Select select = new Select(doGetElement(locator));

		select.selectByVisibleText(value);

	}

	public void doSelectDropdownByIndex(By locator, int value) {

		Select select = new Select(doGetElement(locator));

		select.selectByIndex(value);

	}

	public void doSelectDropdownByValue(By locator, String value) {

		Select select = new Select(doGetElement(locator));

		select.selectByValue(value);

	}

	public ArrayList<String> doSelectDropdownGetOptions(By locator) {
		ArrayList<String> dropdownvalues = new ArrayList<String>();
		Select selectOptions = new Select(doGetElement(locator));
		List<WebElement> dropdownOptions = selectOptions.getOptions();
		int count = dropdownOptions.size();
		for (int i = 0; i < count; i++) {
			String text = dropdownOptions.get(i).getText();
			dropdownvalues.add(text);

		}
		return dropdownvalues;

	}

	public int doGetDropdownOptionCount(By locator) {
		return doSelectDropdownGetOptions(locator).size();
	}

	public void doGetDropdownValueWithSelect(By locator, String value) {
		Select select = new Select(doGetElement(locator));
		List<WebElement> options = select.getOptions();
		int count = options.size();
		for (int i = 0; i < count; i++) {
			String text = options.get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(value)) {
				options.get(i).click();
				break;
			}
		}

	}

	public void doGetDropdownValueWithoutSelect(By locator, String value) {
		// Select select= new Select(doGetElement(locator));

		List<WebElement> options = doGetAllElement(locator);
		int count = options.size();
		for (int i = 0; i < count; i++) {
			String text = options.get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(value)) {
				options.get(i).click();
				break;
			}
		}

	}

	public void doSelectMultipleDropdownValues(By locator, String... value) {
		// Select select= new Select(doGetElement(locator));

		List<WebElement> options = doGetAllElement(locator);
		if (!value[0].equalsIgnoreCase("all")) {
			int count = options.size();
			for (int i = 0; i < count; i++) {
				String text = options.get(i).getText();
				// System.out.println(text);
				for (int k = 0; k < value.length; k++) {
					// String text=options.get(i).getText();

					if (text.equalsIgnoreCase(value[k])) {
						options.get(i).click();
						break;
					}
				}
			}
		} else
			try {
				for (int all = 0; all < options.size(); all++) {
					options.get(all).click();

				}
			} catch (Exception e) {
				// TODO: handle exception
			}

	}
	
	//*************************************************************************************
	//Action Class Methods

	public void doActionDragAndDrop(By sourceLocator ,By destLocator)
	{  
		WebElement source = doGetElement(sourceLocator);
		WebElement destination = doGetElement(destLocator);
	
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}
	public void doActionMoveToElement(By Locator)
	{  
		WebElement source = doGetElement(Locator);
				Actions act = new Actions(driver);
		act.moveToElement(source).build().perform();
	}
	public void doActionContextClick(By Locator)
	{  
		WebElement source = doGetElement(Locator);
				Actions act = new Actions(driver);
		act.contextClick(source).build().perform();
	}
	public void doActionClick(By Locator)
	{  
		WebElement source = doGetElement(Locator);
				Actions act = new Actions(driver);
		act.click(source).build().perform();
	}
	public void doActionClickAndHold(By Locator)
	{  
		WebElement source = doGetElement(Locator);
				Actions act = new Actions(driver);
		act.clickAndHold(source).build().perform();
	}
	public void doActionSendKeys(By Locator,String value)
	{  
		WebElement source = doGetElement(Locator);
				Actions act = new Actions(driver);
		act.sendKeys(source, value).build().perform();
	}
	
	//Webdriverwait methods -explicit waits
	public WebElement doWaitForElementToBeLocated(By locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
		
		
	}
	public WebElement doWaitForElementToBeVisible(By locator,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		WebElement element =doGetElement(locator);
		return wait.until(ExpectedConditions.visibilityOf(element));
		 
		
	}
	public WebElement doWaitForElementTobeClickable(By locator,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		//WebElement element =doGetElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
		
	}
	public Boolean doWaitForURL(String URL,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.urlContains(URL));
	}
	public Alert doWaitForAlertPresent(int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
	
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	return alert;
	
	}
	public void doClickWhenReady(By locator,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		//WebElement element =doGetElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
} 
	public String doWaitForTitleIs(String title,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		//WebElement element =doGetElement(locator);
		 wait.until(ExpectedConditions.titleContains(title));
		 return driver.getTitle();
	
} 
	public List<WebElement> doGetAllElementsUsingWait(By locator , int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
