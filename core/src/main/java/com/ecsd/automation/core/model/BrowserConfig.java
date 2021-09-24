package com.ecsd.automation.core.model;

/**
 * @author olufemi on 2021-09-22
 */
public class BrowserConfig {

    private String url;
    private String device;
    private String driverType;

    private BrowserConfig(Builder builder) {
        setUrl(builder.url);
        setDevice(builder.device);
        setDriverType(builder.driverType);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    String getDriverType() {
        return driverType;
    }

    private void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    String getDevice() {
        return device;
    }

    private void setDevice(String device) {
        this.device = device;
    }

    public static final class Builder {
        private String url;
        private String device;
        private String driverType;

        private Builder() {
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withDevice(String device) {
            this.device = device;
            return this;
        }

        public Builder withDriverType(String driverType) {
            this.driverType = driverType;
            return this;
        }

        public BrowserConfig build() {
            return new BrowserConfig(this);
        }
    }
}
