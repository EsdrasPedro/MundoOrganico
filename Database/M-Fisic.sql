CREATE DATABASE IF NOT EXISTS mundo_organico;
USE mundo_organico;

CREATE TABLE IF NOT EXISTS user (
  id int unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL DEFAULT '0',
  cpf varchar(100) DEFAULT '0',
  cellphone varchar(100) NOT NULL DEFAULT '0',
  email varchar(100) NOT NULL DEFAULT '0',
  password varchar(200) NOT NULL DEFAULT '0',
  CONSTRAINT user_PK PRIMARY KEY (id),
  UNIQUE KEY email (email),
  UNIQUE KEY cpf (cpf));
  
  CREATE TABLE IF NOT EXISTS salesman (
  id int unsigned NOT NULL AUTO_INCREMENT,
  fantasy_name varchar(100) NOT NULL DEFAULT '0',
  cnpj varchar(100) NOT NULL DEFAULT '0',
  email varchar(150) NOT NULL DEFAULT '0',
  password varchar(200) NOT NULL DEFAULT '0',
  CONSTRAINT salesman_PK PRIMARY KEY (id),
  UNIQUE KEY fantasy_name (fantasy_name),
  UNIQUE KEY cnpj (cnpj),
  UNIQUE KEY email (email));
  
  CREATE TABLE IF NOT EXISTS category (
  id int unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL DEFAULT '0',
  CONSTRAINT category_PK PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS address (
  id int unsigned NOT NULL AUTO_INCREMENT,
  location varchar(200) NOT NULL DEFAULT '',
  number int NOT NULL DEFAULT 0,
  reference varchar(100) DEFAULT '0',
  complement varchar(100) DEFAULT '0',
  user_id int unsigned NOT NULL DEFAULT 0,
  CONSTRAINT address_PK PRIMARY KEY (id),
  CONSTRAINT address_user_FK FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS passwordtoken (
  id int unsigned NOT NULL AUTO_INCREMENT,
  token varchar(200) NOT NULL DEFAULT '0',
  used tinyint NOT NULL DEFAULT 0,
  user_id int unsigned NOT NULL DEFAULT 0,
  CONSTRAINT passwordtoken_PK PRIMARY KEY (id),
  CONSTRAINT passwordtoken_user_FK FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS request (
  id int unsigned NOT NULL AUTO_INCREMENT,
  time time NOT NULL DEFAULT '00:00:00',
  date date NOT NULL DEFAULT '00/00/00',
  status varchar(100) NOT NULL DEFAULT '0',
  amount double NOT NULL DEFAULT 0,
  user_id int unsigned NOT NULL,
  CONSTRAINT request_PK PRIMARY KEY (id),
  CONSTRAINT request_user_FK FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS type (
  id int unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL DEFAULT '0',
  category_id int unsigned DEFAULT NULL,
  CONSTRAINT type_PK PRIMARY KEY (id),
  CONSTRAINT type_category_FK FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE ON UPDATE NO ACTION);
  
  CREATE TABLE IF NOT EXISTS product (
  id int unsigned NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL DEFAULT '0',
  description varchar(320) NOT NULL DEFAULT '0',
  value double NOT NULL DEFAULT 0,
  type_id int unsigned NOT NULL DEFAULT 0,
  salesman_id int unsigned NOT NULL DEFAULT 0,
  CONSTRAINT product_PK PRIMARY KEY (id),
  CONSTRAINT product_type_FK FOREIGN KEY (type_id) REFERENCES type (id) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT product_salesman_FK FOREIGN KEY (salesman_id) REFERENCES salesman (id) ON DELETE NO ACTION ON UPDATE NO ACTION);
 
  
  CREATE TABLE IF NOT EXISTS ordered_items (
  id int unsigned NOT NULL AUTO_INCREMENT,
  value double NOT NULL DEFAULT 0,
  amount int NOT NULL DEFAULT 0,
  request_id int unsigned NOT NULL DEFAULT 0,
  product_id int unsigned NOT NULL DEFAULT 0,
  CONSTRAINT ordered_items_PK PRIMARY KEY (id),
  CONSTRAINT ordered_items_product_FK FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT ordered_items_request_FK FOREIGN KEY (request_id) REFERENCES request (id) ON DELETE CASCADE ON UPDATE NO ACTION);