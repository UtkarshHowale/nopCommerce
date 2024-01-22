package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import Utils.Log;

public class ShoopingCartPage extends BasePage {


	public ShoopingCartPage() {

	}

	private By product_name = By.xpath("//a[@class=\"product-name\"]");
	private By totalPricetext = By.xpath("//span[@class=\"value-summary\"]");
	private By checkout_button = By.name("checkout");
	private By termsofservice_checkbox = By.xpath("//input[@id='termsofservice']");

	public WebElement Product() {

		presenceOfElement(product_name);
		WebElement product = getElement(product_name);
		return product;

	}

	public String TotalPriceValue() {

		presenceOfElement(totalPricetext);
		return getElement(totalPricetext).getText();
	}

	public CheckoutPage ClickOnCheckOutButton() {

		presenceOfElement(checkout_button);
		clickElement(checkout_button);
		return new CheckoutPage();
	}

	public void SelectTermsOfService() {

		WebElement checkbox = getElement(termsofservice_checkbox);

		if (!checkbox.isSelected()) {

			checkbox.click();

		}
	}

}
