package testScenarios;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MappingCleanUpLoggingPage;
import pageObjects.MappingPage;
import pageObjects.SharepointPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class SharepointLogin extends BaseClass {
	
	TestUtil tu;

	LoginPage loginPage;
	MappingPage mappingPage;
	HomePage homePage;
	SharepointPage sharepointPage;
	MappingCleanUpLoggingPage mCLPage;

	ElementUtil utils;
	static ExtentTest test;

	static ExtentReports report;

	static List<WebElement> folders;

	@BeforeSuite
	public void startTest() {

		File f = new File("reports\\ExtentReportsResults.html");
		String absolutePath = f.getAbsolutePath();
		report = new ExtentReports(absolutePath);

	}

	@BeforeTest()
	public void setup() throws IOException {

		initialization("TestMappingExportAuto.xlsx");

		loginPage = new LoginPage();
		homePage = new HomePage();
		mappingPage = new MappingPage();
		sharepointPage = new SharepointPage();
		mCLPage = new MappingCleanUpLoggingPage();

		tu = new TestUtil();
		utils = new ElementUtil(driver);

	}
	@Test
	public void Login() throws IOException, InterruptedException {
		driver.get(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 0));
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		if (title.equals("Sign in to your account")) {

			utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getUsername()), 30);
			driver.findElement(sharepointPage.getUsername())
					.sendKeys(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 1));
			System.out.println(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 1));
			driver.findElement(sharepointPage.getSubmit()).click();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getPassword()), 30);
			driver.findElement(sharepointPage.getPassword())
					.sendKeys(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 2));
			System.out.println(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 2));
			utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getSubmit()), 30);
			driver.findElement(sharepointPage.getSubmit()).click();
			//
			// Thread.sleep(10000);
			// Thread.sleep(10000);
			// Thread.sleep(10000);
			//
			// driver.manage().timeouts().implicitlyWait(120,
			// TimeUnit.SECONDS);
			// driver.findElement(sharepointPage.getSubmit()).click();
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.findElement(sharepointPage.getSubmit()).click();

		}
		utils.waitForElementToBeClickable(sharepointPage.getMyFiles(), 120);
		// driver.findElement(sharepointPage.getMyFiles()).click();

		utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()), 90);
		folders = driver.findElements(sharepointPage.getFolders());
		
		driver.findElement(By.xpath("//*[@id=\"O365_MainLink_MePhoto\"]/div/div/div/div/div[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"mectrl_body_signOut\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
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

//		 driver.quit();

	}

}
