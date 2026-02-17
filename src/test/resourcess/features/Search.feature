Feature: Search functionality

  Scenario: Search with valid keyword
  Given User is on the Home page
  When User enters search keyword "hp"
  And User clicks on Search button
  Then Results should contain related items


  Scenario: Search with non existing keyword
  Given User is on the Home page
  When User enters search keyword "abcdef123"
  And User clicks on Search button
  Then No results message should be displayed

  Scenario: Search with empty keyword
  Given User is on the Home page
  When User dont enter any product name into the search box field 
  And User clicks on Search button
  Then Validation message should be displayed
