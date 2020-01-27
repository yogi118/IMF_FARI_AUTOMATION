#Author: yogendra.sahu@lntinfotech.com
@fari @api
Feature: Verify the FARI API response
  As the FARI UI frontend user, I can access the APIs  
  so that I can predict the forecast values and  generate visualization graphs and predict the oil production

  @arima
  Scenario Outline: As the FARI UI frontend user, I want to consume the ARIMA forecast API response and validate the forecast values for given time period
    Given I have "<base_uri>" and "<base_path>" for fari model
    When I want to generate forecast value for "<from_date>" to "<to_date>" for "<transaction>" request
    Then I should get valid response
    And Response body should contain expected values
      | algorithm | transid | forecast                                                                                                                                                                                                                                                                      |
      | ARIMA     |     123 | {2020-01-01 00:00:00=9.99, 2021-01-01 00:00:00=17.44, 2022-01-01 00:00:00=19.85, 2023-01-01 00:00:00=15.73, 2024-01-01 00:00:00=11.83, 2025-01-01 00:00:00=10.39, 2026-01-01 00:00:00=14.15, 2027-01-01 00:00:00=16.73, 2028-01-01 00:00:00=16.23, 2029-01-01 00:00:00=13.31} |

    Examples: 
      | base_uri                                                                 | base_path                  | transaction | from_date  | to_date    |
      | https://mosaic-qa.lti-mosaic.com/4cd3c4ce-2848-4d1f-916d-bf0e3be2540e/ml | transaction_forecast_arima |         123 | 2020-01-01 | 2030-01-01 |

  @lstm
  Scenario Outline: As the FARI UI frontend user, I want to consume the LSTM forecast API response and validate the forecast values for given time period
    Given I have "<base_uri>" and "<base_path>" for fari model
    When I want to generate forecast value for "<from_date>" to "<to_date>" for "<trans_id>" request
    Then I should get valid response
    And Response body should contain expected values
      | algorithm | transid | forecast                                                                                                                                                                                                                                                                                                |
      | lstm_3    |     123 | {2020-01-01 00:00:00=10.0, 2021-01-01 00:00:00=15.53, 2022-01-01 00:00:00=13.54, 2023-01-01 00:00:00=14.09, 2024-01-01 00:00:00=15.03, 2025-01-01 00:00:00=14.96, 2026-01-01 00:00:00=15.28, 2027-01-01 00:00:00=15.56, 2028-01-01 00:00:00=15.69, 2029-01-01 00:00:00=15.86, 2030-01-01 00:00:00=16.0} |

    Examples: 
      | base_uri                                                                 | base_path                   | trans_id | from_date  | to_date    |
      | https://mosaic-qa.lti-mosaic.com/4cd3c4ce-2848-4d1f-916d-bf0e3be2540e/ml | transaction_lstm_3_forecast |      123 | 2020-01-01 | 2030-01-01 |
