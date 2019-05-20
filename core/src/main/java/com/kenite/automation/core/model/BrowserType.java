package com.kenite.automation.core.model;


import com.google.common.collect.ImmutableMap;
import com.kenite.automation.core.exceptions.KeniteWebException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @author olufemi on 2019-05-16
 */
public enum BrowserType {

    CHROME {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {
            try {
                return new RemoteWebDriver(new URL(config.getUrl()), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new KeniteWebException("Cannot Instantiate new Driver", e);
            }
        }
    },

    CHROME_MOBILE {
        @Override
        protected WebDriver createWebDriver(BrowserConfig config) {

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, getChromeMobileEmulatorOptions(config));

            try {
                return new RemoteWebDriver(new URL(config.getUrl()), desiredCapabilities);
            } catch (MalformedURLException e) {
                throw new KeniteWebException("Cannot Instantiate new Driver", e);
            }
        }

    };
    /**
     * Creates the web driver.
     *
     * @return the web driver
     */
    protected abstract WebDriver createWebDriver(BrowserConfig config);


    Map<String, Object> getChromeMobileEmulatorOptions(BrowserConfig config) {
        return ImmutableMap.of("mobileEmulation", ImmutableMap.of("deviceName", config.getDevice()));
    }


}
