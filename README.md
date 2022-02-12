# financisto-mobile-tests
Учебный проект реализации автотестирования мобильного приложения.<br/></br>
![This is an image](/icons/Java.png)![This is an image](/icons/Gradle.png)![This is an image](/icons/Intelij_IDEA.png)![This is an image](/icons/Selenide.png)![This is an image](/icons/Selenoid.png)![This is an image](/icons/JUnit5.png)![This is an image](/icons/Allure_Report.png)![This is an image](/icons/AllureTestOps.png)
<!-- [This is an image](/icons/appium.png)![This is an image](/icons/androidstudio.png) -->

## Описание проекта
В качестве объекта тестирование выбрано мобильное приложение приложение для учета личных финансов с открытым исходным кодом financisto.<br/></br>
Приложение позволяет пользователю создавать и вести учёт по счетам в разных валютах. Планировать бюджет, проводить транзакции, оперировать остатками, получать отчёты по периодам, проектам, категориям  и т.д.<br/></br>
> <a target="_blank" href="https://play.google.com/store/apps/details?id=ru.orangesoftware.financisto&hl=ru&gl=US"> Подробнее о приложении по ссылке</a>

<img src="/images/page.png" wight=70px heigth=100px> <img src="/images/page2.png" wight=70px heigth=100px></br>

#### Список проверок, реализованных в автотестах
- Выполнение проводки по счёту
- Добавление счёта c ненулевым остатком
- Добавление счёта c нулевым остатком
- Получение отчёта по счёту. За период
- Редактирование счёта. Изменение названия
- Редактирование счёта. Изменение начальной суммы
- Удаление счёта
#### Список проверок ручного тестирования
- Просмотр информации о счёте

## Особенности реализации
Реализован полный цикл работы с тест-кейсами в Allure Test Ops. От первоначального описания списка необходимых проверок до выгрузки результатов тестирования в сводный отчёт и формирования статистических Dashboard.<br/></br>
Для описания шагов тест-кейсов в java-коде использован степовой подход.

----Использована настройка трёх вариантов конфигурации запуска.
