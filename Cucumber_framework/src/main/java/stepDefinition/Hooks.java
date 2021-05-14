package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import supportMethods.BrowserFactory;
import supportMethods.FileRead;

public class Hooks {

	public static WebDriver driver;
	private static String browser;
	
	@Before
	public void executeBeforeScenario() throws FileNotFoundException, IOException {
		
		browser = FileRead.readProperties().get("chrome");
		driver = BrowserFactory.selectBrowser(browser);
		System.out.println(browser+" launched sucessfully....");
	}
	
	@AfterStep
	public void takeScreenshot() {
		
	}
	
	@After
	public void executeAfterScenario() {
		
		driver.quit();
		System.out.println(browser+" closed sucessfully....");
	}
	
	public static WebDriver getCurrentDriver() {
		
		if (driver != null) 
			return driver;
		else
			throw new WebDriverException("WebDriver instance is null...");
	}
}
