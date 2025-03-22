Feature: Logout Functionality

  Scenario: User logs out successfully
    Given User is logged into the application
    When User clicks on the Logout button
    Then User should be redirected to the login page

  Scenario: Verify session expiry after logout
    Given User logs out of the application
    When User clicks the Back button in the browser
    Then User should not be able to access the previous page