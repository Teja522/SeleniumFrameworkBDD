@Login
Feature: Login functionality

  Scenario: Verify login with multiple credentials
    Given User is on the login page
    When User enters the following credentials
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |
      | error_user    | secret_sauce |
    Then User should be logged in successfully