package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		
		
		tags = "" ,
		features= "src/test/resources/Features",
		glue = "stepDefinition",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		
		)


public class TestRunner extends AbstractTestNGCucumberTests {

}
