package Pages;

import org.openqa.selenium.By;

import BasePage.BasePage;
import Utils.PropertyReader;

public class LoginPage extends BasePage{

	public LoginPage() {
		
	}
	
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By login_button = By.xpath("//button[@class=\"button-1 login-button\"]");
	
	public void login() {
		
		try {
			
			presenceOfElement(email);
			enterInput(email,PropertyReader.readKeys("Email") );
			presenceOfElement(password);
			enterInput(password,PropertyReader.readKeys("Password") );
			presenceOfElement(login_button);
			clickElement(login_button);
		}
		catch(Exception e) {
		
			e.printStackTrace();
		}
	}
	
	public LoginPage loginToNopCommerce(String Email_id,String Password) {
		
		presenceOfElement(email);
		enterInput(email, Email_id);
		presenceOfElement(password);
		enterInput(password, Password);
		presenceOfElement(login_button);
		clickElement(login_button);
		
		return this;
		
	}
	
	public HomePage afterLogin() {
		
		return new HomePage();
	}
}
