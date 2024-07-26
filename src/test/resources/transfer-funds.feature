Feature: User Transfer Funds

  @Positive @Transfer
  Scenario Outline: Successful transfer with valid amount
    Given User has logged in
    When User click transfer funds link button on sidebar
    And User inputs valid "<transferAmount>"
    And User selects account for the transaction
    And User clicks transfer
    Then User transfer funds successfully with message $"<transferAmount>" has been transferred

    Examples:
      | transferAmount |
      | 1              |
      | 10             |
      | 100            |

  @Negative @Transfer
  Scenario Outline: Failed transfer with invalid amount
    Given User has logged in
    When User click transfer funds link button on sidebar
    And User inputs invalid "<invalidTransferAmount>"
    And User selects account for the transaction
    And User clicks transfer
    Then User transfers funds failed with "<errorMessage>"

    Examples:
      | invalidTransferAmount | errorMessage                           |
      | -1                    | Transfer amount must be greater than 0.|
      | 600                   | Insufficient balance.                 |
