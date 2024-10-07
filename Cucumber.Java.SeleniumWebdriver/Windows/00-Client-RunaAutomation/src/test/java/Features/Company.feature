Feature: Runa Company Feature
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  @regression
  Scenario Outline: C70_Create Company
    Given I click Administrator
    And I click Perfil de empresa
    And I click Agregar empresa
    And I get the data for company creation "<fileName>" and "<fieldName>"
    And I enter Company name
    And I enter Business name
    And I upload logo
    And I select Industry
    And I enter rfc
    And I select Tax Regime
    And I enter Employer registration
    And I enter Risk premium
    And I select state
    And I enter Direction
    And I enter Postal Code
    And I select bank accounts
    And I enter IMSS subdelegation key
#    And I upload Digital Seal Certificate key
#    And I upload Digital Seal Certificate
    And I enter Password for digital seal certificate
#    And I select <additionaloption>
    When I click GUARDER button
    Then I validate company is added

    Examples:
      |  fileName      | fieldName         |
      |  Company.json  | createCompany     |

#  @regression
#  Scenario Outline: C71_Edit Company
#    Given I click Administrator
#    And I click Perfil de empresa
#    And I get the data for company creation "<fileName>" and "<fieldName>"
#    And I click edit Company
#    And I enter value to edit
#    When I click GUARDER button
#    Then I validate company field value updated to new value
#    Examples:
#      |  fileName      | fieldName       |
#      |  Company.json  | editCompany     |
#
#  @regression
#  Scenario Outline: C72_Delete Company
#    Given I click Administrator
#    And I click Perfil de empresa
#    And I get the data for company creation "<fileName>" and "<fieldName>"
#    And I click edit Company
#    And I click on delete button
#    And I validate confirmation-dialog
#    When I click on continue
#    Then I validate company should be deleted
#    Examples:
#      |  fileName      | fieldName         |
#      |  Company.json  | deleteCompany     |