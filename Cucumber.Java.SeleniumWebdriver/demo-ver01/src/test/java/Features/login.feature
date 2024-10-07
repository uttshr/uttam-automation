Feature: This will test the login feature of https://demo.nopcommerce.com/
  Scenario Outline: Login with valid credentials
    Given I navigate to the website
    And I click login link
    And I enter <email> and <password>
    And I click SignIn button
    Then I should see a dashboard
    Examples:
    |email|password|
    |uttam.shrestha@sevadev.com|abc123|
