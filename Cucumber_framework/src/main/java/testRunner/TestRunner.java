package testRunner;

import java.io.File;
import java.io.IOException;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import supportMethods.FileRead;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = {"src\\test\\resources\\featureFiles\\sample.feature"}, 
		glue = { "stepDefinition" }, 
		tags = { "~@ignore"}, 
		plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, 
		monochrome = true, 
		dryRun = false)


public class TestRunner {

	public static Scenario scenario;
	public static void setReportProperties() throws IOException {

		Reporter.loadXMLConfig(new File(FileRead.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
	}
}
