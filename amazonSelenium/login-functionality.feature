Feature: User Authentication
  Test user login with valid and invalid credentials
  
  Background:
  Given User is on the login page

  Scenario Outline: Valid user login
    When User enters "<email or mobile>"
    And User clicks on continue button
    And User enters "<password>"
    And User clicks on sign in button
    Then User should be logged in successfully

    Examples: 
      | email or mobile  					| password 				|
      |	rafidamazontest@gmail.com	|	rafidamazontest	|

  Scenario Outline: Invalid user login
    When User enters "<email or mobile>"
    And User clicks on continue button
    And User enters "<password>"
    And User clicks on sign in button
    Then User should be logged in successfully

    Examples: 
      | email or mobile  					| password 					|
      |	rafidamazontest@gmail.com	|	invalidpassword		|
      |	rafidamazontest@gmail.com	|										|      
