
Feature: Basic Validations
@Smoke
  Scenario: Access My Benefits link validation

    Given user is on home page of Blue Cross Blue Shield
    When user clicks “Access My Benefits” link
    Then user should see “Enter the first three letters of the Identification Number from your member ID card.” message