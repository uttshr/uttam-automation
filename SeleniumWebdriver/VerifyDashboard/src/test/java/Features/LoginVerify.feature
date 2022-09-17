Feature: Open login page and verify
  This scenario enter username and password and then verify dashboard
  Scenario Outline: Login and verify dashboard
    Given I navigate to login page
    And I enter <username> and <password>
    And I click login button
    Then I should see dashboard
    Examples:
    | username  | password  |
    | Admin     | admin123  |