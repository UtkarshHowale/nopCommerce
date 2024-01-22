package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import Utils.CommonFunctions;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage() {
		
	}
	
	private By first_name = By.id("BillingNewAddress_FirstName");
	private By last_name = By.id("BillingNewAddress_LastName"); 
	private By email = By.id("BillingNewAddress_Email");
	private By country = By.id("BillingNewAddress_CountryId");
	private By city = By.id("BillingNewAddress_City");
	private By address = By.id("BillingNewAddress_Address1");
	private By pin = By.id("BillingNewAddress_ZipPostalCode");
	private By phone_no = By.id("BillingNewAddress_PhoneNumber");
	private By billing_adress_continue_button =By.name("save");
	private By shipping_method_continuebutton = By.xpath("//button[@class='button-1 shipping-method-next-step-button']");
	private By payment_method_continuebutton = By.xpath("//button[@class='button-1 payment-method-next-step-button']");
	private By shippingadress_text = By.xpath("//label[@for=\"billing-address-select\"]");
	private By paymentinformation_continuebutton = By.xpath("//button[@class='button-1 payment-info-next-step-button']");
	private By orderconfrim_button = By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]");
	private By ordersucess_text = By.xpath("//div[@class=\"title\"]//strong");
	private By orderdetails_link = By.xpath("//a[normalize-space()='Click here for order details.']");
	
	public void AddBillingAdress() {
		
		presenceOfElement(first_name).clear();
		enterInput(first_name, "utkarsh");
		
		presenceOfElement(last_name).clear();
		enterInput(last_name, "howale");
		
		presenceOfElement(email).clear();
		enterInput(email, "utkarsh@mail.com");
		
		presenceOfElement(country);
		WebElement element = getElement(country);
		new CommonFunctions().SelectByVisibleText(element, "India");
		
		presenceOfElement(address);
		enterInput(address, "pune");
		
		presenceOfElement(city);
		enterInput(city, "dehu road");
		
		presenceOfElement(pin);
		enterInput(pin, "45892");
		
		presenceOfElement(phone_no);
		enterInput(phone_no, "9512586489");
		
		presenceOfElement(billing_adress_continue_button);
		clickElement(billing_adress_continue_button);
		
	}
	
	public void ClickOnBillingAdressContinueButton() {
		
		elementToBeClickable(billing_adress_continue_button);
		clickElement(billing_adress_continue_button);
	}
	
	public void ClickOnShippingMethodContinueButton() {
		
		elementToBeClickable(shipping_method_continuebutton);
		clickElement(shipping_method_continuebutton);
	}
	
	public void ClickOnPaymentMethodContinueButton() {
		
		elementToBeClickable(payment_method_continuebutton);
		clickElement(payment_method_continuebutton);
	}
	
	public WebElement ShippingAdressText() {
		
		presenceOfElement(shippingadress_text);
		return getElement(shippingadress_text);
	}
	
	public void ClickOnPaymentInformationContinueButton() {
		
		elementToBeClickable(paymentinformation_continuebutton);
		clickElement(paymentinformation_continuebutton);
	}
	
	public void ClickOnOrderConfrimButton() {
		
		elementToBeClickable(orderconfrim_button);
		clickElement(orderconfrim_button);
	}
	
	public String OrderSuccessfullText() {
		
		presenceOfElement(ordersucess_text);
		return getElement(ordersucess_text).getText();
	}

	public OrderDetailsPage ClickOnOrderDetails() {
		
		elementToBeClickable(orderdetails_link);
		clickElement(orderdetails_link);
		return new OrderDetailsPage();
	}
}
