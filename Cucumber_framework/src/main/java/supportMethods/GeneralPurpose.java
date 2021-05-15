package supportMethods;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.google.common.io.Files;
import stepDefinition.Hooks;
import testRunner.TestRunner;

public class GeneralPurpose {

	private static WebDriver driver = Hooks.getCurrentDriver();

	public static String todaysDate() {

		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getCurrentTime() {

		Calendar calander = Calendar.getInstance();
		Date time = calander.getTime();
		return time.toString();
	}


	public static String getCurrentScenario() {

		return TestRunner.scenario.getName(); 
	}

	public static String getScenarioResult() {

		return TestRunner.scenario.getStatus(); 
	}

	public static String takeScreenShot(String filename) throws IOException {

		try {

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "/results/"+todaysDate()+"/" + filename + ".png";
			File newFile = new File(filePath);
			Files.copy(file, newFile);
			return filePath;

		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage()); 
			return null; 
		}
	}
}

