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
		
	Scenario: Verify report an issue function
		When User logs in with 'rafidamazontest@gmail.com' and 'rafidamazontest'
		And User is on the product details page
		And User clicks report an issue link
		Then User should see popup for reporting issues
		
	Scenario: Verify page sections in product details page
		When User logs in with 'rafidamazontest@gmail.com' and 'rafidamazontest'
		And User is on the product details page
		Then User should see from the brand section
		Then User should see product description section
		Then User should see looking for specific info section
		Then User should see product information section
		Then User should see videos section
		Then User should see product guides and documents section
		Then User should see compare with similar items section
		Then User should see important information section
		Then User should see customer reviews section
		Then User should see your browsing history section
		
	Scenario: Verify navigation header in product details page
		When User is on the product details page
		And User scrolls down
		Then User should see navigation header appear on the top
		Then User should see top link
		Then User should see about this item link
		Then User should see similar link
		Then User should see questions link
		Then User should see product information link
		Then User should see reviews link
		
		
		
	
		