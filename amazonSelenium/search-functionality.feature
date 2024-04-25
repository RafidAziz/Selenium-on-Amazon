Feature: Search Product
  User is able to search for a product
  
  Background:
  Given User is on the home page

  Scenario Outline: Search product with valid input
    When User searches "<productName>"
    And User clicks on the search button
    Then User should be redirected to the results page
		
		Examples:
		| productName |
		| iPad Mini 6 |