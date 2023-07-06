package pom.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckOutCompletePage {
public static WebDriver driver;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement thankYouHeader;
	
	@FindBy(xpath  = "//button[text()='Back Home']")
	private WebElement backHome;
	
	
	public SauceDemoCheckOutCompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public WebElement getThankYouHeader() {
		return thankYouHeader;
	}


	public WebElement getBackHome() {
		return backHome;
	}
	
	
}
