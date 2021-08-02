package com.qa.fts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.fts.utils.Constants;
import com.qa.fts.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	

	// 1. private By locators:

	private By loginid = By.id("UserID");
	private By password = By.id("Password");
	private By newUserRegisterLink = By.linkText("New User");
	private By newProjectrequestLink = By.linkText("New Project request");
	private By forgotPwdlink = By.linkText("Forget Password");
	private By signin = By.xpath("//button[@type='submit']");

	// 2. constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}

	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}

	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdlink);
	}

	public DashBoardpage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(loginid, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(signin);
		return new DashBoardpage(driver);
	}

	public NewUserRegisterPage navigateToNewUserRegisterPage() {
		elementUtil.doClick(newUserRegisterLink);
		return new NewUserRegisterPage(driver);
	}

	
}
