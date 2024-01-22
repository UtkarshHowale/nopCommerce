package Tests;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseTest;
import Driver.DriverManager;
import Pages.HomePage;
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

public class ShoopingCartPageTest extends BaseTest {

	@Description("Verify that we able to add searched product into the shooping cart and check its displying on shooping cart page or not")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = { "Sanity",
			"Regression" }, priority = 1)
	public void ProductAddToShoopingCartTest(String Product) {

		Log.StartTestCase("ProductAddToShoopingCartTest");

		Log.Info("Step_1: Enter product name in search box");
		new HomePage().SearchProduct(Product);

		Log.Info("Step_2: Click on search button");
		new HomePage().ClickOnSearchButton();

		Log.Info("Step_3: Scroll till product details dispalaying");
		new CommonFunctions().Scroll();

		Log.Info("Step_4: Check the searched product is displaying or not");
		WebElement product = new SearchResultPage().SearchedProduct();

		if (!product.isDisplayed()) {

			Log.Error("Searched product is not displayed");

		} else {

			Log.Info("Step_5: Click on add to cart button");
			new SearchResultPage().ClickOnAddToCart();

			Log.Info("Step_6: Click on shooping cart link");
			ShoopingCartPage shopCartPage = new SearchResultPage().ClickOnShoopingCartLink();

			Log.Info("Step_7: Verify the product is displaying on the shooping cart page");
			WebElement cartproduct = shopCartPage.Product();

			if (!cartproduct.isDisplayed()) {

				Log.Error("Product is not showing on the shooping cart page");

			} else {

				Log.Info("Product is displaying on the shooping cart page");

			}
		}

		Log.EndTestCase("ProductAddToShoopingCartTest");

		new ExtentManager().test.pass(
				"Searched Product is sucessfully added to the shooping cart and it is displaying on the shooping cart page");
	}

	@Description("Verify that we able to go to the check out page or not")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = { "sanity",
			"regression" }, priority = 2)
	public void GoToCheckOutPage(String Proudct, String ExpectedUrl) {

		Log.StartTestCase("GoToCheckOutPage");

		Log.Info("Step_1: Enter product name in search box");
		new HomePage().SearchProduct(Proudct);

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

		Log.Info("Step_8: Verify the result");
		new CommonFunctions().VerifyCurrentPageUrl(ExpectedUrl);

		Log.EndTestCase("GoToCheckOutPage");

		new ExtentManager().test.pass("We are sucessfully landed on the checkout page");
	}

	@Description("Verify the total price is showing correct or not")
	@Test(groups = { "sanity", "regression" }, priority = 3)
	public void VerifyTheTotalPrice(String Product, String TotalPrice) {

		Log.StartTestCase("VerifyTheTotalPrice");

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

		Log.Info("Step_6: Verify the total price");
		String ActualTotalPrice = new ShoopingCartPage().TotalPriceValue();
		new CommonFunctions().addAssert(ActualTotalPrice, TotalPrice);

		Log.EndTestCase("VerifyTheTotalPrice");

		new ExtentManager().test.pass("Total price verified sucessfully");

	}

}
