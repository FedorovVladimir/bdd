Feature: OpenIndexPage
    Scenario: Успешное открытие главное страницы сайта
        When Open index page site
        Then I see index page and title "create patterns"
