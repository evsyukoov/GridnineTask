# GridnineTask

##  Сборка и запуск мейника

mvn package

java -jar target/Gridnine-1.0.jar

## Тесты

Написано несколько юнит-тестов для каждого фильтра из задания

## Особенности

Тестовые классы пришлось сделать public для удобства тестирования и выноса своего кода в отдельный package, логику классов не трогал.(toString() немного поменял для удобного вывода)

Также дописал несколько методов по созданию наборов перелетов для тестирования. Исходный createFlights() не менял.

