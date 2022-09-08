Feature: Runa Login Feature
Feature Description: Test login feature


@regression
Scenario Outline: C9_Login test - positive scenario

        Given I navigate to runa app
        And  I get the data for login with "<fileName>" and "<fieldName>"
        When I enter email
        And I enter password
        And I click getInto button
        Then I validate login successful message

    Examples:
        |  fileName  | fieldName  |
        |  login.json  | valid     |


  @regression
  Scenario Outline: C8_Login test - negative scenario

    Given I navigate to runa app
    And   I get the data for login with "<fileName>" and "<fieldName>"
    When I enter email
    And I enter password
    And I click getInto button
    Then I validate login unsuccessful message

    Examples:
      |   fileName  | fieldName     |
      |  login.json  | invalid1     |
      |  login.json  | invalid2     |
