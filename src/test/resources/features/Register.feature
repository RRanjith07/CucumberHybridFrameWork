Feature: Registration Functionality
  Scenario: User Creates an account only with Mandatory fields
    Given User navigates to Register Account Page
    When user enters the details into below field
      | FirstName | Ranjith    |
      | LastName  | R          |
      | Telephone | 9844162479 |
      | Password  | Password1  |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User Creates an account with all fields
    Given User navigates to Register Account Page
    When user enters the details into below field
      | FirstName | Ranjith    |
      | LastName  | R          |
      | Telephone | 9844162479 |
      | Password  | Password1  |
    And User selects Yes for the Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User Creates a duplicate account
    Given User navigates to Register Account Page
    When user enters the details into below field with duplicate email
      | FirstName | Ranjith             |
      | LastName  | R                   |
      | E-Mail     | Ranjith@yopmail.com |
      | Telephone | 9844162479          |
      | Password  | Password1           |
    And User selects Yes for the Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get the warning message about duplicate email address

    Scenario: User  Creates an account without filling any details
      Given User navigates to Register Account Page
      When User do not enter any details into the field
      And User clicks on Continue button
      Then User should get the warning messages for every mandatory fields
