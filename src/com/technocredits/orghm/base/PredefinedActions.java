package com.technocredits.orghm.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	protected static WebDriver driver;

	public static void start(String url) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Open chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("STEP : Enter URL");
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		System.out.println("Open chrome browser");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println("STEP : Enter URL");
		driver.get("https://oct30automation-trials72.orangehrmlive.com/");
		driver.manage().window().maximize();
	}

	protected List<String> getTextOfAllElements(String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		List<String> listOfElements = new ArrayList<String>();
		for (WebElement element : elements) {
			listOfElements.add(element.getText());
		}
		return listOfElements;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}
}
