Feature: Add New Payee Functionality

  Scenario Outline: Add a new payee with different inputs
    Given User is on the Add New Payee page
    When User enters Payee Name as "<payeeName>"
    And User enters Address as "<address>"
    And User enters Account Number as "<accountNumber>"
    And Clicks the Add button
    Then User should see Payee Added "<message>"

    Examples:
      | payeeName | address       | accountNumber | message                      |
      | John Doe  | 123 Street    | 987654321     | The new payee John Doe was successfully created.    |
      |           | 456 Avenue    | 123456789     | All fields are required.     |
      
