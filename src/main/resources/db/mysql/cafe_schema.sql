CREATE DATABASE IF NOT EXISTS petclinic;

ALTER DATABASE cafe
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON petclinic.* TO pc@localhost IDENTIFIED BY 'pc';

USE petclinic;

CREATE TABLE IF NOT EXISTS vets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS specialties (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id INT(4) UNSIGNED NOT NULL,
  specialty_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  UNIQUE (vet_id,specialty_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS types (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  INDEX(name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS pets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birth_date DATE,
  type_id INT(4) UNSIGNED NOT NULL,
  owner_id INT(4) UNSIGNED NOT NULL,
  INDEX(name),
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT(4) UNSIGNED NOT NULL,
  visit_date DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
) engine=InnoDB;


DROP TABLE bill_items;
DROP TABLE bills;
DROP TABLE cafe_tables;
DROP TABLE waiters;
DROP TABLE menu_items;
DROP TABLE menu_groups;

CREATE TABLE cafe_tables (
  id          INTEGER NOT NULL PRIMARY KEY,
  name        VARCHAR(20) NOT NULL,
  css_class   VARCHAR(20) NOT NULL,
  enabled     BOOLEAN NOT NULL,
  waiter_id   INTEGER
);

CREATE TABLE menu_groups (
  id    INTEGER NOT NULL PRIMARY KEY,
  name  VARCHAR(255) NOT NULL
);

CREATE TABLE menu_items (
  id             INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name           VARCHAR(255) NOT NULL,
  menu_group_id  INTEGER NOT NULL,
  price          DECIMAL NOT NULL
);
ALTER TABLE menu_items ADD CONSTRAINT fk_menu_items_groups
  FOREIGN KEY (menu_group_id) REFERENCES menu_groups (id);

CREATE TABLE waiters (
  id         INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name  VARCHAR(30) NOT NULL,
  telephone  VARCHAR(20),
  email      VARCHAR(80)
);

CREATE TABLE bills (
  id               INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  table_id         INTEGER NOT NULL,
  waiter_id        INTEGER NOT NULL,
  open_date        DATETIME NOT NULL,
  persons          INTEGER NOT NULL,
  close_date       DATETIME,
  discount_percent INTEGER,
  discount_amount  DECIMAL(15,2),
  bill_amount      DECIMAL(15,2),
  whole_amount     DECIMAL(15,2),
  payment_type     INTEGER,
  transact_number  VARCHAR(20)
);
ALTER TABLE bills ADD CONSTRAINT fk_bills_cafe_tables_id
  FOREIGN KEY (table_id) REFERENCES cafe_tables(id);
ALTER TABLE bills ADD CONSTRAINT fk_bills_waiters_id
  FOREIGN KEY (waiter_id) REFERENCES waiters(id);

CREATE TABLE bill_items (
  id            INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  bill_id       INTEGER NOT NULL,
  menu_items_id INTEGER NOT NULL,
  order_date    DATETIME NOT NULL,
  price         DECIMAL(15,2) NOT NULL
);
ALTER TABLE bill_items ADD CONSTRAINT fk_bill_items_bills_id
  FOREIGN KEY (bill_id) REFERENCES bills(id);
ALTER TABLE bill_items ADD CONSTRAINT fk_bill_items_menu_items_id
  FOREIGN KEY (menu_items_id) REFERENCES menu_items(id);

/**********************************************************************/
CREATE TABLE bill_dates (
  bill_date DATETIME NOT NULL
);
