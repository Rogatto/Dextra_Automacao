package runner;


import com.cucumber.listener.Reporter;
import cucumber.api.SnippetType;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import utilities.DataAtual;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        features = {"src/test/java/features"},
        glue = {"steps"}

)


public class TestRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("extent-config.xml"));
    }
}
