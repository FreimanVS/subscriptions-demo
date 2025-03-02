# Subscriptions demo project

Техническое задание: Реализация микросервиса
### Описание задачи
Необходимо разработать микросервис на Spring Boot 3, который будет
предоставлять REST API для управления пользователями и их подписками на
сервисы.
Проект должен использовать Java 17.
**Срок выполнения:** 2 дня.
### Функциональные требования
1. API для управления пользователями
- Создание пользователя.
- Получение информации о пользователе.
- Обновление данных пользователя.
- Удаление пользователя.
2. API для подписок
- Добавление подписки пользователю.
- Получение списка подписок пользователя.
- Удаление подписки.
- Подписки представляют собой подписки на цифровые сервисы, такие как
  YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix и другие стриминговые
  платформы.
3. Интеграция с базой данных
- Использовать PostgreSQL.
- Таблицы: users, subscriptions.
4. Логирование
- Логирование через SLF4J.
5. Docker
- Создать Dockerfile для развертывания сервиса.
- Разработать docker-compose.yml, который позволит локально запускать проект
  вместе с базой данных.
### Требования к API
Примерные эндпоинты:
POST /users - создать пользователя
GET /users/{id} - получить информацию о пользователе
PUT /users/{id} - обновить пользователя
DELETE /users/{id} - удалить пользователя
POST /users/{id}/subscriptions - добавить подписку
GET /users/{id}/subscriptions - получить подписки пользователя
DELETE /users/{id}/subscriptions/{sub_id} - удалить подписку
GET /subscriptions/top - получить ТОП-3 популярных подписок

## API TO TEST
### start with the command in terminal:
```
sh start-prod.sh
```
### or with the command if you want to start the application locally):
```
sh start-db.sh
```
### create user
```
curl --location 'http://localhost:8085/api/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{"name":"user111","surname":"surname","username": "username8","email":"someemail@mail.ru","password":"abs"}'
```
### create subscription
```
curl --location 'http://localhost:8085/api/v1/subscriptions' \
--header 'Content-Type: application/json' \
--data '{
    "name":"subscr"
}'
```
### link the subscription to the user
```
curl --location --request POST 'http://localhost:8085/api/v1/users/1/subscriptions/1'
```
### get the user
```
curl --location --request GET 'http://localhost:8085/api/v1/users/1'
```
### get the user's subscriptions
```
curl --location --request GET 'http://localhost:8085/api/v1/users/1/subscriptions'
```
### get TOP-3 subscriptions
```
curl --location --request GET 'http://localhost:8085/api/v1/subscriptions/top'
```
### delete the subscription
```
curl --location --request DELETE 'http://localhost:8085/api/v1/users/1/subscriptions/1'
```