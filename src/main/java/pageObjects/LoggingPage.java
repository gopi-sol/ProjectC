package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class LoggingPage extends BaseClass {

	static ElementUtil utils = new ElementUtil(driver);
	
	public LoggingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	By testGoBA = By.xpath("//input[@id='btnGOba']");
	
	By refresh = By.xpath("//input[@id='btnRefresh']");
	
	By firstDay = By.xpath("//input[@id='txtStartDate']");
	
	By Type = By.xpath("//select[@id='ddlType']");
	
	By entity  = By.xpath("//input[@id='txtEntity']");
	
	By taskTextBox = By.xpath("//input[@id='txtTask']");
	
	By documentTextBox = By.xpath("//input[@id='txtDocument']");
	
	By descriptionTextBox = By.xpath("//input[@id='txtDescription']");
	
	By batchId = By.xpath("//input[@id='txtBatchID']");
	
	By subjectDropdown = By.xpath("//select[@id='ddlSubject']");
	
	By statusDropdown = By.xpath("//select[@id='ddlStatus']");
	
	By systemSettings = By.xpath("//select[@id='ddlSystemSettings']");
	
public void clearLogging() {
		
		utils.waitForElementToBeClickable(Type, 30);
		utils.doSelectValuesByIndex(Type, 0);
//		utils.waitForElementToBeClickable(subjectDropdown, 30);
//		utils.doSelectValuesByIndex(subjectDropdown, 0);
		utils.waitForElementToBeClickable(statusDropdown, 30);
		utils.doSelectValuesByValue(statusDropdown, "");
		utils.waitForElementToBeClickable(systemSettings, 30);
		utils.doSelectValuesByIndex(systemSettings, 0);
//		utils.waitForElementToBeClickable(batchId, 30);
//		utils.doSelectValuesByIndex(batchId, 0);
//		utils.waitForElementToBeClickable(taskTextBox, 30);
//		utils.doSelectValuesByIndex(taskTextBox, 0);
		utils.waitForElementToBeClickable(entity, 30);
		utils.doSelectValuesByIndex(entity, 0);
		utils.waitForElementToBeClickable(descriptionTextBox, 30);
		utils.doSelectValuesByIndex(descriptionTextBox, 0);
		utils.waitForElementToBeClickable(documentTextBox, 30);
		utils.doSelectValuesByIndex(documentTextBox, 0);
		
		
	}
	
	
	public By getSystemSettings() {
		return systemSettings;
	}


	public By getStatusDropdown() {
		return statusDropdown;
	}


	public By getSubjectDropdown() {
		return subjectDropdown;
	}

	public By getBatchId() {
		return batchId;
	}

	public By getDescriptionTextBox() {
		return descriptionTextBox;
	}

	public By getDocumentTextBox() {
		return documentTextBox;
	}

	public By getTaskTextBox() {
		return taskTextBox;
	}

	public By getEntity() {
		return entity;
	}

	By document = By.xpath("//span[@id='lblDocument']");
	
	By freeFields = By.xpath("//table[@id='table14System.String[]']/tbody/tr");
	
	  By personalDetailspartner = By.xpath("//table[@id='table13System.String[]']/tbody/tr");


	public By getFreeFields() {
		return freeFields;
	}
	
	public By getPersonalDetailspartner() {
		return personalDetailspartner;
	}
	
	By logTable = By.xpath("//table[@id='tblsourceImportToolLog']/tbody/tr");
	
	By peopleStatus = By.xpath("//span[@id='FreeField14']");
	
	By peopleExportStatus = By.xpath("//span[@id='FreeField168']");
	
	By peopleTitle = By.xpath("//span[@id='title']");
	
	By peopleSalutation = By.xpath("//span[@id='FreeField120']");
	
	By peopleInitials = By.xpath("//span[@id='initial']");
	
	By peopleFirstNames = By.xpath("//span[@id='FreeField22']");
	
	By peopleFirstName  = By.xpath("//span[@id='FreeField162']");
	
	By peopleMiddleName = By.xpath("//span[@id='FreeField163']");
	
	By peopleSurName = By.xpath("//span[@id='FreeField164']");
	
	By peopleBirthNameMiddleName = By.xpath("//span[@id='FreeField13']");
	
	By peopleFullName = By.xpath("//span[@id='FullName']");
	
	By peopleDateOfBirth = By.xpath("//span[@id='DateOfBirth']");
	
	By peoplePlaceOfBirth = By.xpath("//span[@id='BirthPlace']");
	
	By peopleCountryOfBirth = By.xpath("//span[@id='FreeField121']");
	
	By peopleNationality = By.xpath("//span[@id='FreeField123']");
	
	By peopleLanguage = By.xpath("//span[@id='FreeField170']");
	
	By peopleFreeField12 = By.xpath("//span[@id='FreeField186']");
	
	By peopleFreeField21 = By.xpath("//span[@id='FreeField200']");
	
	By peopleFreeField22 = By.xpath("//span[@id='FreeField201']");
	
	By peopleFreeField23 = By.xpath("//span[@id='FreeField202']");
	
	By peopleFreeField24 = By.xpath("//span[@id='FreeField203']");
	
	By peopleFreeField25 = By.xpath("//span[@id='FreeField204']");
	
	By peopleFreeField26 = By.xpath("//span[@id='FreeField205']");
	
	By peopleFreeField27 = By.xpath("//span[@id='FreeField206']");
	
	By homeAdrsFO1 = By.xpath("//span[@id='FreeField2']");
	
	By homeAdrsFO2 = By.xpath("//span[@id='FreeField3']");
	
	By homeAdrsFOG = By.xpath("//span[@id='FreeField4']");
	
	By homeAdrsBO1 = By.xpath("//span[@id='FreeField5']");
	
	By homeAdrsBO2 = By.xpath("//span[@id='FreeField6']");
	
	By homeAdrsBOG = By.xpath("//span[@id='FreeField7']");
	
	By homeAdrsStName = By.xpath("//span[@id='Line1']");
	
	By homeAdrsNumber = By.xpath("//span[@id='Line2']");
	
	By homeAdrsAddition = By.xpath("//span[@id='Line3']");
	
	By homeAdrsPsCode = By.xpath("//span[@id='PostCode']");
	
	By homeAdrsCity = By.xpath("//span[@id='City']");
	
	By homeAdrsFlAdrs = By.xpath("//span[@id='FreeField8']");
	
	By homeAdrsRegion = By.xpath("//span[@id='FreeField9']");
	
	By homeAdrsCountry = By.xpath("//span[@id='FreeField10']");
	
	By homeAdrsDes = By.xpath("//span[@id='FreeField19']");
	
	By homeAdresBackBtn = By.xpath("//input[@id='btnCancel']");
	
	By personalDetails = By.xpath("//table[@id='table01System.String[]']/tbody/tr");
	
	By addressType = By.xpath("//span[@id='TypeID']");
	
	public By getAddressType() {
		return addressType;
	}


	public By getPersonalDetails() {
		return personalDetails;
	}


	public By getType() {
		return Type;
	}
	

	public By getHomeAdrsStName() {
		return homeAdrsStName;
	}


	public By getHomeAdrsNumber() {
		return homeAdrsNumber;
	}


	public By getHomeAdrsAddition() {
		return homeAdrsAddition;
	}


	public By getHomeAdrsPsCode() {
		return homeAdrsPsCode;
	}


	public By getHomeAdrsCity() {
		return homeAdrsCity;
	}


	public By getHomeAdrsFlAdrs() {
		return homeAdrsFlAdrs;
	}


	public By getHomeAdrsRegion() {
		return homeAdrsRegion;
	}


	public By getHomeAdrsCountry() {
		return homeAdrsCountry;
	}


	public By getHomeAdrsDes() {
		return homeAdrsDes;
	}


	public By getHomeAdresBackBtn() {
		return homeAdresBackBtn;
	}


	public By getHomeAdrsFO2() {
		return homeAdrsFO2;
	}


	public By getHomeAdrsFOG() {
		return homeAdrsFOG;
	}


	public By getHomeAdrsBO1() {
		return homeAdrsBO1;
	}


	public By getHomeAdrsBO2() {
		return homeAdrsBO2;
	}


	public By getHomeAdrsBOG() {
		return homeAdrsBOG;
	}
static By pageheader = By.xpath("//div[@id='headerDiv']/div[2]");

	public By getPageheader() {
	return pageheader;
}


	static By addresses = By.xpath("//div[@id='Div_4']/div[2]/div/table/tbody/tr");
	
//	By adressesSibling = By.xpath("//a[contains(@href,'EntityId=Kbwtt')]//following::td[1]");
	
	By homeAddressRef =By.xpath("//table[@id='table00System.String[]']/tbody/tr");
	
	By addressGeneral = By.xpath("//table[@id='table01System.String[]']/tbody/tr");
	
	By addressAudit = By.xpath("//table[@id='table02System.String[]']/tbody/tr");
	
	public By getAddressAudit() {
		return addressAudit;
	}


	public By getAddressGeneral() {
		return addressGeneral;
	}


	public By getHomeAddressRef() {
		return homeAddressRef;
	}


	public By getHomeAdrsFO1() {
		return homeAdrsFO1;
	}


	public By getAddresses() {
		return addresses;
	}

	

	public By getPeopleFreeField22() {
		return peopleFreeField22;
	}

	public By getPeopleFreeField23() {
		return peopleFreeField23;
	}

	public By getPeopleFreeField24() {
		return peopleFreeField24;
	}

	public By getPeopleFreeField25() {
		return peopleFreeField25;
	}

	public By getPeopleFreeField26() {
		return peopleFreeField26;
	}

	public By getPeopleFreeField27() {
		return peopleFreeField27;
	}

	public By getPeopleFreeField21() {
		return peopleFreeField21;
	}

	public By getPeopleFreeField12() {
		return peopleFreeField12;
	}

	public By getPeopleLanguage() {
		return peopleLanguage;
	}

	public By getPeopleNationality() {
		return peopleNationality;
	}


	public By getPeopleCountryOfBirth() {
		return peopleCountryOfBirth;
	}


	public By getPeoplePlaceOfBirth() {
		return peoplePlaceOfBirth;
	}


	public ElementUtil getUtils() {
		return utils;
	}


	public By getPeopleDateOfBirth() {
		return peopleDateOfBirth;
	}


	public By getPeopleFullName() {
		return peopleFullName;
	}


	public By getPeopleBirthNameMiddleName() {
		return peopleBirthNameMiddleName;
	}


	public By getPeopleSurName() {
		return peopleSurName;
	}


	public By getPeopleMiddleName() {
		return peopleMiddleName;
	}


	public By getPeopleFirstName() {
		return peopleFirstName;
	}


	public By getPeopleFirstNames() {
		return peopleFirstNames;
	}


	public By getPeopleInitials() {
		return peopleInitials;
	}


	public By getPeopleSalutation() {
		return peopleSalutation;
	}


	public By getPeopleTitle() {
		return peopleTitle;
	}


	public By getPeopleExportStatus() {
		return peopleExportStatus;
	}


	public By getDocument() {
		return document;
	}


	public By getPeopleStatus() {
		return peopleStatus;
	}


	public By getFirstDay() {
		return firstDay;
	}

	
	public By getLogTable() {
		return logTable;
	}

	public By getRefresh() {
		return refresh;
	}

	public By getTestGoBA() {
		return testGoBA;
	}
	
	public static List<WebElement> findingColumns(List<WebElement> locator) {
		List<WebElement> columns = utils.getElement(addresses).findElements(By.tagName("td"));
	return columns;
	}
	
	

	
}
