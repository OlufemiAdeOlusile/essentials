package com.kenite.automation;


import com.kenite.automation.core.factory.BrowserFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        tags = "@assets, @price, @market",
        format = {"pretty", "html:target/cucumber-reports/cucumber-pretty"}
)


public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CucumberRunner.class);

    private static BrowserFactory getBrowserFactory() {
        return new BrowserFactory();
    }

    @BeforeSuite
    public void startSuite() {
        getBrowserFactory().initBrowser();
        LOGGER.info("Test Suite Started");
    }

    @AfterSuite
    public void stopSuite() {
        getBrowserFactory().quitBrowser();
        LOGGER.info("Test Suite Ended");
    }
}
