package com.simplilearn.WebDriverProject;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AlertsExample {

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
			
				driver.get("https://demoqa.com/alerts");
			
			/*WebElement elem = driver.findElement(By.xpath("//*[@id='alertButton']"));
	        elem.click();*/
				WebElement confirm = driver.findElement(By.xpath("//*[@id='confirmButton']"));
				confirm.click();
	        
	        Alert alert = driver.switchTo().alert();
	        System.out.println(alert.getText());
	        //alert.accept();
	        alert.dismiss();



	}

}
