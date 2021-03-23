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
@tag
Feature: Twitter Login Test

  @tag1
  Scenario: When clicked on "Follow On Twitter" Button, enter username, pasword and click on login user should be logged in
    Given browser is open
    And user is navigate to the website
    And user clicks on button Follow On Twitter
    When user enters username and password
    And user clicks on login button
    Then user is navigated to the twitter site.
