Feature: Login Functionality

  @Regression

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>" and clicks the login button
    Then the user should be redirected to the shop page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |


  Scenario Outline: Successful logout after login
    Given the user with "<username>" und "<password>" is on the shop page after a successful login
    When the user clicks the logout button
    Then the user should be redirected to the login page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |


  Scenario Outline: Login Navigation Security
    Given the user with "<username>" und "<password>" is on the shop page after a successful login
    And the user clicks the browser's Back button
    And the user clicks the browser's Forward button
    Then the user should be able to access the Shop page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |


  Scenario Outline: Failed login test
    Given the user is on the login page
    When the user tries with "<username>" and "<password>"
    Then an error message "<error_message>" should be displayed
    And the user should remain on the login page
    Examples:
      | username                | password         | error_message                      |
      | invalid_user_name       | secret_sauce     | INVALID_USERNAME_OR_PASSWORD_ERROR |
      |                         | secret_sauce     | EMPTY_USERNAME_ERROR               |
      # invalid password
      | standard_user           | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | locked_out_user         | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | problem_user            | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | performance_glitch_user | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | error_user              | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | visual_user             | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      #empty password
      | standard_user           |                  | EMPTY_PASSWORD_ERROR               |
      | locked_out_user         |                  | EMPTY_PASSWORD_ERROR               |
      | problem_user            |                  | EMPTY_PASSWORD_ERROR               |
      | performance_glitch_user |                  | EMPTY_PASSWORD_ERROR               |
      | error_user              |                  | EMPTY_PASSWORD_ERROR               |
      | visual_user             |                  | EMPTY_PASSWORD_ERROR               |











































