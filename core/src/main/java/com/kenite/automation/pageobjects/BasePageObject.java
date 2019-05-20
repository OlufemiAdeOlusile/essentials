package com.kenite.automation.pageobjects;

import com.kenite.automation.core.config.ConfigResolver;
import com.kenite.automation.core.factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * @author olufemi on 2019-05-18
 */
public abstract class BasePageObject<V> {

    protected static final String URL = ConfigResolver.getConfig().getString("test.url");
    protected static WebDriver driver = new BrowserFactory().getBrowser();

    public BasePageObject() {
        PageFactory.initElements(driver, this);
    }


    @SuppressWarnings(value = "unchecked")
    public V and() {
        return (V) this;
    }

    public abstract V waitForPage();

}
