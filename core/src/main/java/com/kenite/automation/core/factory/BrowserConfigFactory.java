package com.kenite.automation.core.factory;

import com.kenite.automation.core.config.ConfigResolver;
import com.kenite.automation.core.model.BrowserConfig;

import java.util.List;

/**
 * @author olufemi on 2019-05-16
 */
class BrowserConfigFactory {

    private static final String DRIVER_TYPE = ConfigResolver.getConfig().getString("browser.type");
    private static final String URL = ConfigResolver.getConfig().getString("browser.remote_uri");
    private static final List<String> DEVICES = ConfigResolver.getConfig().getStringList("browser.devices");
    private static final String CHROME_DEVICE = "CHROME_MOBILE";

    private BrowserConfigFactory() {

    }

    /**
     * @return the Browser Config depending on the browser choice
     */
    static BrowserConfig initConfig() {
        return DRIVER_TYPE.equals(CHROME_DEVICE) ? getInitChromeMobileConfig() : getInitChromeConfig();
    }


    private static BrowserConfig getInitChromeConfig() {
        return BrowserConfig.newBuilder().withDriverType(DRIVER_TYPE).withUrl(URL)
                .build();
    }


    private static BrowserConfig getInitChromeMobileConfig() {
        return BrowserConfig.newBuilder().withDriverType(DRIVER_TYPE)
                .withDevice(DeviceFactory.getUnUsedDevice(DEVICES)).withUrl(URL)
                .build();
    }

}
