package com.qa.fts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.fts.utils.Constants;
import com.qa.fts.utils.ElementUtil;

public class NewUserRegisterPage {

	private ElementUtil elementUtil;

	private By loginId = By.id("UserId");
	private By userName = By.id("UserName");
	private By password = By.id("Password");
	private By confpassword = By.id("RePassword");
	private By email = By.id("Email");
	private By designation = By.id("DesignationId");
	private By mobile = By.id("MobileNo");
	private By extension = By.id("Extention");
	private By gID = By.id("GID");
	private By empID = By.id("EmployeeID");
	private By project = By.id("ProjectId");
	private By role = By.id("RoleID");
	private By department = By.id("DepartmentID");
	private By level = By.id("LevelId");
	private By rptMgr = By.id("iReportingUserId");
	private By reset = By.id("btnReset");
	private By loginLink = By.id(".fa-angle-double-left");
	private By submit = By.id("btnSubmit");
	private By reqCreatedMsg = By.cssSelector(".alert-dismissible");

	public NewUserRegisterPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}

	public boolean newUserRegistration(String loginId, String userName, String password, String confpassword,
			String email) {
		elementUtil.doSendKeys(this.loginId, loginId);
		elementUtil.doSendKeys(this.userName, userName);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confpassword, confpassword);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSelectDropDownByVisibleText(designation, "Manager");
		elementUtil.doSelectDropDownByVisibleText(project, "FTS");
		elementUtil.doSelectDropDownByVisibleText(department, "SWIE");

		elementUtil.doClick(submit);

		String mesg = elementUtil.waitForElementVisible(reqCreatedMsg, 5).getText();
		System.out.println("Registration Validation OTP Creaion : " + mesg);

		if (mesg.contains(Constants.USER_OTP_CREATION_MESSG)) {
			elementUtil.doClick(loginLink);
			return true;
		}

		return false;

	}

}
