Feature: Runa Payroll Feature
Feature Description: This test will creates and validates payroll in test environment.
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  # Group 1 - Weekly Payroll QA - 7 days | Used: 15-21 Apr
  # Group 2 - Fortnightly Payroll Mexico - 15 days | Used: May, June
  # Group 3 - Biweekly
  # Group 4 - Monthly Payroll KEMPER URGATE SCHOOL - 30 days | Used: June


#@regression @payrollCreation
#Scenario Outline: C99_Creating Payroll : Successful
#  Given I navigate Nomina Activas
#  And I click on Neuva Nomina
#  And I get the data for payroll creation "<fileName>" and "<fieldName>"
#  And I select group
#  And I enter dates
#  When I click on Crear
#  Then I validate if the payroll was created
#  Examples:
#    | fileName            |  fieldName  |
#    | Payroll.json        | validDateRange.grupo1  |
#    | Payroll.json        | validDateRange.grupo2  |


  @regression @payrollCreation
  Scenario Outline: C13_Creating Payroll Errors in creation : Range of Incidents
    Given I navigate Nomina Activas
    And I click on Neuva Nomina
    And I get the data for payroll creation "<fileName>" and "<fieldName>"
    And I select group
    And I enter dates
    When I click on Crear
    Then I should validate error message
    Examples:
      | fileName            |  fieldName  |
      | Payroll.json        | invalidDateRange.grupo1  |
      | Payroll.json        | invalidDateRange.grupo2  |

#  @regression @payrollCreation
#  Scenario Outline: C14_Creating Payroll : Errors in creation: Payroll in same time period
#    Given I navigate Nomina Activas
#    And I click on Neuva Nomina
#    And I get the data for payroll creation "<fileName>" and "<fieldName>"
#    And I select group
#    And I enter dates
#    When I click on Crear
#    Then I should validate error message
#
#    Examples:
#      | fileName            |  fieldName  |
#      | Payroll.json        | existingDateRange.grupo1  |
#      | Payroll.json        | existingDateRange.grupo2  |