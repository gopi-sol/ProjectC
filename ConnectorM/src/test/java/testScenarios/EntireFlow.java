package testScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pageObjects.AccessInformationPage;
import pageObjects.CopytoolPage;
import pageObjects.HomePage;
import pageObjects.LoggingPage;
import pageObjects.LoginPage;
import pageObjects.MappingPage;
import pageObjects.PopupHandle;
import pageObjects.RecipePage;
import pageObjects.RelationsPage;
import pageObjects.StatusCodePage;

import pageObjects.SystemPage;
import pageObjects.SystemSettingsPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class EntireFlow extends BaseClass {

	LoginPage loginPage;
	MappingPage mappingPage;
	HomePage homePage;
	LoggingPage loggingPage;
	StatusCodePage statuscodePage;
	AccessInformationPage accessInformationPage;
	SystemSettingsPage systemSettingsPage;
	PopupHandle popupHandle;
	RelationsPage relationsPage;
	RecipePage recipePage;
	SystemPage systemPage;
	CopytoolPage copytoolPage;

	TestUtil tu;
	ElementUtil utils;

	static ExtentTest test;

	static ExtentReports report;

	static String filepathPT;

	@BeforeSuite
	public void startTest() {

		File f = new File("reports\\CompleteFlowProcess1.html");
		String absolutePath = f.getAbsolutePath();
		report = new ExtentReports(absolutePath);

	}

	@BeforeTest()
	public void setup() throws IOException {

		initialization("MappingRegression.xlsx");

		loginPage = new LoginPage();
		homePage = new HomePage();
		mappingPage = new MappingPage();
		loggingPage = new LoggingPage();
		statuscodePage = new StatusCodePage();
		accessInformationPage = new AccessInformationPage();
		systemSettingsPage = new SystemSettingsPage();
		popupHandle = new PopupHandle();
		relationsPage = new RelationsPage();
		recipePage =new RecipePage();
		systemPage = new SystemPage();
		copytoolPage = new CopytoolPage();
		
		tu = new TestUtil();
		utils = new ElementUtil(driver);

	}
	
	private static final String Sftp = "test";

	@Test(priority = 1)
	public void sftpImport() {
		
		test.log(LogStatus.INFO, "<b>" + "SFTP CONNECTION" + "</b>");
		
		String localPath = "/";
		String fileName = "test_json (3).json";
		String sftpPath = "/Training/vamshi/import/flowTest";
		String sftpHost = "51.144.240.121";
		String sftpPort = "22";
		String sftpUser = "soldevteam";
		String sftpPassword = "$ol@ftp@321";

		try

		{
			JSch jsch = new JSch();
			com.jcraft.jsch.Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(sftpPassword);
			
			session.connect();
			System.out.println("Connection Established");
			test.log(LogStatus.INFO, "<b>" + "SFTP Connection Established" + "</b>");
			Channel channel = session.openChannel("sftp");
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.connect();
			sftpChannel.put(localPath + fileName, sftpPath);
			System.out.println("File Transferred");
			test.log(LogStatus.INFO, "<b>" + "File Transferred" + "</b>");

			sftpChannel.disconnect();
			session.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	static List<WebElement> logRows, logColumns, addcolumn, AddressesRows, refRowColumns, refRows,auditRows,auditRowColumn, genRows, genRowColumns = null;
	static String text1;
	@Test(priority = 2)
	public void flowCheck() throws IOException, InterruptedException {

		urlLaunch("MappingRegression.xlsx");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingRegression.xlsx","Login", 1, 1),
				tu.getData("MappingRegression.xlsx", "Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));
			test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Log in success");
		} catch (Exception e) {

			try {
				String title1 = driver.getTitle();
				Assert.assertEquals(title, "Service Unavailable");
				test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Service Unavailable");

			} catch (Exception noSuchElementException) {

			}

		}

		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 1, 0));

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
		
		/* Language Setup 
		
		// driver.switchTo().frame("kop");
		// utils.waitForElementToBeClickable(driver.findElement(By.xpath("//a[@id='hypSettings']")),
		// 30);
		//
		// driver.findElement(By.xpath("//a[@id='hypSettings']")).click();
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("mainwindow");
		//
		// utils.waitForElementToBeClickable(driver.findElement(By.xpath("//input[@id='wizSettings_StartNavigationTemplateContainerID_btnStartNext']")),
		// 30);
		// driver.findElement(By.xpath("//input[@id='wizSettings_StartNavigationTemplateContainerID_btnStartNext']")).click();
		//
		// utils.waitForElementToBeClickable(driver.findElement(By.xpath("//input[@id='wizSettings_btnStepNext']")),
		// 30);
		// driver.findElement(By.xpath("//input[@id='wizSettings_btnStepNext']")).click();
		//
		// utils.waitForElementToBeClickable(driver.findElement(By.xpath("//input[@id='wizSettings_FinishNavigationTemplateContainerID_btnFinishNext']")),
		// 30);
		// driver.findElement(By.xpath("//input[@id='wizSettings_FinishNavigationTemplateContainerID_btnFinishNext']")).click();

		// homePage.clickMapping();

		// homePage.clickStatusCodes();
		// driver.switchTo().frame("mainwindow");
		// utils.getElement(statuscodePage.getPageHeader()).click();
		// utils.waitForElementToBeClickable(statuscodePage.getType(), 30);
		// utils.doSelectValuesByVisibleText(statuscodePage.getType(),
		// "Success");
		*/
		
		/*Source System Creation*/
		
		systemPage.clickSystems();
		driver.switchTo().frame("mainwindow");
		utils.doMoveToElementAndClick(systemPage.getPageheader());
		utils.waitForElementToBeClickable(systemPage.getAddnewbutton(), 30);
		
		utils.scrollIntoView(systemPage.getAddnewbutton());
		utils.doJsClick(systemPage.getAddnewbutton());
		// utils.getElement(systemPage.getAddnewbutton()).click();
		utils.waitForElementToBeClickable(systemPage.getSelectsystem(), 30);
		utils.doSelectValuesByVisibleText(systemPage.getSelectsystem(), "FTP/SFTP","FTP/SFTP");
		utils.doSelectValuesByVisibleText(systemPage.getTimezone(), "Amsterdam","Amsterdam");
		utils.doSelectValuesByVisibleText(systemPage.getResponsetype(), "XML","XML");
		utils.doSelectValuesByVisibleText(systemPage.getField(), "Front office code 1", "Front office code 1");

		/* Description */
		
		driver.findElement(By.xpath("//*[@id=\"Locale\"]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		driver.findElement(By.xpath("//input[@id='txtDescription']")).sendKeys("sftp_Test_Source");
		utils.waitForElementToBeClickable(driver.findElement(By.xpath("//input[@id='btnAdd']")), 30);
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		utils.waitForElementToBeClickable(systemPage.getSelectLanguage(), 30);
		utils.doSelectValuesByValue(systemPage.getSelectLanguage(), "en-GB");
		utils.getElement(systemPage.getDescription()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.waitForElementToBeClickable(systemPage.getPopupSaveBtn(), 30);
		utils.getElement(systemPage.getPopupSaveBtn()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemPage.getSavebtn(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Source System creation");

		/*Source System Saved */
		
		utils.getElement(systemPage.getSavebtn()).click();
		utils.waitForElementToBeClickable(systemPage.getAddnewbutton(), 30);
		
		
		/*Target System Creation*/
		
		systemPage.clickSystems();
		driver.switchTo().frame("mainwindow");
		utils.doMoveToElementAndClick(systemPage.getPageheader());
		utils.waitForElementToBeClickable(systemPage.getAddnewbutton(), 30);
		
		
		utils.scrollIntoView(systemPage.getAddnewbutton());
		utils.doJsClick(systemPage.getAddnewbutton());
		// utils.getElement(systemPage.getAddnewbutton()).click();
		utils.waitForElementToBeClickable(systemPage.getSelectsystem(), 30);
		utils.doSelectValuesByVisibleText(systemPage.getSelectsystem(), "FTP/SFTP","FTP/SFTP");
		utils.doSelectValuesByVisibleText(systemPage.getTimezone(), "UTC","UTC");
		utils.doSelectValuesByVisibleText(systemPage.getResponsetype(), "XML","XML");
		utils.doSelectValuesByVisibleText(systemPage.getField(), "Back office code 1", "Back office code 1");
		
		/* Description */
	
		driver.findElement(By.xpath("//*[@id=\"Locale\"]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		driver.findElement(By.xpath("//input[@id='txtDescription']")).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.waitForElementToBeClickable(driver.findElement(By.xpath("//input[@id='btnAdd']")), 30);
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		utils.waitForElementToBeClickable(systemPage.getSelectLanguage(), 30);
		utils.doSelectValuesByValue(systemPage.getSelectLanguage(), "en-GB");
		utils.getElement(systemPage.getDescription()).sendKeys("sftp_Test_target");
		utils.waitForElementToBeClickable(systemPage.getPopupSaveBtn(), 30);
		utils.getElement(systemPage.getPopupSaveBtn()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemPage.getSavebtn(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Target System creation");

		/*Target System Saved */
		
		utils.getElement(systemPage.getSavebtn()).click();
		utils.waitForElementToBeClickable(systemPage.getAddnewbutton(), 30);
		
		
		/*StatusCodes Creation and Linking*/
		
		homePage.clickStatusCodes();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getPageHeader(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "StatusCodes Screen");
		
		/*Success Codes*/
		
		utils.getElement(statuscodePage.getPageHeader()).click();
		utils.waitForElementToBeClickable(statuscodePage.getType(), 30);
		utils.doSelectValuesByVisibleText(statuscodePage.getType(), "Success","Succes");
		utils.waitForElementToBeClickable(statuscodePage.getNewButton(), 30);
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("200");
		
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Success");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Status code 200 creation");
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("201");
		
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Created");
		
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Status code 201 creation");
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		//Functional feedback
	
		utils.doSelectValuesByVisibleText(statuscodePage.getType(), "Functional feedback","Functionele feedback");
		utils.waitForElementToBeClickable(statuscodePage.getNewButton(), 30);
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("400");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Bad request");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Status code 400 creation");
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		/*
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("401");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Unauthorized");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("404");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("page not found");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("403");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Forbidden");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		

		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("412");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Unknown response");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		*/
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("500");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Internal Server Error");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Status code 500 creation");
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		//Technical error
		
		utils.doSelectValuesByVisibleText(statuscodePage.getType(), "Technical error","Technische fout");
		utils.waitForElementToBeClickable(statuscodePage.getNewButton(), 30);
		Thread.sleep(3000);
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("503");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("The service is unavailable");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Status code 503 creation");
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		/*
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("422");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Invalid");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("429");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Too many request");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("403");
		
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Forbidden");
		
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		

		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("401");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Unauthorized");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		
		
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("400");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("bad request");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
		utils.getElement(statuscodePage.getNewButton()).click();
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeHTTP(), 30);
		utils.getElement(statuscodePage.getStatusCodeHTTP()).sendKeys("404");
		utils.waitForElementToBeClickable(statuscodePage.getStatusCodeText(), 30);
		utils.getElement(statuscodePage.getStatusCodeText()).sendKeys("Not found");
		utils.getElement(statuscodePage.getSystemSelection()).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='popupFrameDraggable']")));
		//Source System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getPopupBrowserSearch()).clear();
		//Target System Search
		utils.getElement(statuscodePage.getPopupBrowserSearch()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(statuscodePage.getSearchSystem()).click();
		utils.getElement(statuscodePage.getSystemCode()).click();
		utils.getElement(statuscodePage.getBtnSelect()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
	
		utils.waitForElementToBeClickable(statuscodePage.getSaveButton(), 30);
		utils.getElement(statuscodePage.getSaveButton()).click();
			*/
		
		/* Access Information Creation */
		
		  homePage.clickAccessInformation();
		  driver.switchTo().frame("mainwindow");
		  utils.waitForElementToBeClickable(accessInformationPage.getPageHeader(),
				  30);
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  utils.getElement(accessInformationPage.getPageHeader()).click();
		  test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Access Information Screen");
		  utils.waitForElementToBeClickable(accessInformationPage.getType(),
		  30);
		  utils.doSelectValuesByVisibleText(accessInformationPage.getType(),
		  "SFTP","SFTP");
		  
		  utils.waitForElementToBeClickable(accessInformationPage.getNewButton(
		  ), 30);
		  
		 
//		 utils.getElement(accessInformationPage.getNewButton()).click();
		 utils.doJsClick(accessInformationPage.getNewButton());
		  
		  utils.getElement(accessInformationPage.getDescBrowser()).click();
		  driver.switchTo().frame(driver.findElement(By.xpath(
		  "//iframe[@id='popupFrameDraggable']")));
		  driver.findElement(By.xpath("//input[@id='txtDescription']")).
		  sendKeys(tu.getData("Entireflow.xlsx", "Access Information", 2, 1));
		  utils.waitForElementToBeClickable(driver.findElement(By.xpath(
		  "//input[@id='btnAdd']")), 30);
		  driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		  
		  utils.waitForElementToBeClickable(accessInformationPage.
		  getSelectLanguage(), 30);
		  utils.doSelectValuesByValue(accessInformationPage.getSelectLanguage()
		  , "en-GB");
		  driver.findElement(By.xpath("//input[@id='txtDescription']")).
		  sendKeys(tu.getData("Entireflow.xlsx", "Access Information", 2, 1));
		  
		  utils.waitForElementToBeClickable(accessInformationPage.
		  getPopupSaveBtn(), 30);
		  utils.getElement(accessInformationPage.getPopupSaveBtn()).click();
		  driver.switchTo().defaultContent();
		  driver.switchTo().frame("mainwindow");
		 utils.waitForElementToBeVisible(accessInformationPage.getSolidCode(),
		  30);
//		 utils.getElement(accessInformationPage.getSolidCode()).clear();
//		  utils.getElement(accessInformationPage.getSolidCode()).sendKeys(
//		  "1");
		  
		  utils.waitForElementToBeClickable(accessInformationPage.getSftpUrl(),
		  30); utils.getElement(accessInformationPage.getSftpUrl()).sendKeys(
				  tu.getData("Entireflow.xlsx", "Access Information", 3, 1));
		  
		  utils.waitForElementToBeClickable(accessInformationPage.getClientId()
		  , 30);
		  utils.getElement(accessInformationPage.getClientId()).sendKeys(
				  tu.getData("Entireflow.xlsx", "Access Information", 4, 1));
		  
		  utils.waitForElementToBeClickable(accessInformationPage.
		  getClientSecret(), 30);
		  utils.getElement(accessInformationPage.getClientSecret()).sendKeys(
				  tu.getData("Entireflow.xlsx", "Access Information", 5, 1));
		  
		  utils.waitForElementToBeClickable(accessInformationPage.getPort(),
		  30);
		  utils.getElement(accessInformationPage.getPort()).sendKeys(tu.getData("Entireflow.xlsx", "Access Information", 6, 1));
		 
		  utils.waitForElementToBeClickable(accessInformationPage.getSaveBtn(),
		  30); 
		  test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Access information Details");
		  utils.getElement(accessInformationPage.getSaveBtn()).click();
		

		/* Logging Off */
	
		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(mappingPage.getLogOff()).click();

		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gobinath1");

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
		/*
		homePage.clickMapping();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 30);
		utils.getElement(mappingPage.getPageHeader()).click();

		/* Regression_mapping _TEST_JSON_V1 *//* download */
		/*
		utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 30);
		utils.getElement(mappingPage.getMappingBrowser()).click();

		driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
		utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 30);
		utils.getElement(mappingPage.getMappingSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 1, 1));
		utils.getElement(mappingPage.getMappingSearchBtn()).click();
		utils.getElement(mappingPage.getPopupSelect1st()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeVisible(mappingPage.getExportBtn(), 30);
		utils.getElement(mappingPage.getExportBtn()).click();
		Thread.sleep(5000);

		File fm = new File(System.getProperty("user.dir") + File.separator + "Mappings");
		fm.mkdir();

		File f = new File(System.getProperty("user.dir") + File.separator + "Mappings" + File.separator + "Source");
		f.mkdir();

		String mappingName = tu.getData("Entireflow.xlsx", "Mapping Template", 1, 1);

		String absolutePathm = f.getAbsolutePath();

		StringSelection fileO = new StringSelection(absolutePathm + File.separator + mappingName);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO, null);

		Robot rb = null;

		try {
			rb = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		rb.setAutoDelay(2000); // Similar to thread.sleep

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.setAutoDelay(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		*/
		/* Regression_Export_mapping_test *//* download */
		/*
		utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 30);
		utils.getElement(mappingPage.getMappingBrowser()).click();

		driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
		utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 30);
		utils.getElement(mappingPage.getMappingSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 1, 2));
		utils.getElement(mappingPage.getMappingSearchBtn()).click();
		utils.getElement(mappingPage.getPopupSelect1st()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeVisible(mappingPage.getExportBtn(), 30);
		utils.getElement(mappingPage.getExportBtn()).click();
		Thread.sleep(5000);

		File fm1 = new File(System.getProperty("user.dir") + File.separator + "Mappings");
		fm1.mkdir();

		File f1 = new File(System.getProperty("user.dir") + File.separator + "Mappings" + File.separator + "Target");
		f1.mkdir();

		String mappingName1 = tu.getData("Entireflow.xlsx", "Mapping Template", 1, 2);

		String absolutePathm1 = f1.getAbsolutePath();

		StringSelection fileO1 = new StringSelection(absolutePathm1 + File.separator + mappingName1);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO1, null);

		Robot rb1 = null;

		try {
			rb1 = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		rb1.setAutoDelay(2000); // Similar to thread.sleep

		rb1.keyPress(KeyEvent.VK_CONTROL);
		rb1.keyPress(KeyEvent.VK_V);
		rb1.keyRelease(KeyEvent.VK_V);
		rb1.keyRelease(KeyEvent.VK_CONTROL);

		rb1.setAutoDelay(2000);

		rb1.keyPress(KeyEvent.VK_ENTER);
		rb1.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(mappingPage.getLogOff()).click();

		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 1, 0));

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
		
		/*Importing mapping template*/
		/*
		homePage.clickMapping();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 30);
		utils.getElement(mappingPage.getPageHeader()).click();
		utils.waitForElementToBeClickable(mappingPage.getImportBtn(), 30);

		utils.getElement(mappingPage.getImportBtn()).click();
		Thread.sleep(10000);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO1, null);

		Robot rb2 = null;

		try {
			rb2 = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		rb2.setAutoDelay(2000); // Similar to thread.sleep

		rb2.keyPress(KeyEvent.VK_CONTROL);
		rb2.keyPress(KeyEvent.VK_V);
		rb2.keyRelease(KeyEvent.VK_V);
		rb2.keyRelease(KeyEvent.VK_CONTROL);

		rb2.setAutoDelay(2000);
		
		rb2.keyPress(KeyEvent.VK_DOWN);
		rb2.keyRelease(KeyEvent.VK_DOWN);
		
		rb2.setAutoDelay(2000);
		rb2.keyPress(KeyEvent.VK_ENTER);
		rb2.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		utils.waitForElementToBeClickable(mappingPage.getMappingTemplateName(), 180);
		//Mapping Template name
		utils.getElement(mappingPage.getMappingTemplateName()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 2, 2));

		utils.waitForElementToBeClickable(mappingPage.getMappingSaveBtn(),30);
		utils.getElement(mappingPage.getMappingSaveBtn()).click();
		
		
		utils.waitForElementToBeClickable(mappingPage.getExportBtn(),180);
		test.log(LogStatus.PASS,
				test.addScreenCapture(getAScreenshot())
						+"Export Mapping Imported");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(mappingPage.getLogOff()).click();
		
		
		/*mapping export
		homePage.clickMapping();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 30);
		utils.getElement(mappingPage.getPageHeader()).click();
		utils.waitForElementToBeClickable(mappingPage.getImportBtn(), 30);
//		utils.getElement(mappingPage.getMappingBrowser()).click();

		utils.getElement(mappingPage.getImportBtn()).click();
		Thread.sleep(10000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO, null);

		Robot rb3 = null;

		try {
			rb3 = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}

		rb3.setAutoDelay(2000); // Similar to thread.sleep

		rb3.keyPress(KeyEvent.VK_CONTROL);
		rb3.keyPress(KeyEvent.VK_V);
		rb3.keyRelease(KeyEvent.VK_V);
		rb3.keyRelease(KeyEvent.VK_CONTROL);
		rb2.setAutoDelay(2000);
		
		rb2.keyPress(KeyEvent.VK_DOWN);
		rb2.keyRelease(KeyEvent.VK_DOWN);
		rb3.setAutoDelay(2000);

		rb3.keyPress(KeyEvent.VK_ENTER);
		rb3.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		utils.waitForElementToBeClickable(mappingPage.getMappingTemplateName(), 30);
		
		//Mapping Template name
		utils.getElement(mappingPage.getMappingTemplateName()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 2, 2));

		utils.waitForElementToBeClickable(mappingPage.getMappingSaveBtn(), 30);
		utils.getElement(mappingPage.getMappingSaveBtn()).click();
		
		utils.waitForElementToBeClickable(mappingPage.getExportBtn(), 120);
		test.log(LogStatus.PASS,
				test.addScreenCapture(getAScreenshot())
						+ "Mapping Exported");
						
						*/
		
		/*
		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(homePage.getLogOut()).click();
		driver.manage().deleteAllCookies();
		
		urlLaunch("MappingRegression.xlsx");

		String title2= driver.getTitle();

		if (title2.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingRegression.xlsx","Login", 1, 1),
				tu.getData("MappingRegression.xlsx", "Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));

		} catch (Exception e) {

			try {
				String title1 = driver.getTitle();
				Assert.assertEquals(title, "Service Unavailable");
				test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Service Unavailable");

			} catch (Exception noSuchElementException) {

			}

		}
		
		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gobinath");

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
		
		*/
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage.clickCopytool();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(copytoolPage.getPageHeader(), 30);
		utils.getElement(copytoolPage.getPageHeader()).click();
		
//		utils.waitForElementToBeClickable(copytoolPage.getSourceMandantBrowser(), 30);
//		utils.getElement(copytoolPage.getSourceMandantBrowser()).click();
		
//		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
//		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
//		
//		//Source system search
//		utils.getElement(popupHandle.getSearchBox()).sendKeys("Gobinath1");
//		utils.getElement(popupHandle.getSearchBtn()).click();
//		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
//		utils.getElement(popupHandle.getPopupSelect1st()).click();
//		
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame("mainwindow");
//		
		
		
		utils.waitForElementToBeClickable(copytoolPage.getTargetServer(), 30);
		utils.doSelectValuesByVisibleText(copytoolPage.getTargetServer(), "Test", "Test");
		
		utils.waitForElementToBeClickable(copytoolPage.getSysSettingsBrowser(), 30);
		utils.getElement(copytoolPage.getSysSettingsBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Source system settings search
		utils.getElement(popupHandle.getSearchBox()).sendKeys("Regression_mapping_test");
		

		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.findElement(By.xpath("//input[@id='btnSelect']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		//Regression_mapping_export_test
		
		utils.waitForElementToBeClickable(copytoolPage.getSysSettingsBrowser(), 30);
		utils.getElement(copytoolPage.getSysSettingsBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		utils.getElement(popupHandle.getSearchBox()).sendKeys("Regression_mapping_export_test");
		

		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.findElement(By.xpath("//input[@id='btnSelect']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		
		
		utils.waitForElementToBeClickable(copytoolPage.getTargetMandantBrowser(), 30);
		utils.getElement(copytoolPage.getTargetMandantBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Source system search
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 1, 0));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		

		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(copytoolPage.getCopyTranslationTable(), 30);
		utils.getElement(copytoolPage.getCopyTranslationTable()).click();
		
		utils.waitForElementToBeClickable(copytoolPage.getCopytoolBtn(), 30);
		utils.getElement(copytoolPage.getCopytoolBtn()).click();
		
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Import Mapping via Copytool");
		
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(10000);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(mappingPage.getLogOff()).click();

		
		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 1, 0));

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
		
		
		/*Source System Settings*/
		
		homePage.clickSystemSetting();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemSettingsPage.getPageHeader(), 30);
		utils.getElement(systemSettingsPage.getPageHeader()).click();
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "System Settings Screen");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getSystemBrowser(), 30);
		utils.getElement(systemSettingsPage.getSystemBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Source system search
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemSettingsPage.getDescTextBox(), 30);
		//Source system Description
		utils.getElement(systemSettingsPage.getDescTextBox()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 1, 1));
		utils.getElement(systemSettingsPage.getSaveBtn()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterdata(), 30);
		utils.getElement(systemSettingsPage.getMasterdata()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getAddMasterdata(), 30);
		utils.getElement(systemSettingsPage.getAddMasterdata()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getTopic(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getTopic(),"Candidate", "Kandidaat");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterSystemBrowser(), 30);
		utils.getElement(systemSettingsPage.getMasterSystemBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		//Target System search in Topic
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 1));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getTransportMechanism(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getTransportMechanism(),"SFTP", "SFTP");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getAccessInfoBrowser(), 30);
		utils.getElement(systemSettingsPage.getAccessInfoBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Access Info search
		utils.getElement(popupHandle.getSearchBox()).sendKeys("soldevteam");
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getType(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getType(),"GET", "GET");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getOrder(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getOrder(),"1", "1");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMappingTemplateBrowser(), 30);
		utils.getElement(systemSettingsPage.getMappingTemplateBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//mapping template search
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 2, 1));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getDonotMoveDeletefile(), 30);
		utils.getElement(systemSettingsPage.getDonotMoveDeletefile()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getInFolderTextbox(), 30);
		utils.getElement(systemSettingsPage.getInFolderTextbox()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 2, 1));
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterdataSaveBtn(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Source System Settings creation");
		utils.getElement(systemSettingsPage.getMasterdataSaveBtn()).click();
		
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Source System Settings"
				);
		Thread.sleep(5000);
//		Thread.sleep(10000);
//		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		/*Target System Settings*/
		
		homePage.clickSystemSetting();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemSettingsPage.getPageHeader(), 30);
		utils.getElement(systemSettingsPage.getPageHeader()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getSystemBrowser(), 30);
		utils.getElement(systemSettingsPage.getSystemBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Target system search
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(systemSettingsPage.getDescTextBox(), 30);
		
		//Target system Description
		
		utils.waitForElementToBeClickable(systemSettingsPage.getDescTextBox(), 30);
		utils.getElement(systemSettingsPage.getDescTextBox()).sendKeys("FlowTestSFTP_Target");
		utils.getElement(systemSettingsPage.getSaveBtn()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterdata(), 30);
		utils.getElement(systemSettingsPage.getMasterdata()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getAddMasterdata(), 30);
		utils.getElement(systemSettingsPage.getAddMasterdata()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getTopic(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getTopic(),"Candidate", "Kandidaat");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterSystemBrowser(), 30);
		utils.getElement(systemSettingsPage.getMasterSystemBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//Target System search in Topic
		
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System", 2, 2));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getTransportMechanism(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getTransportMechanism(),"SFTP", "SFTP");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getAccessInfoBrowser(), 30);
		utils.getElement(systemSettingsPage.getAccessInfoBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		//Access info search
		utils.getElement(popupHandle.getSearchBox()).sendKeys("soldevteam");
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getType(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getType(),"INSERT", "INSERT");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getOrder(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getOrder(),"1", "1");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getSubOrder(), 30);
		utils.doSelectValuesByVisibleText(systemSettingsPage.getSubOrder(),"1", "1");
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMappingTemplateBrowser(), 30);
		utils.getElement(systemSettingsPage.getMappingTemplateBrowser()).click();
		
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		
		//mapping template search
		
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "Mapping Template", 2, 2));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		
		utils.waitForElementToBeClickable(systemSettingsPage.getFileName(), 30);
		utils.getElement(systemSettingsPage.getFileName()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 3, 2));
		
		utils.waitForElementToBeClickable(systemSettingsPage.getOutFolderTextbox(), 30);
		utils.getElement(systemSettingsPage.getOutFolderTextbox()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 2, 2));
		
		utils.waitForElementToBeClickable(systemSettingsPage.getSaveRefPath(), 30);
		utils.getElement(systemSettingsPage.getSaveRefPath()).click();
		
		utils.waitForElementToBeClickable(systemSettingsPage.getMasterdataSaveBtn(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Target System Settings creation");
		utils.getElement(systemSettingsPage.getMasterdataSaveBtn()).click();
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Target System Settings");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*Relations-activating supplier in new Mandant*/
	
		Thread.sleep(5000);
		homePage.clickRelations();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(relationsPage.getPageHeader(),45);
		Thread.sleep(3000);
		utils.getElement(relationsPage.getPageHeader()).click();
		utils.waitForElementToBeClickable(relationsPage.getTypeDropdown(),45);
		utils.doSelectValuesByVisibleText(relationsPage.getTypeDropdown(), "Supplier", "Supplier");
		
		utils.waitForElementToBeClickable(relationsPage.getNewBtn(),45);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Relations Screen");
		utils.getElement(relationsPage.getNewBtn()).click();
		
		
		utils.waitForElementToBeClickable(relationsPage.getNameTextbox(),45);
		utils.getElement(relationsPage.getNameTextbox()).sendKeys("Auto_test");
		
		utils.waitForElementToBeClickable(relationsPage.getSaveBtn(),45);
		utils.getElement(relationsPage.getSaveBtn()).click();
		
		
		utils.waitForElementToBeClickable(relationsPage.getRefreshBtn(),45);
		utils.getElement(relationsPage.getRefreshBtn()).click();
		
		Thread.sleep(5000);
		
		utils.waitForElementToBeVisible(relationsPage.getRelationsTable(),45);
		
		List<WebElement> relationsList = driver.findElements(relationsPage.getRelationsTable());
		System.out.println(relationsList.size());
		for (int i = 0; i < relationsList.size(); i++) {
			System.out.println(i);
			List<WebElement> relationsColumn = relationsList.get(i).findElements(By.tagName("td"));
			
			if (relationsColumn.get(1).getText().equals("Auto_test")) {
				
				WebElement element = relationsColumn.get(0).findElement(By.tagName("a"));
				
				element.click();

				break;
			}
			
		}
test.log(LogStatus.INFO, "<b>" + "SFTP CONNECTION" + "</b>");
		
		String localPath = "/";
		String fileName = "test_json (3).json";
		String sftpPath = "/Training/vamshi/import/flowTest";
		String sftpHost = "51.144.240.121";
		String sftpPort = "22";
		String sftpUser = "soldevteam";
		String sftpPassword = "$ol@ftp@321";

		try

		{
			JSch jsch = new JSch();
			com.jcraft.jsch.Session session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(sftpPassword);
			
			session.connect();
			System.out.println("Connection Established");
			test.log(LogStatus.INFO, "<b>" + "SFTP Connection Established" + "</b>");
			Channel channel = session.openChannel("sftp");
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.connect();
			sftpChannel.put(localPath + fileName, sftpPath);
			System.out.println("File Transferred");
			test.log(LogStatus.INFO, "<b>" + "File Transferred" + "</b>");

			sftpChannel.disconnect();
			session.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*Recipe Settings*/
		
		
		utils.waitForElementToBeClickable(relationsPage.getRecipeBtn(), 60);
		utils.getElement(relationsPage.getRecipeBtn()).click();
		
		utils.waitForElementToBeClickable(recipePage.getSourceToSolidRegular(), 60);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Recipe Settings Screen");
		utils.getElement(recipePage.getSourceToSolidRegular()).click();
		
		utils.waitForElementToBeClickable(recipePage.getSourceToSolidActive(), 60);
		utils.getElement(recipePage.getSourceToSolidActive()).click();
		
		String attribute = utils.getElement(recipePage.getSourceToSolidActive()).findElement(By.xpath("preceding-sibling::*[2]")).getAttribute("type");
		System.out.println(utils.getElement(recipePage.getSourceToSolidActive()).findElement(By.xpath("preceding-sibling::*[1]")).getAttribute("type"));
		System.out.println(attribute);
		
		
		if (attribute.equals("checkbox")) {
			utils.getElement(recipePage.getSourceToSolidActive()).findElement(By.xpath("preceding-sibling::*[2]")).click();
		}
		
		utils.waitForElementToBeClickable(recipePage.getSysSettingsBrowserBtn1(), 60);
		utils.getElement(recipePage.getSysSettingsBrowserBtn1()).click();
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 1, 1));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(recipePage.getIntervalType(), 30);
		
		
		utils.doSelectValuesByVisibleText(recipePage.getIntervalType(), "Tijdsinterval", "Tijdsinterval");
		
		
		utils.waitForElementToBeClickable(recipePage.getIntervalTextbox(), 30);
		utils.getElement(recipePage.getIntervalTextbox()).sendKeys("1");
		
		utils.waitForElementToBeClickable(recipePage.getIntervalTextbox(), 30);
		utils.doSelectValuesByVisibleText(recipePage.getIntervalTextboxDropdown(), "Minuut / Minuten", "Minuut / Minuten");
		
		utils.waitForElementToBeClickable(recipePage.getMonday(), 30);
		utils.getElement(recipePage.getMonday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getTuesday(), 30);
		utils.getElement(recipePage.getTuesday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getWednesday(), 30);
		utils.getElement(recipePage.getWednesday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getThursday(), 30);
		utils.getElement(recipePage.getThursday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getFriday(), 30);
		utils.getElement(recipePage.getFriday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getSaturday(), 30);
		utils.getElement(recipePage.getSaturday()).click();
		
		utils.waitForElementToBeClickable(recipePage.getSunday(), 30);
		utils.getElement(recipePage.getSunday()).click();
		
		
		utils.waitForElementToBeClickable(recipePage.getAttempt1(), 30);
		utils.getElement(recipePage.getAttempt1()).sendKeys("30");
		
		utils.waitForElementToBeClickable(recipePage.getAttempt1Dropdown(), 30);
		utils.doSelectValuesByVisibleText(recipePage.getAttempt1Dropdown(), "Seconde / Seconden", "Seconde / Seconden");
		
		utils.waitForElementToBeClickable(recipePage.getAttempt2(), 30);
		utils.getElement(recipePage.getAttempt2()).sendKeys("30");
		
		utils.waitForElementToBeClickable(recipePage.getAttempt2Dropdown(), 30);
		utils.doSelectValuesByVisibleText(recipePage.getAttempt2Dropdown(), "Seconde / Seconden", "Seconde / Seconden");
		
		utils.waitForElementToBeClickable(recipePage.getAttempt3(), 30);
		utils.getElement(recipePage.getAttempt3()).sendKeys("30");
		
		utils.waitForElementToBeClickable(recipePage.getAttempt3Dropdown(), 30);
		utils.doSelectValuesByVisibleText(recipePage.getAttempt3Dropdown(), "Seconde / Seconden", "Seconde / Seconden");
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Source Recipe Settings");
		utils.waitForElementToBeClickable(recipePage.getSolidToTargetRegular(), 60);
		utils.getElement(recipePage.getSolidToTargetRegular()).click();
		
		
		String attribute1 = utils.getElement(recipePage. getSolidToTargetActive()).findElement(By.xpath("preceding-sibling::*[2]")).getAttribute("type");
		
		if (attribute1.equals("checkbox")) {
			
			utils.getElement(recipePage. getSolidToTargetActive()).findElement(By.xpath("preceding-sibling::*[2]")).click();
		}
		
		utils.waitForElementToBeClickable(recipePage.getSysSettingsBrowserBtn2(), 60);
		utils.getElement(recipePage.getSysSettingsBrowserBtn2()).click();
		driver.switchTo().frame(utils.getElement(popupHandle.getPopupFrame()));
		utils.waitForElementToBeClickable(popupHandle.getSearchBox(), 30);
		utils.getElement(popupHandle.getSearchBox()).sendKeys(tu.getData("Entireflow.xlsx", "System Settings", 1, 2));
		utils.getElement(popupHandle.getSearchBtn()).click();
		utils.waitForElementToBeClickable(popupHandle.getPopupSelect1st(), 30);
		utils.getElement(popupHandle.getPopupSelect1st()).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainwindow");
		
		utils.waitForElementToBeClickable(recipePage.getSaveBtn(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Target Recipe Settings");
		utils.getElement(recipePage.getSaveBtn()).click();
		
		utils.waitForElementToBeClickable(relationsPage.getRecipeBtn(), 60);
		utils.getElement(relationsPage.getRecipeBtn()).click();
		
		utils.waitForElementToBeClickable(recipePage.getSourceToSolidRegular(), 60);

		utils.getElement(recipePage.getSourceToSolidRegular()).click();
		
		try {
			
			utils.waitForElementToBeClickable(recipePage.getGoBtn(), 30);
			utils.getElement(recipePage.getGoBtn()).click();
			
		} catch (Exception e) {
			
		}
		
		
		
		Thread.sleep(5000);
		
		/*Logging Screen*/
		/*Final*/
		
		homePage.clickLogging();
		driver.switchTo().frame("mainwindow");
		utils.doMoveToElementAndClick(loggingPage.getDocument());
//		loggingPage.clearLogging();
		// utils.getElement(loggingPage.getFirstDay()).clear();
		// utils.waitForElementToBeClickable(loggingPage.getFirstDay(), 90);
		// utils.getElement(loggingPage.getFirstDay()).sendKeys("18-07-2022");

		// utils.getElement(loggingPage.getEntity()).clear();
		// utils.getElement(loggingPage.getEntity()).sendKeys("309983");
		
		utils.waitForElementToBeClickable(loggingPage.getTestGoBA(), 30);
		test.log(LogStatus.PASS, test.addScreenCapture(entireScreenshot()) + "Logging Screen"
				);
		Thread.sleep(5000);
//		utils.getElement(loggingPage.getTestGoAB()).click();
//		utils.waitForElementToBeClickable(loggingPage.getSupplierBtn(), 30);
//		utils.getElement(loggingPage.getSupplierBtn()).click();
		
		utils.waitForElementToBeClickable(loggingPage.getRefresh(), 30);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.waitForElementToBeClickable(loggingPage.getRefresh(), 30);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.waitForElementToBeClickable(loggingPage.getRefresh(), 30);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.waitForElementToBeClickable(loggingPage.getRefresh(), 30);
		utils.getElement(loggingPage.getRefresh()).click();

		utils.waitForElementToBeClickable(loggingPage.getLogTable(), 30);
		logRows = driver.findElements(loggingPage.getLogTable());
		
		
		for (int i = 0; i < logRows.size(); i++) {

			logColumns = logRows.get(i).findElements(By.tagName("td"));

			if (logColumns.get(0).getText().equals("Export") && logColumns.get(1).getText().equals("Candidate")
					&& logColumns.get(3).getText().contains("FTP/SFTP responds 200")) {
				String text = logColumns.get(5).getText();
				logColumns.get(5).click();
				Thread.sleep(5000);
				
				File f3 = new File(System.getProperty("user.dir") + File.separator + "Tfiles");
				f3.mkdir();
				String absolutePath = f3.getAbsolutePath();
				
				filepathPT = absolutePath+ File.separator + text;
				StringSelection filePT = new StringSelection(filepathPT);

				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePT, null);

				Robot rbt = null;

				try {
					rbt = new Robot();
				} catch (AWTException e) {
					
					e.printStackTrace();
				}

				rbt.setAutoDelay(2000); // Similar to thread.sleep

				rbt.keyPress(KeyEvent.VK_CONTROL);
				rbt.keyPress(KeyEvent.VK_V);

				rbt.keyRelease(KeyEvent.VK_V);
				rbt.keyRelease(KeyEvent.VK_CONTROL);

				rbt.setAutoDelay(2000);

				rbt.keyPress(KeyEvent.VK_ENTER);
				rbt.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
			} 

		}
		

		for (int i = 0; i < logRows.size(); i++) {

			logColumns = logRows.get(i).findElements(By.tagName("td"));

			if (logColumns.get(0).getText().equals("Import") && logColumns.get(1).getText().equals("Candidate")
					&& logColumns.get(3).getText().contains("Sftp task created successfully for candidate data")) {
				utils.scrollIntoView(logColumns.get(0));
				Thread.sleep(3000);
				test.log(LogStatus.PASS, test.addScreenCapture(entireScreenshot()) + "Logging Screen -Process"
						);
//				logColumns.get(6).click();
				break;
			} 

		}
		
		utils.scrollIntoView(loggingPage.getPersonalDetails());
		utils.waitForElementToBeClickable(loggingPage.getPersonalDetails(), 90);
		List<WebElement> personalDetailsRows = driver.findElements(loggingPage.getPersonalDetails());

		for (int i = 0; i < personalDetailsRows.size(); i++) {

			List<WebElement> pDColumns = personalDetailsRows.get(i).findElements(By.tagName("td"));
			int rowLength = tu.getRowLength("MappingRegression.xlsx","Source");

			int lastCellNum = tu.getLastCellNum("MappingRegression.xlsx","Source", rowLength);

			for (int k = 1; k < rowLength; k++) {

				for (int j = 0; j < pDColumns.size(); j++) {

					if (pDColumns.get(j).getText().trim().replace(" ", "")
							.equalsIgnoreCase(tu.getData("MappingRegression.xlsx","Source", k, 1))) {
						test.log(LogStatus.INFO, "<b>" + "Source" + "</b>");
						if (pDColumns.get(j + 1).getText().equals(tu.getData("MappingRegression.xlsx","Source", k, 2))) {

							utils.scrollIntoView(pDColumns.get(j + 1));
							test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
									+ pDColumns.get(j + 1).getText() + " & " + tu.getData("MappingRegression.xlsx","Source", k, 2));
						} else {
							utils.scrollIntoView(pDColumns.get(j + 1));

							test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) + "Values doesnot match"
									+ "-" + pDColumns.get(j + 1).getText() + " & " + tu.getData("MappingRegression.xlsx","Source", k, 2));
						}

					}
					break;
				}
			}

		}
		
		utils.scrollIntoView(loggingPage.getPersonalDetailspartner());
		utils.waitForElementToBeClickable(loggingPage.getPersonalDetailspartner(), 90);
		List<WebElement> personalDetailspartnerrows = driver.findElements(loggingPage.getPersonalDetailspartner());
	
		for (int i = 0; i <personalDetailspartnerrows.size(); i++) {
			
			
			List<WebElement> partnercolumn = personalDetailspartnerrows.get(i).findElements(By.tagName("td"));
			int PDExcelrowLength = tu.getRowLength("MappingRegression.xlsx","Entity");
			
		//	int lastCellNum = tu.getLastCellNum("Entity", PDExcelrowLength);
		
			for (int k = 1; k < PDExcelrowLength+1; k++) {
			
//			for (int j = 0; j < partnercolumn.size(); j++) {
				
				
				if (partnercolumn.get(0).getText().trim().equalsIgnoreCase(tu.getData("MappingRegression.xlsx","Entity", k, 1))) {
					test.log(LogStatus.INFO, "<b>" + "Entity" + "</b>");
					if (partnercolumn.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Entity", k, 2))) {
					
					utils.scrollIntoView(partnercolumn.get(1));
						test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Values match"+"-"+partnercolumn.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Entity", k, 2));
					} else {
						utils.scrollIntoView(partnercolumn.get(1));
						
						test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) +"Values doesnot match"+"-"+partnercolumn.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Entity", k, 2));
					}
	}
		
