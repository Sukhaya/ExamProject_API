@Api
Feature: API тест с запросами получения информации из сериала и их сравнении

  Scenario: Ищем определенного персонажа в сериале по id
    Given Получаем информацию по персонажу
      | 2 |


  Scenario: Ищем последний эпизод с определенным персонажем
    Given Получаем информацию по персонажу
      | 2 |
    Then Получаем последний эпизод с нашим персонажем

  Scenario: Ищем последнего персонажа из последнего эпизода определенного персонажа
    Given Получаем информацию по персонажу
      | 2 |
    Then Получаем последний эпизод с нашим персонажем
    Then Получаем последнего персонажа из последнего эпизода нашего персонажа

  Scenario: Получаем локацию и расу последнего персонажа из последнего эпизода определенного персонажа
    Given Получаем информацию по персонажу
      | 2 |
    Then Получаем последний эпизод с нашим персонажем
    Then Получаем последнего персонажа из последнего эпизода нашего персонажа
    Then Получаем локацию и расу последнего персонажа из последнего эпизода нашего персонажа и сравниваем


  Scenario: Проверяем совпадение расы 2х персонажей
    Given Получаем информацию по персонажу
      | 2 |
    Then Получаем последний эпизод с нашим персонажем
    Then Получаем последнего персонажа из последнего эпизода нашего персонажа
    Then Получаем локацию и расу последнего персонажа из последнего эпизода нашего персонажа и сравниваем
    And Проверяем совпадение расы

  Scenario: Проверяем совпадение локации 2х персонажей
    Given Получаем информацию по персонажу
      | 2 |
    Then Получаем последний эпизод с нашим персонажем
    Then Получаем последнего персонажа из последнего эпизода нашего персонажа
    Then Получаем локацию и расу последнего персонажа из последнего эпизода нашего персонажа и сравниваем
    And Проверяем совпадение локации
