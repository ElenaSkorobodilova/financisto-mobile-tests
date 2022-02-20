# financisto-mobile-tests
![This is an image](/icons/Java.png)![This is an image](/icons/Gradle.png)![This is an image](/icons/Intelij_IDEA.png)![This is an image](/icons/Selenide.png)![This is an image](/icons/Selenoid.png)![This is an image](/icons/JUnit5.png)![This is an image](/icons/Allure_Report.png)![This is an image](/icons/AllureTestOps.png)![This is an image](/icons/appium.png) ![This is an image](/icons/androidstudio.png)
## Описание проекта
Учебный проект реализации автотестирования мобильного приложения.<br/></br>
В качестве объекта тестирование выбрано мобильное приложение приложение для учета личных финансов с открытым исходным кодом **financisto**.<br/></br>
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
Для описания шагов тест-кейсов в java-коде использован степовой подход.<br/></br>
Реализована возможность настройки параметров запуска через соответствующие файлы конфигурации
- browserstack.properties
- selenoid.properties
- local.properties

## Ограничения проекта
Файл apk взят из открытого источника. Реализована собственными силами некая сборка, доступная к скачиванию тестами из Github, приложение также установлено на сервер browserstack. Но запуск тестов на удалённых серверах происходит с ошибками.<br/> 
Поэтому рекомендован локальный прогон тестов.

#### Пример запуска из командной строки
```bash
gradle clean local
```

## Этапы реализации
> <a target="_blank" href="https://allure.autotests.cloud/project/1000/dashboards/1881"> Проект в Allure Test Ops</a>
### 1. Формирование списка необходимых проверок в Allure Test Ops
<img src="/images/manual_list.png"><br/></br>
Кейсы разбиты по группам:
- Epic = UserStory
- Feature = Accounts (работа со счетами), Reports (формирование отчётов)
- Story = Transactions, Create, Edit, Delete (для Accounts), Gets (для Reports)

### 2. Импорт тест-кейсов в IntelliJ IDEA
<img src="/images/import cases from allure to.png"><br/></br>

### 3. Разработка кода, настройка сборки, запуск на локальном компьютере
Два варианта настройки параметра в localdevice.properties
- по умолчанию: local_device.url=http://127.0.0.1:4723/wd/hub
- c помощью запуска сервиса **ngrok**: local_device.url=http://6459-176-213-208-102.ngrok.io/wd/hub

### 4. Импорт результатов прогонов из IntelliJ IDEA в Allure Test Ops
<img src="/images/dashboard.png">
Итоговые результаты сгруппированы в Dashboard по Feature и Story для удоства локализации дефектов по основным функциям приложения.<br/><br/>  


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
