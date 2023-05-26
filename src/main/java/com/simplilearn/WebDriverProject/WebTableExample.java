package com.simplilearn.WebDriverProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableExample {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--lang=en");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
	    
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println("Total numnber of rows is: " + rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("Total number of columns is: " + columns.size());
		
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		System.out.println(data.getText());
		
		

	}

}
