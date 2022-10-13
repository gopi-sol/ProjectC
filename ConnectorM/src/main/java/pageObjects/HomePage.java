package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;
import testUtils.ElementUtil;

public class HomePage extends BaseClass {

	
ElementUtil utils = new ElementUtil(driver);
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="lblHdr3")
	WebElement Username;
	
	@FindBy(xpath="//input[@aria-controls='tblHourSummary']")
	WebElement textBox;
	
	By modules= By.id("lblheaderModules");
	
	By masterData = By.id("lblHeaderStamgegevens");
	
	By statusCodes = By.xpath("//a[text()='Statuscodes']");
	
	By mapping = By.xpath("//a[@href='Authenticate/Mapping/HRXmlConnectivityNew.aspx']");
	
	By systemSetting = By.xpath("//a[@href='Authenticate/SystemSetting/SystemSetting.aspx']");
	
	By accessInformation = By.xpath("//a[text()='Access informations']|//a[text()='Toegangsinformaties']");
	
	public By getStatusCodes() {
		return statusCodes;
	}

	public By getAccessInformation() {
		return accessInformation;
	}

	public By getSystems() {
		return systems;
	}

	By logging = By.xpath("//a[@href='Authenticate/Common/Logging.aspx']");
	
	By mandantBrowser = By.xpath("//input[@id='btnMandantBrowser']");
	
	By mandantSearchBox = By.xpath("//input[@id='browSearch']");
	
	By mandantSearchBtn = By.xpath("//input[@id='Search']");
	
	By popupSelect1st = By.xpath("//table[@id='gvBrowse']/tbody/tr[2]/td[1]");
	
	By popupFrame = By.xpath("//iframe[@id='popupFrameDraggable']");
	
//	@FindBy(xpath="//a[@href='Authenticate/Invoice/CockpitNew.aspx']")
//	WebElement cockPit;
	
	By logOff = By.xpath("//a[@id='hypDelegation']");
	
	By logOut =By.xpath("//a[@id='hypLogin']");

	public By getLogOut() {
		return logOut;
	}

	public By getRelations() {
		return relations;
	}

	public By getCopytool() {
		return copytool;
	}

	By popupCloseBtn = By.xpath("(//div[@id='popupControls'])[2]/img[@id='popCloseBox']");
	
	By popupTitle = By.xpath("//div[@id='popupTitle']");
	
	By mappingCleanUpLogging = By.xpath("//a[@href='Authenticate/MappingCleanupLog.aspx']");
	
	By userName = By.xpath("//span[@id='lblHdr3']");
	
	By systems = By.xpath("//a[text()='Systems']|//a[text()='Systemen']");
	
	By relations = By.xpath("//a[text()='Relations']");
	
	By copytool = By.xpath("//a[text()='Copytool']");
	
	public By getUserName() {
		return userName;
	}

	public By getLogging() {
		return logging;
	}
	
	public By getSystemSetting() {
		return systemSetting;
	}

	public By getMappingCleanUpLogging() {
		return mappingCleanUpLogging;
	}

	public By getPopupTitle() {
		return popupTitle;
	}

	public By getPopupCloseBtn() {
		return popupCloseBtn;
	}

	public By getLogOff() {
		return logOff;
	}
	
	public By getPopupFrame() {
		return popupFrame;
	}

	public By getPopupSelect1st() {
		return popupSelect1st;
	}

	public By getMandantSearchBtn() {
		return mandantSearchBtn;
	}

	public By getMandantSearchBox() {
		return mandantSearchBox;
	}

	public By getMandantBrowser() {
		return mandantBrowser;
	}

	@FindBy(id="drplstEntity")
	WebElement Entitydroplist;
	
	By pageHeader = By.xpath("//div[@class='pageHeader makeInline']");
	
//	@FindBy(xpath="//*[@id=\"headerDiv\"]/div[2]")
//	WebElement pageHeader;
	
	@FindBy(xpath="//a[@id='hypLogin']")
	WebElement SignOut;
	
	
	public ElementUtil getUtils() {
		return utils;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getTextBox() {
		return textBox;
	}

	public By getModules() {
		return modules;
	}

	public By getMasterData() {
		return masterData;
	}

	

	public WebElement getEntitydroplist() {
		return Entitydroplist;
	}
	
	

//	public WebElement getpageHeader() {
//		return pageHeader;
//	}

	public WebElement getSignOut() {
		return SignOut;
	}


	public void HomePagecheck() throws IOException {
		
		String pagelogo = driver.getTitle();
		if (pagelogo.equals("Solid Online")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Unsuccessful");
			Assert.assertEquals(pagelogo, "Solid Online");
		}
		
		
	}
	public void clickMapping() {
		 
		 driver.switchTo().defaultContent();
		 utils.waitForElementToBeClickable(modules, 30);
		 utils.doMoveToElement(modules);
		 utils.waitForElementToBeClickable(mapping, 20);
		 utils.doMoveToElementAndClick(mapping);

	}
	public void clickStatusCodes() {
		 
		 driver.switchTo().defaultContent();
		 utils.doMoveToElement(masterData);
		 utils.waitForElementToBeClickable(statusCodes, 20);
		 utils.doMoveToElementAndClick(statusCodes);

	}
	
	public void clickAccessInformation() {
		 
		 driver.switchTo().defaultContent();
		 utils.doMoveToElement(masterData);
		 utils.waitForElementToBeClickable(accessInformation, 20);
		 utils.doMoveToElementAndClick(accessInformation);

	}
	
	
	public void clickSystems() {
		
		 driver.switchTo().defaultContent();
		 utils.doMoveToElement(masterData);
		 utils.waitForElementToBeClickable(systems, 20);
		 utils.doMoveToElementAndClick(systems);
	}
	
	public void clickLogging() {
		 driver.switchTo().defaultContent();
		 utils.doMoveToElement(modules);
		 utils.waitForElementToBeClickable(logging, 20);
		 utils.doMoveToElementAndClick(logging);


	}
	public void UserNamevalidations() {
    	
		String users = Username.getText();
		Assert.assertEquals(users, "Charlie  Works,Charlie Works");
		
    }
	
	public void clickSystemSetting() {
		driver.switchTo().defaultContent();
		 utils.doMoveToElement(modules);
		 utils.waitForElementToBeClickable(systemSetting, 20);
		 utils.doMoveToElementAndClick(systemSetting);

	}
	
	public void clickMappingCleanUpLogging() {
		driver.switchTo().defaultContent();
		 utils.doMoveToElement(modules);
		 utils.waitForElementToBeClickable(mappingCleanUpLogging, 20);
		 utils.doMoveToElementAndClick(mappingCleanUpLogging);

	}
	
	public void clickRelations() {
		driver.switchTo().defaultContent();
		 utils.doMoveToElement(masterData);
		 utils.waitForElementToBeClickable(relations, 20);
		 utils.doMoveToElementAndClick(relations);

	}
	
	public void clickCopytool() {
		driver.switchTo().defaultContent();
		 utils.waitForElementToBeClickable(modules, 30);
		 utils.doMoveToElement(modules);
		 utils.waitForElementToBeClickable(copytool, 20);
		 utils.doMoveToElementAndClick(copytool);

	}


	public void Logout() {
		utils.doJsClick(SignOut);

	}
	
	 public By getPageHeader() {
		return pageHeader;
	}

	
	public By getMapping() {
		return mapping;
	}

	private List<WebElement> modulesList;
	
	public List<WebElement> getModulesList() {
		driver.findElements(By.xpath("//div[@class='col_1']//a[@target='mainwindow']"));
		
		return modulesList;
	}
	
	
}