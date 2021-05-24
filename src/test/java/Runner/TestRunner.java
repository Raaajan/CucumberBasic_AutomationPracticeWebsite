package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "D:\\Automation\\Eclipse\\AutomationParctice\\src\\test\\java\\features",
		glue = "stepDefinition",
		monochrome = true,
		publish=true,
		plugin= {"pretty","html:target/cucumber/shopping.html"}
		
		
		)



public class TestRunner {

}
