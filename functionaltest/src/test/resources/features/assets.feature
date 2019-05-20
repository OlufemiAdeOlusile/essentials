@assets

Feature: validate Assets Pairs


  Scenario Outline: validating each Pair in Asset Table contains correct assetSign
    Given i am on the markets page
    When i search for an asset with the assert sign "<assertSign>"
    Then i should see a list of assets with pairs containing only the assert sign "<assertSign>"

    Examples:
      | assertSign |
      | BTC        |
      | LTC        |