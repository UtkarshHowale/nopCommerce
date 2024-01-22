package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() {

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/TestsReport/" + "ExtentReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "Utkarsh Howale");
		extent.setSystemInfo("ProjectName", "nopCommerce Project");
		extent.setSystemInfo("Tester", "Utkarsh Howale");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		
		extent.flush();
	}
}
