package com.technocredits.orghm.pages;

import java.util.List;

import com.technocredits.orghm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {

	public boolean isProfilePictureDisplayed() {
		return getElement("XPATH", "//img[@class='circle account-photo']", false).isDisplayed();
	}

	public void clickOnUserDropdown() {
		clickOnElement(getElement("XPATH", "//a[@id='user-dropdown']", false));
	}

	public List<String> getListOfUserDropdownOptions() {
		return getTextOfAllElements("//ul[@id='user_menu']/li/a");
	}

	public int getTotalAvailableOptions() {
		return getListOfUserDropdownOptions().size();
	}

	public void clickOnAbout() {
		clickOnElement(getElement("XPATH", "//a[text()='About']", false));
	}

	public void clickOnSubMenu(String subMenu) {
		clickOnElement(getElement("XPATH", "//a[text()='" + subMenu + "']", false));
	}

	public String getCmpNameFromAboutPopup() {
		String company = getElement("XPATH", "//div[@id='companyInfo']/div/div[1]/p", false).getText();
		return company.split(": ")[1];
	}

	public String getVersionFromAboutPopup() {
		String version = getElement("XPATH", "//div[@id='companyInfo']/div/div[2]/p", false).getText();
		return version.split(": ")[1];
	}

	public String getEmployeesFromAboutPopup() {
		String employees = getElement("XPATH", "//div[@id='companyInfo']/div//div[3]/p", true).getText();
		return employees.split(": ")[1];
	}

	public String getUsersFromAboutPopup() {
		String users = getElement("XPATH", "//div[@id='companyInfo']/div//div[4]/p", false).getText();
		return users.split(": ")[1];
	}

	public String getRenewalOnFromAboutPopup() {
		String renewal = getElement("XPATH", "//div[@id='companyInfo']/div//div[5]/p", false).getText();
		return renewal.split(": ")[1];
	}

	public boolean isEmpCountGreaterThanZero() {
		boolean flag = true;
		String emp = getEmployeesFromAboutPopup();
		int totalEmp = Integer.parseInt(emp.split(" ")[0]);
		if (totalEmp < 0)
			flag = false;
		else
			flag = true;
		return flag;
	}

	public List<String> getAboutMenuText() {
		return getTextOfAllElements("//div[@id='companyInfo']//p");
	}

	public void clickOnOkButton() {
		clickOnElement(getElement("XPATH", "//a[text()='Ok']", false));
	}
}
