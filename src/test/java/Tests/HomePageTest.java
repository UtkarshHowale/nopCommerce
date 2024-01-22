
package Tests;

import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Base.BaseTest;
import Driver.DriverManager;
import Pages.HomePage;
import Utils.CommonFunctions;
import Utils.ExtentManager;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends BaseTest {

	@Description("Verify the title of the homepage is matching as per expectation or not")
	@Test(groups = "Smoke", priority = 1)
	public void HomePageTitleTest() {

		Log.StartTestCase("HomePageTitleTest");

		Log.Info("Verify homepage title to ensure that we are on homepage");
		new CommonFunctions().VerifyCurrentThePageTitle("nopCommerce demo store");

		Log.EndTestCase("HomePageTitleTest");

		new ExtentManager().test.pass("Title verified sucessfully");
	}

	@Description("Verify the logo image is displaying on the homepage or not")
	@Test(groups = "Smoke", priority = 2)
	public void LogoImageTest() {

		Log.StartTestCase("LogoImageTest");

		WebElement logo = new HomePage().logoImage();

		if (!logo.isDisplayed()) {

			Log.Error("Logo Image is not present on the homepage");

		} else {

			Log.Info("Logo Image is present on the homepage");
		}

		Log.EndTestCase("LogoImageTest");

		new ExtentManager().test.pass("Logo image is present");

	}

}
