package com.kenite.automation.pageobjects.pages;

import com.kenite.automation.core.exceptions.KeniteWebException;
import com.kenite.automation.pageobjects.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;

import static com.kenite.automation.core.dsl.WebDriverDsl.*;

/**
 * @author olufemi on 2019-05-16
 */
public class MarketPage extends BasePageObject<MarketPage> {


    private static final String ASSETS = "Assets";

    @FindBy(css = ".filter-bar-item .menu-item")
    private List<WebElement> filterBarMenuItems;
    @FindBy(id = "menuContentQueryInput")
    private WebElement searchMenuTextField;
    @FindBy(css = ".bulk-search-menu-row-button.search-menu-row-text")
    private WebElement clearFilters;
    @FindBy(css = ".search-menu-items .search-menu-row")
    private List<WebElement> menuItems;
    @FindBy(id = "filter-bar")
    private WebElement filterbar;
    @FindBy(css = ".rankings-list-pair.uppercase")
    private List<WebElement> rankingsPair;
    @FindBy(css = ".rankings-list-price")
    private List<WebElement> rankingsPrice;

    @Override
    public MarketPage waitForPage() {
        waitForNewPage(filterbar);
        return this;
    }

    public void open() {
        openUrl(URL);
        waitForPage();
    }

    public void searchAssets(String assetSign) {
        clickFromDropDownUntilElementIsVisible(filterBarMenuItems, searchMenuTextField, ASSETS);
        clickIfVisible(clearFilters);
        fillText(searchMenuTextField, assetSign);
        clickAssetFromDropDown(assetSign);
        clickFromList(filterBarMenuItems, ASSETS);
    }


    public void verifyEachPriceOnTableIsNotBelowThreshold(String price) {
        rankingsPrice.forEach(f -> Assert.assertTrue(parseStringToDouble(f.getText()) > parseStringToDouble(price),
                String.format("Table price %s is lower than threshold price %s", f.getText(), price)));
    }


    public void verifyEachPairOnTableContainsAssetSign(String assetSign) {
        rankingsPair.forEach(f -> Assert.assertTrue(f.getText().contains(assetSign), String.format("Table Contains wrong sign %s", f.getText())));
    }


    public String clickRandomPairFromTableAndSavePairValue() {
        Optional<WebElement> elementOptional = rankingsPair.stream().findAny();

        if (elementOptional.isPresent()) {
            WebElement element = elementOptional.get();
            String retval = getText(element);
            clickUntilElementVisible(element);
            return retval;
        } else {
            throw new KeniteWebException("Cannot retrieve any pair on table");
        }

    }


    private void clickAssetFromDropDown(String assetSign) {
        menuItems.stream().filter(f -> f.getAttribute("data-value").equalsIgnoreCase(assetSign)).findFirst().ifPresent(WebElement::click);
    }
}
