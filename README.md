# ExamProject_API
Экзаменационное задание №2
Написание автоматизированных тестов для API и UI

В тестах применены Cucumber, JUnit, Maven, Rest Assured, Allure

Основной класс
class CucumberRunnerTest - основной класс для запуска всех сценариев

Запуск тестов через консоль
mvn clean test

Построение локально отчетов в аллюре
mvn allure:serve

Входные данные
Задаются в файле application.properties

Доп.требования
Проверки должны быть проведены через Assertions
Не должно быть system.out.println
