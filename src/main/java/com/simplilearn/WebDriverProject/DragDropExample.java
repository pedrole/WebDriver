package com.simplilearn.WebDriverProject;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragDropExample {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 DesiredCapabilities caps = new DesiredCapabilities();

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--lang=en");
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			HashMap<String, Object> profile = new HashMap<String, Object>();
			HashMap<String, Object> contentSettings = new HashMap<String, Object>();
			
			contentSettings.put("cookies",2);
			profile.put("managed_default_content_settings",contentSettings);
			prefs.put("profile",profile);
			chromeOptions.setExperimentalOption("prefs",prefs);
			caps.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
			
			WebDriver driver = new ChromeDriver(caps);
			
			

			driver.get("https://demo.guru99.com/test/drag_drop.html");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			
		    
			
			WebElement from = driver.findElement(By.xpath("//li[@id='credit2']/a"));
			
		       WebElement To = driver.findElement(By.xpath("//ol[@id='bank']/li"));
		       
		       Actions actions = new Actions(driver);
		       actions.dragAndDrop(from, To).build().perform();



	}

}
