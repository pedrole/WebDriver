package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String user, String pass) {
		
		
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		
		WebElement userName= driver.findElement(By.name("user_login"));
		userName.sendKeys(user);
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(pass);
		
		 WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
	}
}
