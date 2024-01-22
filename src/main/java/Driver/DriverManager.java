package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class DriverManager {

	static WebDriver driver = null;

	private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static void setDriver(WebDriver DriverRf) {

		dr.set(DriverRf);
	}

	public static WebDriver getDriver() {

		return dr.get();
	}

	public static void unload() {

		dr.remove();
	}

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public static void startDriver(String BrowserName) {

		if (getDriver() == null) {

			switch (BrowserName.toLowerCase()) {

			case "chrome":

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				setDriver(new ChromeDriver(chromeOptions));

				break;

			case "firefox":

				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				setDriver(new FirefoxDriver(firefoxOptions));

				break;

			case "edge":

				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				setDriver(new EdgeDriver(edgeOptions));

				break;
			}
		}
	}
	
	
	@Parameters("browser")
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public static void closeDriver() {

		if (getDriver() != null) {

			getDriver().quit();
		}
	}

}
