package pom.saucedemo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoInventoryPage {

public static WebDriver driver;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement sortDropdown;
	
	@FindBy(xpath  = "//div[@class='inventory_item_price']")
	private List<WebElement> itemPrices;
	
	@FindBy(xpath = "//button[contains(., 'Add to cart')]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartIcon;
	
	public SauceDemoInventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getSortDropdown() {
		return sortDropdown;
	}

	public List<WebElement> getItemPrices() {
		return itemPrices;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}
	
	
}
