-- Создание базы данных "Друзья человека"
DROP DATABASE IF EXISTS Friends_of_Human;
CREATE DATABASE IF NOT EXISTS Friends_of_Human;

-- Использование созданной базы данных
USE Friends_of_Human;

-- Создание таблицы для собак
CREATE TABLE Dogs (
    dog_id INT AUTO_INCREMENT PRIMARY KEY,
    dog_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для собак
INSERT INTO Dogs (dog_name, command, birth_date) VALUES
('Buddy', 'Сидеть', '2019-05-10'),
('Max', 'Фас', '2020-02-15'),
('Rocky', 'Апорт', '2018-11-20');

-- Создание таблицы для кошек
CREATE TABLE Cats (
    cat_id INT AUTO_INCREMENT PRIMARY KEY,
    cat_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для кошек
INSERT INTO Cats (cat_name, command, birth_date) VALUES
('Whiskers', 'Лови', '2022-08-25'),
('Mittens', 'Гуляй', '2019-03-12'),
('Snowball', 'Прятки', '2016-12-30');

-- Создание таблицы для хомяков
CREATE TABLE Hamsters (
    hamster_id INT AUTO_INCREMENT PRIMARY KEY,
    hamster_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для хомяков
INSERT INTO Hamsters (hamster_name, command, birth_date) VALUES
('Nibbles', 'Кружи', '2018-06-21'),
('Squeaky', 'Копай', '2023-09-14'),
('Fluffy', 'Беги', '2020-03-02');

-- Создание таблицы для лошадей
CREATE TABLE Horses (
    horse_id INT AUTO_INCREMENT PRIMARY KEY,
    horse_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для лошадей
INSERT INTO Horses (horse_name, command, birth_date) VALUES
('Thunder', 'Вперед', '2015-04-17'),
('Spirit', 'Прыгай', '2016-09-28'),
('Blaze', 'Галоп', '2021-12-10');

-- Создание таблицы для верблюдов
CREATE TABLE Camels (
    camel_id INT AUTO_INCREMENT PRIMARY KEY,
    camel_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для верблюдов
INSERT INTO Camels (camel_name, command, birth_date) VALUES
('Sahara', 'Иди', '2014-08-20'),
('Desert', 'Пей', '2013-11-15'),
('Nomad', 'Садись', '2015-07-02');

-- Создание таблицы для ослов
CREATE TABLE Donkeys (
    donkey_id INT AUTO_INCREMENT PRIMARY KEY,
    donkey_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE
);

-- Заполнение таблицы для ослов
INSERT INTO Donkeys (donkey_name, command, birth_date) VALUES
('Eeyore', 'Тяни', '2016-03-12'),
('Burrito', 'Ешь', '2017-10-05'),
('Pedro', 'Иди сюда', '2018-02-28');

-- Создание таблицы "Домашние животные"
CREATE TABLE Domestic_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE,
    animal_type VARCHAR(50) -- Добавляем поле для указания типа животного
);

-- Заполнение таблицы "Домашние животные" данными из таблиц "Cats", "Dogs" и "Hamsters"
INSERT INTO Domestic_Animals (animal_name, command, birth_date, animal_type)
SELECT cat_name, command, birth_date, 'Cat' FROM Cats
UNION ALL
SELECT dog_name, command, birth_date, 'Dog' FROM Dogs
UNION ALL
SELECT hamster_name, command, birth_date, 'Hamster' FROM Hamsters;

-- Создание таблицы "Вьючные животные"
CREATE TABLE Pack_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE,
    animal_type VARCHAR(50) -- Добавляем поле для указания типа животного
);

-- Заполнение таблицы "Вьючные животные" данными из таблиц "Horses", "Camels" и "Donkeys"
INSERT INTO Pack_Animals (animal_name, command, birth_date, animal_type)
SELECT horse_name, command, birth_date, 'Horse' FROM Horses
UNION ALL
SELECT camel_name, command, birth_date, 'Camel' FROM Camels
UNION ALL
SELECT donkey_name, command, birth_date, 'Donkey' FROM Donkeys;


SELECT * FROM Domestic_Animals; 
SELECT * FROM Pack_Animals; 

-- Удаление информации о верблюдах из таблицы "Вьючные животные"
DELETE FROM Pack_Animals WHERE animal_type = 'Camel';

-- Объединение таблиц "Horses" и "Donkeys" в одну таблицу "Equines"
DROP TABLE IF EXISTS Equines; 
CREATE TABLE Equines (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_name VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE,
    animal_type VARCHAR(50) -- Добавляем поле для указания типа животного
);

-- Заполнение таблицы "Equines" данными из таблиц "Horses" и "Donkeys"
INSERT INTO Equines (animal_name, command, birth_date, animal_type)
SELECT horse_name, command, birth_date, 'Horse' FROM Horses
UNION ALL
SELECT donkey_name, command, birth_date, 'Donkey' FROM Donkeys;

SELECT * FROM Equines;

-- Создание таблицы "молодые животные"
DROP TABLE IF EXISTS Young_Animals;
CREATE TABLE Young_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_name VARCHAR(50),
	animal_type VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE,
    age_months INT -- Столбец для хранения возраста в месяцах
);

-- Заполнение таблицы "молодые животные" данными из таблиц "Domestic_Animals" и "Pack_Animals"
INSERT INTO Young_Animals (animal_name, animal_type, command, birth_date, age_months)
SELECT animal_name, animal_type, command, birth_date, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_months
FROM Domestic_Animals
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3
UNION ALL
SELECT animal_name, animal_type, command, birth_date, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_months
FROM Equines
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;

SELECT * FROM Young_Animals;

-- Создание объединенной таблицы
DROP TABLE IF EXISTS All_Animals; 
CREATE TABLE All_Animals (
    animal_id INT AUTO_INCREMENT PRIMARY KEY,
    animal_name VARCHAR(50),
    animal_type VARCHAR(50),
    command VARCHAR(100),
    birth_date DATE,
    animal_class VARCHAR(50), -- Добавляем поле для указания принадлежности к исходной таблице
    young_or_not VARCHAR(10) -- Добавляем поле для указания, является ли животное молодым или нет
);

-- Заполнение объединенной таблицы данными из таблиц "Domestic_Animals" с указанием принадлежности и проверкой на наличие в таблице "молодые животные"
INSERT INTO All_Animals (animal_name, animal_type, command, birth_date, animal_class, young_or_not)
SELECT animal_name, animal_type, command, birth_date, 'Domestic_Animals' AS animal_class,
    CASE WHEN animal_name IN (SELECT animal_name FROM Young_Animals) THEN 'Young' ELSE 'Not Young' END AS young_or_not
FROM Domestic_Animals
UNION ALL
-- Заполнение объединенной таблицы данными из таблиц "Equines" с указанием принадлежности и проверкой на наличие в таблице "молодые животные"
SELECT animal_name, animal_type, command, birth_date, 'Equines' AS animal_class,
    CASE WHEN animal_name IN (SELECT animal_name FROM Young_Animals) THEN 'Young' ELSE 'Not Young' END AS young_or_not
FROM Equines;

SELECT * FROM All_Animals; 
