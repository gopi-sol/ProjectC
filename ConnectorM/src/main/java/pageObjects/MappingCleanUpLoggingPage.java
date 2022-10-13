package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import testUtils.ElementUtil;

public class MappingCleanUpLoggingPage extends BaseClass{
	
ElementUtil utils = new ElementUtil(driver);
	
	public MappingCleanUpLoggingPage() {
		PageFactory.initElements(driver, this);
	}
	
	By mappingCleanUpRows = By.xpath("//table[@id='tblsourceDynamicDatalog']/tbody/tr");
	
	By statusDropdown = By.xpath("//select[@id='ddlStatus']");
	
	By startDateTextBox = By.xpath("//input[@id='txtStartDate']");
	
	By endDateTextBox = By.xpath("//input[@id='txtEndDate']");
	
	By refreshBtn = By.xpath("//input[@id='btnRefresh']");
	
	public By getRefreshBtn() {
		return refreshBtn;
	}

	public By getStatusDropdown() {
		return statusDropdown;
	}

	public By getStartDateTextBox() {
		return startDateTextBox;
	}

	public By getEndDateTextBox() {
		return endDateTextBox;
	}

	public By getMappingCleanUpRows() {
		return mappingCleanUpRows;
	}
	
	public String currentDate() {
		
		LocalDate today = LocalDate.now();
	    
	    String date1 = today.toString();
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String format = today.format(formatter);
	    System.out.println("Current date: " + format);
	    return format;
	  
	}
	
	
	public String yesterdayDate() {
		
		LocalDate today = LocalDate.now();
		 LocalDate Week = today.minus(1, ChronoUnit.DAYS);
		  
		  
		    String date2 = Week.toString();
		    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    String format1 = Week.format(formatter1);
		    System.out.println("Yesterday Date: " + format1);
		    return format1;

	}

}
