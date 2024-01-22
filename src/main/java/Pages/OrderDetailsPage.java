package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;

public class OrderDetailsPage extends BasePage{

	public OrderDetailsPage() {
	
	}
	
	private By order_id = By.xpath("//div[@class=\"order-number\"]");
	
	public WebElement OrderID() {
		
		return getElement(order_id);
	}
}
