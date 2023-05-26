package wdTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pages.LoginPage;



public class SimplilearnLogin extends BaseClass {
	
	
	@Test
	public void NegativeTest() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("xyz@gmail.com","12345678_Aa");
		
		
		WebElement errorMsg = driver.findElement(By.id("msg_box"));
		String actError = errorMsg.getText();
		String expectedError = "The email or password you have entered is invalid.";
		
		
		Assert.assertEquals(actError, expectedError);
		
		
		
	}
	
	@Test
	public void PositiveTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("lealpedro2009@gmail.com", "Shenmue2");
		
	}
	

	
	
}
