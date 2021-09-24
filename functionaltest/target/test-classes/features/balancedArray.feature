@array_feature

Feature: balanced arrays

  Scenario: verify success message is shown when correct answers are submitted
    Given i am on the home page
    When i submit the 'correct' answers with name 'femi' for the balanced array challenge
    Then i should see the message containing 'Congratulations you have succeeded' displayed


  Scenario: verify error message is shown when wrong answers are submitted
    Given i am on the home page
    When i submit the 'wrong' answers with name 'femi' for the balanced array challenge
    Then i should see the message containing 'It looks like your' displayed