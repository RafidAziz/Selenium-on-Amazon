Feature: Lists & Registries Module
  Test cases related to shopping lists and registries
  
  Background:
  	Given User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest' for List and Registry module
  	And redirected to the lists & registries page

  Scenario: Create a list
    When User clicks create a list button
    And User enters shopping list 'shopping list'
    And User clicks create list button to confirm creation
    Then User should see shopping list created successfully