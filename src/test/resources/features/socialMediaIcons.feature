Feature: Social Media Icon Verification

  Scenario: Verify 4 social media buttons are displayed

    Given user goes to Blue Cross Blue Shield website "https://www.bcbs.com/"
    And verifies the title "Blue Cross Blue Shield" is displayed
    Then user should be able to see four social media icons
      | icons    |
      | Facebook |
      | Twitter  |
      | LinkedIn |
      | YouTube  |


  Scenario Outline: Validate social media buttons work
    Given user goes to Blue Cross Blue Shield website "https://www.bcbs.com/"
    And verifies the title "Blue Cross Blue Shield" is displayed
    When user clicks on  "<icons>" then title should be "<title>"
    Examples:
      | icons    | title                                                           |
      | Facebook | Blue Cross and Blue Shield Association - Home \| Facebook       |
      | Twitter  | Blue Cross Blue Shield Association (@BCBSAssociation) / Twitter |
      | LinkedIn | Sign Up \| LinkedIn                |
      | YouTube  | Blue Cross Blue Shield Association - YouTube                    |