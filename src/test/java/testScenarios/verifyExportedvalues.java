package testScenarios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jcraft.jsch.JSch;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoggingPage;
import pageObjects.LoginPage;
import pageObjects.MappingPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class verifyExportedvalues extends BaseClass{
	
	LoginPage loginPage;
	MappingPage mappingPage;
	HomePage homePage;
	LoggingPage loggingPage;
	
	TestUtil tu;
	ElementUtil utils;
	
	static ExtentTest test;

	static ExtentReports report;

	@BeforeSuite
	public void startTest() {

		File f = new File("reports\\ExtentReportsResults.html");
		String absolutePath = f.getAbsolutePath();
		report = new ExtentReports(absolutePath);

	}
	
	@BeforeTest()
	public void setup() throws IOException {

		initialization();

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
	
	@Test
	public void exportedValuesVsExpectedValues() throws InterruptedException, IOException, ParseException {
		
		
		urlLaunch();

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("Login", 1, 1), tu.getData("Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));
			

		} catch (Exception e) {

			try {

			

			} catch (Exception noSuchElementException) {

				

			}

		}
		
		/*DelegatingMandant*/
		
		driver.switchTo().defaultContent();
		utils.waitForElementToBeClickable(homePage.getMandantBrowser(), 90);
		utils.getElement(homePage.getMandantBrowser()).click();
		driver.switchTo().frame(utils.getElement(homePage.getPopupFrame()));
		utils.getElement(homePage.getMandantSearchBox()).sendKeys("Gopinath");
		
		utils.getElement(homePage.getMandantSearchBtn()).click();
		utils.waitForElementToBeClickable(homePage.getPopupSelect1st(), 90);
		utils.getElement(homePage.getPopupSelect1st()).click();
//		
//		/*Logging*/
//		
//		homePage.clickLogging();
//		driver.switchTo().frame("mainwindow");
//		utils.doMoveToElementAndClick(loggingPage.getDocument());
//		utils.getElement(loggingPage.getFirstDay()).clear();
//		utils.waitForElementToBeClickable(loggingPage.getFirstDay(), 90);
//		utils.getElement(loggingPage.getFirstDay()).sendKeys("18-04-2022");
//		utils.doSelectValuesByValue(loggingPage.getType(), "Export");
//		Thread.sleep(2000);
//
//		utils.getElement(loggingPage.getRefresh()).click();
//		Thread.sleep(2000);
//		utils.getElement(loggingPage.getRefresh()).click();
//		utils.waitForElementToBeClickable(loggingPage.getLogTable(), 90);
		
//		JSONParser jsonParser = new JSONParser();
//		File f  = new File("C:/Users/gobi/Downloads/exportTextJson.json");
//		
//		FileReader reader = new FileReader(f);
//		//Read JSON file
//		Object obj = jsonParser.parse(reader);
//		JSONObject jsonObject = (JSONObject)obj;
//		
//		Object object = jsonObject.get("status");
//		JSONArray subjects = (JSONArray) obj;
//		System.out.println(subjects.get(1).toString());
//		System.out.println(subjects);
//		Iterator iterator = subjects.iterator();
//        while (iterator.hasNext()) {
//           System.out.println(iterator.next());
//        }
//		String string = obj.toString();
//		System.out.println(string);
		
		try {
	        JSONParser parser = new JSONParser();
	        //Use JSONObject for simple JSON and JSONArray for array of JSON.
	        JSONObject data = (JSONObject) parser.parse(
	              new FileReader("C:/Users/gobi/Downloads/exportTextJson.json"));//path to the JSON file.

	        String json = data.toJSONString();
	        System.out.println(json);
	    } catch (Exception e) {
	        e.printStackTrace();
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
