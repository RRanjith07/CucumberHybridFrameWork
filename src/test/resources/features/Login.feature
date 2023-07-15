Feature: Login Functionality

  Scenario Outline: Login with valid credentials
    Given User Navigates to LoginPage
    When User enters the Valid Email Address <UserName>
    And User enters the Valid Password <Password>
    And User clicks on Login Button
    Then User should logged in Successfully
    Examples:
      | UserName             | Password  |
      | Ranjith@yopmail.com  | Password1 |
      | Ranjith7@yopmail.com | Password1 |


  Scenario: Login with invalid credentials
    Given User Navigates to LoginPage
    When User enters the inValid Email Address
    And User enters the inValid Password "Password123"
    And User clicks on Login Button
    Then User should should get a warning message

    Scenario: Login with valid email and invalid password
      Given User Navigates to LoginPage
      When User enters the Valid Email Address "Ranjith7@yopmail.com"
      And User enters the inValid Password "Password123"
      And User clicks on Login Button
      Then User should should get a warning message

      Scenario:Login with invalid email and valid password
        Given User Navigates to LoginPage
        When User enters the inValid Email Address
        And User enters the Valid Password "Password1"
        And User clicks on Login Button
        Then User should should get a warning message

        Scenario: Login without providing any credentials
          Given User Navigates to LoginPage
          When User do not enters the  Email Address
          And User do not enters the Password
          And User clicks on Login Button
          Then User should should get a warning message