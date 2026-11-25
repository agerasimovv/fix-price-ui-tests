# 🛒 Проект автоматизации тестирования интернет-магазина Fix Price

<p align="center">
  <a href="https://fix-price.com/">
    <img src="https://img.shields.io/badge/Fix_Price-Online_Store-78BE20?style=for-the-badge" alt="Fix Price"/>
  </a>
</p>

Самостоятельный учебный проект по автоматизации UI-тестирования интернет-магазина [Fix Price](https://fix-price.com/).

Автотесты реализованы на Java с использованием Selenide и JUnit 5. Настроены удалённый запуск через Jenkins, браузерное окружение в Docker, формирование Allure Report, архивирование артефактов сборки и автоматическая отправка результатов в Telegram.

## 📖 Содержание

- [Технологии и инструменты](#stack)
- [Реализованные тестовые сценарии](#tests)
- [Архитектура проекта](#architecture)
- [Локальный запуск](#local)
- [Удалённый запуск через Jenkins](#jenkins)
- [Отчётность Allure Report](#allure)
- [Уведомления в Telegram](#telegram)

<a id="stack"></a>

## 🛠 Технологии и инструменты

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java"/>
  <img src="https://img.shields.io/badge/Selenide-65B344?style=for-the-badge" alt="Selenide"/>
  <img src="https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5"/>
  <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white" alt="Gradle"/>
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white" alt="IntelliJ IDEA"/>
  <img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white" alt="Jenkins"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
  <img src="https://img.shields.io/badge/Selenium_Grid-43B02A?style=for-the-badge&logo=selenium&logoColor=white" alt="Selenium Grid"/>
  <img src="https://img.shields.io/badge/Allure_Report-FF5722?style=for-the-badge" alt="Allure Report"/>
  <img src="https://img.shields.io/badge/Telegram-26A5E4?style=for-the-badge&logo=telegram&logoColor=white" alt="Telegram"/>
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub"/>
</p>

<a id="tests"></a>

## ✅ Реализованные тестовые сценарии

### Настройка региона

- [x] Открытие сайта и обработка всплывающих окон.
- [x] Выбор города Екатеринбург.
- [x] Проверка выбранного города.

### Навигация сайта

- [x] Проверка текстового содержимого шапки сайта.
- [x] Проверка элементов навигационного меню.
- [x] Проверка содержимого футера.

### Корзина и доставка

- [x] Поиск товара по названию.
- [x] Добавление товара в корзину.
- [x] Выбор способа получения товара.
- [x] Заполнение адреса доставки.
- [x] Выбор варианта доставки.
- [x] Подтверждение параметров доставки.
- [x] Подтверждение информационного окна.
- [x] Проверка отображения выбранного товара.

| Тестовый класс | Назначение |
|---|---|
| `CitySelectionTest` | Проверка настройки региона |
| `NavigationContentTest` | Проверка навигации и текстового содержимого сайта |
| `ProductDeliveryTest` | Проверка добавления товара и настройки доставки |

<a id="architecture"></a>

## 📂 Архитектура проекта

```text
fix-price-ui-tests/
├── media/
│   └── screenshots/
├── notification/
│   └── allure-notifications-4.11.1.jar
├── src/test/java/
│   ├── helpers/
│   │   └── Attach.java
│   ├── pages/
│   │   └── PageObjectLocal.java
│   ├── testdata/
│   │   └── FooterTestData.java
│   └── tests/
│       ├── CitySelectionTest.java
│       ├── NavigationContentTest.java
│       ├── ProductDeliveryTest.java
│       └── TestBase.java
├── gradle/
├── .gitignore
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

### Особенности реализации

- Использование паттерна Page Object.
- Использование Fluent Interface для последовательного вызова методов.
- Централизованная конфигурация браузера.
- Разделение тестовой логики и тестовых данных.
- Динамические ожидания Selenide.
- Группировка тестов с помощью аннотаций Allure.
- Детализация сценариев через Allure Steps.
- Прикрепление скриншотов, HTML-кода страницы и логов браузера.
- Передача параметров запуска через системные свойства.
- Автоматическое закрытие WebDriver после выполнения тестов.
- Архивирование результатов тестирования в Jenkins.

### Основные классы

| Класс | Назначение |
|---|---|
| `PageObjectLocal` | Локаторы и методы взаимодействия с интерфейсом |
| `TestBase` | Конфигурация браузера и жизненный цикл тестов |
| `Attach` | Прикрепление дополнительных материалов к Allure Report |
| `FooterTestData` | Хранение ожидаемых текстовых значений элементов сайта |

### Основные зависимости

| Библиотека | Версия |
|---|---|
| Selenide | 7.18.2 |
| JUnit Jupiter | 5.10.2 |
| Datafaker | 2.7.0 |
| Allure Selenide | 2.35.5 |
| Allure JUnit 5 | 2.35.5 |
| Allure Gradle Plugin | 4.3.0 |
| Allure Notifications | 4.11.1 |

<a id="local"></a>

## 💻 Локальный запуск

### Клонирование репозитория

```bash
git clone https://github.com/agerasimovv/fix-price-ui-tests.git
cd fix-price-ui-tests
```

### Запуск всех тестов на Windows

```powershell
.\gradlew.bat clean test
```

### Запуск на Linux / macOS

```bash
./gradlew clean test
```

### Запуск отдельного тестового класса

```powershell
.\gradlew.bat test --tests "tests.ProductDeliveryTest"
```

### Формирование и открытие Allure Report

```powershell
.\gradlew.bat allureServe
```

<a id="jenkins"></a>

## 🚀 Удалённый запуск через Jenkins

Jenkins и Selenium Standalone Chrome развёрнуты в отдельных Docker-контейнерах.

Jenkins загружает исходный код из GitHub и запускает автотесты через Gradle. Взаимодействие с браузером осуществляется через удалённый WebDriver.

### Схема выполнения автотестов

```mermaid
flowchart LR
    A[GitHub] --> B[Jenkins]
    B --> C[Gradle]
    C --> D[Selenide / JUnit 5]
    D <--> E[Selenium / Docker]
    E <--> F[Fix Price]
    D --> G[Allure Results]
    G --> H[Allure Report]
    H --> I[Telegram]
    H --> J[Build Artifacts]
```

### Команда удалённого запуска

```bash
./gradlew clean test -Dselenide.remote=http://selenium-chrome:4444
```

Адрес удалённого WebDriver доступен внутри общей Docker-сети.

### Главная страница Jenkins Job

<p align="center">
  <img src="media/screenshots/jenkins-build.png" width="900" alt="Jenkins Job"/>
</p>

### Результаты успешной сборки

После выполнения тестов Jenkins сохраняет артефакты:

- `allure-report.zip` — архив сформированного отчёта.
- `allure-summary.json` — сводка результатов тестирования.

<p align="center">
  <img src="media/screenshots/jenkins-build-details.png" width="900" alt="Jenkins Build Details"/>
</p>

<a id="allure"></a>

## 📊 Отчётность Allure Report

По результатам выполнения автотестов автоматически формируется Allure Report.

Отчёт содержит общую статистику, результаты выполнения сценариев, продолжительность тестирования и историю предыдущих запусков.

### Общая статистика выполнения тестов

<p align="center">
  <img src="media/screenshots/allure-overview.png" width="1000" alt="Allure Overview"/>
</p>

### Детализация тестовых сценариев

Для структурирования отчётности используются аннотации `@Feature`, `@Story`, `@DisplayName`, `@Owner` и `@Link`.

В отчёте доступны:

- Статус выполнения тестового сценария.
- Последовательность действий и проверок.
- Продолжительность выполнения каждого шага.
- Скриншоты браузера.
- HTML-код страницы.
- Логи консоли браузера.
- Информация об ошибках.

<p align="center">
  <img src="media/screenshots/allure-test-details.png" width="1000" alt="Allure Test Details"/>
</p>

<a id="telegram"></a>

## 📱 Уведомления в Telegram

После завершения тестирования и формирования Allure Report результаты автоматически отправляются в Telegram с помощью Allure Notifications.

Уведомление содержит:

- Название проекта.
- Информацию об окружении.
- Продолжительность тестирования.
- Общее количество тестовых сценариев.
- Статистику результатов выполнения.

Конфигурационный файл с токеном Telegram-бота исключён из системы контроля версий.

<p align="center">
  <img src="media/screenshots/telegram-notification.png" width="450" alt="Telegram Notification"/>
</p>

---

<p align="center">
  <b>Java • Selenide • JUnit 5 • Jenkins • Docker • Allure</b>
</p>
