Feature: Login functionality

 Scenario Outline: Successful login with valid credentials 
 Given User is on Login page
 When User enters valid email address <UserEmail> field
 And User enters password <Password> field
 And User clicks on Login button
 Then User should be logged in successfully
 Examples:
 |UserEmail                      |  Password    |
 |bodasinghisuresh@gmail.com     |  9550362600  |
 |bodasinghisuresh123@gmail.com  |  9550362600  |
 |bodasinghisuresh1234@gmail.com |  9550362600  |
 
 
   Scenario: Login with invalid password 
    Given User is on Login page
    When User enters username "ndsnksnksnd"
    And User enters password "kssdsjdksj"
    And User clicks on Login button
    Then Error message should be displayed

  Scenario: Login with invalid username
    Given User is on Login page
    When User enters username "kksmsmdsmd"
    And User enters password "kcskksskj"
    And User clicks on Login button
    Then Error message should be displayed 

  Scenario: Login with empty username
    Given User is on Login page
    When User enters username ""
    And User enters password "kkskxkxk"
    And User clicks on Login button
    Then Error message should be displayed 

  Scenario: Login with empty password
    Given User is on Login page
    When User enters username "isxjisjxaj"
    And User enters password ""
    And User clicks on Login button
    Then Error message should be displayed 
