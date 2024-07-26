@All
Feature: User Logout

  @Positive @Logout
  Scenario: Successful logout
    Given User has logged in
    When User click logout link button
    Then User logouts successfully