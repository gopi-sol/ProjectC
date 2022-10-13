package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class PopupHandle extends BaseClass{
ElementUtil utils = new ElementUtil(driver);
	
	public PopupHandle() {
		PageFactory.initElements(driver, this);
	}
	
	By popupFrame = By.xpath("//iframe[@id='popupFrameDraggable']");

	By SearchBox = By.xpath("//input[@id='browSearch']");
	
	By SearchBtn = By.xpath("//input[@id='Search']");
	
	By popupSelect1st = By.xpath("//table[@id='gvBrowse']/tbody/tr[2]/td[1]");

	public ElementUtil getUtils() {
		return utils;
	}

	public By getPopupSelect1st() {
		return popupSelect1st;
	}

	public By getPopupFrame() {
		return popupFrame;
	}

	public By getSearchBox() {
		return SearchBox;
	}

	public By getSearchBtn() {
		return SearchBtn;
	}
	
	
}
