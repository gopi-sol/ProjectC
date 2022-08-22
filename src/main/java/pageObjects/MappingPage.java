package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class MappingPage extends BaseClass {

	
ElementUtil utils = new ElementUtil(driver);
	
	public MappingPage() {
		PageFactory.initElements(driver, this);
	}
	
	By mappingBrowser = By.xpath("//input[@id='imgTemplate']");

	By popupSelect1st = By.xpath("//table[@id='gvBrowse']/tbody/tr[2]/td[1]");
	
	By popupFrame = By.xpath("//iframe[@id='popupFrameDraggable']");
	

	By mappingSearchBox = By.xpath("//input[@id='browSearch']");
	
	By mappingSearchBtn = By.xpath("//input[@id='Search']");
	
	By pageHeader = By.xpath("//div[@id='pnlMain']/div/p");
	
	By exportBtn = By.xpath("//input[@id='BtnxmlExport']");
	
	By mappingSetting = By.xpath("//div[@id='imgHeading']");
	
	By logOut = By.xpath("//a[@id='hypLogin']");
	
	By popupCloseBtn = By.xpath("(//div[@id='popupControls'])[2]/img[@id='popCloseBox']");
	
<<<<<<< HEAD
	By deleteBtn = By.xpath("//input[@id='btnDelete']");
	
	public By getDeleteBtn() {
		return deleteBtn;
	}

=======
>>>>>>> 3beb93f127be57a33e6dcf85db0324785fec86a9
	public By getPopupCloseBtn() {
		return popupCloseBtn;
	}

	public By getLogOut() {
		return logOut;
	}

	By logOff = By.xpath("//a[@id='hypDelegation']");

	public By getLogOff() {
		return logOff;
	}

	public By getMappingSetting() {
		return mappingSetting;
	}

	public By getExportBtn() {
		return exportBtn;
	}

	public By getPageHeader() {
		return pageHeader;
	}

	public By getMappingSearchBox() {
		return mappingSearchBox;
	}

	public By getMappingSearchBtn() {
		return mappingSearchBtn;
	}

	public By getPopupSelect1st() {
		return popupSelect1st;
	}

	public By getPopupFrame() {
		return popupFrame;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getMappingBrowser() {
		return mappingBrowser;
	}
}
