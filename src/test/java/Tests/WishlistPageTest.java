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
import Pages.WishlistPage;
import Utils.CommonFunctions;
import Utils.ExcelDataProvidor;
import Utils.ExtentManager;
import Utils.Log;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class WishlistPageTest extends BaseTest {

	@Description("Verify that we able to add searched product into the wishlist and check its displaying on wishlist page or not")
	@Test(dataProviderClass = ExcelDataProvidor.class, dataProvider = "TestData", groups = { "Sanity", "Regression" })
	public void ProductAddToWishlistTest(String ProductName, String ExpectedSuccessMessage) {

		Log.StartTestCase("ProductAddToWishlistTest");

		Log.Info("Step_1: Enter product name in search box");
		new HomePage().SearchProduct(ProductName);

		Log.Info("Step_2: Click on search button");
		new HomePage().ClickOnSearchButton();

		Log.Info("Step_3: Scroll till product details dispalaying");
		new CommonFunctions().Scroll();

		Log.Info("Step_4: Check the searched product is displaying or not");
		WebElement product = new SearchResultPage().SearchedProduct();

		if (!product.isDisplayed()) {

			Log.Error("Searched product is not displayed");

		} else {

			Log.Info("Step_5: Click on the add wishlist button");
			new SearchResultPage().ClickOnAddToWishlistButton();

			Log.Info("Step_6: Verify the success message is showing");
			String ActualSuccessMessage = new SearchResultPage().WishlistSuccessMessage();
			new CommonFunctions().addAssert(ActualSuccessMessage, ExpectedSuccessMessage);

			Log.Info("Step_7: Click on to the wishlist page link to navigate to the wishlist page");
			WishlistPage wishlistPage = new SearchResultPage().ClickOnWishlistPageLink();

			Log.Info("Step_8: Verify the product is displaying on the wishlist page");
			WebElement wishlistproduct = wishlistPage.Product();

			if (!wishlistproduct.isDisplayed()) {

				Log.Error("Product is not showing into the wishlist");

			} else {

				Log.Info("Product is displaying in the wishlist");
			}

			Log.EndTestCase("ProductAddToWishlistTest");

			new ExtentManager().test.pass(
					"Searched Product is sucessfully added to the wishlist and it is displaying on the wishlist page");
		}
	}
}
