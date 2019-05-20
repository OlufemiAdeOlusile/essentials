package com.kenite.automation;


import com.kenite.automation.pageobjects.pages.MarketPage;
import com.kenite.automation.pageobjects.pages.TradePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author olufemi on 2019-05-16
 */
public class MarketStepDefs {

    private MarketPage marketPage = new MarketPage();
    private TradePage tradePage = new TradePage();
    private String pair;

    @Given("^i am on the markets page$")
    public void i_am_on_the_markets_page() {
        marketPage.open();
    }

    @When("^i search for an asset with the assert sign \"([^\"]*)\"$")
    public void i_search_for_an_asset_with_the_assert_sign(String assetsSign) {
        marketPage.waitForPage().and().searchAssets(assetsSign);

    }

    @Then("^i should see a list of assets with pairs containing only the assert sign \"([^\"]*)\"$")
    public void i_should_see_a_list_of_assets_with_pairs_containing_only_the_assert_sign(String assetsSign) {
        marketPage.waitForPage().and().verifyEachPairOnTableContainsAssetSign(assetsSign);
    }

    @Then("^each price on table should not be below \"([^\"]*)\" threshold$")
    public void each_price_on_table_should_not_be_less_than(String price) {
        marketPage.waitForPage().and().verifyEachPriceOnTableIsNotBelowThreshold(price);
    }

    @When("^i chose any pair from the market page table\"$")
    public void i_chose_any_pair_from_the_market_page_table() {
        pair = marketPage.waitForPage().and().clickRandomPairFromTableAndSavePairValue();
    }

    @Then("^pair picked from the market page table should be correctly shown on the trade page market header$")
    public void pair_picked_from_the_market_page_table_should_be_correctly_shown_on_the_trade_page_market_header() {
        tradePage.waitForPage().and().verifyMarketContainsCorrectPair(pair);
    }

}
