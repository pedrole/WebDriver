package com.simplilearn.WebDriverProject;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FbSignUp {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--lang=en");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
	    
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']")).click();

		WebElement signUp = driver.findElement(By.xpath("//a[text()='Create new account']"));
		signUp.click();
		
		WebElement day = driver.findElement(By.id("day"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("15");
		
		WebElement month = driver.findElement(By.id("month"));
		Select ddMonth = new Select(month);
		ddMonth.selectByVisibleText("Aug");
		
		List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']/option"));
		
		for (WebElement monthElement : months) {
			System.out.println("month: " +monthElement.getText());
			
		}
		
		 WebElement selectedYear = driver.findElement(By.xpath("//select[@id='year']/option[@selected='1']"));
		 
		 System.out.println("Selected Year is: " + selectedYear.getText());
		 
		String genValue = "Male";
		// WebElement radioMale = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		 //radioMale.click();
		 WebElement dynamicGender = driver.findElement(By.xpath("//label[text()='" + genValue + "']/following-sibling::input"));
		 dynamicGender.click();
		
		

	}

}
