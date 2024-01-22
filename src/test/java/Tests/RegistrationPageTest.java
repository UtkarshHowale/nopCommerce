package Tests;

import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import Base.BaseTest;
import Driver.DriverManager;
import Pages.HomePage;
import Pages.RegistrationPage;
import Utils.CommonFunctions;
import Utils.ExtentManager;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegistrationPageTest extends BaseTest {

	@Description("Verify that the user able to register or not")
	@Test(groups = "Sanity")
	public void RegistrationFunctionalityTest() {

		Log.StartTestCase("RegistrationFunctionalityTest");

		Log.Info("Step_1: Go to registration page");
		new HomePage().GoToRegistrationPage();

		Log.Info("Step_2: Select a gender");
		new RegistrationPage().SelectMaleGender();

		Log.Info("Step_3: Enter a first name");
		new RegistrationPage().EnterFirstName();

		Log.Info("Step_4: Enter a last name");
		new RegistrationPage().EnterLastName();

		Log.Info("Step_5: Enter a email id");
		new RegistrationPage().EnterEmail();

		Log.Info("Step_6: Enter a new password");
		new RegistrationPage().EnterPassword();

		Log.Info("Step_7: Enter a confrim password");
		new RegistrationPage().EnterConfrimPassword();

		Log.Info("Step_8: Click on the register button");
		new RegistrationPage().ClickOnRegisterButton();

		Log.Info("Step_9: Verify the result");
		String ActulSuccessMessage = new RegistrationPage().SuccessfullRegistrationMessage();
		String ExpectedSuccessMessage = "Your registration completed";

		new CommonFunctions().addAssert(ActulSuccessMessage, ExpectedSuccessMessage);

		Log.EndTestCase("RegistrationFunctionalityTest");

		new ExtentManager().test.pass("User registered successfully");
	}
}
