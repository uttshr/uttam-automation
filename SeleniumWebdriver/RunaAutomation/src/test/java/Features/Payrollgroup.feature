Feature: Runa Payroll Group Feature
Feature Description: This test will creates,edit and delete payroll group in test environment.
  Background:
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  @regression @payrollGroup
  Scenario Outline: C99_Create payroll group : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Nominas
    And I click on new group
    And I get the data for payroll group "<fileName>" and "<fieldName>"
    And I Enter group name
    And I Select company name
    And I Select company bank id
    And I Select payroll group frequency
    And I Select payroll group calculation
    And I Select annual gratuity
    And I Select subsidyType
    When I click GUARDER button
    Then I validate if the payroll group is created

    Examples:
      | fileName               |  fieldName               |
      | PayrollGroup.json      |  createPayrollGroup      |

  @regression @payrollGroup
  Scenario Outline: C99_Edit payroll group : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Nominas
    And I get the data for payroll group "<fileName>" and "<fieldName>"
    And I Click on edit payroll group
    And I Update value of the field
    When I click GUARDER button
    And I click on continue
    Then I validate if field value is updated with new value

    Examples:
      | fileName               |  fieldName  |
      | PayrollGroup.json      |  editPayrollGroup      |

  @regression @payrollGroup
  Scenario Outline: C99_Delete payroll group : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Nominas
    And I get the data for payroll group "<fileName>" and "<fieldName>"
    And I Click on edit payroll group
    And I click on delete button
    And I validate confirmation-dialog
    When I click on continue
    And I click on Aceptar button
    Then I validate payroll group should be deleted

    Examples:
      | fileName               |  fieldName  |
      | PayrollGroup.json      |  deletePayrollGroup      |

