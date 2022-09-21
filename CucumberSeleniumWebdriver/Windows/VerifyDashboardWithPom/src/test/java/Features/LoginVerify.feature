Feature: Open login page and verify dashboard
  This feature will open login page and will enter username and password then a dashboard element is verified
  Scenario Outline: Open website and login
    Given I open website
    And I enter <username> and <password>
    And I click login button
    Then I verify dashboard
    Examples:
      | username  | password  |
      | Admin     | admin123  |