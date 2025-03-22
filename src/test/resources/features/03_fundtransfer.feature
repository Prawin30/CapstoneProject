Feature: Fund Transfer Functionality

  Scenario Outline: Fund Transfer Validation
    Given User is on the Fund Transfer page
    When User selects "<fromAccount>" as From Account
    And User selects "<toAccount>" as To Account
    And User enters "<amount>" as transfer amount
    And Clicks the submit button
    Then User should see msg as "<message>" and balance must be updated "<checkBalance>"

    Examples:
      | fromAccount | toAccount | amount  | message                                          |checkBalance|
      | Savings(Avail. balance = $ 1548)    | Checking   | 500     | You successfully transferred $500 from Checking to Savings |yes|
      | Checking(Avail. balance = $ -500.2)    | Savings   | 10000  | Insufficient funds.                              |no|
      | Checking(Avail. balance = $ -500.2)    | Savings   | -100    | Invalid amount entered.                         |no|
