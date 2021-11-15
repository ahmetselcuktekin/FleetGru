@Login
Feature: user should be able to login with valid credential

  @driverLogin
  Scenario: Login as a driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login