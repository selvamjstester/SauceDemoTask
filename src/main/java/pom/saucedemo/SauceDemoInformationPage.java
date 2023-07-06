package pom.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoInformationPage {
public static WebDriver driver;
	
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstname;
	
	@FindBy(xpath  = "//input[@data-test='lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement zipCode;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	public SauceDemoInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
}
