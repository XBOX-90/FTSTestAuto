package com.qa.fts.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.fts.factory.DriverFactory;
import com.qa.fts.pages.ArtworkRequestorReqPage;
import com.qa.fts.pages.DashBoardpage;
import com.qa.fts.pages.LoginPage;
import com.qa.fts.pages.NewUserRegisterPage;

public class BaseTest {

	DriverFactory df;
	private WebDriver driver;
	public Properties prop;

	public LoginPage loginPage;
	public DashBoardpage DBpage;
	public ArtworkRequestorReqPage ArtReqpage;
    public NewUserRegisterPage userRegistrationPage;
	
	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", browserName); // To set Browser property from testNG
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}