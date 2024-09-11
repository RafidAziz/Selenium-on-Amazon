Feature: Search product
  Search and view product related cases
  
  Background:
  Given User is on the home page

  Scenario Outline: Search product with valid input
    When User searches "<productName>"
    And User clicks on the search button
    Then User should be redirected to the results page
		
		Examples:
		| productName		|
		| iPad Mini Six	|
		| Macbook Pro		|
		
  Scenario: View a product
    Given User is on the amazon search results page
  	When User clicks on a product
  	Then User should be redirected to the product details page
  	
	Scenario: Change product quantity
		When User is on the product details page
		And User changes product quantity
		Then User should see quantity is changed
		
	Scenario: Verify Buy Now button
		When User logs in with 'rafidamazontest@gmail.com' and 'rafidamazontest'
		And User is on the product details page
		And User clicks on Buy Now button
		Then User should see the checkout page
		
	Scenario: Verify seller name
		When User logs in with 'rafidamazontest@gmail.com' and 'rafidamazontest'
		And User is on the product details page
		And User clicks on Sold By link
		Then User should see the seller name
		
	Scenario: Verify returns popup
		When User is on the product details page
		And User clicks returns link
		Then User should see popup of return policy
		
	Scenario: Verify payment popup
		When User is on the product details page
		And User clicks payment link
		Then User should see popup of payment policy