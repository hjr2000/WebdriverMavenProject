package Training.DecemberMavenProject;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

features = {"featurefiles/"},

plugin = {"pretty",

"html:target/cucumber-html-report",

"junit:target/cucumber-junit-report/allcukes.xml"},

tags = {"@Runme"}

)

public class cukerunner {

}