package com.ecsd.automation.pageobjects;

import com.ecsd.automation.core.config.ConfigResolver;
import com.ecsd.automation.core.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author olufemi on 2021-09-22
 */
public abstract class BasePageObject<V> {

    protected static final String URL = ConfigResolver.getConfig().getString("test.url");
    protected static WebDriver driver = new BrowserFactory().initBrowser();

    public BasePageObject() {
        PageFactory.initElements(driver, this);
    }


    @SuppressWarnings(value = "unchecked")
    public V and() {
        return (V) this;
    }

    public abstract V waitForPage();

}
