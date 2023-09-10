# Aston_Task

Для запуска потребуется БД, например MySql и юзер для нее
Команды для создания юзера и БД

CREATE USER 'user'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';

CREATE DATABASE  aston_db;
USE aston_db;

CREATE TABLE bank_accounts (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(20),
  money int,
  pin int,
  PRIMARY KEY (id)
);

Перечень эндпоинтов api-службы:
/api/addBankAccount(PUT запрос) - добавляет аккаунт, пример JSON 
{
    "name": "Oleg",
    "pin": 4234
}

/api/bankAccounts(GET запрос) - возвращает все имена и их текущий баланс

/api/deposit(POST запрос) - осуществляет пополнение счета, пример JSON 
{
    "bankAccountId": 2,
    "money": 2000,
    "pin": 1234
}

/api/withdraw(POST запрос) - осуществляет снятие средств со счета, пример JSON 
{
    "bankAccountId": 3,
    "money": 1000,
    "pin": 3421
}

/api/transfer(POST запрос) - осуществляет перевод с одного счета на другой, пример JSON 
{
    "currentBankAccountId": 2,
    "pendingBankAccountId": 3,
    "money": 3234,
    "pin": 1234
}
