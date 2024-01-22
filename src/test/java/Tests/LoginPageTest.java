package Tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Base.BaseTest;
import Driver.DriverManager;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.CommonFunctions;
import Utils.ExcelDataProvidor;
import Utils.ExtentManager;
import Utils.Log;
import Utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {

	@Description("Verify user able to login or not")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = { "Smoke" })
	public void LoginFunctionalityTest(String email, String password) {

		Log.StartTestCase("LoginFunctionalityTest");

		Log.Info("Step_1: Go to login page");
		new HomePage().GoToLoginPage();

		Log.Info("Step_2: Enter the email & password & click on the login button");
		HomePage homepage = new LoginPage().loginToNopCommerce(email, password).afterLogin();

		Log.Info("Step_3: Verify the result");
		String ActualResult = homepage.HomePageText();
		String ExpectedResult = "My account";
		new CommonFunctions().addAssert(ActualResult, ExpectedResult);

		Log.EndTestCase("LoginFunctionalityTest");

		new ExtentManager().test.pass("User login successful we are on the homepage");

	}
}
