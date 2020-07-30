Для запуска требуется предварительно создать БД H2 с именем test в папке пользователя и выполнить создание таблиц:

CREATE TABLE USER(
  id int not null,
  name varchar not null,
  age int not null,
  telephone varchar,
  primary key(id)
);

CREATE TABLE CUSTOMER(
  id int not null,
  first_name varchar not null,
  last_name varchar not null,
  address varchar,
  primary key(id)
);
