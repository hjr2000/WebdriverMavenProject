Feature: Testing the internet


Scenario: Running a google search
  Given I am on the google homepage
  When I search for webdriver
  Then the page title is as expected

Scenario: Successfully accessing a page behind basic HTTP authentication
  Given I successfully reach a page behind basic HTTP authentication
  Then I see the page content as expected

@Runme
Scenario: Cancelling the basic authentication dialog
  Given I attempt to access a page behind HTTP authentication
  When I cancel the authentication dialog
  Then I see the appropriate not authorised message

