package pom.saucedemo;

import org.openqa.selenium.WebDriver;

public class Page_Object_Manager {

	public static WebDriver driver;

	private SauceDemoCartPage s;

	private SauceDemoCheckOutCompletePage s1;

	private SauceDemoCheckOutOverviewPage s2;

	private SauceDemoInformationPage s3;

	private SauceDemoInventoryPage s4;

	private SauceDemoLoginPage s5;

	public Page_Object_Manager(WebDriver driver) {

		this.driver=driver;
	}

	public SauceDemoLoginPage getSauceDemoLoginPage() {

		s5 = new SauceDemoLoginPage(driver);
		
		return s5;
	}

	public SauceDemoInventoryPage getSauceDemoInventoryPage() {

		s4 = new SauceDemoInventoryPage(driver);
		
		return s4;

	}
	
	public SauceDemoInformationPage getSauceDemoInformationPage() {
		
		s3= new SauceDemoInformationPage(driver);
		
		return s3;
	}
	
	public SauceDemoCheckOutOverviewPage getSauceDemoCheckOutOverviewPage() {
		
		s2= new SauceDemoCheckOutOverviewPage(driver);
		
		return s2;
	}
	
	public SauceDemoCheckOutCompletePage  getSauceDemoCheckOutCompletePage() {
		
		s1= new SauceDemoCheckOutCompletePage(driver);
		
		return s1;
	}
	
	public SauceDemoCartPage getSauceDemoCartPage() {
		
		s= new SauceDemoCartPage(driver);
		
		return s;
	}
	
	

}
