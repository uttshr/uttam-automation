Feature: Runa Concept Feature
Feature Description: This test will creates,edit and delete concept in test environment.
  Background:
  Background:
    Given I navigate to runa app
    When I login to application
    Then I validate login successful message "¡Hola, Administrador!"

  @regression @payrollGroup
  Scenario Outline: C99_Create concept : Successful
    Given I click Administrator
    And I Click Configuracion
    And I Click Conceptos
    And I click on Neuva percepcion
    And I get the data for concept "<fileName>" and "<fieldName>"
    And I Enter perception name
    And I Select type of perception
    And I Select SAT catalog
    And I Select type of concept
    And I Select ISN gravel
    And I Select ISR gravel
    And I Enter account number
    When I click GUARDER button
    Then I validate if the concept is created

    Examples:
      | fileName         |  fieldName          |
      | Concept.json      |  createConcept     |

  @regression
  Scenario Outline: C71_Edit Concept
    Given I click Administrator
    And I Click Configuracion
    And I Click Conceptos
    And I get the data for concept "<fileName>" and "<fieldName>"
    And I click on edit concept
    And I enter value to edit in concept
    When I click GUARDER button
    And I click on continue button
    Then I validate updated field value in concept
    Examples:
      |  fileName      | fieldName       |
      |  Concept.json  | editConcept     |

  @regression
  Scenario Outline: C71_Delete Concept
    Given I click Administrator
    And I Click Configuracion
    And I Click Conceptos
    And I get the data for concept "<fileName>" and "<fieldName>"
    And I click on edit concept
    When I click on delete button
    Then I validate if concept is deleted
    Examples:
      |  fileName      | fieldName       |
      |  Concept.json  | deleteConcept   |