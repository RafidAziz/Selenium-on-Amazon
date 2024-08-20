Feature: Customer Preferences Module
  Test cases related to language, currency and country settings
  
  Background:
  	Given User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest' for Customer Preferences Module

  Scenario: Change language settings
    When User goes to the language settings page
    And User selects another language
    And User clicks save changes button
    And User sees language is changed correctly
    Then User changes language back to english
    
  Scenario: Change currency settings
  	When User goes to the currency settings page
  	And User selects another currency
  	And User clicks save changes button
  	And User sees currency is changed correctly
  	Then User changes currency back to USD  	