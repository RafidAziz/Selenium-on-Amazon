Feature: User Authentication
  Test user login with valid and invalid credentials
  Test log out
  
  Background:
  Given User is on the login page

  Scenario Outline: Valid user login
    When User enters "<emailOrMobile>"
    And User clicks on continue button
    And User enters password "<password>"
    And User clicks on sign in button
    Then User should be logged in successfully

    Examples: 
      | emailOrMobile  						| password 				|
      |	rafidamazontest@gmail.com	|	rafidamazontest	|

  Scenario Outline: Invalid user login
    When User enters "<emailOrMobile>"
    And User clicks on continue button
    And User enters password "<password>"
    And User clicks on sign in button
    Then User should not be logged in successfully

    Examples: 
      | emailOrMobile  						| password 					|
      |	rafidamazontest@gmail.com	|	invalidpassword		|
      |	rafidamazontest@gmail.com	|										|
      
    Scenario: Log out
			When User enters 'rafidamazontest@gmail.com'
    	And User clicks on continue button
    	And User enters password 'rafidamazontest'
    	And User clicks on sign in button
    	And User clicks on sign out button
    	Then User should be logged out successfully          
