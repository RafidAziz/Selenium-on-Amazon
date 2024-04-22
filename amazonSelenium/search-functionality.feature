Feature: Search Product
  User is able to search for a product
  
  Background:
  Given User is on the home page

  Scenario: Search product with valid input
    When User searches "iPad Mini 6"
    And User clicks on the search button
    Then User should be redirected to the results page
