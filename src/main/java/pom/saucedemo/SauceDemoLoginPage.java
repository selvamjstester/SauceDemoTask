package pom.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {
	
public static WebDriver driver;
	
	@FindBy(id = "user-name")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='login-button']")
	private WebElement loginButton;
	
	public SauceDemoLoginPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2,this);
	}
	
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}


}
