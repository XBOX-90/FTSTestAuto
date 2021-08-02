package com.qa.fts.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.fts.utils.Constants;
import com.qa.fts.utils.ElementUtil;

public class DashBoardpage {

	private ElementUtil elementUtil;
	private LoginPage loginPage;
	public Properties prop;
	
	private By projectLinks = By.xpath("//div[@id='ordbatdiv']");
	private By sparkleLogo = By.xpath("//img[@src='/Images/SparkleLogo.png']");
	private By logoutLink = By.tagName("strong");
	private By wlcmuser = By.xpath("//span[.='Welcome tarun ']");

	
	public DashBoardpage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}

	public String getDBPageTitle() {
		return elementUtil.waitForTitle(5, Constants.DASHBOARD_PAGE_TITLE);
	}

	public String getDBPageURL() {
		return elementUtil.getPageUrl();
	}

	public String getwlcmUserName() {
		return elementUtil.doGetText(wlcmuser);
	}

	public List<String> getProjectsList() {
		List<String> projectsName = new ArrayList<String>();
		List<WebElement> projectsList = elementUtil.waitForVisibilityOfElements(projectLinks, 5);
		for (WebElement e : projectsList) {
			projectsName.add(e.getText());
		}
		Collections.sort(projectsName);
		return projectsName;
	}

	public boolean isLogoutExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}

	public void navigateToArtworkRequestorReqPage() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
}
