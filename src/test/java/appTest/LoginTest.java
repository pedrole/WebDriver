package appTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static WebElement findElement;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		
		WebElement userName= driver.findElement(By.name("user_login"));
		userName.sendKeys("xyz@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345678_Aa");
		
		 WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		WebElement loginBtn = driver.findElement(By.name("btn_login"));
		loginBtn.click();
		
		
		WebElement errorMsg = driver.findElement(By.id("msg_box"));
		String actError = errorMsg.getText();
		String expectedError = "The email or password you have entered is invalid.";
		
		
		if(actError.equals(expectedError)) {
			System.out.println("TC is passed");
		}
		else
			System.out.println("TC is failed");
		
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		 System.out.println("Total nums of links is: " + links.size());
		 
		 for (int i = 0; i < links.size(); i++) {
			 System.out.println(links.get(i).getText());
			 System.out.println(links.get(i).getAttribute("href"));
			
		}
		
		driver.close();
	}

}
