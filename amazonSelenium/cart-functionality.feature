Feature: Shopping Cart Module
  Test cases related to shopping cart module

	Background:
		Given User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest'

  Scenario Outline: Add product to cart
    When User is in the product details page
    And User clicks on add to cart button
    Then User is redirected to 'added to cart' page

   Scenario Outline: Remove product from cart
    When User is in the shopping cart page
    And User clicks on delete link
    Then User sees a message that the item is removed from cart