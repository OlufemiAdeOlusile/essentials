@market

Feature: validate markets

  Scenario: validating pair chosen from market page is correctly shown in trade page market header
    Given i am on the markets page
    When i chose any pair from the market page table"
    Then pair picked from the market page table should be correctly shown on the trade page market header
