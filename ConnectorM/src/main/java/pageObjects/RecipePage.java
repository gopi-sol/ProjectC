package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class RecipePage extends BaseClass {

	
ElementUtil utils = new ElementUtil(driver);
	
	public RecipePage() {
		PageFactory.initElements(driver, this);
	}
	
	By sourceToSolidRegular =By.xpath("//span[text()='Source system to Solid Online (B>A)']");
	
	By solidToTargetRegular =By.xpath("//span[text()='Solid Online to target system (B>A)']");
	
	By sourceToSolidActive = By.xpath("//span[contains(text(),' Source system to Solid Online (B>A) -')]");
	
	By solidToTargetActive = By.xpath("//span[contains(text(),' Solid Online to target system (B>A) - ')]");
	
	public By getSolidToTargetActive() {
		return solidToTargetActive;
	}

	By sysSettingsBrowserBtn2 = By.xpath("(//img[@tabindex='1'])[2]");
	
	By sysSettingsBrowserBtn3 = By.xpath("(//img[@tabindex='1'])[3]");
	
	By intervalType = By.xpath("(//select[@tabindex='2'])[2]");
	
	By saveBtn =By.xpath("//input[@id='btnSave']");
	
	By goBtn =  By.xpath("//input[@id='btnGO']");
	
	By intervalTextbox = By.xpath("//input[@tabindex='3']");
	
	By intervalTextboxDropdown = By.xpath("//select[@tabindex='4']");
	
	By attempt1 = By.xpath("(//input[@tabindex='32'])[2]");
	
	By monday = By.xpath("//input[@tabindex='15']");
	
	By tuesday = By.xpath("//input[@tabindex='16']");
	
	By wednesday = By.xpath("//input[@tabindex='17']");
	
	By thursday = By.xpath("//input[@tabindex='18']");
	
	public By getMonday() {
		return monday;
	}

	public By getTuesday() {
		return tuesday;
	}

	public By getWednesday() {
		return wednesday;
	}

	public By getThursday() {
		return thursday;
	}

	public By getFriday() {
		return friday;
	}

	public By getSaturday() {
		return saturday;
	}

	public By getSunday() {
		return sunday;
	}

	By friday = By.xpath("//input[@tabindex='19']");
	
	By saturday = By.xpath("//input[@tabindex='20']");
	
	By sunday = By.xpath("(//input[@tabindex='21'])[2]");
	
	
	public By getAttempt1() {
		return attempt1;
	}

	public By getAttempt1Dropdown() {
		return attempt1Dropdown;
	}

	public By getAttempt2() {
		return attempt2;
	}

	public By getAttempt2Dropdown() {
		return attempt2Dropdown;
	}

	public By getAttempt3() {
		return attempt3;
	}

	public By getAttempt3Dropdown() {
		return attempt3Dropdown;
	}

	By attempt1Dropdown = By.xpath("(//select[@tabindex='33'])[2]");
	
	By attempt2 = By.xpath("(//input[@tabindex='34'])[2]");
	
	By attempt2Dropdown = By.xpath("(//select[@tabindex='35'])[2]");
	
	By attempt3 = By.xpath("(//input[@tabindex='36'])[2]");
	
	By attempt3Dropdown = By.xpath("(//select[@tabindex='37'])[2]");
	
	public By getIntervalTextboxDropdown() {
		return intervalTextboxDropdown;
	}

	public By getIntervalTextbox() {
		return intervalTextbox;
	}

	public By getGoBtn() {
		return goBtn;
	}

	public By getSysSettingsBrowserBtn1() {
		return sysSettingsBrowserBtn2;
	}

	public By getSaveBtn() {
		return saveBtn;
	}

	public By getIntervalType() {
		return intervalType;
	}

	public By getSysSettingsBrowserBtn2() {
		return sysSettingsBrowserBtn3;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getSourceToSolidActive() {
		return sourceToSolidActive;
	}

	public By getSourceToSolidRegular() {
		return sourceToSolidRegular;
	}

	public By getSolidToTargetRegular() {
		return solidToTargetRegular;
	}

	
	
}
