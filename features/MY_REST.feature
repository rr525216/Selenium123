@REST @WEB-Rest
Feature: My rest


  @MyREST12345
  Scenario: REST Basics
    Given User get the DATA
    Then Response Code 200

  @MyRESTpractice
  Scenario: REST Basics
    Given User get the DATA in backend
#    Given User POST the DATA in backend
#    Given User PUT the DATA in backend
#    Given User PATCH the DATA in backend



  @mylocalapi

  Scenario: local api creation

    Given LocalHost Launch



