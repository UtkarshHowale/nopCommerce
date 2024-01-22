package Base;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Driver.DriverManager;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.ExtentManager;
import Utils.PropertyReader;
import io.qameta.allure.Allure;

public class BaseTest {

	@Parameters("browser")
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void StartConfig() {

		ExtentManager.setExtent();
	}

	@Parameters("browser")
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void CloseConfig() {

		ExtentManager.setExtent();
	}

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	protected void SetUp(String browser) {

		try {

			DriverManager.startDriver(browser);
//			DriverManager.startDriver(PropertyReader.readKeys("BrowserName"));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyReader.readKeys("BaseUrl"));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Parameters("browser")
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	protected void tearDown() {

		try {

			DriverManager.closeDriver();
			ExtentManager.endReport();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DriverManager.unload();
		}

	}
}
