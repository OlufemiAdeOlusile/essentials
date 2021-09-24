package com.ecsd.automation.core.factory;

import com.ecsd.automation.core.config.ConfigResolver;
import com.ecsd.automation.core.model.BrowserConfig;

/**
 * @author olufemi on 2021-09-22
 */
class BrowserConfigFactory {

    private static final String DRIVER_TYPE = ConfigResolver.getConfig().getString("browser.type");
    private static final String URL = ConfigResolver.getConfig().getString("browser.remote_uri");


    private BrowserConfigFactory() {

    }

    /**
     * @return the Browser Config depending on the browser choice
     */
    static BrowserConfig initConfig() {
        return getInitChromeConfig();
    }


    private static BrowserConfig getInitChromeConfig() {
        return BrowserConfig.newBuilder().withDriverType(DRIVER_TYPE).withUrl(URL)
                .build();
    }


}
