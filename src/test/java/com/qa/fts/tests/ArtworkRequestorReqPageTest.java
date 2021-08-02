package com.qa.fts.tests;

import org.testng.annotations.BeforeClass;

import com.qa.fts.base.BaseTest;

public class ArtworkRequestorReqPageTest extends BaseTest {

	@BeforeClass
	public void ArtReqSetup() {
		DBpage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
}
