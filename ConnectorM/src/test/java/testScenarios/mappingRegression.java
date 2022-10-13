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
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
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

public class mappingRegression extends BaseClass {
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

		File f = new File("reports\\ConnectorMappingRegressionReport.html");
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

		tu = new TestUtil();
		utils = new ElementUtil(driver);

	}

	@BeforeMethod
	public void setUp() throws Exception {

		test = report.startTest(this.getClass().getSimpleName());

	}

	private static final String Sftp = "test";

	@Test(priority = 1)
	public void sftpImport() throws JSchException, SftpException {
		
		test.log(LogStatus.INFO, "<b>" + "SFTP CONNECTION" + "</b>");
		
		String localPath = "/";
		String fileName = "test_json (3).json";
		String sftpPath = "/Training/vamshi/import/regression";
		String sftpHost = "51.144.240.121";
		String sftpPort = "22";
		String sftpUser = "soldevteam";
		String sftpPassword = "$ol@ftp@321";


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

	}

	static List<WebElement> logRows, logColumns, addcolumn, AddressesRows, refRowColumns, refRows,auditRows,auditRowColumn, genRows, genRowColumns = null;
	static String text1;

	@Test(priority = 2, dependsOnMethods={"sftpImport"})
	public void comparingImportedValues() throws InterruptedException, IOException {

		urlLaunch("MappingRegression.xlsx");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingRegression.xlsx","Login", 1, 1), tu.getData("MappingRegression.xlsx","Login", 1, 2));

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
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gobinath1");

		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();

		/* Logging */

		homePage.clickLogging();
		driver.switchTo().frame("mainwindow");
		utils.doMoveToElementAndClick(loggingPage.getDocument());

		utils.getElement(loggingPage.getTestGoBA()).click();
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.getElement(loggingPage.getRefresh()).click();
		Thread.sleep(10000);
		utils.getElement(loggingPage.getRefresh()).click();
		test.log(LogStatus.PASS, test.addScreenCapture(entireScreenshot()) + "Logging Screen");

		utils.waitForElementToBeClickable(loggingPage.getLogTable(), 30);
		logRows = driver.findElements(loggingPage.getLogTable());
		
		for (int i = 0; i < logRows.size(); i++) {

			logColumns = logRows.get(i).findElements(By.tagName("td"));
		
			if (logColumns.get(0).getText().equals("Export") &&( logColumns.get(1).getText().equals("Candidate") ||logColumns.get(1).getText().equals("Kandidaat"))
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
			}

		}
		

		for (int i = 0; i < logRows.size(); i++) {

			logColumns = logRows.get(i).findElements(By.tagName("td"));

			if (logColumns.get(0).getText().equals("Import") &&( logColumns.get(1).getText().equals("Candidate") ||logColumns.get(1).getText().equals("Kandidaat"))
					&&( logColumns.get(3).getText().equals("Candidate updated"))||logColumns.get(3).getText().equals("Candidate created") ){

				logColumns.get(6).click();
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
