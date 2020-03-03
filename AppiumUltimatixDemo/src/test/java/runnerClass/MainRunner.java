package runnerClass;

import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/FeatureFiles/Login.Feature",	
				plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		glue={"StepDefinitions"},
		tags={"@Login"},
		monochrome = true)

public class MainRunner {

public static void teardown() 
{
Reporter.assignAuthor("Aarthi R Manoj");
}

}
