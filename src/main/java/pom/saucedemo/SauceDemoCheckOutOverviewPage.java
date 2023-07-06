package pom.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCheckOutOverviewPage {
public static WebDriver driver;
	
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
	private WebElement totalAmount;
	
	@FindBy(xpath  = "//button[text()='Finish']")
	private WebElement finish;
	
	
	public SauceDemoCheckOutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public WebElement getTotalAmount() {
		return totalAmount;
	}


	public WebElement getFinish() {
		return finish;
	}
	
}
