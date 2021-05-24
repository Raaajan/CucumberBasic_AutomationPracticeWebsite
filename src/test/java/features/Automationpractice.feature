#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Shopping on automation practice
  I want to use this template for my feature file

  Scenario: shopping on automationpractice
    Given I am automationpractice website
    And verify logo
    And check bestseller tab is enabled and click on it
    And mouseover and click on addcart for image at 2
    And verify popup msg for producht successfully added
    And verify continue shopping and checkout button enabled and click on proceed btn
    And verify page header as shopping cart summery
    And verify your shopping cart contains "1" product
    And click on plus icon
    And verify your shopping cart contains "2" product
    And close browser
