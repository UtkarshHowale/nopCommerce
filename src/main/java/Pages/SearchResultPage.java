package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;

public class SearchResultPage extends BasePage {

	public SearchResultPage() {
		
	}
	
	private By product_name = By.xpath("//h2[@class=\"product-title\"]");
	private By wishlistButton = By.xpath("//button[@title=\"Add to wishlist\"]");
	private By wishlistsuccessText = By.xpath("//p[@class=\"content\"]");
	private By wishlistlink = By.xpath("//a[@href=\"/wishlist\"]");
	private By shoopingcartlink = By.xpath("//a[@href=\"/cart\"]");
	private By addtocartbutton = By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]");
	private By addCart = By.xpath("//button[@id='add-to-cart-button-4']");
	
	public String ProductName() {
		
		presenceOfElement(product_name);
		return getElement(product_name).getText();
	}
	
	public void ClickOnAddToWishlistButton() {
		
		elementToBeClickable(wishlistButton);
		clickElement(wishlistButton);
	}
	
	public WebElement SearchedProduct() {
		
		WebElement product =  getElement(product_name);
		return product;
		
	}
	
	public String WishlistSuccessMessage() {
		
		presenceOfElement(wishlistsuccessText);
		return getElement(wishlistsuccessText).getText();
	}
	
	public WishlistPage ClickOnWishlistPageLink() {
		
		elementToBeClickable(wishlistlink);
		clickElement(wishlistlink);
		return new WishlistPage();
	}
	
	public void ClickOnAddToCart() {
		
		presenceOfElement(addtocartbutton);
		clickElement(addtocartbutton);
	}
	
	public ShoopingCartPage ClickOnShoopingCartLink() {
		
		presenceOfElement(addCart);
		clickElement(addCart);
		presenceOfElement(shoopingcartlink);
		clickElement(shoopingcartlink);
		return new ShoopingCartPage();
	}
	
}
