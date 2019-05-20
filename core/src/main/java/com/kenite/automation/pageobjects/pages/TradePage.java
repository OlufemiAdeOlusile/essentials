package com.kenite.automation.pageobjects.pages;

import com.kenite.automation.pageobjects.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.kenite.automation.core.dsl.WebDriverDsl.waitForNewPage;

/**
 * @author olufemi on 2019-05-18
 */
public class TradePage extends BasePageObject<TradePage> {

    @FindBy(id = "market")
    private WebElement market;


    public TradePage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public TradePage waitForPage() {
        waitForNewPage(market);
        return this;
    }

    public void verifyMarketContainsCorrectPair(String pair) {
        Assert.assertEquals(market.getText(), pair.replaceAll("\\s+", ""), "TradePage does not show the correct pair");
    }

}
