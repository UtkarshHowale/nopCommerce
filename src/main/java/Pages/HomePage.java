package Pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import Utils.CommonFunctions;

public class HomePage extends BasePage {

	public HomePage() {

	}

	private By HomePageText = By.xpath("//a[@class=\"ico-account\"]");
	private By LogoImage = By.xpath("//img[@alt=\"nopCommerce demo store\"]");
	private By RegistrationLink = By.xpath("//a[@class=\"ico-register\"]");
	private By LoginPageLink = By.xpath("//a[normalize-space()='Log in']");
	private By search_text = By.xpath("//form[@id=\"small-search-box-form\"]//input[@id=\"small-searchterms\"]");
	private By searchButton = By.xpath("//form[@id=\"small-search-box-form\"]//button[@class=\"button-1 search-box-button\"]");
	private By HeaderMenuComputer = By.xpath("//a[@href=\"/computers\"]");
	
	public WebElement logoImage() {

		WebElement logo = getElement(LogoImage);
		return logo;

	}

	public String HomePageText() {

		return getElement(HomePageText).getText();
	}

	public void GoToRegistrationPage() {

		elementToBeClickable(RegistrationLink);
		clickElement(RegistrationLink);
	}

	public void GoToLoginPage() {

		elementToBeClickable(LoginPageLink);
		clickElement(LoginPageLink);
	}

	public void SearchProduct(String value) {

		presenceOfElement(search_text);
		enterInput(search_text, value);

	}

	public void ClickOnSearchButton() {
		elementToBeClickable(searchButton);
		clickElement(searchButton);
	}

}
