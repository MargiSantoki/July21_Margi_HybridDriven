package com.technocredits.orghm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fname);
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String mname) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(mname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lname) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLocation(String location) {
		driver.findElement(By.xpath("//i[text()='arrow_drop_down']")).click();
		driver.findElement(By.xpath("//span[text()='" + location + "']//parent::a")).click();
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		return this;
	}

	public PIM_AddEmployeePage setHobbies(String hobbies) {
		driver.findElement(By.xpath("//input[@id='5']")).sendKeys(hobbies);
		return this;
	}

	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		try {
			driver.findElement(
					By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input"))
					.click();
		}catch(StaleElementReferenceException e) {
			driver.findElement(
					By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input"))
					.click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='" + shiftValue + "']")));
		element.click();
		return this;
	}

	public PIM_AddEmployeePage setEffectiveFrom(String date) {
		driver.findElement(By.xpath("//label[text()='Effective From']//following-sibling::span//i")).click();
		driver.findElement(By.xpath(
				"//input[@id='add_employee_effective_date']//following-sibling::span//div[text()='" + date + "']"))
				.click();
		return this;
	}

	public PIM_AddEmployeePage setRegion(String region) {
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']//span[@class='caret']//following-sibling::input"))
				.click();
		driver.findElement(By.xpath("//div[@id='9_inputfileddiv']//span[text()='" + region + "']")).click();
		return this;
	}

	public PIM_AddEmployeePage setFte(String fteInput) {
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//span[@class='caret']//following-sibling::input"))
				.click();
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//span[text()='" + fteInput + "']")).click();
		return this;
	}

	public PIM_AddEmployeePage setTemporaryDepartment(String tempDept) {
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input"))
				.click();
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//span[text()='" + tempDept + "']")).click();
		return this;
	}

	public void addEmployeeInfo(String fname, String mname, String lname, String location) {
		setEmpFirstName(fname);
		setEmpMiddleName(mname);
		setEmpLastName(lname);
		setEmpLocation(location);
	}

	public PIM_AddEmployeePage clickOnSaveButton() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		return this;
	}

	public boolean isSuccessfullySaved() {
		return driver.findElement(By.xpath("//div[text()='Successfully Saved']")).isDisplayed();
	}

}
