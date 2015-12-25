Feature: Testing Google

@Runme
Scenario: Running a google search

Given I am on the google homepage
When I search for webdriver
Then the page title is as expected

