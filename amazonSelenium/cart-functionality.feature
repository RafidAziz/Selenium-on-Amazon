Feature: Shopping Cart Module
  Test cases related to shopping cart module

	Background:
		Given User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest'

  Scenario Outline: Add product to cart
    When User is in the product details page
    And User clicks on add to cart button
    Then User is redirected to 'added to cart' page
    
  Scenario Outline: Verify product price on the product detail page matches the price in the cart
   	When User is in the product details page
   	And User notes the product price
   	And User is in the shopping cart page
   	Then User should see the same product price in the cart as on the product detail page
   
	 Scenario Outline: Change product quantity in cart
		When User is in the shopping cart page
		And User changes product quantity in cart
		Then User should see quantity is changed in cart
		
	 Scenario Outline: Remove product from cart
	  When User is in the shopping cart page
	  And User clicks on delete link
	  Then User sees a message that the item is removed from cart