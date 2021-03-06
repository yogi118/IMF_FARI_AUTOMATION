#Author: yogendra.sahu@lntinfotech.com
@fari
Feature: Predict oil production as per user inputs
  As an end user, I can view all the user input parameters on the user input screen
  so that I can provide user inputs to generate visualization graphs and predict the oil production

  @functional @ui @completed
  Scenario: As an end user, I want to interact with all the user input fields
    Given I am on IMF landing page
    When I navigate to FARI user input screen
    Then All the user input field should be displayed

  @functional @ui
  Scenario Outline: As an end user, I want to get input suggestion when I enter wrong input values
    Given I am on IMF landing page
    And I navigate to FARI user input screen
    When I enter "<input_value>" in "<input_field>" field
    Then I should be suggested with "<input_suggestion>" message

    Examples: 
      | input_field                                                  | input_value | input_suggestion |
      | Production bonus (Start of Production)                       | fifty       | some message 1   |
      | Commencement of Decommissioning Provision                    | ten         | some message 2   |
      | Development and replacement capital cost depreciation period | tweety      | some message 3   |
      | Cost Recovery Ceiling                                        | ten         | some message 4   |
      | Value                                                        | ten         | some message 5   |
      | Uplift Limit                                                 | ten         | some message 6   |

  @functional @ui @wip
  Scenario: As an end user, I want to reset the user input values provided for oil production prediction
    Given I am on IMF landing page
    And I navigate to FARI user input screen
    When I enter values in "first" input field
      | Regime Name                            | Rfactor |
      | Production bonus (Start of Production) |      18 |
      | Royalty Rate                           |      25 |
      | Royalty Base                           | Gross   |
    And I enter values in "second" input field
      | Decommissioning Provision                                    | Yes |
      | Commencement of Decommissioning Provision                    |  12 |
      | Cost Recovery Ceiling                                        |   6 |
      | Development and replacement capital cost depreciation period |  10 |
    And I enter values in "third" input field
      | Investment Uplift | Yes   |
      | Value             |    10 |
      | Uplift Limit      |   2.5 |
      | From Year         |  2021 |
      | To Year           |  2030 |
      | Type of Algorithm | ARIMA |
    And I resets the user input values provided
    Then Input values should set to intial state

  @functional @ui @graph @modal
  Scenario: As an end user, I want to navigate to the visualization screen and validate the graph generated by selecting ARIMA algorithm provided all the user input values are correct
    Given I am on IMF landing page
    And I navigate to FARI user input screen
    When I enter the input field values
      | Regime Name                                                  | EUROPE |
      | Production bonus (Start of Production)                       |     18 |
      | Commencement of Decommissioning Provision                    |     12 |
      | Royalty Rate                                                 |     25 |
      | Royalty Base                                                 | Gross  |
      | Decommissioning provision                                    | Yes    |
      | Development and replacement capital cost depreciation period |     10 |
      | Cost Recovery Ceiling                                        |      6 |
      | Investment Uplift                                            | Yes    |
      | Value                                                        |     10 |
      | Uplift Limit                                                 |    2.5 |
      | From Year                                                    |   2021 |
      | To Year                                                      |   2030 |
      | Type of Algorithm                                            | ARIMA  |
    And I submit the user input values
    Then I should be navigated to the visualization screen
    And Visualization report should be displayed as per user input

  @functional @ui @graph @model
  Scenario: As an end user, I want all user input filed and model score generated is saved in the database and validate the graph generated by selecting LSTM algorithm
    Given I am on IMF landing page
    And I navigate to FARI user input screen
    When I enter the input field values
      | Regime Name                                                  | EUROPE |
      | Production bonus (Start of Production)                       |     18 |
      | Commencement of Decommissioning Provision                    |     12 |
      | Royalty Rate                                                 |     25 |
      | Royalty Base                                                 | Gross  |
      | Decommissioning provision                                    | Yes    |
      | Development and replacement capital cost depreciation period |     10 |
      | Cost Recovery Ceiling                                        |      6 |
      | Investment Uplift                                            | Yes    |
      | Value                                                        |     10 |
      | Uplift Limit                                                 |    2.5 |
      | From Year                                                    |   2021 |
      | To Year                                                      |   2030 |
      | Type of Algorithm                                            | LSTM   |
    And I submit the user input values
    Then I should be navigated to the visualization screen
    And User input submitted should reflect in the database
      | Regime Name                                                  | EUROPE |
      | Production bonus (Start of Production)                       |     18 |
      | Commencement of Decommissioning Provision                    |     12 |
      | Royalty Rate                                                 |     25 |
      | Royalty Base                                                 | Gross  |
      | Decommissioning provision                                    | Yes    |
      | Development and replacement capital cost depreciation period |     10 |
      | Cost Recovery Ceiling                                        |      6 |
      | Investment Uplift                                            | Yes    |
      | Value                                                        |     10 |
      | Uplift Limit                                                 |    2.5 |
      | From Year                                                    |   2021 |
      | To Year                                                      |   2030 |
      | Type of Algorithm                                            | LSTM   |
    And Model score generated should be displayed
    And Model score generated should reflect in the database
    And Visualization report should be displayed as per user input

  @model @ui @graph @analysis
  Scenario: As an end user, I want to change the date range so that different visualization report is generated for oil production analysis
    Given I am on IMF landing page
    And I navigate to FARI user input screen
    When I enter the input field values
      | Regime Name                                                  | EUROPE |
      | Production bonus (Start of Production)                       |     18 |
      | Commencement of Decommissioning Provision                    |     12 |
      | Royalty Rate                                                 |     25 |
      | Royalty Base                                                 | Gross  |
      | Decommissioning provision                                    | Yes    |
      | Development and replacement capital cost depreciation period |     10 |
      | Cost Recovery Ceiling                                        |      6 |
      | Investment Uplift                                            | Yes    |
      | Value                                                        |     10 |
      | Uplift Limit                                                 |    2.5 |
      | From Year                                                    |   2021 |
      | To Year                                                      |   2030 |
      | Type of Algorithm                                            | LSTM   |
    And I submit the user input values
    Then I should be navigated to the visualization screen
    And Visualization report should be displayed as per user input
    When I change date range to some other value by toggling the time duration
    Then Visualization graph should change accordingly