//}
			}
		}
		
		
		utils.waitForElementToBeClickable(loggingPage.getFreeFields(), 90);
		utils.scrollIntoView(loggingPage.getFreeFields());
		List<WebElement> freefieldsrows = driver.findElements(loggingPage.getFreeFields());
	
		for (int i = 0; i <freefieldsrows.size(); i++) {
			
			
			List<WebElement> freefieldscolumn = freefieldsrows.get(i).findElements(By.tagName("td"));
			int freefieldsrowLength = tu.getRowLength("MappingRegression.xlsx","Entity");
			
		//	int lastCellNum = tu.getLastCellNum("Entity", PDExcelrowLength);
		
			for (int k = 1; k < freefieldsrowLength+1; k++) {
			
//			for (int j = 0; j < freefieldscolumn.size(); j++) {
				
				
				if (freefieldscolumn.get(0).getText().trim().equalsIgnoreCase(tu.getData("MappingRegression.xlsx","Entity", k, 1))) {
					test.log(LogStatus.INFO, "<b>" + "Entity" + "</b>");
					if (freefieldscolumn.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Entity", k, 2))) {
					
					utils.scrollIntoView(freefieldscolumn.get(1));
						test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Values match"+"-"+freefieldscolumn.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Entity", k, 2));
					} else {
						utils.scrollIntoView(freefieldscolumn.get(1));
						
						test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) +"Values doesnot match"+"-"+freefieldscolumn.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Entity", k, 2));
					}
	}
		
