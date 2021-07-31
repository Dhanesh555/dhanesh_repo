package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import supportMethods.BrowserFactory;
import supportMethods.FileRead;
import supportMethods.GeneralPurpose;
import testRunner.TestRunner;

public class Hooks {

	private static WebDriver driver;
	private static String browser;


	@Before
	public void executeBeforeScenario(Scenario scenario) throws
	FileNotFoundException, IOException {

		TestRunner.scenario = scenario; 
		browser = FileRead.readProperties().get("chrome"); 
		driver = BrowserFactory.selectBrowser(browser);
		System.out.println(browser+" launched sucessfully...."); 
	}


	@After
	public void takeScreenshot() throws IOException {

		String fileName = GeneralPurpose.getCurrentScenario()+"_"+GeneralPurpose.getCurrentTime();
		GeneralPurpose.takeScreenShot(fileName);
	}

	@After()
	public void executeAfterScenario() throws IOException {

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
