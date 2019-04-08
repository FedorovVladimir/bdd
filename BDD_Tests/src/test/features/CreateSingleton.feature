Feature: CreateSingleton
  Scenario: Успешное открытие главное страницы сайта
    When Open index page site
    Then I see index page and title "create patterns"

  Scenario: Создание паттерна одиночка
    When Открываем главную страницу сайта
    And Заполняем поле для название класса
    And Нажимаем кнопку "Создать"
    Then Получаем страницу с кодом одиночки

