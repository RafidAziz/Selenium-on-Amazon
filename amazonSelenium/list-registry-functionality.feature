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
    
	Scenario: Delete a list
		When User goes to 'Your Lists' page
		And User clicks on 'Manage List' for the first list
		And User clicks on delete list button
		Then User should see shopping list is deleted successfully
		
	Scenario: Verify registry categories links
		When User goes to registries page
		And User clicks on each category
		Then User should see the category's page
		
	Scenario: Create wedding registry
		When User goes to wedding registry page
		And User enters partner full name 'rafid2' and 'test2'
		And User clicks first Continue button 
		And User enters wedding date and guest count: '11/11/2027' and '100'
		And User clicks second Continue button
		And User selects address and tick all checkboxes
		And User clicks third Continue button
		And User ticks private checkbox
		And User clicks Create button
		Then User should see the created wedding registry
		
	Scenario: Delete wedding registry
		When User goes to wedding registry settings
		And User clicks on delete registry buttons
		Then User should not see the wedding registry anymore
		