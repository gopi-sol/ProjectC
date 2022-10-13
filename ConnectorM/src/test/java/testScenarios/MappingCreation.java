package testScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoggingPage;
import pageObjects.LoginPage;
import pageObjects.MappingPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class MappingCreation extends BaseClass {

	LoginPage loginPage;
	MappingPage mappingPage;
	HomePage homePage;
	LoggingPage loggingPage;

	TestUtil tu;
	ElementUtil utils;

	static ExtentTest test;

	static ExtentReports report;

	static String filepathPT;

	@BeforeSuite
	public void startTest() {

		File f = new File("reports\\MappingCreationTest.html");
		String absolutePath = f.getAbsolutePath();
		report = new ExtentReports(absolutePath);

	}

	@BeforeTest()
	public void setup() throws IOException {

		initialization("MappingCreation.xlsx");

		loginPage = new LoginPage();
		homePage = new HomePage();
		mappingPage = new MappingPage();
		loggingPage = new LoggingPage();

		tu = new TestUtil();
		utils = new ElementUtil(driver);

	}

	@BeforeMethod
	public void setUp() throws Exception {
	
			test = report.startTest(this.getClass().getClass().getSimpleName());
		
	}
	
	String data,property=null;
	
	@Test(enabled=true,priority=1)
	public void completeMappingCreation() throws IOException, InterruptedException {

		urlLaunch("MappingCreation.xlsx");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingCreation.xlsx", "Login", 1, 1),
				tu.getData("MappingCreation.xlsx", "Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));

		} catch (Exception e) {

			try {

			} catch (Exception noSuchElementException) {

			}

		}

		/* DelegatingMandant */

		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gopinath");

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();

		homePage.clickMapping();
		System.out.println(tu.getColumnLength("MappingCreation.xlsx", "Mapping",2));

		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 90);

		utils.getElement(mappingPage.getPageHeader()).click();
		
		utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 90);
		utils.getElement(mappingPage.getMappingBrowser()).click();
		String parentWindowHandler = driver.getWindowHandle();
		driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
		utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 90);
		utils.getElement(mappingPage.getMappingSearchBox())
				.sendKeys("Auto_Mapping_Import1");
		utils.getElement(mappingPage.getMappingSearchBtn()).click();
		Thread.sleep(2000);
		utils.waitForElementToBeClickable(mappingPage.getPopupSelect1st(), 90);
		utils.getElement(mappingPage.getPopupSelect1st()).click();
		driver.switchTo().window(parentWindowHandler);
		driver.switchTo().frame("mainwindow");
	
		/*
		utils.getElement(mappingPage.getSourceFileRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getJsonRadioBtn(), 30);
		utils.getElement(mappingPage.getJsonRadioBtn()).click();
		
		
		utils.waitForElementToBeClickable(mappingPage.getTargetSchemaRadioBtn(), 30);
		utils.getElement(mappingPage.getTargetSchemaRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getTargetSOLRadioBtn(), 30);
		utils.getElement(mappingPage.getTargetSOLRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getTopicType(), 30);
		utils.doSelectValuesByVisibleText(mappingPage.getTopicType(), "Candidate", "Kaandidat");
		test.log(LogStatus.INFO, test.addScreenCapture(getAScreenshot()) +"Mapping Creation for Topic Candidate");
		utils.waitForElementToBeClickable(mappingPage.getSourceUploadFile(), 30);
		utils.getElement(mappingPage.getSourceUploadFile()).click();
		
		Thread.sleep(10000);
		
		
		
		StringSelection file = new StringSelection(System.getProperty("user.dir")+File.separator+"test_json (3).json");
		System.out.println(file.toString());
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		systemClipboard.setContents(file, null);

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

		Thread.sleep(5000);
		
		utils.waitForElementToBeClickable(mappingPage.getMappingTemplateName(), 60);
		utils.getElement(mappingPage.getMappingTemplateName()).sendKeys("Auto_Mapping_Import1");

		utils.waitForElementToBeClickable(mappingPage.getMappingSaveBtn(), 60);
		utils.getElement(mappingPage.getMappingSaveBtn()).click();
		*/
		utils.waitForElementToBeClickable(mappingPage.getContractExpandBtn(), 90);
		test.log(LogStatus.INFO, test.addScreenCapture(getAScreenshot()) +"Mapping Created for import");

		utils.getElement(mappingPage.getContractExpandBtn()).click();
		
		utils.waitForElementToBeClickable(mappingPage.getNodesTarget(), 90);
		
		 for (int i = 2; i < tu.getRowLength("MappingCreation.xlsx", "Mapping"); i++) {
			
			 System.out.println("Row-"+i);
			 mappingPage.clickNodes(tu.getData("MappingCreation.xlsx", "Mapping", i, 1),tu.getData("MappingCreation.xlsx", "Mapping", i, 0));
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Auto Mapping of Nodes");
		for (int j = 2; j <6 ; j++) {
			
			if (tu.getData("MappingCreation.xlsx", "Mapping", i, j).equalsIgnoreCase("yes")) {
				
				data = tu.getData("MappingCreation.xlsx", "Mapping", 1, j);
				mappingPage.clickProperties("MappingCreation.xlsx", "Mapping", i, j, data);
				
			}
		}
		/*
			 for (int j = 4; j < tu.getColumnLength("MappingCreation.xlsx", "ExportMapping",i); j++) {
				
				 if (tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equalsIgnoreCase("yes")) {
					
					data = tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+2));
					mappingPage.clickProperty("MappingCreation.xlsx", "Mapping", i, j, data);
					System.out.println(data);
						
				}else if (!tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)).equals("")) {
 					
					data = tu.getData("MappingCreation.xlsx", "Mapping", 1, (j+2));
					mappingPage.clickProperty("MappingCreation.xlsx", "Mapping", i, j, data);
					System.out.println(data);
					System.out.println("Excel Read - "+tu.getData("MappingCreation.xlsx", "Mapping", i, (j+2)));
				
				}
				 
			}
		*/	
			 utils.waitForElementToBeClickable(mappingPage.getFieldSaveBtn(), 90);
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Nodes Mapped with properties"); 
			 utils.getElement(mappingPage.getFieldSaveBtn()).click();

			 Thread.sleep(5000);
			
			 utils.waitForElementToBeClickable(mappingPage.getNodesTarget(), 90);
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Mapping Saved"); 
		}
			//input[@type='checkbox']&//input[contains(@id,'tvTarget')]
		
	}
	
	
	@Test(enabled=false,priority=2)
	public void completeMappingCreationExport() throws IOException, InterruptedException {
		driver.manage().deleteAllCookies();
		urlLaunch("MappingCreation.xlsx");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

//			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingCreation.xlsx", "Login", 1, 1),
				tu.getData("MappingCreation.xlsx", "Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));

		} catch (Exception e) {

			try {

			} catch (Exception noSuchElementException) {

			}

		}

		/* DelegatingMandant */

		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gopinath");

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();

		homePage.clickMapping();
		System.out.println(tu.getColumnLength("MappingCreation.xlsx","ExportMapping",2));

		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 90);

		utils.getElement(mappingPage.getPageHeader()).click();
		/*
		utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 90);
		utils.getElement(mappingPage.getMappingBrowser()).click();
		String parentWindowHandler = driver.getWindowHandle();
		driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
		utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 90);
		utils.getElement(mappingPage.getMappingSearchBox())
				.sendKeys("test_09");
		utils.getElement(mappingPage.getMappingSearchBtn()).click();
		Thread.sleep(2000);
		utils.waitForElementToBeClickable(mappingPage.getPopupSelect1st(), 90);
		utils.getElement(mappingPage.getPopupSelect1st()).click();
		driver.switchTo().window(parentWindowHandler);
		driver.switchTo().frame("mainwindow");
		*/
		
		utils.getElement(mappingPage.getTargetFileRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getJsonRadioTargetBtn(), 30);
		utils.getElement(mappingPage.getJsonRadioTargetBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getSourceSchemaRadioBtn(), 30);
		utils.getElement(mappingPage.getSourceSchemaRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getSourceSOLRadioBtn(), 30);
		utils.getElement(mappingPage.getSourceSOLRadioBtn()).click();

		utils.waitForElementToBeClickable(mappingPage.getTopicTargetType(), 30);
		utils.doSelectValuesByVisibleText(mappingPage.getTopicTargetType(), "Candidate", "Kaandidat");
		test.log(LogStatus.INFO, test.addScreenCapture(getAScreenshot()) +"Mapping Creation for Topic Candidate");
		utils.waitForElementToBeClickable(mappingPage.getTargetUploadFile(), 30);
		utils.getElement(mappingPage.getTargetUploadFile()).click();
		
		Thread.sleep(5000);
		
		StringSelection file = new StringSelection(System.getProperty("user.dir")+File.separator+"test_json (3).json");
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		systemClipboard.setContents(file, null);

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

		Thread.sleep(5000);
		
		utils.waitForElementToBeClickable(mappingPage.getMappingTemplateName(), 60);
		utils.getElement(mappingPage.getMappingTemplateName()).sendKeys("Auto_Mapping_Export");

		utils.waitForElementToBeClickable(mappingPage.getMappingSaveBtn(), 60);
		utils.getElement(mappingPage.getMappingSaveBtn()).click();
		
		
		utils.waitForElementToBeClickable(mappingPage.getContractExpandBtn(), 90);
		test.log(LogStatus.INFO, test.addScreenCapture(getAScreenshot()) +"Mapping Created for Export");
		utils.getElement(mappingPage.getContractExpandBtn()).click();
		
		utils.waitForElementToBeClickable(mappingPage.getNodesTarget(), 90);
		
		 for (int i = 2; i < tu.getRowLength("MappingCreation.xlsx", "ExportMapping"); i++) {
			
			 System.out.println("Row-"+i);
			 mappingPage.clickTargetNodes(tu.getData("MappingCreation.xlsx", "ExportMapping", i, 1),tu.getData("MappingCreation.xlsx", "ExportMapping", i, 0));
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Auto Mapping of Nodes");

			 for (int j = 2; j <6 ; j++) {
			if (tu.getData("MappingCreation.xlsx", "ExportMapping", i, j).equalsIgnoreCase("yes")) {
				
				data = tu.getData("MappingCreation.xlsx", "ExportMapping", 1, j);
				mappingPage.clickProperties("MappingCreation.xlsx", "ExportMapping", i, j, data);
				
			}
		}
			/* 
			 for (int j = 4; j < tu.getColumnLength("MappingCreation.xlsx", "ExportMapping",i); j++) {
				
				 if (tu.getData("MappingCreation.xlsx", "ExportMapping", i, (j+2)).equalsIgnoreCase("yes")) {
					
					data = tu.getData("MappingCreation.xlsx", "ExportMapping", 1, (j+2));
//					mappingPage.clickProperty("MappingCreation.xlsx", "ExportMapping", i, j, data);
					System.out.println(data);
						
				}else if (!tu.getData("MappingCreation.xlsx", "ExportMapping", i, (j+2)).equals("")) {
 					
					data = tu.getData("MappingCreation.xlsx", "ExportMapping", 1, (j+2));
//					mappingPage.clickProperty("MappingCreation.xlsx", "ExportMapping", i, j, data);
					System.out.println(data);
					System.out.println("Excel Read - "+tu.getData("MappingCreation.xlsx", "ExportMapping", i, (j+2)));
				}
				 
			}
			 */
			 
			 utils.waitForElementToBeClickable(mappingPage.getFieldSaveBtn(), 90);
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Nodes Mapped with properties"); 
			 utils.getElement(mappingPage.getFieldSaveBtn()).click();
			
			 Thread.sleep(5000);
			 utils.waitForElementToBeClickable(mappingPage.getNodesTarget(), 90);
			 test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) +"Mapping Saved"); 
		}
		
		
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
