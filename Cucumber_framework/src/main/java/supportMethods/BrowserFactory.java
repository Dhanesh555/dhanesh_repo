package supportMethods;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory {

	public static WebDriver selectBrowser(String browser) {

		switch (browser) {
		case "chrome":
			return BrowserFactory.launchChromeBrowser();
		case "linuxChrome":
			return BrowserFactory.launchLinuxChromeBrowser();
		case "firefox":
			return BrowserFactory.launchFirefoxBrowser();
		case "internetExplorer":
			return BrowserFactory.launchIEBrowser();
		default:
			throw new WebDriverException("Please provide a browser...");
		}
	}

	private static WebDriver launchChromeBrowser() {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromeDriver//chromedriver");
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		option.setExperimentalOption("prefs", chromePrefs);
		return new ChromeDriver(option);
	}

	private static WebDriver launchFirefoxBrowser() {

		System.setProperty("webdriver.gecko.driver", ".//drivers//geckoDriver//geckodriver.exe");
		FirefoxOptions option = new FirefoxOptions();
		HashMap<String, Object> Prefs = new HashMap<String, Object>();
		Prefs.put("profile.default_content_settings.popups", 0);
		option.setCapability("prefs", Prefs);
		return new FirefoxDriver(option);
	}

	private static WebDriver launchLinuxChromeBrowser() {

		System.setProperty("webdriver.chrome.driver", ".//drivers//linuxChromeDriver//chromedriver");
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		option.setExperimentalOption("prefs", chromePrefs);
		return new ChromeDriver(option);
	}
	
	private static WebDriver launchIEBrowser() {

		System.setProperty("webdriver.chrome.driver", ".//drivers//chromeDriver//chromedriver.exe");
		InternetExplorerOptions option = new InternetExplorerOptions();
		HashMap<String, Object> Prefs = new HashMap<String, Object>();
		Prefs.put("profile.default_content_settings.popups", 0);
		option.setCapability("prefs", Prefs);
		return new InternetExplorerDriver(option);
	}
}
