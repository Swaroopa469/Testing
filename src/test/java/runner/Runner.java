package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/feature/exampledemo.feature",
glue = {"stepDefinitions"},
dryRun = false ,
monochrome = true ,
tags ="@tag",
snippets = CucumberOptions.SnippetType.CAMELCASE)


public class Runner {

}
