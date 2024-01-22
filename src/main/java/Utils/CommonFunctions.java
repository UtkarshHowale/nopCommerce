package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import BasePage.BasePage;
import Driver.DriverManager;

 
public class CommonFunctions {
	
	private Actions actions = new Actions(DriverManager.getDriver());
	private Assertion assertion = new Assertion();
	private Select select;

	public CommonFunctions() {

	}

	public String getPageTitle() {

		return DriverManager.getDriver().getTitle();
	}

	public void addAssert(String Actual, String Expected) {

		Assertion assertion = new Assertion();
		assertion.assertEquals(Actual, Expected);
	}

	public void addAssertWithInfoMessage(String Actual, String Expected, String Message) {

		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(Actual, Expected, Message);
	}
	
	public void Scroll() {
		
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("window.scrollTo(0,350)");
	}
	
	public void ScrollToTop() {
		
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("window.scrollTo(0,0)");
	}
	
	public void ScrollTillEndOfPage() {
		
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void VerifyCurrentThePageTitle(String ExpectedTitle) {
		
		String ActualTitle = DriverManager.getDriver().getTitle();
		Log.Info("Actual Page Title Is : " + ActualTitle);
		Log.Info("Expected Page Title Is : " + ExpectedTitle);
		assertion.assertEquals(ActualTitle, ExpectedTitle,"Titles are not matching");
	}
	
	public void VerifyCurrentPageUrl(String ExpectedUrl) {
		
		String ActualUrl = DriverManager.getDriver().getCurrentUrl();
		Log.Info("Actual Page Url Is :" + ActualUrl);
		Log.Info("Expected Page Url is:" + ExpectedUrl);
		assertion.assertEquals(ActualUrl, ExpectedUrl,"Urls are not matching");
	}
	
	public void PageRefresh() {
		
		DriverManager.getDriver().navigate().refresh();
	}
	
	public void SelectByIndexValue(WebElement element, int value) {
		
	    select = new Select(element);
		select.selectByIndex(value);
	}
	
	public void SelectByVisibleText(WebElement element, String value) {
		
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void MouserHover(WebElement element) {
		
		actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).build().perform();
	}
	
	public void MouseHoverAndClick(WebElement element) {
		
		actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element).click().build().perform();
	}
	
	public String screenShot(WebDriver driver, String filename) {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	
}
