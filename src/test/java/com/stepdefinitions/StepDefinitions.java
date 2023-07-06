package com.stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.helper.File_Reader_Manager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pom.saucedemo.Page_Object_Manager;

public class StepDefinitions extends BaseClass{
	Page_Object_Manager pom = new Page_Object_Manager(driver);
	
	@Before
	public static void beforeEveryScenario() throws IOException {

		takeScreenshot(driver, "beforeScenario");
	}
	
	@After
	public static void afterEveryScenario() throws IOException {
		takeScreenshot(driver, "afterScenario");

	}
	
	@Given("I am on the Demo Login Page")
	public void i_am_on_the_demo_login_page() throws IOException {
		String url = File_Reader_Manager.getInstanceCr().getUrl();
		getUrl(url);
	    
	}


	@When("I fill the account information for account StandardUser into the UserName field and the PassWord field")
	public void i_fill_the_account_information_for_account_standard_user_into_the_user_name_field_and_the_pass_word_field(io.cucumber.datatable.DataTable dataTable) {
	   
		
	    
	    List<List<String>> li = dataTable.asLists();
	    pom.getSauceDemoLoginPage().getUserName().sendKeys(li.get(0).get(0));
	    pom.getSauceDemoLoginPage().getPassword().sendKeys(li.get(0).get(1));

	    
	}



	@When("I click the Login Button")
	public void i_click_the_login_button() {
	    pom.getSauceDemoLoginPage().getLoginButton().click();

	}
	@Then("I am redirected to the Demo Main Page")
	public void i_am_redirected_to_the_demo_main_page() {
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		if (actualUrl.equals(expectedUrl)) {
			System.out.println("User is Redirected to the Main Page");
			//Reporter.log
		} else {
			System.err.println("User is not Redirected to the Main Page");
		}
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	@Then("I verify the App Logo exists")
	public void i_verify_the_app_logo_exists() {
		WebElement appLogo = driver.findElement(By.xpath("//div[@class='app_logo']"));
		if (appLogo.isDisplayed()) {
			System.out.println("User verifies App Logo ");
			//Reporter.log
		} else {
			System.err.println("User Unable to see App Logo ");
		} 
		Assert.assertTrue(appLogo.isDisplayed());
	}
	
	@When("I fill the account information for account LockedOutUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field() {
	    pom.getSauceDemoLoginPage().getUserName().sendKeys("locked_out_user");
	    pom.getSauceDemoLoginPage().getPassword().sendKeys("secret_sauce");

	}
	
	@Then("I verify the Error Message contains the text {string}")
	public void i_verify_the_error_message_contains_the_text(String string) throws InterruptedException {
		String expectedMsg = string;
		System.out.println(expectedMsg);
		Thread.sleep(2000);
		WebElement errorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		String actualMsg = errorMsg.getText();
		System.out.println(actualMsg);
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("User verify the Error Message");
			//Reporter.log
		} else {
			System.err.println("User unable verify the Error Message");
		} 
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	@Given("I am on the inventory page")
	public void i_am_on_the_inventory_page() throws IOException {
		String url = File_Reader_Manager.getInstanceCr().getUrl();
		getUrl(url);
		 pom.getSauceDemoLoginPage().getUserName().sendKeys("standard_user");
		 pom.getSauceDemoLoginPage().getPassword().sendKeys("secret_sauce");
		 pom.getSauceDemoLoginPage().getLoginButton().click();
	}
	@When("user sorts products from low price to high price")
	public void user_sorts_products_from_low_price_to_high_price() {
		String sort ="Price (low to high)";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectByVisibleText(pom.getSauceDemoInventoryPage().getSortDropdown(),sort);
	}
	@When("user adds lowest priced product")
	public void user_adds_lowest_priced_product() throws InterruptedException {
		List<WebElement> itemsPrices = pom.getSauceDemoInventoryPage().getItemPrices();
		int totalItems = itemsPrices.size();
		System.out.println("Total Items: "+totalItems);
		
		    Double lowestValue = null;
	        WebElement addToCartButton = null;
	        
		for (WebElement item : itemsPrices) {
			String text = item.getText();
			String value = text.replace("$", "");
			System.out.println(value);
			Double itemValue = Double.valueOf(value);
			
			 if (lowestValue == null || itemValue < lowestValue) {
	                lowestValue = itemValue;
	               Thread.sleep(1000);
	                addToCartButton = driver.findElement(By.xpath("(//button[contains(., 'Add to cart')])[1]"));
	            }
		}
		System.out.println("Lowest Value is: "+lowestValue );
		addToCartButton.click();
	}
	@When("user clicks on cart")
	public void user_clicks_on_cart() {
	    pom.getSauceDemoInventoryPage().getCartIcon().click();
	}
	@When("user clicks on checkout")
	public void user_clicks_on_checkout() {
	    pom.getSauceDemoCartPage().getCheckOut().click();
	}
	@When("user enters first name John")
	public void user_enters_first_name_john() {
	    pom.getSauceDemoInformationPage().getFirstname().sendKeys("John");
	}
	@When("user enters last name Doe")
	public void user_enters_last_name_doe() {
	    pom.getSauceDemoInformationPage().getLastName().sendKeys("Doe");

	}
	@When("user enters zip code {int}")
	public void user_enters_zip_code(Integer int1) {
		String valueOf = String.valueOf(int1);
	    pom.getSauceDemoInformationPage().getZipCode().sendKeys(valueOf);

	}
	@When("user clicks Continue button")
	public void user_clicks_continue_button() {
	    pom.getSauceDemoInformationPage().getContinueButton().click();

	}
	@Then("I verify in Checkout overview page if the total amount for the added item is ${double}")
	public void i_verify_in_checkout_overview_page_if_the_total_amount_for_the_added_item_is_$(Double double1) {
		String expectedtotalAmount = "Total: $8.63";
		String actualtotalAmount = pom.getSauceDemoCheckOutOverviewPage().getTotalAmount().getText();
		System.out.println(actualtotalAmount);
		if (actualtotalAmount.equals(expectedtotalAmount)) {
			System.out.println("User verify the total amount for the added item is $8.63");
			
		} else {
			System.err.println("User unable verify the total amount for the added item is $8.63");
		} 
		
		Assert.assertEquals(expectedtotalAmount, actualtotalAmount);
		
	}
	@When("user clicks Finish button")
	public void user_clicks_finish_button() {
		pom.getSauceDemoCheckOutOverviewPage().getFinish().click();
	}
	@Then("Thank You header is shown in Checkout Complete page")
	public void thank_you_header_is_shown_in_checkout_complete_page() {
		if (pom.getSauceDemoCheckOutCompletePage().getThankYouHeader().isDisplayed()) {
			System.out.println("Thank you Header is Displayed ");
		}
		String thankYouText = pom.getSauceDemoCheckOutCompletePage().getThankYouHeader().getText();
		System.out.println(thankYouText);
		//Reporter.log
		
	}
	
}
