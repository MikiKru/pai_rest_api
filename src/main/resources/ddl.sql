-- utworzenie db
create database app_db;
-- utworznie użytkownika na serwerze db
create user 'ex_app_user'@'localhost' identified by 'qwe123';
grant CREATE, ALTER, DROP, SELECT, UPDATE, DELETE, INSERT, references
on app_db.*
to 'ex_app_user'@'localhost';