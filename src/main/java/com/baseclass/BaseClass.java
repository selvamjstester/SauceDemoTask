package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions ac;
	public static Select s;

	public static WebDriver browserLaunch(String name) {
		if (name.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\Users\\Welcome\\eclipse-workspace\\SeleniumJune\\Driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (name.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver",
//					"C:\\Users\\Welcome\\eclipse-workspace\\SeleniumJune\\Driver\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		return driver;

	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void alertHandling(String command) {

		if (command.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (command.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		}

	}

	public static void alertInsertValue(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void mouseHover(WebElement element) {
		ac = new Actions(driver);

		ac.moveToElement(element).perform();
	}

	public static void rightClick(WebElement element) {
		ac.contextClick(element).perform();
	}

	public static void selectByVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);

	}

	public static void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);

	}

	public static void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}
	
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + timestamp + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(filePath));
        return filePath;
    }
}
