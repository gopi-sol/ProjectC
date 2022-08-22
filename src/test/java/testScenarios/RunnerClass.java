package testScenarios;

import com.beust.testng.TestNG;

import base.BaseClass;


public class RunnerClass extends BaseClass {
	
	@SuppressWarnings("deprecation")
	static TestNG tng;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		ExtentReportListener ext = new ExtentReportListener();
		
		tng = new TestNG();
		
		tng.setTestClasses(new Class[] {MappingsExport.class});
//		tng.addListener(ext);
		tng.run();
		
	}

}
