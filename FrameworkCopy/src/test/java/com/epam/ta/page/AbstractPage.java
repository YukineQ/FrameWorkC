package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;

	private static final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}


	public static WebElement waitWebElementLocatedBy(By by)
	{
		return (new WebDriverWait(DriverSingleton.getDriver(), WAIT_TIMEOUT_SECONDS))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static WebElement waitWebElementInvisibilityOf(WebElement element)
	{
		while (!new WebDriverWait(DriverSingleton.getDriver(),WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.invisibilityOf(element))){}
		return element;
	}

	public static void waitWebElementVisibilityOf(By by){
		 new WebDriverWait(DriverSingleton.getDriver(), 10)
				 .until(
				ExpectedConditions.visibilityOfElementLocated(by)
		);
	}

	public void waitUntilAjaxCompleted(){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(jQueryAJAXCompleted());
	}

	protected static ExpectedCondition<Boolean> jQueryAJAXCompleted(){
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver){
				return (Boolean) ((JavascriptExecutor)
						driver).executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
			}
		};
	}

	public void waitUntilFieldIsChanged(WebElement element, String startValue){
		new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, startValue)));
	}
}
