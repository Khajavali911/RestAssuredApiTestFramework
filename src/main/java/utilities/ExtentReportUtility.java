package utilities;

import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;



public class ExtentReportUtility {
	ExtentReports extent=null;
	////
	public void ExtentReport() {
		String filename = "test_output\\extentreport.html";
		extent = new ExtentReports();
       // extent.
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.loadXMLConfig("resources\\extent-config.xml");		
		extent.attachReporter(htmlReporter);
	}
	
	
	
	public void FlushReport() {
		extent.flush();
	}

}
