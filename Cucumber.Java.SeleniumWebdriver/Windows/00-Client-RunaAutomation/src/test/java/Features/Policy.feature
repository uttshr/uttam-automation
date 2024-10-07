Feature: Runa Policy Feature
Feature Description: This test will creates,edit and delete policy in test environment.
  Background:
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  @regression @payrollGroup
  Scenario Outline: C99_Create policy : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Politicas
    And I click on Neuva politica
    And I get the data for policy "<fileName>" and "<fieldName>"
    And I Enter policy name
    And I Enter economy days
    And I Select vacation bonus to the anniversary
    And I Update details in pantry vouchers
    And I Update details in saving fund
    And I Update details restaurant voucher
    And I Update discounts for calculations
    And I Select calculations based on
    When I click GUARDER button
    Then I validate if the policy group is created

    Examples:
      | fileName         |  fieldName        |
      | Policy.json      |  createPolicy     |

  @regression @payrollGroup
  Scenario Outline: C99_Edit policy : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Politicas
    And I get the data for policy "<fileName>" and "<fieldName>"
    And I Click on edit policy
    And I Update value of the field in policy
    When I click GUARDER button
    And I click on continue button
    And I click on Aceptar button
    Then I validate if policy field value is updated with new value

    Examples:
      | fileName               |  fieldName       |
      | Policy.json            |  editPolicy      |

  @regression @payrollGroup
  Scenario Outline: C99_Delete policy : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Politicas
    And I get the data for policy "<fileName>" and "<fieldName>"
    And I Click on edit policy
    When I click on delete button
    And I click on continue button
    Then I validate if policy should be deleted

    Examples:
      | fileName         |  fieldName         |
      | Policy.json      |  deletePolicy      |