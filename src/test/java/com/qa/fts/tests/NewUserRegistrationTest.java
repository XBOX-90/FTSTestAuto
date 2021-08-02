package com.qa.fts.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.fts.base.BaseTest;
import com.qa.fts.utils.Constants;
import com.qa.fts.utils.ExcelUtil;

public class NewUserRegistrationTest extends BaseTest {

	@BeforeClass
	public void setupuserRegistration() {
		userRegistrationPage = loginPage.navigateToNewUserRegisterPage();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}

	public String getRandomNumber() {
		Random randomGenerator = new Random();
		String email = "testautomation" + randomGenerator.nextInt(1000) + "@gmail.com";
		return email;
	}

	
	  @Test public void userRegistrationTest() {
	  Assert.assertTrue(userRegistrationPage.newUserRegistration("Prakhar",
	  "PrakharSWIE", "123qwe", "123qwe", "prakhar.Srivastava@idemia.com")); }
	 

	/*
	 * @Test public void userRegistrationTest() {
	 * Assert.assertTrue(userRegistrationPage.newUserRegistration()); // Add
	 * Argument }
	 */
}
