@activity1
  Feature: Google search

    Scenario: Searching for Cheese
      Given User is on Google home page
      When User types in Cheese and hits ENTER
      Then Show how many search results were found
      And Close the browser