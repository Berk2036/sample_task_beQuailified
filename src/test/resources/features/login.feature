Feature: Login Functionality


  Background: the user is on the login page
    Given the user is on the "login" page

  Scenario Outline: Verify successful login with valid credentials
    Given the user loges in with  "<username>" and "<password>"
    Then the user should be redirected to the "shop" page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: Successful logout after login
    Given the user loges in with  "<username>" and "<password>"
    When the user clicks the logout button
    Then the user should be redirected to the "login" page
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: Login Navigation Security
    Given the user loges in with  "<username>" and "<password>"
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

  Scenario Outline: Failed login test <description>
    Given the user tries with "<username>" and "<password>"
    Then an error message "<error_message>" should be displayed
    And the user should remain on the login page
    Examples:
      | description       | username                | password         | error_message                      |
      | invalid user name | invalid_user_name       | secret_sauce     | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | empty user name   |                         | secret_sauce     | EMPTY_USERNAME_ERROR               |
      | invalid password  | standard_user           | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | invalid password  | locked_out_user         | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | invalid password  | problem_user            | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | invalid password  | performance_glitch_user | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | invalid password  | error_user              | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | invalid password  | visual_user             | invalid_password | INVALID_USERNAME_OR_PASSWORD_ERROR |
      | empty password    | standard_user           |                  | EMPTY_PASSWORD_ERROR               |
      | empty password    | locked_out_user         |                  | EMPTY_PASSWORD_ERROR               |
      | empty password    | problem_user            |                  | EMPTY_PASSWORD_ERROR               |
      | empty password    | performance_glitch_user |                  | EMPTY_PASSWORD_ERROR               |
      | empty password    | error_user              |                  | EMPTY_PASSWORD_ERROR               |
      | empty password    | visual_user             |                  | EMPTY_PASSWORD_ERROR               |











































