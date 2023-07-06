package com.runner;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;
import com.helper.File_Reader_Manager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Welcome\\eclipse-workspace\\Sauce_Demo_Project\\src\\test\\java\\com\\feature\\login_and_purchase.feature", 
                  glue = "com.stepdefinitions",
                  plugin= {"pretty", 
                		   "html:target/sauce_html_report.html" ,
                		   "json:target/sauce_html_report.json"
                		  , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner {
	public static WebDriver driver;

	@BeforeClass
	public static void setup() throws IOException {

		String browser = File_Reader_Manager.getInstanceCr().getBrowser();
		driver = BaseClass.browserLaunch(browser);
	}

}
