package appTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowsExample {

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

		driver.get("https://demoqa.com/browser-windows");

		//driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Before clicking tab button: " + parentWindow);
		
		//WebElement window = driver.findElement(By.id("windowButton"));
		WebElement tab = driver.findElement(By.id("tabButton"));
		tab.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		
		while (iterator.hasNext()) {
			String currentHandel = iterator.next();
			System.out.println(currentHandel);
			if (!currentHandel.equals(parentWindow)) {
				driver.switchTo().window(currentHandel);
				
			}
			
		}
		
		WebElement ChildWinElem = driver.findElement(By.tagName("h1"));
		System.out.println("Text on new window is " + ChildWinElem.getText());
		
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
		//driver.close();

	}

}
