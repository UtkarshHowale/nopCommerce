package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;

public class WishlistPage extends BasePage {

	public WishlistPage() {

	}

	private By product_name = By.xpath("//a[@class=\"product-name\"]");

	public WebElement Product() {

		presenceOfElement(product_name);
		WebElement product = getElement(product_name);
		return product;

	}
}
