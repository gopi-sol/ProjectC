package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class AccessInformationPage extends BaseClass {
	
	
ElementUtil utils = new ElementUtil(driver);
	
	public AccessInformationPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public ElementUtil getUtils() {
		return utils;
	}
	
	By pageHeader = By.xpath("//div[@id='headerDiv']/div[@class='pageHeader makeInline']");
	
	By type = By.xpath("//select[@id='ddlType']");
	
	By newButton = By.xpath("//input[@id='BtnNew']");
	
	By descBrowser = By.xpath("//img[@id='Locale']");
	
	By selectLanguage = By.xpath("//select[@id='ddlLanguage']");
	
	By popupSaveBtn = By.xpath("//img[@id='btnSave']");
	
	By clientId = By.xpath("//input[@id='FreeField2']");
	
	By clientSecret = By.xpath("//input[@id='FreeField3']");
	
	By accessToken = By.xpath("//input[@id='FreeField5']");
	
	By refreshToken = By.xpath("//input[@id='FreeField16']");
	
	By useToken = By.xpath("//input[@id='FreeField7']");
	
	By grantType = By.xpath("//select[@id='FreeField10']");
	
	By contentType = By.xpath("//select[@id='FreeField11']");
	
	By accessTokenType = By.xpath("//select[@id='FreeField12']");
	
	By accessTokenExpirationDate = By.xpath("//input[@id='FreeField13']");
	 
	By sftpUrl = By.xpath("//input[@id='FreeField17']");
	
	By accessInformationType = By.xpath("//img[@id='TypeID']");
	
	By port = By.xpath("//input[@id='FreeField18']");
	
	By saveBtn = By.xpath("//input[@id='btnSave']");
	
	By solidCode = By.xpath("//input[@id='Code']");
	
	public By getSolidCode() {
		return solidCode;
	}

	public By getSaveBtn() {
		return saveBtn;
	}

	public By getSftpUrl() {
		return sftpUrl;
	}

	
	public By getPort() {
		return port;
	}

	public By getAccessToken() {
		return accessToken;
	}

	public By getRefreshToken() {
		return refreshToken;
	}

	public By getUseToken() {
		return useToken;
	}

	public By getGrantType() {
		return grantType;
	}

	public By getContentType() {
		return contentType;
	}

	public By getAccessTokenType() {
		return accessTokenType;
	}

	public By getAccessTokenExpirationDate() {
		return accessTokenExpirationDate;
	}

	public By getAccessInformationType() {
		return accessInformationType;
	}

	public By getClientSecret() {
		return clientSecret;
	}

	public By getClientId() {
		return clientId;
	}

	public By getPopupSaveBtn() {
		return popupSaveBtn;
	}

	public By getSelectLanguage() {
		return selectLanguage;
	}

	public By getDescBrowser() {
		return descBrowser;
	}

	public By getNewButton() {
		return newButton;
	}

	public By getType() {
		return type;
	}

	public By getPageHeader() {
		return pageHeader;
	}

	
}