//}
			}
		}
		
		
		utils.waitForElementToBeClickable(loggingPage.getFreeFields(), 90);
		utils.scrollIntoView(loggingPage.getFreeFields());
		List<WebElement> freeFieldRows = driver.findElements(loggingPage.getFreeFields());	
		
		for (int i = 0; i <freeFieldRows.size(); i++) {
			
			List<WebElement> fFColumns = freeFieldRows.get(i).findElements(By.tagName("td"));
			int rowLength = tu.getRowLength("MappingRegression.xlsx","Formula");
			
			int lastCellNum = tu.getLastCellNum("MappingRegression.xlsx","Formula", rowLength);
			
			for (int k = 1; k < rowLength+1; k++) {
				
//				for (int j = 0; j < fFColumns.size(); j++) {
			
					if (fFColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(tu.getData("MappingRegression.xlsx","Formula", k, 1))) {
						test.log(LogStatus.INFO, "<b>" + "Formula" + "</b>");
						if (fFColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Formula", k, 2))) {
			
			
							utils.scrollIntoView(fFColumns.get(1));
			
							test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Values match"+"-"+fFColumns.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Formula", k, 2));
						} else {
			
							utils.scrollIntoView(fFColumns.get(1));
			
			
							test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) +"Values doesnot match"+"-"+fFColumns.get(1).getText()+" & "+tu.getData("MappingRegression.xlsx","Formula", k, 2));
			
						}
			
					}
			     
			
