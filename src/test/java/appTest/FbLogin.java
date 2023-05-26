package appTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FbLogin {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--lang=en");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
	    
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']")).click();
		
	WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
	userName.sendKeys("xyz@gmail.com");
	
	WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
	password.sendKeys("123456");
	
	WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
	
	loginButton.click();

	}

}
