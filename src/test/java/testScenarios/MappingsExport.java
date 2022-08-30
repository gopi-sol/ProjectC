package testScenarios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MappingCleanUpLoggingPage;
import pageObjects.MappingPage;
import pageObjects.SharepointPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class MappingsExport extends BaseClass {

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

	static String ExcelName;
	static StringSelection fileO;
	static List<WebElement> mappingCleanUpRows, mappingCleanUpColumns = null;

	@Test()
	public void mappingExport() throws IOException, InterruptedException {

		urlLaunch("TestMappingExportAuto.xlsx");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else if (title.equals("Service Unavailable")) {

			test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) + "Service Unavailable");

			Assert.assertEquals(title, "Login pagina");
		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 1),
				tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));
			test.log(LogStatus.PASS,

					test.addScreenCapture(getAScreenshot()) + "Logged in");

		} catch (Exception e) {

			try {

			} catch (Exception noSuchElementException) {

			}

		}

		homePage.clickMappingCleanUpLogging();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(driver.findElement(By.xpath("//div[@id='headerdiv']")), 30);
		driver.findElement(By.xpath("//div[@id='headerdiv']")).click();
		test.log(LogStatus.PASS,

				test.addScreenCapture(getAScreenshot()) + "Mapping clean up page");

		utils.waitForElementToBeClickable(mCLPage.getStartDateTextBox(), 60);
		utils.getElement(mCLPage.getStartDateTextBox()).clear();
		utils.getElement(mCLPage.getStartDateTextBox()).sendKeys(mCLPage.yesterdayDate());

		utils.waitForElementToBeClickable(mCLPage.getEndDateTextBox(), 60);
		utils.getElement(mCLPage.getEndDateTextBox()).clear();
		utils.getElement(mCLPage.getEndDateTextBox()).sendKeys(mCLPage.currentDate());

		utils.waitForElementToBeClickable(mCLPage.getStatusDropdown(), 60);
		utils.doSelectValuesByVisibleText(mCLPage.getStatusDropdown(), "Open");

		utils.waitForElementToBeClickable(mCLPage.getMappingCleanUpRows(), 60);
		mappingCleanUpRows = driver.findElements(mCLPage.getMappingCleanUpRows());
		System.out.println(mappingCleanUpRows.size());

		File fExcel = new File(System.getProperty("user.dir"));

		String absolutePathExcel = fExcel.getAbsolutePath();

		for (int i = 0; i < mappingCleanUpRows.size(); i++) {

			mappingCleanUpColumns = mappingCleanUpRows.get(i).findElements(By.tagName("td"));

			System.out.println(mappingCleanUpColumns.get(0).getText());
			System.out.println(mappingCleanUpColumns.get(0).getText().contains(mCLPage.currentDate()));

			if (mappingCleanUpColumns.get(0).getText().contains(mCLPage.currentDate())) {
				System.out.println("Entered if");
				System.out.println(mappingCleanUpColumns.get(1).getText());

				ExcelName = mappingCleanUpColumns.get(1).getText();

				System.out.println(mappingCleanUpColumns.get(1) + " is about to be clicked");

				WebElement toClick = mappingCleanUpColumns.get(1).findElement(By.tagName("a"));
				 toClick.click();
				 Thread.sleep(5000);
				
				 System.out.println(mappingCleanUpColumns.get(1) + " is clicked");
				 StringSelection file = new StringSelection(absolutePathExcel + File.separator
				 + ExcelName);
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
				 break;
			} else {
				System.out.println("No Files available on this Date");
				test.log(LogStatus.FAIL,

						test.addScreenCapture(getAScreenshot()) + " No Files available on this Date");

				Assert.assertTrue(mappingCleanUpColumns.get(0).getText().contains(mCLPage.currentDate()));

			}

		}
		// *

		for (int i = 0; i < tu.getRowLength(ExcelName, "Mapping templates "); i++) {
			System.out.println("Entered for");
			driver.switchTo().defaultContent();
			utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
			utils.getElement(homePage.getMandantBrowser()).click();
			driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
			utils.getElement(homePage.getMandantSearchBox())
					.sendKeys(tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
			System.out.println(tu.getData(ExcelName, "Mapping templates ", i + 1, 0) + "is Passed");
			utils.getElement(homePage.getMandantSearchBtn()).click();

			if (utils.getElement(homePage.getPopupSelect1st()).getText().equals("No data found")
					|| utils.getElement(homePage.getPopupSelect1st()).getText().equals("Geen gegevens gevonden")) {
				test.log(LogStatus.FAIL,

						test.addScreenCapture(getAScreenshot()) + tu.getData(ExcelName, "Mapping templates ", i + 1, 0)
								+ " -No such Mandant found");
				// tu.writeOnCell("Mapping templates ", i+1, 1, "No such
				// Mandant");

				driver.switchTo().defaultContent();

				utils.doJsClick(homePage.getPopupCloseBtn());

				Thread.sleep(2000);

				System.out.println("No data found");

				driver.switchTo().frame("kop");
				utils.getElement(mappingPage.getLogOut()).click();

				Thread.sleep(2000);

				urlLaunch("TestMappingExportAuto.xlsx");

				String title1 = driver.getTitle();

				if (title1.equals("Login pagina")) {

				} else {

					Assert.assertEquals(title1, "Login pagina");

				}

				loginPage.ClearUsPwd();
				loginPage.LoginPageTest(tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 1),
						tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 2));

				try {

					driver.switchTo().frame(driver.findElement(By.id("kop")));

				} catch (Exception e) {

					try {

					} catch (Exception noSuchElementException) {

					}

				}

			} else {

				utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
				utils.getElement(homePage.getPopupSelect1st()).click();

				test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot())
						+ tu.getData(ExcelName, "Mapping templates ", i + 1, 0) + " -Mandant delegated");

				System.out.println(tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
				Thread.sleep(2000);
				driver.switchTo().frame("kop");
				utils.waitForElementToBeClickable(homePage.getUserName(), 90);
				System.out.println(utils.getElement(homePage.getUserName()).getText());

				if (utils.getElement(homePage.getUserName()).getText().equals(",")) {
					System.out.println(utils.getElement(homePage.getUserName()).getText());
					System.out.println("Can't proceed Further");
					test.log(LogStatus.FAIL,

							test.addScreenCapture(getAScreenshot())
									+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
									+ " -Can't proceed Further");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("kop");
					utils.getElement(mappingPage.getLogOff()).click();

				} else if (utils.getElement(homePage.getUserName()).getText().split(",")[1]
						.equals(tu.getData(ExcelName, "Mapping templates ", i + 1, 0))
						&& utils.getElement(homePage.getUserName()).getText().split(",")[1].length() > 1) {

					System.out.println(utils.getElement(homePage.getUserName()).getText().split(",")[1]
							+ tu.getData(ExcelName, "Mapping templates ", i + 1, 0));

					homePage.clickMapping();
					System.out.println("Mapping Clicked");
					driver.switchTo().frame("mainwindow");
					utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 90);
					System.out.println(utils.getElement(mappingPage.getPageHeader()).getText());
					utils.getElement(mappingPage.getPageHeader()).click();
					System.out.println(utils.getElement(mappingPage.getPageHeader()).getText() + " is Clicked");

					utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 90);
					utils.getElement(mappingPage.getMappingBrowser()).click();
					String parentWindowHandler = driver.getWindowHandle();
					driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
					utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 90);
					utils.getElement(mappingPage.getMappingSearchBox())
							.sendKeys(tu.getData(ExcelName, "Mapping templates ", i + 1, 1));
					utils.getElement(mappingPage.getMappingSearchBtn()).click();
					Thread.sleep(2000);
					utils.waitForElementToBeClickable(mappingPage.getPopupSelect1st(), 90);

					if (utils.getElement(mappingPage.getPopupSelect1st()).getText().equals("No data found") || utils
							.getElement(mappingPage.getPopupSelect1st()).getText().equals("Geen gegevens gevonden")) {
						test.log(LogStatus.FAIL,

								test.addScreenCapture(getAScreenshot())
										+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
										+ " -No such mapping found");
						// tu.writeOnCell("Mapping templates ", i+1, 2, "No such
						// Mapping");

						driver.switchTo().defaultContent();
						utils.doJsClick(mappingPage.getPopupCloseBtn());
						driver.switchTo().frame("kop");
						utils.getElement(mappingPage.getLogOff()).click();

					} else {
						utils.waitForElementToBeClickable(mappingPage.getPopupSelect1st(), 90);
						if (utils.getElement(mappingPage.getPopupSelect1st()).getText()
								.equals(tu.getData(ExcelName, "Mapping templates ", i + 1, 1))) {

							utils.getElement(mappingPage.getPopupSelect1st()).click();
							driver.switchTo().window(parentWindowHandler);
							driver.switchTo().frame("mainwindow");

							utils.waitForElementToBeVisible(mappingPage.getExportBtn(), 90);
							utils.getElement(mappingPage.getExportBtn()).click();
							Thread.sleep(2000);

							File fm = new File(System.getProperty("user.dir") + File.separator + "Mappings");
							fm.mkdir();

							String mandantFolder = tu.getData(ExcelName, "Mapping templates ", i + 1, 0).replace("/",
									"|");

							File f = new File(System.getProperty("user.dir") + File.separator + "Mappings"
									+ File.separator + mandantFolder);
							f.mkdir();

							if (f.exists() == true) {
								System.out.println(f + " is created");
							} else {
								System.out.println(f + " is not created");
							}

							String absolutePathm = f.getAbsolutePath();

							String mappingName = tu.getData(ExcelName, "Mapping templates ", i + 1, 1).replace("/",
									"|");

							fileO = new StringSelection(absolutePathm + File.separator + mappingName);

							Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO, null);

							Robot rb = null;

							// Toolkit.getDefaultToolkit().getSystemSelection().setContents(fileO,
							// (ClipboardOwner) this);

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
							test.log(LogStatus.PASS,

									test.addScreenCapture(getAScreenshot())
											+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
											+ "- mapping downloaded");

							driver.switchTo().defaultContent();
							driver.switchTo().frame("kop");
							utils.getElement(mappingPage.getLogOut()).click();
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.get(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 0));
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							String SharepointLoginpagetitle = driver.getTitle();

							if (SharepointLoginpagetitle.equals("Sign in to your account")) {
								if (i > 0) {

									driver.findElement(By.xpath("//div[@id='otherTileText']")).click();

								}
								utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getUsername()), 30);
								driver.findElement(sharepointPage.getUsername())
										.sendKeys(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 1));
								System.out.println(tu.getData("TestMappingExportAuto.xlsx", "Sharepoint", 1, 1));
								driver.findElement(sharepointPage.getSubmit()).click();
								Thread.sleep(2000);
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
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								driver.findElement(sharepointPage.getSubmit()).click();

							}
							utils.waitForElementToBeClickable(sharepointPage.getMyFiles(), 120);
							// driver.findElement(sharepointPage.getMyFiles()).click();

							// utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
							// 90);
							folders = driver.findElements(sharepointPage.getFolders());
							if (folders.size() > 0) {

								for (int k = 0; k < folders.size(); k++) {
									System.out.println(folders.get(k).getText());
									if (folders.get(k).getText().equals("Test")) {
										System.out.println(folders.get(k).getText() + " is about to be clicked");

										folders.get(k).click();
										System.out.println("Test" + " is Clicked");

										Thread.sleep(3000);
										break;
									} else {
										utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getNew()),
												90);
										driver.findElement(sharepointPage.getNew()).click();
										utils.waitForElementToBeClickable(
												driver.findElement(sharepointPage.getFolder()), 90);
										driver.findElement(sharepointPage.getFolder()).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										utils.waitForElementToBeClickable(sharepointPage.getFolderName(), 90);
										driver.findElement(sharepointPage.getFolderName()).sendKeys("Test");
										utils.waitForElementToBeClickable(
												driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
												90);
										folders = driver.findElements(sharepointPage.getFolders());

										for (int k1 = 0; k1 < folders.size(); k1++) {

											if (folders.get(k1).getText().equals("Test")) {

												folders.get(k1).click();
												Thread.sleep(3000);
												break;
											}

										}
									}
								}
							} else {
								utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getNew()), 90);
								driver.findElement(sharepointPage.getNew()).click();
								utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getFolder()), 90);
								driver.findElement(sharepointPage.getFolder()).click();
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								utils.waitForElementToBeClickable(sharepointPage.getFolderName(), 90);
								driver.findElement(sharepointPage.getFolderName()).sendKeys("Test");
								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
								driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()), 90);
								folders = driver.findElements(sharepointPage.getFolders());

								for (int k1 = 0; k1 < folders.size(); k1++) {

									if (folders.get(k1).getText().equals("Test")) {

										folders.get(k1).click();
										Thread.sleep(3000);
										break;
									}

								}
							}
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							// utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
							// 90);
							folders = driver.findElements(sharepointPage.getFolders());
							if (folders.size() == 0) {

								utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getNew()), 90);
								driver.findElement(sharepointPage.getNew()).click();
								utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getFolder()), 90);
								driver.findElement(sharepointPage.getFolder()).click();
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								utils.waitForElementToBeClickable(sharepointPage.getFolderName(), 90);
								driver.findElement(sharepointPage.getFolderName())
										.sendKeys("test_" + tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
								driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();

								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								// utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
								// 90);
								folders = driver.findElements(sharepointPage.getFolders());
								System.out.println(folders.size());

								for (int k1 = 0; k1 < folders.size(); k1++) {

									if (folders.get(k1).getText()
											.equals("test_" + tu.getData(ExcelName, "Mapping templates ", i + 1, 0))) {

										folders.get(k1).click();
										Thread.sleep(3000);
										break;
									}

								}

							} else {

								for (int k = 0; k < folders.size(); k++) {
									if (folders.get(k).getText()
											.equals("test_" + tu.getData(ExcelName, "Mapping templates ", i + 1, 0))) {
										System.out.println(folders.get(k).getText() + " is about to be clicked");

										folders.get(k).click();
										System.out.println(" is Clicked");

										Thread.sleep(3000);
										break;
									} else if (k == folders.size() - 1) {

										utils.waitForElementToBeClickable(driver.findElement(sharepointPage.getNew()),
												90);
										driver.findElement(sharepointPage.getNew()).click();
										utils.waitForElementToBeClickable(
												driver.findElement(sharepointPage.getFolder()), 90);
										driver.findElement(sharepointPage.getFolder()).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										utils.waitForElementToBeClickable(sharepointPage.getFolderName(), 90);
										driver.findElement(sharepointPage.getFolderName()).sendKeys(
												"test_" + tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
										utils.waitForElementToBeClickable(
												driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
												90);
										folders = driver.findElements(sharepointPage.getFolders());
										System.out.println(folders.size());

										for (int k1 = 0; k1 < folders.size(); k1++) {

											if (folders.get(k1).getText().equals(
													"test_" + tu.getData(ExcelName, "Mapping templates ", i + 1, 0))) {

												folders.get(k1).click();
												Thread.sleep(3000);
												break;
											}
											break;
										}
									}
								}
							}

							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							// utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
							// 90);
							folders = driver.findElements(sharepointPage.getFolders());
							String currentDate = utils.currentDate();
							String dateStamp = currentDate.replace("-", "");

							if (folders.size() == 0) {
								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//span[contains(text(),'New')]")), 90);
								driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//span[contains(text(),'Folder')]")), 90);
								driver.findElement(By.xpath("//span[contains(text(),'Folder')]")).click();
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//input[@aria-label='Enter your folder name']")),
										90);

								driver.findElement(By.xpath("//input[@aria-label='Enter your folder name']"))
										.sendKeys("MappingExport_" + dateStamp);

								utils.waitForElementToBeClickable(
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
								driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								// utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
								// 90);
								folders = driver.findElements(sharepointPage.getFolders());

								System.out.println(folders.size());
								for (int k2 = 0; k2 < folders.size(); k2++) {

									if (folders.get(k2).getText().equals("MappingExport_" + dateStamp)) {

										folders.get(k2).click();
										Thread.sleep(3000);
										break;
									}
								}
							} else {

								System.out.println(folders.size());
								for (int k = 0; k < folders.size(); k++) {
									if (folders.get(k).getText().equals("MappingExport_" + dateStamp)) {

										System.out.println(folders.get(k).getText() + " is about to be clicked");

										folders.get(k).click();
										System.out.println(" is Clicked");

										Thread.sleep(3000);
										break;

									} else if (!("MappingExport_" + dateStamp).equals(folders.get(k).getText())
											&& k == folders.size() - 1) {

										utils.waitForElementToBeClickable(
												driver.findElement(By.xpath("//span[contains(text(),'New')]")), 90);
										driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
										utils.waitForElementToBeClickable(
												driver.findElement(By.xpath("//span[contains(text(),'Folder')]")), 90);
										driver.findElement(By.xpath("//span[contains(text(),'Folder')]")).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										utils.waitForElementToBeClickable(driver.findElement(
												By.xpath("//input[@aria-label='Enter your folder name']")), 90);

										driver.findElement(By.xpath("//input[@aria-label='Enter your folder name']"))
												.sendKeys("MappingExport_" + dateStamp);
										utils.waitForElementToBeClickable(
												driver.findElement(By.xpath("//span[contains(text(),'Create')]")), 90);
										driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
										Thread.sleep(2000);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()),
												90);
										folders = driver.findElements(sharepointPage.getFolders());
										System.out.println("This is here");
										System.out.println(folders.size());
										for (int k2 = 0; k2 < folders.size(); k2++) {

											if (folders.get(k2).getText().equals("MappingExport_" + dateStamp)) {

												folders.get(k2).click();
												System.out.println(
														"MappingExport_" + dateStamp + " is created and Clicked");
												Thread.sleep(3000);
												break;
											}

										}
										break;

									}
								}
							}

							Thread.sleep(2000);

							utils.waitForElementToBeClickable(
									driver.findElement(By.xpath("//span[contains(text(),'Upload')]")), 90);
							driver.findElement(By.xpath("//span[contains(text(),'Upload')]")).click();
							utils.waitForElementToBeClickable(
									driver.findElement(By.xpath("//span[contains(text(),'Files')]")), 90);
							driver.findElement(By.xpath("//span[contains(text(),'Files')]")).click();

							Thread.sleep(5000);
							Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileO, null);

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
							rb1.keyPress(KeyEvent.VK_DOWN);
							rb1.keyRelease(KeyEvent.VK_DOWN);
							rb1.setAutoDelay(2000);
							rb1.keyPress(KeyEvent.VK_ENTER);
							rb1.keyRelease(KeyEvent.VK_ENTER);
							rb1.setAutoDelay(2000);

							Thread.sleep(5000);

							utils.visibilityOfAllElements(driver.findElements(sharepointPage.getFolders()), 120);
							folders = driver.findElements(sharepointPage.getFolders());
							System.out.println("going to delete" + folders.size());
							for (int k = 0; k < folders.size(); k++) {
								System.out.println(folders.get(k).getText());

								String mappingUploaded = folders.get(k).getText().split("[.]")[0];
								System.out.println(mappingUploaded);

								if (mappingUploaded.equals(mappingName)) {
									System.out.println(mappingName);
									System.out.println(mappingName + " is Uploaded");
									test.log(LogStatus.PASS,
											test.addScreenCapture(getAScreenshot())
													+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
													+ "- mapping uploaded");

									driver.findElement(
											By.xpath("//*[@id=\"O365_MainLink_MePhoto\"]/div/div/div/div/div[2]"))
											.click();
									driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
									driver.findElement(By.xpath("//*[@id=\"mectrl_body_signOut\"]")).click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

									urlLaunch("TestMappingExportAuto.xlsx");

									String title2 = driver.getTitle();

									if (title2.equals("Login pagina")) {

									} else {

										Assert.assertEquals(title2, "Login pagina");

									}

									loginPage.ClearUsPwd();
									loginPage.LoginPageTest(tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 1),
											tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 2));

									try {

										driver.switchTo().frame(driver.findElement(By.id("kop")));

									} catch (Exception e) {

										try {

										} catch (Exception noSuchElementException) {

										}

									}

									driver.switchTo().defaultContent();
									utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
									utils.getElement(homePage.getMandantBrowser()).click();
									driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
									utils.getElement(homePage.getMandantSearchBox())
											.sendKeys(tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
									System.out.println(
											tu.getData(ExcelName, "Mapping templates ", i + 1, 0) + "is Passed");
									utils.getElement(homePage.getMandantSearchBtn()).click();

									utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
									utils.getElement(homePage.getPopupSelect1st()).click();
									test.log(LogStatus.PASS,
											test.addScreenCapture(getAScreenshot())
													+ tu.getData(ExcelName, "Mapping templates ", i + 1, 0)
													+ " -Mandant delegated");
									System.out.println(tu.getData(ExcelName, "Mapping templates ", i + 1, 0));
									Thread.sleep(2000);

									homePage.clickMapping();
									System.out.println("Mapping Clicked");
									driver.switchTo().frame("mainwindow");
									utils.waitForElementToBeClickable(mappingPage.getPageHeader(), 90);
									System.out.println(utils.getElement(mappingPage.getPageHeader()).getText());
									utils.getElement(mappingPage.getPageHeader()).click();
									System.out.println(
											utils.getElement(mappingPage.getPageHeader()).getText() + " is Clicked");

									utils.waitForElementToBeClickable(mappingPage.getMappingBrowser(), 90);
									utils.getElement(mappingPage.getMappingBrowser()).click();
									String parentWindowHandler1 = driver.getWindowHandle();
									driver.switchTo().frame(utils.getElement(mappingPage.getPopupFrame()));
									utils.waitForElementToBeClickable(mappingPage.getMappingSearchBox(), 90);
									utils.getElement(mappingPage.getMappingSearchBox())
											.sendKeys(tu.getData(ExcelName, "Mapping templates ", i + 1, 1));
									utils.getElement(mappingPage.getMappingSearchBtn()).click();
									Thread.sleep(2000);
									utils.waitForElementToBeClickable(mappingPage.getPopupSelect1st(), 90);

									utils.getElement(mappingPage.getPopupSelect1st()).click();
									driver.switchTo().window(parentWindowHandler1);
									driver.switchTo().frame("mainwindow");
									utils.waitForElementToBeClickable(mappingPage.getDeleteBtn(), 90);
									utils.getElement(mappingPage.getDeleteBtn()).click();
									TimeUnit.SECONDS.sleep(2);

									Alert alert = driver.switchTo().alert();

									String text = alert.getText();

									System.out.println(alert);
									alert.accept();

									System.out.println("Mapping Delete");
									test.log(LogStatus.PASS,
											test.addScreenCapture(getAScreenshot())
													+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
													+ "- mapping deleted");

									driver.switchTo().defaultContent();
									driver.switchTo().frame("kop");
									utils.getElement(mappingPage.getLogOff()).click();
									Thread.sleep(5000);
									break;

								} else if (!mappingName.equals(folders.get(k).getText().split(".")[0])
										&& k == folders.size() - 1) {

									System.out.println(mappingName);
									System.out.println(mappingName + " is not Uploaded");
									test.log(LogStatus.FAIL,
											test.addScreenCapture(getAScreenshot())
													+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
													+ "- mapping not uploaded");
									urlLaunch("TestMappingExportAuto.xlsx");

									String title2 = driver.getTitle();

									if (title2.equals("Login pagina")) {

									} else {

										Assert.assertEquals(title2, "Login pagina");

									}

									loginPage.ClearUsPwd();
									loginPage.LoginPageTest(tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 1),
											tu.getData("TestMappingExportAuto.xlsx", "Login", 1, 2));

									try {

										driver.switchTo().frame(driver.findElement(By.id("kop")));

									} catch (Exception e) {

										try {

										} catch (Exception noSuchElementException) {

										}

									}
								}
							}

						} else {
							test.log(LogStatus.FAIL,

									test.addScreenCapture(getAScreenshot())
											+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
											+ " -No such mapping found");
							// tu.writeOnCell("Mapping templates ", i+1, 2, "No
							// such Mapping");

							Thread.sleep(2000);

							driver.switchTo().defaultContent();
							utils.doJsClick(mappingPage.getPopupCloseBtn());
							driver.switchTo().frame("kop");
							utils.getElement(mappingPage.getLogOff()).click();
						}

					}
				} else {
					System.out.println("Can't proceed Further");
					test.log(LogStatus.FAIL,

							test.addScreenCapture(getAScreenshot())
									+ tu.getData(ExcelName, "Mapping templates ", i + 1, 1)
									+ " -Can't proceed Further");
					driver.switchTo().frame("kop");
					utils.getElement(mappingPage.getLogOff()).click();
				}
			}

		}

		homePage.clickMappingCleanUpLogging();
		driver.switchTo().frame("mainwindow");
		utils.waitForElementToBeClickable(driver.findElement(By.xpath("//div[@id='headerdiv']")), 30);
		driver.findElement(By.xpath("//div[@id='headerdiv']")).click();

		utils.waitForElementToBeClickable(mCLPage.getMappingCleanUpRows(), 60);
		mappingCleanUpRows = driver.findElements(mCLPage.getMappingCleanUpRows());
		System.out.println(mappingCleanUpRows.size());

		for (int i = 0; i < mappingCleanUpRows.size(); i++) {

			mappingCleanUpColumns = mappingCleanUpRows.get(i).findElements(By.tagName("td"));

			if (mappingCleanUpColumns.get(1).getText().equals(ExcelName)) {
				List<WebElement> toClick = mappingCleanUpColumns.get(2).findElements(By.tagName("button"));
				toClick.get(0).click();
//				System.out.println(toClick.get(0).getText() + " is going to be clicked");
				Thread.sleep(5000);
				break;
			}

		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("kop");
		utils.getElement(mappingPage.getLogOut()).click();
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