//				}
						
		}
		}
		
		
		
		utils.scrollIntoView(loggingPage.getAddresses());
		utils.waitForElementToBeClickable(loggingPage.getAddresses(), 90);
		AddressesRows = driver.findElements(loggingPage.getAddresses());

		for (int i = 0; i < AddressesRows.size(); i++) {
			System.out.println("AdressesRows- " + i);
			utils.waitForElementToBeClickable(loggingPage.getAddresses(), 90);
			AddressesRows = driver.findElements(loggingPage.getAddresses());
			addcolumn = AddressesRows.get(i).findElements(By.tagName("td"));
			System.out.println("addColumn- " + addcolumn.size());

			int ExcelrowLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

			// for (int j = 0; j < addcolumn.size(); j++) {

			for (int k = 1; k < ExcelrowLength; k++) {

				if (addcolumn.get(1).getText().trim().replace(" ", "")
						.equalsIgnoreCase(tu.getData("MappingRegression.xlsx","Fixed", k, 1).split("/")[0])) {
					System.out.println("Entity- " + addcolumn.get(0).getText());
					WebElement entity = addcolumn.get(0).findElement(By.tagName("a"));

					utils.waitForElementToBeClickable(entity, 30);
					utils.scrollIntoView(entity);
					entity.click();
					utils.waitForElementToBeClickable(loggingPage.getAddressType(), 30);
					if (utils.getElement(loggingPage.getAddressType()).getText().trim().replace(" ", "")
							.equalsIgnoreCase("Homeaddress")) {
						test.log(LogStatus.INFO, "<b>" + "Fixed" + "</b>");
						utils.waitForElementToBeClickable(loggingPage.getHomeAddressRef(), 5);
						refRows = driver.findElements(loggingPage.getHomeAddressRef());

						System.out.println("refRows- " + refRows.size());
						for (int l = 0; l < refRows.size(); l++) {
							refRows = driver.findElements(loggingPage.getHomeAddressRef());
							refRowColumns = refRows.get(l).findElements(By.tagName("td"));
							System.out.println("refRowColumns- " + refRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("Homeaddress")
										&& refRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "HomeAddress -" + "Reference - "
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (refRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(refRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(refRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}

						}

						utils.scrollIntoView(loggingPage.getAddressGeneral());
						utils.waitForElementToBeClickable(loggingPage.getAddressGeneral(), 5);
						genRows = driver.findElements(loggingPage.getAddressGeneral());

						for (int j = 0; j < genRows.size(); j++) {

							genRows = driver.findElements(loggingPage.getAddressGeneral());
							genRowColumns = genRows.get(j).findElements(By.tagName("td"));
							System.out.println("genRowColumns- " + genRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("Homeaddress")
										&& genRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "HomeAddress -" + "General -"
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (genRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(genRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(genRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}
//							if (j == genRows.size() - 1) {
//								driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
//							}
						}
						
						utils.scrollIntoView(loggingPage.getAddressAudit());
						utils.waitForElementToBeClickable(loggingPage.getAddressAudit(), 5);
						auditRows = driver.findElements(loggingPage.getAddressAudit());

						for (int j = 0; j < auditRows.size(); j++) {

							auditRows = driver.findElements(loggingPage.getAddressAudit());
							auditRowColumn = auditRows.get(j).findElements(By.tagName("td"));
							System.out.println("auditRowColumn- " + auditRowColumn.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("Homeaddress")
										&& auditRowColumn.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "HomeAddress -" + "Audit -"
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (auditRowColumn.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(auditRowColumn.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ auditRowColumn.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(auditRowColumn.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ auditRowColumn.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}
							if (j == auditRows.size() - 1) {
								driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
							}
						}
						
						
						break;
					}

					if (utils.getElement(loggingPage.getAddressType()).getText().trim().replace(" ", "")
							.equalsIgnoreCase("Workaddress")) {
						test.log(LogStatus.INFO, "<b>" + "Fixed" + "</b>");
						utils.waitForElementToBeClickable(loggingPage.getHomeAddressRef(), 5);
						refRows = driver.findElements(loggingPage.getHomeAddressRef());

						System.out.println("refRows- " + refRows.size());
						for (int l = 0; l < refRows.size(); l++) {
							refRows = driver.findElements(loggingPage.getHomeAddressRef());
							refRowColumns = refRows.get(l).findElements(By.tagName("td"));
							System.out.println("refRowColumns- " + refRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("Workaddress")
										&& refRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "WorkAddress -" + "Reference - "
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (refRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(refRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(refRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}

						}
						
						utils.scrollIntoView(loggingPage.getAddressGeneral());
						utils.waitForElementToBeClickable(loggingPage.getAddressGeneral(), 5);
						genRows = driver.findElements(loggingPage.getAddressGeneral());

						for (int j = 0; j < genRows.size(); j++) {

							genRows = driver.findElements(loggingPage.getAddressGeneral());
							genRowColumns = genRows.get(j).findElements(By.tagName("td"));
							System.out.println("genRowColumns- " + genRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength + 1; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("Workaddress")
										&& genRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "WorkAddress -" + "General -"
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (genRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(genRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(genRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}
							if (j == genRows.size() - 1) {
								driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
							}
						}
						break;
					}

					if (utils.getElement(loggingPage.getAddressType()).getText().trim().replace(" ", "")
							.equalsIgnoreCase("General")) {

						test.log(LogStatus.INFO, "<b>" + "Fixed" + "</b>");
						utils.waitForElementToBeClickable(loggingPage.getHomeAddressRef(), 5);
						refRows = driver.findElements(loggingPage.getHomeAddressRef());

						System.out.println("refRows- " + refRows.size());
						for (int l = 0; l < refRows.size(); l++) {
							refRows = driver.findElements(loggingPage.getHomeAddressRef());
							refRowColumns = refRows.get(l).findElements(By.tagName("td"));
							System.out.println("refRowColumns- " + refRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("General")
										&& refRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "General -" + "Reference - "
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (refRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(refRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(refRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ refRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}

						}

						utils.scrollIntoView(loggingPage.getAddressGeneral());
						utils.waitForElementToBeClickable(loggingPage.getAddressGeneral(), 5);
						genRows = driver.findElements(loggingPage.getAddressGeneral());

						for (int j = 0; j < genRows.size(); j++) {

							genRows = driver.findElements(loggingPage.getAddressGeneral());
							genRowColumns = genRows.get(j).findElements(By.tagName("td"));
							System.out.println("genRowColumns- " + genRowColumns.size());

							int fixedLength = tu.getRowLength("MappingRegression.xlsx","Fixed");

							for (int m = 1; m < fixedLength + 1; m++) {

								if (tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[0].trim().replace(" ", "")
										.equalsIgnoreCase("General")
										&& genRowColumns.get(0).getText().trim().replace(" ", "").equalsIgnoreCase(
												tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2].trim().replace(" ", ""))) {

									test.log(LogStatus.INFO, "<b>" + "General -" + "General -"
											+ tu.getData("MappingRegression.xlsx","Fixed", m, 1).split("/")[2] + "</b>");

									if (genRowColumns.get(1).getText().equals(tu.getData("MappingRegression.xlsx","Fixed", m, 2))) {

										utils.scrollIntoView(genRowColumns.get(1));
										test.log(LogStatus.PASS,
												test.addScreenCapture(getAScreenshot()) + "Values match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									} else {
										utils.scrollIntoView(genRowColumns.get(1));

										test.log(LogStatus.FAIL,
												test.addScreenCapture(getAScreenshot()) + "Values doesnot match" + "-"
														+ genRowColumns.get(1).getText() + " & "
														+ tu.getData("MappingRegression.xlsx","Fixed", m, 2));
									}

								}

								// }

							}
							if (j == genRows.size() - 1) {
								driver.findElement(By.xpath("//input[@id='btnCancel']")).click();
							}
						}
						break;
					}

					break;
				}

			}

			// }
		}
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser
				.parse(new FileReader(filepathPT+".json"));

		JsonElement jsonElement = object.get("result");

		Set<Entry<String, JsonElement>> entrySet = object.entrySet();

		for (Entry<String, JsonElement> entry : entrySet) {

			JsonElement value = entry.getValue();
			String key = entry.getKey();

			if (value.isJsonObject() == true) {

			} else if (value.isJsonArray() == true) {

				JsonArray asJsonArray = value.getAsJsonArray();

				for (int i = 0; i < asJsonArray.size(); i++) {

					if (asJsonArray.get(i).isJsonObject() == true) {

						JsonObject asJsonObject = asJsonArray.get(i).getAsJsonObject();
						Set<Entry<String, JsonElement>> entrySet2 = asJsonObject.entrySet();

						for (Entry<String, JsonElement> entry2 : entrySet2) {

							if (entry2.getValue().isJsonObject() == true) {

								JsonObject asJsonObject2 = entry2.getValue().getAsJsonObject();
								Set<Entry<String, JsonElement>> entrySet3 = asJsonObject2.entrySet();

								for (Entry<String, JsonElement> entry3 : entrySet3) {
									System.out.println(entry3);
									int fixedLength = tu.getRowLength("MappingRegression.xlsx","Export");
									
										for (int j = 0; j < fixedLength; j++) {
											if (tu.getData("MappingRegression.xlsx","Export", j+1, 1).equalsIgnoreCase(entry3.getKey())) {
												test.log(LogStatus.INFO, "<b>" + "Export -" 
														+ tu.getData("MappingRegression.xlsx","Export", j+1, 1) + "</b>");
												
												if (tu.getData("MappingRegression.xlsx","Export", j+1, 2).equalsIgnoreCase(entry3.getValue().toString().substring(1, entry3.getValue().toString().length()-1))) {
													test.log(LogStatus.PASS,"Expected Value -"+tu.getData("MappingRegression.xlsx","Export", j+1, 2)+"  "+"Actual Value -"+entry3.getValue().toString().substring(1, entry3.getValue().toString().length()-1));
													test.log(LogStatus.PASS,"Values Match");
												} else {
													test.log(LogStatus.FAIL,"Values doesn't Match");
													test.log(LogStatus.PASS,"Expected Value -"+tu.getData("MappingRegression.xlsx","Export", j+1, 2)+"  "+"Actual Value -"+entry3.getValue().toString().substring(1, entry3.getValue().toString().length()-1));
												}
											}
										}
									}
								}

							}
						}
					}
				}
			}

		
		
		
		
	}

	@BeforeMethod
	public void setUp() throws Exception {

		test = report.startTest(this.getClass().getSimpleName());

	}

	@AfterSuite
	public void endTest() {

		report.endTest(test);
		report.flush();

	}

	@AfterTest
	public void tearDown() {

		// driver.quit();

	}

}
