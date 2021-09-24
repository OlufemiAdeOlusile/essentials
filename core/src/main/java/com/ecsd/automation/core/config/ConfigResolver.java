package com.ecsd.automation.core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * @author olufemi on 2021-09-22
 */
public class ConfigResolver {

    private static final String BUILD_CONF = "conf/defaults";

    private static final Config CONFIG = ConfigFactory.load(BUILD_CONF);

    private ConfigResolver() {

    }

    public static Config getConfig() {
        return CONFIG;
    }
}
