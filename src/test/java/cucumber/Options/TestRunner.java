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
        value = "pretty")
public class TestRunner {

}
