@All
Feature: User Registration

  @Positive @Register
  Scenario: Successful registration with valid inputs
    Given User is on parabank homepage
    When User click register link button
    And User inputs valid registration details
    And User submits the registration form
    Then User registers successfully

  @Negative1 @Register
  Scenario: Failed registration with existing username
    Given User is on parabank homepage
    When User click register link button
    And User inputs registration details with existing username
    And User submits the registration form
    Then User gets alert username already exists

  @Negative2 @Register
  Scenario: Failed registration with mismatched passwords
    Given User is on parabank homepage
    When User click register link button
    And User inputs registration details with mismatched passwords
    And User submits the registration form
    Then User gets error password did not match

  @Negative3 @Register
  Scenario Outline: Failed registration with invalid inputs
    Given User is on parabank homepage
    When User click register link button
    And User inputs registration details with "<firstName>", "<lastName>", "<street>", "<city>", "<state>", "<zipCode>", "<phone>", "<ssn>", "<username>", "<password>", "<confirmPassword>"
    And User submits the registration form
    Then User gets error "<errorMessage>"

    Examples:
      | firstName | lastName | street     | city       | state | zipCode | phone      | ssn        | username | password  | confirmPassword | errorMessage          |
      |           | Doe      | 123 Main St | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 | user123  | password  | password        | First name is required. |
      | John      |           | 123 Main St | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 | user123  | password  | password        | Last name is required.  |
      | John      | Doe      |             | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 | user123  | password  | password        | Address is required.    |
      | John      | Doe      | 123 Main St |             | IL    | 62701   | 1234567890 | 123-45-6789 | user123  | password  | password        | City is required.       |
      | John      | Doe      | 123 Main St | Springfield |       | 62701   | 1234567890 | 123-45-6789 | user123  | password  | password        | State is required.      |
      | John      | Doe      | 123 Main St | Springfield | IL    |         | 1234567890 | 123-45-6789 | user123  | password  | password        | Zip Code is required.   |
      | John      | Doe      | 123 Main St | Springfield | IL    | 62701   |            | 123-45-6789 | user123  | password  | password        | Phone number is required. |
      | John      | Doe      | 123 Main St | Springfield | IL    | 62701   | 1234567890 |            | user123  | password  | password        | Social Security Number is required.       |
      | John      | Doe      | 123 Main St | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 |          | password  | password        | Username is required.   |
      | John      | Doe      | 123 Main St | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 | user123  |           | password        | Password is required.   |
      | John      | Doe      | 123 Main St | Springfield | IL    | 62701   | 1234567890 | 123-45-6789 | user123  | password  |                 | Password confirmation is required. |
