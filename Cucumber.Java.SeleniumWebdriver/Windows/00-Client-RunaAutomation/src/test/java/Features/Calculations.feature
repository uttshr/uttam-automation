Feature: Runa Payroll Feature
Feature Description: This test will creates and validates payroll in test environment.
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  @regression @payrollCreation
  Scenario Outline: C99_Creating Payroll : Successful
    Given I navigate Nomina Activas
    And I click on Neuva Nomina
    And I get the data for calculations "<fileName>" and "<fieldName>"
    And I select group
    And I enter dates
    And I click on Crear
    And I validate if the payroll was created
    And I click on Comenzar button
    And I click on Continuar button
    When I click on employee
    And I Edit Sueldo value
    Then Validate changed values

    Examples:
      | fileName                 |  fieldName  |
      | Calculations.json        | ManualEdit  |