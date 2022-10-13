package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class RelationsPage extends BaseClass  {
ElementUtil utils = new ElementUtil(driver);
	
	public RelationsPage() {
		PageFactory.initElements(driver, this);
	}
	
	By pageHeader = By.xpath("//div[@class='pageHeader makeInline']");
	
	By typeDropdown  = By.xpath("//select[@id='ddlType']");
	
	By newBtn = By.xpath("//input[@id='BtnNew']");
	
	By nameTextbox = By.xpath("//input[@id='AccountNames']");
	
	By saveBtn = By.xpath("//input[@id='btnSave']");
	
	By relationsTable = By.xpath("//table[@id='tblEnitityList']/tbody/tr");
	
	By recipeBtn = By.xpath("//input[@id='BtnRecipe']");
	
	 By refreshBtn =  By.xpath("//input[@id='BtnRefresh']");
	

	public By getRefreshBtn() {
		return refreshBtn;
	}

	public By getRecipeBtn() {
		return recipeBtn;
	}

	public By getRelationsTable() {
		return relationsTable;
	}

	public By getSaveBtn() {
		return saveBtn;
	}

	public By getNameTextbox() {
		return nameTextbox;
	}

	public By getNewBtn() {
		return newBtn;
	}

	public By getTypeDropdown() {
		return typeDropdown;
	}

	public ElementUtil getUtils() {
		return utils;
	}

	public By getPageHeader() {
		return pageHeader;
	}
	
}
