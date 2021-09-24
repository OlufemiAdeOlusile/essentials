package com.ecsd.automation;



import com.ecsd.automation.core.factory.BrowserFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        tags = "@array_feature",
        publish = true
)


public class CucumberRunner extends AbstractTestNGCucumberTests {

    @AfterTest
    public void tearDown() {
        new BrowserFactory().quitBrowser();
    }

}
