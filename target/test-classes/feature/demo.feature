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
Feature: Adactin Login
  I want to use this template for my feature file

  @tag
  Scenario: Login should be successfully performed
    Given Go to the URL
   	When click on login button
   	Then check for homepage

    
    @tag
      Scenario: Logout should be successfully performed
    Given Homepage verification
   	When click on logout button
   	Then check for loginpage
