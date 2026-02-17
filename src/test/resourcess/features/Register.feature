Feature: Registration functionality
    

  Scenario: Successful registration with valid details
    Given User is on Registration page
    When User enters the details into below fields
    |FirstName   |Test|
    |lastName    |Engineer|
    |email       |suresh@gmail.com|
    |Telephone   |123456789|
    |password    |123456789|
    And User selects privacy policy
    And User clicks on Coutinue button
    Then Registration should be successful
    

  Scenario: Successful registration with Full valid details
    Given User is on Registration page
    When User enters the details into below fields
    |FirstName   |Test|
    |lastName    |Engineer|
    |email       |suresh@gmail.com|
    |Telephone   |123456789|
    |password    |123456789|
    And User selects Yes for news letter
    And User selects privacy policy
    And User clicks on Coutinue button
    Then Registration should be successful
   
    Scenario: User creates a duplicate account 
    Given User is on Registration page
    When User enters the duplecate details into below fields
    |FirstName   |Test|
    |lastName    |Engineer|
    |email       |suresh@gmail.com|
    |Telephone   |123456789|
    |password    |123456789|
    And User selects Yes for news letter
    And User selects privacy policy
    And User clicks on Coutinue button
    Then User should get a proper duplicate worning message
    
    Scenario: User creates an account without filing any details  
    Given User is on Registration page
    When User dont enter any details into fields
    And User clicks on Coutinue button
    Then User should get a proper worning message for every mandatory field
    
    
   


