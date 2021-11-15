@filter
Feature: As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Background:
    Given the user is on the login page
    When the user enters the driver information
    When the user should be able to login
    And the user select "Fleet" "Vehicles" from the top bar
    Then the user should see Fleet-Vehicles page

  @Last_Odometer
  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' page

    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter

  @Last_Odometer @content
  Scenario: The content of the "Last Odometer" filter should be correct.
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then content of list should have to following  types
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |

  @Last_Odometer @between
  Scenario:The user selects "Between" method with numeric values, the results should be between the specified values
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Between" method
    And the user enters start value "10" end value "100"
    And click the Update button
    Then results table should only show Last Odometer between "10" to "100"

  @Last_Odometer @equals
  Scenario:The user selects "Equals" method with numeric values, the results should match the specified value exactly
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Equals" method
    And the user enters value "100"
    And click the Update button
    Then All the results should match "100" exactly

  @Last_Odometer @moreThan
  Scenario:The user selects "More than" method with numeric values, the results should be more than the specified value
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "More than" method
    And the user enters value "5000"
    And click the Update button
    Then All the results should be more than "5000" value

  @Last_Odometer @lessThan
  Scenario:The user selects "Less than" method with numeric values, the results should be less than the specified value
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Less Than" method
    And the user enters value "5000"
    And click the Update button
    Then All the results should be less than "5000" value

  @Last_Odometer @isEmpty
  Scenario:The user selects "Is Empty" method, only empty values should be displayed
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "Is Empty" method
    And click the Update button
    Then only empty values should be displayed

  @Last_Odometer @between @lessThan @wrongTest
  Scenario Outline: Method ("Between") shouldn't accept non-numeric values
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "<link>" method
    And the user enters start value "<start>" end value "<end>"
    Then click the Update button and result table should not change

    Examples:
      | link    | start   | end  |
      | Between | ++^     | +    |
      | Between | door    | pen  |
      | Between | vehicle | 341  |
      | Between | 33      | lock |



  @Last_Odometer @equals @moreThan @lessThan @wrongTest
  Scenario Outline: Methods ("Equals","More Than","Less Than") shouldn't accept non-numeric values
    When the user click the Filter button
    When the user click Manage Filter
    Then the user select "Last Odometer" filter
    And the user click "Last Odometer" box
    And the user click choose button
    Then user selects "<link>" method
    And the user enters value "<start>"
    Then click the Update button and result table should not change
    Examples:
      | link      | start   |
      | Equals    | vehicle |
      | More than | +^^^    |
      | Less Than | door    |