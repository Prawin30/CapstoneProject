Feature: Download Account Statement

  Scenario Outline: User downloads an account statement
    Given User is on the Statements & Documents page
    When User selects account "Checking"
    #And User selects date range 
    And Clicks the download statement button
    Then The PDF file should be downloaded successfully

    