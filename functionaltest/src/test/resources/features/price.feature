@price

Feature: validate price boundary


  Scenario Outline: validating each Price in market table is not lower than set price
    Given i am on the markets page
    When i search for an asset with the assert sign "<assertSign>"
    Then each price on table should not be below "<price>" threshold

    Examples:
      | assertSign | price |
      | BTC        | 1000  |
      | LTC        | -1    |