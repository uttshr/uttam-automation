  Feature: To test login
    Scenario Outline: Login to website
      Given I navigate to website
      And I enter <username> and <password>
      And I click login button
      Then I should see dashboard
      Examples:
        | username | password  |
        | Admin    | admin123  |

