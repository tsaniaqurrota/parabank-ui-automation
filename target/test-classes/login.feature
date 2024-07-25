@All
Feature: User Login

  @Positive @Login
  Scenario: Successful login with valid credentials
    Given User is on parabank homepage
    When User inputs valid credentials
    And User click login button
    Then User logins successfully

  @Negative @Login
  Scenario Outline: Failed login with invalid credentials
    Given User is on parabank homepage
    When User inputs login details with "<username>", "<password>"
    And User click login button
    Then User gets login error "<errorMessage>"
    Examples:
      | username    | password    | errorMessage                      |
      | invalidUser | invalidPass | The username and password could not be verified. |
      | user123   | invalidPass | The username and password could not be verified. |
      | invalidUser | password   | The username and password could not be verified. |
      |             | password   | Please enter a username and password. |
      | user123   |             | Please enter a username and password. |