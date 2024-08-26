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
		
	