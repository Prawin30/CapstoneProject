Feature: Scenarios for Login Functionality

Scenario Outline: User tries to login with different credentials
  Given User is on the login page
  When User enters "<username>" and "<password>"
  And Clicks the login button
  Then User should see their username as "<message>"

  Examples:  
    | username  | password  | message                                  |
    | wrongUser | wrongPass | Login and/or password are wrong.         |
    |           |           | Login and/or password are wrong.         |
    | username  | password  | username																 |