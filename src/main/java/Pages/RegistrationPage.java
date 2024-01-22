package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import BasePage.BasePage;

public class RegistrationPage extends BasePage {

	private Faker faker = new Faker();

	public RegistrationPage() {

	}

	private By male_gender = By.xpath("//input[@id='gender-male']");
	private By female_gender = By.xpath("//input[@id='gender-female']");
	private By first_name = By.id("FirstName");
	private By last_name = By.id("LastName");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By confirm_password = By.id("ConfirmPassword");
	private By registrationButton = By.id("register-button");
	private By registrationSuccessMessage = By.xpath("//div[@class=\"result\"]");

	public void SelectMaleGender() {

		elementToBeClickable(male_gender);
		clickElement(male_gender);

	}

	public void SelectFemaleGender() {

		elementToBeClickable(female_gender);
		clickElement(female_gender);
	}

	public void EnterFirstName() {

		presenceOfElement(first_name);
		enterInput(first_name, faker.name().firstName());
	}

	public void EnterLastName() {

		presenceOfElement(last_name);
		enterInput(last_name, faker.name().lastName());
	}

	public void EnterEmail() {

		String name = faker.name().firstName();
		String lastname = faker.name().lastName();

		presenceOfElement(email);
		enterInput(email, name + lastname + "@gmail.com");
	}

	public void EnterPassword() {

		presenceOfElement(password);
		enterInput(password, "test@123");
	}

	public void EnterConfrimPassword() {

		presenceOfElement(confirm_password);
		enterInput(confirm_password, "test@123");
	}

	public void ClickOnRegisterButton() {

		elementToBeClickable(registrationButton);
		clickElement(registrationButton);
	}

	public String SuccessfullRegistrationMessage() {

		return getElement(registrationSuccessMessage).getText();
	}
}
