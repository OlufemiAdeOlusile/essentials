package com.ecsd.automation.core.factory;


import com.ecsd.automation.core.model.BrowserManager;
import org.openqa.selenium.WebDriver;

/**
 * @author olufemi on 2021-09-22
 */
public class BrowserFactory {


    /**
     *
     * @return instantiate and return driver
     */
    public WebDriver initBrowser() {
        return BrowserManager.getInstance().getDriver(BrowserConfigFactory.initConfig());
    }

    /**
     *
     * @return instantiated driver
     */
    public WebDriver getBrowser() {
        return BrowserManager.getInstance().getInstantiatedDriver();
    }

    /**
     * quit the driver
     */
    public void quitBrowser() {
        BrowserManager.getInstance().destroyDriver();
    }
}
