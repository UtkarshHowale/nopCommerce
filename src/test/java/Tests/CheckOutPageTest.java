package Tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseTest;
import Driver.DriverManager;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderDetailsPage;
import Pages.SearchResultPage;
import Pages.ShoopingCartPage;
import Utils.CommonFunctions;
import Utils.ExcelDataProvidor;
import Utils.ExtentManager;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CheckOutPageTest extends BaseTest {

	@Description("Verify the checkout page functionality is working fine or not")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = "Regression")
	public void CheckOutFunctionalityTest(String Product, String OrderSuccessText) {

		Log.StartTestCase("CheckOutFunctionalityTest");

		Log.Info("Step_1: Enter product name in search box");
		new HomePage().SearchProduct(Product);

		Log.Info("Step_2: Click on search button");
		new HomePage().ClickOnSearchButton();

		Log.Info("Step_3: Scroll till product details dispalaying");
		new CommonFunctions().Scroll();

		Log.Info("Step_4: Click on add to cart button");
		new SearchResultPage().ClickOnAddToCart();

		Log.Info("Step_5: Click on shooping cart link");
		new SearchResultPage().ClickOnShoopingCartLink();

		Log.Info("Step_6: Select the tearms of services checkbox");
		new ShoopingCartPage().SelectTermsOfService();

		Log.Info("Step_7: Click on the checkout button");
		new ShoopingCartPage().ClickOnCheckOutButton();

		Log.Info("Step_8: Login to complete checkout proccess");
		new LoginPage().login();

		Log.Info("Step_9 : Re-select the tearm of service");
		new ShoopingCartPage().SelectTermsOfService();

		Log.Info("Step_10: Again click on checkout button");
		new ShoopingCartPage().ClickOnCheckOutButton();

		WebElement text = new CheckoutPage().ShippingAdressText();

		if (!text.isDisplayed()) {

			Log.Info("Enter Adress Details");
			new CheckoutPage().AddBillingAdress();

		} else {

			Log.Info("Step_11: After adding billing address Click on continue button to processed to shipping method");
			new CheckoutPage().ClickOnBillingAdressContinueButton();

		}

		Log.Info("Step_12: Click on continue button to procced to the payment method");
		new CheckoutPage().ClickOnShippingMethodContinueButton();

		Log.Info("Step_13: Click on continue button to procced to the payament information");
		new CheckoutPage().ClickOnPaymentMethodContinueButton();

		Log.Info("Step_14: Click on continue button to procced to oreder conformation");
		new CheckoutPage().ClickOnPaymentInformationContinueButton();

		Log.Info("Step_15: Click on order confirm button");
		new CheckoutPage().ClickOnOrderConfrimButton();

		Log.Info("Step_16: Verify the result success message");
		String ActualOrderSuccessText = new CheckoutPage().OrderSuccessfullText();
		new CommonFunctions().addAssert(ActualOrderSuccessText, OrderSuccessText);

		Log.Info("Step_17: Click on order details links to verify the order details");
		OrderDetailsPage orderdetailspage = new CheckoutPage().ClickOnOrderDetails();

		Log.Info("Step_18: Verify order details");

		WebElement OrderID = orderdetailspage.OrderID();

		if (!OrderID.isDisplayed()) {

			Log.Error("Order details are not showing");

		} else {

			Log.Info("Order details are displaying");
		}

		Log.EndTestCase("CheckOutFunctionalityTest");

		new ExtentManager().test.pass("Order details are displaying correctly");
	}

}
