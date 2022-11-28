@Travel
Feature: Travels page logon


  Scenario Outline: login page

    Given User Login the page
    And User enters from city "<FromCity>" and to city "<ToCity>"

    Examples:

      | FromCity                                           | ToCity |
      | Rajiv Gandhi International Airport (HYD) Hyderabad |Indira Gandhi International Airport  (DEL) Delhi        |