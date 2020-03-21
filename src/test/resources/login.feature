Feature: Login User

  Scenario: User login with correct credentials
    Given I go to login page
    When I login as user "lyonka1@mail.ru" with password "voPtaf-qezjih-hephy9"
    Then I should see MY DASHBOARD message

  Scenario Outline: User login with incorrect credentials
    Given I go to login page
    When I login as user "<email>" with password "<password>"
    Then I should not see MY DASHBOARD message

    Examples:
      | email                | password             |
      | tlekeux1@plala.or.jp | NCmcrMcgWm3          |
      | atiffin2@prlog.org   | voPtaf-qezjih-hephy9 |
      | lyonka1@mail.ru      | LKBN5zCnY            |