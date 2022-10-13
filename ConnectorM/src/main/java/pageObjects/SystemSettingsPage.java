package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class SystemSettingsPage extends BaseClass {
ElementUtil utils = new ElementUtil(driver);
	
	public SystemSettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	By systemBrowser = By.xpath("//input[@id='btnSystemEntity']");
	
	By descTextBox = By.xpath("//input[@id='txtDescription']");
	
	public By getDescTextBox() {
		return descTextBox;
	}
	
	By pageHeader = By.xpath("//div[@class='pageHeader makeInline']");

	

	By descBrowser = By.xpath("//input[@id='btnSystemSettingBrowser']");
	
	By saveBtn = By.xpath("//input[@id='btnSave']");
	
	By Masterdata = By.xpath("//span[@id='lblMaster']");
	
	By addMasterdata = By.xpath("//input[@id='btnAddMasterData']");
	
	By activateBtn = By.xpath("//input[@id='btnActive']");
	
	By deactivateBtn = By.xpath("//input[@id='btnDeactive']");
	
	By refreshBtn = By.xpath("//input[@id='btnRefreshgv']");
	
	By topic = By.xpath("//select[@id='ddTopic']");
	
	By subTopic = By.xpath("//select[@id='ddSubTopic']");
	
	By masterdataDesc = By.xpath("//textarea[@id='txtDescriptionSSD']");
	
	By masterSystemBrowser = By.xpath("//input[@id='masterSystemEntityBrowser']");
	
	By transportMechanism = By.xpath("//select[@id='ddTransportmechanism']");
	
	By accessInfoBrowser = By.xpath("//input[@id='accessInformationBrowser']");
	
	By type = By.xpath("//select[@id='ddType']");
	
	By httpMethod = By.xpath("//select[@id='ddHttpMethod']");
	
	By order = By.xpath("//select[@id='ddOrder']");
	
	By fileName = By.xpath("//input[@id='txtOutFileName']");
	
	public By getFileName() {
		return fileName;
	}

	public By getSubOrder() {
		return subOrder;
	}

	By subOrder = By.xpath("//select[@id='ddSubOrder']");
	
	By mappingTemplateBrowser = By.xpath("//input[@id='mappingTemplateBrowser']");
	
	By inFolderTextbox = By.xpath("//input[@id='txtInFolder']");
	
	By outFolderTextbox = By.xpath("//input[@id='txtInFolder']");
	
	By requestUrl = By.xpath("//textarea[@id='txtRequestURL']");
	
	By masterdataSaveBtn = By.xpath("//input[@id='MasterDataSave']");
	
	By saveRefPath= By.xpath("//input[@id='chkUpdateReference']");
	
	By donotMoveDeletefile = By.xpath("//input[@id='chkDonotMoveFile']");
	
	public By getDonotMoveDeletefile() {
		return donotMoveDeletefile;
	}

	public By getSaveRefPath() {
		return saveRefPath;
	}

	public By getPageHeader() {
		return pageHeader;
	}

	public By getAddMasterdata() {
		return addMasterdata;
	}

	public By getActivateBtn() {
		return activateBtn;
	}

	public By getDeactivateBtn() {
		return deactivateBtn;
	}

	public By getRefreshBtn() {
		return refreshBtn;
	}

	public By getTopic() {
		return topic;
	}

	public By getSubTopic() {
		return subTopic;
	}

	public By getMasterdataDesc() {
		return masterdataDesc;
	}

	public By getMasterSystemBrowser() {
		return masterSystemBrowser;
	}

	public By getTransportMechanism() {
		return transportMechanism;
	}

	public By getAccessInfoBrowser() {
		return accessInfoBrowser;
	}

	public By getType() {
		return type;
	}

	public By getHttpMethod() {
		return httpMethod;
	}

	public By getOrder() {
		return order;
	}

	public By getMappingTemplateBrowser() {
		return mappingTemplateBrowser;
	}

	public By getInFolderTextbox() {
		return inFolderTextbox;
	}

	public By getOutFolderTextbox() {
		return outFolderTextbox;
	}

	public By getRequestUrl() {
		return requestUrl;
	}

	public By getMasterdataSaveBtn() {
		return masterdataSaveBtn;
	}
	

	public By getMasterdata() {
		return Masterdata;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getSystemBrowser() {
		return systemBrowser;
	}

	public By getDescBrowser() {
		return descBrowser;
	}

	public By getSaveBtn() {
		return saveBtn;
	}
	
}
