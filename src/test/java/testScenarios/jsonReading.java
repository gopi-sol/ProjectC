package testScenarios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import pageObjects.LoggingPage;
import pageObjects.LoginPage;
import pageObjects.MappingPage;
import testUtils.ElementUtil;
import testUtils.TestUtil;

public class jsonReading {
	
	static TestUtil tu;
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

		tu = new TestUtil();
		
	}

	@BeforeMethod
	public void setUp() throws Exception {

		test = report.startTest(this.getClass().getSimpleName());

	}

	@Test
	public void jsonComparison()
			throws JsonParseException, JsonMappingException, IOException, ParseException {
		tu = new TestUtil();
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser
				.parse(new FileReader("C:\\Users\\gobi\\workspace\\ConnectorM\\Tfiles\\374754.json"));

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
									int fixedLength = tu.getRowLength("MappingRegression","Export");
										for (int j = 0; j < fixedLength; j++) {
											if (tu.getData("MappingRegression","Export", j+1, 1).equalsIgnoreCase(entry3.getKey())) {
												
												if (tu.getData("MappingRegression","Export", j+1, 2).equalsIgnoreCase(entry3.getValue().toString().substring(1, entry3.getValue().toString().length()-1))) {
													
													test.log(LogStatus.PASS,"Values Match");
												} else {
													test.log(LogStatus.FAIL,"Values doesn't Match");
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
