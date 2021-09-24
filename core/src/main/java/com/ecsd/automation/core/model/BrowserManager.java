package com.ecsd.automation.core.model;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author olufemi on 2021-09-22
 */
public class BrowserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserManager.class);
    private static final BrowserManager INSTANCE = new BrowserManager();

    private static ThreadLocal<WebDriver> registry = new ThreadLocal<>();


    private BrowserManager() {
    }

    public static BrowserManager getInstance() {
        return INSTANCE;
    }


    /**
     * @param config browser config
     * @return WebDriver
     */
    public WebDriver getDriver(BrowserConfig config) {
        WebDriver driver = registry.get();

        if (driver == null) {
            driver = initDriver(config);
            registry.set(driver);
        }
        return driver;
    }


    /**
     * @return Appium Instantiated Driver
     */
    public WebDriver getInstantiatedDriver() {
        WebDriver driver = registry.get();
        if (driver != null) {
            return driver;
        } else {
            throw new IllegalStateException("Driver is not Instantiated");
        }
    }


    /**
     * Destroy driver  if is still active
     * Remove from registry
     */
    public void destroyDriver() {
        WebDriver driver = registry.get();

        if (driver != null) {
            LOGGER.info("Destroying WebDriver instance...");

            try {
                driver.quit();
            } catch (WebDriverException e) {
                LOGGER.warn("Exception occurred while closing browser!", e);
            }

            registry.remove();

            LOGGER.info("Driver instance destroyed successfully.");
        } else {
            LOGGER.warn("Driver instance is not available, unable to destroy!");
        }

    }


    private WebDriver initDriver(BrowserConfig config) {
        return BrowserType.valueOf(config.getDriverType()).createWebDriver(config);
    }

}

