package com.ecsd.automation.core.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author olufemi on 2021-09-22
 */
public enum BrowserType {

    CHROME {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {
            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new IllegalStateException("Cannot Instantiate new Driver", e);
            }
        }
    };

    /**
     * Creates the web driver.
     *
     * @return the web driver
     */
    protected abstract WebDriver createWebDriver(BrowserConfig config);
}
