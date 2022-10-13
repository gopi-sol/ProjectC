package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class StatusCodePage extends BaseClass{
ElementUtil utils = new ElementUtil(driver);
	
	public StatusCodePage() {
		PageFactory.initElements(driver, this);
	
}
	By pageHeader = By.xpath("//div[@id='headerDiv']/div[@class='pageHeader makeInline']");
	
	By type = By.xpath("//select[@id='ddlType']");
	
	By newButton = By.xpath("//input[@id='BtnNew']");
	
	By statusCodeHTTP = By.xpath("//input[@id='FreeField1']");
	
	By statusCodeText = By.xpath("//input[@id='FreeField2']");
	
	By saveButton = By.xpath("//input[@id='btnSave']");

	By systemSelection = By.xpath("//img[@id='FreeEntity19sID']");
	
	By popupBrowserSearch = By.xpath("//input[@id='browSearch']");
	
	By searchSystem = By.xpath("//input[@id='Search']");
	
	By systemCode = By.xpath("//table[@id='gvBrowse']");
	
	By btnSelect = By.xpath("//input[@id='btnSelect']");
			
			
	public By getBtnSelect() {
		return btnSelect;
	}
	public By getSystemCode() {
		return systemCode;
	}
	public By getSearchSystem() {
		return searchSystem;
	}
	
	public By getPopupBrowserSearch() {
		return popupBrowserSearch;
	}
	public By getSystemSelection() {
		return systemSelection;
	}
	public By getSaveButton() {
		return saveButton;
	}
	public By getStatusCodeText() {
		return statusCodeText;
	}
	public By getStatusCodeHTTP() {
		return statusCodeHTTP;
	}
	public By getNewButton() {
		return newButton;
	}
	public By getType() {
		return type;
	}
	public ElementUtil getUtils() {
		return utils;
	}
	public By getPageHeader() {
		return pageHeader;
	}
	
}
