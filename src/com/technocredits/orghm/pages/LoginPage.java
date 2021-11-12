package com.technocredits.orghm.pages;

import com.technocredits.orghm.base.PredefinedActions;

public class LoginPage extends PredefinedActions {

	public boolean isLogoDisplayed() {
		return getElement("XPATH", "//img", false).isDisplayed();
	}

	public boolean isLoginPanelDisplayed() {
		return getElement("XPATH", "//div[@id='divLoginForm']", false).isDisplayed();
	}

	public void enterCredentials(String username, String password) {
		getElement("XPATH", "//input[@id='txtUsername']", false).sendKeys(username);
		getElement("XPATH", "//input[@id='txtPassword']", false).sendKeys(password);
	}

	public MenuPage clickOnLoginButton() {
		clickOnElement(getElement("XPATH", "//input[@id='btnLogin']", false));
		return new MenuPage();
	}

	public String getLoginErrorMessage() {
		return getElement("XPATH", "//span[@id='spanMessage']", false).getText();
	}
}
