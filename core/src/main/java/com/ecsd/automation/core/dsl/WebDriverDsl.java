package com.ecsd.automation.core.dsl;

import com.ecsd.automation.core.factory.BrowserFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * @author olufemi on 2021-09-22
 */
public class WebDriverDsl {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverDsl.class);
    private static final long WAIT_TIMEOUT = 20;
    private static WebDriver driver = new BrowserFactory().getBrowser();

    private WebDriverDsl() {
    }


    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void waitForNewPage(WebElement webElement) {
        waitForElementToBeVisible(webElement);
    }


    public static void fillText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }


    public static void clickUntilElementVisible(WebElement clickableElement, WebElement visibleElement) {
        new WebDriverWait(driver, WAIT_TIMEOUT).pollingEvery(Duration.ofSeconds(2))
                .until(input -> clickIfNotVisible(clickableElement, visibleElement));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> isVisible(element));
    }

    public static void waitForElementToNotBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(input -> !isVisible(element));
    }

    public static void delayFor3Seconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    private static boolean clickIfNotVisible(WebElement clickableElement, WebElement visibleElement) {
        if (isVisible(visibleElement)) {
            return true;
        } else {
            clickableElement.click();
            return false;
        }

    }

    private static boolean isVisible(WebElement element) {
        boolean retval;

        try {
            retval = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element was not found!", e);
            retval = false;
        }

        return retval;
    }

}
