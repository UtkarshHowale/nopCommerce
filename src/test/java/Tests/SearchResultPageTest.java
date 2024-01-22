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
import Utils.CommonFunctions;
import Utils.ExcelDataProvidor;
import Utils.ExtentManager;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SearchResultPageTest extends BaseTest {

	@Description("Verify that we able to search product or not and also searched product is available or not ")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = {"Smoke","Sanity"})
	public void SearchedProductAvailabilityTest(String ProductName) {

		Log.StartTestCase("SearchedProductAvailabilityTest");

		Log.Info("Step_1: Enter product name in search box");
		new HomePage().SearchProduct(ProductName);

		Log.Info("Step_2: Click on search button");
		new HomePage().ClickOnSearchButton();

		Log.Info("Step_3: Scroll till product details dispalaying");
		new CommonFunctions().Scroll();

		Log.Info("Step_4: Verify the result");

		String SearchedProduct = new SearchResultPage().ProductName();
		new CommonFunctions().addAssert(SearchedProduct, ProductName);

		Log.EndTestCase("SearchedProductAvailabilityTest");

		new ExtentManager().test.pass("Searched product is dispalying and its avalaible");

	}

}
