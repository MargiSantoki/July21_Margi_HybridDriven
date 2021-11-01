package com.technocredits.orghm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghm.base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	public boolean isLogoDisplayed() {
		return driver.findElement(By.xpath("//img")).isDisplayed();
	}

	public boolean isLoginPanelDisplayed() {
		return driver.findElement(By.xpath("//div[@id='divLoginForm']")).isDisplayed();
	}

	public void enterCredentials(String username, String password) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
	}

	public MenuPage clickOnLoginButton() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		return new MenuPage();
	}

	public String getLoginErrorMessage() {
		return driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	}
}
