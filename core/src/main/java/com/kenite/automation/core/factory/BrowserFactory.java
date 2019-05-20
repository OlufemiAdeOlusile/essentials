package com.kenite.automation.core.factory;


import com.kenite.automation.core.model.BrowserManager;
import org.openqa.selenium.WebDriver;

/**
 * @author olufemi on 2019-05-16
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
