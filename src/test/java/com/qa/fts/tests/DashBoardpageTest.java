package com.qa.fts.tests;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.fts.base.BaseTest;
import com.qa.fts.utils.Constants;
import com.qa.fts.utils.Error;

public class DashBoardpageTest extends BaseTest {

	@BeforeClass
	public void DBpageSetup() {
		DBpage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void DBpageTitleTest() {
		String DBtitle = DBpage.getDBPageTitle();
		System.out.println("DashBoard page title is: " + DBtitle);
		Assert.assertEquals(DBtitle, Constants.DASHBOARD_PAGE_TITLE);
	}

	@Test
	public void userNameTest() {
		String LoginUserName = DBpage.getwlcmUserName();
		System.out.println("Logged in username is : " + LoginUserName);
		Assert.assertEquals(LoginUserName, Constants.DASHBOARD_PAGE_USER);
	}

	@Test
	public void projectListTest() {
		List<String> projectsList = DBpage.getProjectsList();
		projectsList.stream().forEach(e -> System.out.println(e));

		Collections.sort(Constants.EXP_DB_PROJECT_LIST);
		Assert.assertEquals(projectsList, Constants.EXP_DB_PROJECT_LIST, "Projects List are not Matching");

	}

	@Test
	public void logOutLinkTest() {
		Assert.assertTrue(DBpage.isLogoutExist(), Error.LOGOUT_LINK_NOT_PRESENT);
	}

}
