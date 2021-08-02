package com.qa.fts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.fts.utils.ElementUtil;

public class ArtworkRequestorReqPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By searchbar = By.xpath("//input[@name='RequestNo']");
	private By newRequest = By.linkText("New Request");
	private By FFitem = By.id("FullfillmentItemID");
	private By customerName = By.id("CustomerID");
	private By schemeID = By.id("SchemeID");
	private By productName = By.id("ProductID");
	private By FTSproject = By.cssSelector(".stickerbox div#ordbatdiv img");

	// FF_Item -> FLYER
	private By paperGSM = By.name("PaperGSM");
	private By paper = By.name("Paper");
	private By openSize = By.name("OpenSize");
	private By closeSize = By.name("CloseSize");
	private By coating = By.name("Coating");
	private By printing = By.name("Printing");
	private By axcode = By.name("Axcode");
	private By remarks = By.id("Remarks");
	private By submit = By.xpath("//button[@type='button']");

	public ArtworkRequestorReqPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}

	
	public void FTSprojectClick() {
		elementUtil.doClick(FTSproject);
	}
	
	public ArtworkRequestorReqPage createArtworkRequest() {
//String customerName, String schemeID, String productName, String FFitem
		elementUtil.doClick(newRequest);
		elementUtil.doSelectDropDownByVisibleText(customerName, "HDFC1");
		elementUtil.doSelectDropDownByVisibleText(schemeID, "GOLD");
		elementUtil.doSelectDropDownByVisibleText(productName, "VPI");
		elementUtil.doSelectDropDownByVisibleText(FFitem, "FLYER");

		elementUtil.doSendKeys(paperGSM, "A");
		elementUtil.doSendKeys(paper, "B");
		elementUtil.doSendKeys(openSize, "C");
		elementUtil.doSendKeys(closeSize, "D");
		elementUtil.doSendKeys(coating, "E");
		elementUtil.doSendKeys(printing, "F");
		elementUtil.doSendKeys(axcode, "G");
		elementUtil.doSendKeys(remarks, "By Automation Script");
		elementUtil.doActionsClick(submit);

		return new ArtworkRequestorReqPage(driver);

		// IF "Request created Successfully" then - Done
	}

}
