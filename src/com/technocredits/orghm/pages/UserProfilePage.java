package com.technocredits.orghm.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.technocredits.orghm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {

	public boolean isProfilePictureDisplayed() {
		return driver.findElement(By.xpath("//img[@class='circle account-photo']")).isDisplayed();
	}

	public void clickOnUserDropdown() {
		driver.findElement(By.xpath("//a[@id='user-dropdown']")).click();
	}

	public List<String> getListOfUserDropdownOptions() {
		return getTextOfAllElements("//ul[@id='user_menu']/li/a");
	}

	public int getTotalAvailableOptions() {
		return getListOfUserDropdownOptions().size();
	}

	public void clickOnAbout() {
		driver.findElement(By.xpath("//a[text()='About']")).click();
	}

	public void clickOnSubMenu(String subMenu) {
		driver.findElement(By.xpath("//a[text()='" + subMenu + "']")).click();
	}

	public String getCmpNameFromAboutPopup() {
		String company = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[1]/p")).getText();
		return company.split(": ")[1];
	}

	public String getVersionFromAboutPopup() {
		String version = driver.findElement(By.xpath("//div[@id='companyInfo']/div/div[2]/p")).getText();
		return version.split(": ")[1];
	}

	public String getEmployeesFromAboutPopup() {
		String employees =  driver.findElement(By.xpath("//div[@id='companyInfo']/div//div[3]/p")).getText();
		return employees.split(": ")[1];
	}

	public String getUsersFromAboutPopup() {
		String users = driver.findElement(By.xpath("//div[@id='companyInfo']/div//div[4]/p")).getText();
		return users.split(": ")[1];
	}

	public String getRenewalOnFromAboutPopup() {
		String renewal = driver.findElement(By.xpath("//div[@id='companyInfo']/div//div[5]/p")).getText();
		return renewal.split(": ")[1];
	}
	
	public boolean isEmpCountGreaterThanZero() {
		boolean flag = true;
		String emp = getEmployeesFromAboutPopup();
		int totalEmp = Integer.parseInt(emp.split(" ")[0]);
		if(totalEmp < 0)
			flag = false;
		else
			flag = true;
		return flag;
	}

	public List<String> getAboutMenuText() {
		return getTextOfAllElements("//div[@id='companyInfo']//p");
	}
	
	public void clickOnOkButton() {
		driver.findElement(By.xpath("//a[text()='Ok']")).click();
	}
}
