Feature: Lists & Registries Module
  Test cases related to shopping lists and registries
  
  Background:
  	Given User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest' for List and Registry module
  	And redirected to the lists & registries page

  #Scenario: Create a list
    #When User clicks create a list button
    #And User enters shopping list 'shopping list'
    #And User clicks create list button to confirm creation
    #Then User should see shopping list created successfully
    #
#	Scenario: Delete a list
#		When User goes to 'Your Lists' page
#		And User clicks on 'Manage List' for the first list
#		And User clicks on delete list button
#		Then User should see shopping list is deleted successfully
		
	Scenario: Verify registry categories links
		When User goes to registries page
		And User clicks on each category
		Then User should see the category's page