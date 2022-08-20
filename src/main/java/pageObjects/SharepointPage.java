package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class SharepointPage extends BaseClass {
	
	
ElementUtil utils = new ElementUtil(driver);
	
	public SharepointPage() {
		PageFactory.initElements(driver, this);
	}
By username = By.xpath("//input[@id='i0116']");

By password = By.xpath("//input[@id='i0118']");

By submit = By.xpath("//input[@type='submit']");

By myFiles = By.xpath("//span[contains(text(),'My files')]");

By folders = By.xpath("//button[@data-automationid='FieldRenderer-name']");

By New = By.xpath("//span[contains(text(),'New')]");

By folder = By.xpath("//span[contains(text(),'Folder')]");

By createFolder = By.xpath("//span[contains(text(),'Create')]");

By signout = By.xpath("//div[@id='O365_HeaderRightRegion']/div[1]");

public By getSignout() {
	return signout;
}

public By getCreateFolder() {
	return createFolder;
}

public By getFolderName() {
	return folderName;
}
By testFolder = By.xpath("//button[contains(text(),'Test')]");

By folderName = By.xpath("//input[@aria-label='Enter your folder name']");

public By getTestFolder() {
	return testFolder;
}

public By getNew() {
	return New;
}

public By getFolder() {
	return folder;
}

public By getMyFiles() {
	return myFiles;
}

public By getFolders() {
	return folders;
}

public By getUsername() {
	return username;
}

public By getPassword() {
	return password;
}

public By getSubmit() {
	return submit;
}

}
