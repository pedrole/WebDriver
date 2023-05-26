package appTest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IframeExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--lang=en");
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> contentSettings = new HashMap<String, Object>();

		contentSettings.put("cookies", 2);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		chromeOptions.setExperimentalOption("prefs", prefs);
		caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		WebDriver driver = new ChromeDriver(caps);

		driver.get("https://demoqa.com/frames");

		//driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		
		WebElement header = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(header.getText());
		
		driver.switchTo().defaultContent();

	}

}
