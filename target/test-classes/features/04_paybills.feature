Feature: Pay Bills Functionality

  Scenario Outline: Pay Bills with different scenarios
    Given User is on the Pay Bills page
    When User selects "<payee>" as payee
    And User enters "<amount>" as amount
    And User enters "<date>" as payment date
    And Clicks the pay button
    Then User should see the "<message>"

    Examples:
      | payee        | amount | date        | message                                    |
      | Sprint  | 100    | 2025-04-01  | The payment was successfully submitted.   |
      |  Bank of America | 200    | 2025-05-15  | The payment was successfully submitted.   |
      | Apple    |        | 2025-04-10  | Amount field cannot be empty.             |
