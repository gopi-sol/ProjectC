package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class CopytoolPage extends BaseClass {
	
ElementUtil utils = new ElementUtil(driver);
	
	public CopytoolPage() {
		PageFactory.initElements(driver, this);
	}
	
	By pageHeader = By.xpath("//div[@id='headerDiv']/div[@class='pageHeader makeInline']");
	
	By targetServer = By.xpath("//select[@id='ddlTrgtSQLType']");
	
	By sourceMandantBrowser = By.xpath("//input[@id='imgSrcMandantFind']");
	
	By sysSettingsBrowser = By.xpath("//input[@id='imgSrcSysSettingsFind']");
	
	By targetMandantBrowser = By.xpath("//input[@id='ImgDestMandantFind']");
	
	By copytoolBtn = By.xpath("//input[@id='btnCopy']");
	
	By copyTranslationTable = By.xpath("//input[@id='chkCopyfreeentity14s']");
	
			

	public By getCopyTranslationTable() {
		return copyTranslationTable;
	}

	public By getCopytoolBtn() {
		return copytoolBtn;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getPageHeader() {
		return pageHeader;
	}

	public By getTargetServer() {
		return targetServer;
	}

	public By getSourceMandantBrowser() {
		return sourceMandantBrowser;
	}

	public By getSysSettingsBrowser() {
		return sysSettingsBrowser;
	}

	public By getTargetMandantBrowser() {
		return targetMandantBrowser;
	}
	
	
	

}
