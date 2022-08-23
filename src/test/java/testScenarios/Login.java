package testScenarios;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
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

public class Login extends BaseClass{

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

		File f = new File("reports\\ExtentReportsResults.html");
		String absolutePath = f.getAbsolutePath();
		report = new ExtentReports(absolutePath);

	}

	@BeforeTest()
	public void setup() throws IOException {

		initialization("MappingRegression");

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
	public void loginSuccess() throws InterruptedException, IOException {
		urlLaunch("MappingRegression");

		String title = driver.getTitle();

		if (title.equals("Login pagina")) {

		} else {

			Assert.assertEquals(title, "Login pagina");

		}

		loginPage.ClearUsPwd();
		loginPage.LoginPageTest(tu.getData("MappingRegression","Login", 1, 1), tu.getData("MappingRegression","Login", 1, 2));

		try {

			driver.switchTo().frame(driver.findElement(By.id("kop")));
			test.log(LogStatus.PASS, test.addScreenCapture(getAScreenshot()) + "Logged in");

		} catch (Exception e) {

			try {
				test.log(LogStatus.FAIL,
						test.addScreenCapture(getAScreenshot()) + loginPage.getInvalidUsPwdText().getText());


			} catch (Exception noSuchElementException) {
				test.log(LogStatus.FAIL, test.addScreenCapture(getAScreenshot()) + loginPage.getWarningText().getText());
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
