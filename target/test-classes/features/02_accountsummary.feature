Feature: Account Summary Functionality

  Scenario: Verify Account Summary Page Loads Correctly
    Given User is Navigating to the Account Summary page
    Then User should see "Cash Accounts"

  Scenario: Validate Account Types on Account Summary Page
    Given User is on the Account Summary page
    Then User should see all account types displayed
