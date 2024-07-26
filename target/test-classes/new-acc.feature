@All
Feature: User makes new account

  @Positive @NewAcc
  Scenario Outline: Successful open new account
    Given User has logged in
    When User click open new account link button on sidebar
    And User selects account type "<accountType>" and existing account
    And User click open new account
    Then User new acc successfully created

    Examples:
      | accountType |
      | SAVINGS     |
      | CHECKING    |
