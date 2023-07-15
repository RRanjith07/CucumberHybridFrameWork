Feature: Search Functionality
  Scenario: User Searches for a valid product
    Given User is on Home Page of the application
    When user searches a valid product "HP" into search box field
    And User clicks on Search button
    Then User should get valid product displayed

  Scenario: User Searches for an invalid product
    Given User is on Home Page of the application
    When user searches a invalid product "Honda" into search box field
    And User clicks on Search button
    Then User should should get proper warning message about no product matching

  Scenario: User Searches without any product
    Given User is on Home Page of the application
    When user do not enter any product name in the search box field
    And User clicks on Search button
    Then User should should get proper warning message about no product matching
