
Запуск тестов через консоль:
- с использованием конфигурации для Selenium Webdriver:

```
gradle clean googleTest -Dhost=${host} -Dbrowser=${browser} -DbrowserVersion=${version}
```

- с использованием библиотеки Owner :

```
gradle clean yandexTest -Dhost=${host}
```

Ключи для запуска:

host | 
:------:|
local   |
remote  |


browser | version
:-------|:-------:
CHROME  | 100
CHROME  | 99
FIREFOX | 98
FIREFOX | 97
OPERA   | 85
OPERA   | 84


