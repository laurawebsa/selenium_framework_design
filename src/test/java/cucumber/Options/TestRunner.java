package cucumber.Options;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = "cucumber.glue",
        value = "stepDefinitions")
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "pretty, json:target/JsonReports/cucumber-report.json, " +
                "html:target/JsonReports/cucumber-report.html")
@ConfigurationParameter(
        key = "cucumber.filter.tags",
        value = "@AddPlace")
public class TestRunner {

}
