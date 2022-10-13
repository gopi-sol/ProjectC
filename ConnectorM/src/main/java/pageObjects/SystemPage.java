package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class SystemPage extends BaseClass {

ElementUtil utils = new ElementUtil(driver);
	
	public SystemPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="lblHdr3")
	WebElement Username;
	
	public WebElement getUsername() {
		return Username;
	}

	public By getMasterData() {
		return masterData;
	}

	public By getSystems() {
		return systems;
	}

	By masterData = By.id("lblHeaderStamgegevens");
	
	By systems = By.xpath("//*[@id=\"ModuleNieuwDiv\"]/a[32]");
	
	By pageheader = By.xpath("//div[@id='headerDiv']/div[@class='pageHeader makeInline']");
	
	By addnewbutton = By.xpath("//input[@id='BtnNew']");
	
	By selectsystem = By.xpath("//*[@id=\"FreeField67\"]");
	
	By timezone = By.xpath("//*[@id=\"FreeField72\"]");
	
	By responsetype =  By.xpath("//*[@id='FreeField64']");
	
	By field =  By.xpath("//*[@id='FreeField66']");
	
	By Savebtn =  By.xpath("//*[@id=\"btnSave\"]");
	
	By selectLanguage = By.xpath("//select[@id='ddlLanguage']");
	
	By description = By.xpath("//input[@id='txtDescription']");
	
	By PopupSaveBtn = By.xpath("//*[@id=\"btnSave\"]");
	
	public By getPopupSaveBtn() {
		return PopupSaveBtn;
	}

	public By getSelectLanguage() {
		return selectLanguage;
	}

	public By getDescription() {
		return description;
	}

	public By getSavebtn() {
		return Savebtn;
	}

	public By getField() {
		return field;
	}

	public By getResponsetype() {
		return responsetype;
	}

	public By getTimezone() {
		return timezone;
	}

	public By getSelectsystem() {
		return selectsystem;
	}

	public By getAddnewbutton() {
		return addnewbutton;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getPageheader() {
		return pageheader;
	}

	public void clickSystems() {
		 driver.switchTo().defaultContent();
		 utils.doMoveToElement(masterData);
		 utils.waitForElementToBeClickable(systems, 20);
		 utils.doMoveToElementAndClick(systems);
		 

	}
	
}
