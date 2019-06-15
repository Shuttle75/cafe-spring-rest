DROP TABLE bill_items;
DROP TABLE bills;
DROP TABLE cafe_tables;
DROP TABLE waiters;
DROP TABLE menu_items;
DROP TABLE menu_groups;
DROP TABLE bill_dates;

CREATE TABLE cafe_tables (
  id          int NOT NULL PRIMARY KEY,
  name        text NOT NULL,
  css_class   text NOT NULL,
  enabled     boolean NOT NULL,
  waiter_id   int
);

CREATE TABLE menu_groups (
  id    int  NOT NULL PRIMARY KEY,
  name  text NOT NULL
);

CREATE TABLE menu_items (
  id             serial  NOT NULL PRIMARY KEY,
  name           text NOT NULL,
  menu_group_id  int  NOT NULL,
  price          numeric(17, 2) NOT NULL
);

ALTER TABLE menu_items ADD CONSTRAINT fk_menu_items_groups
  FOREIGN KEY (menu_group_id) REFERENCES menu_groups (id);

CREATE TABLE waiters (
  id         int  NOT NULL PRIMARY KEY,
  first_name text NOT NULL,
  last_name  text NOT NULL,
  telephone  text,
  email      text
);

CREATE TABLE bills (
  id               serial NOT NULL PRIMARY KEY,
  table_id         int NOT NULL,
  waiter_id        int NOT NULL,
  open_date        timestamp without time zone NOT NULL,
  persons          int NOT NULL,
  close_date       timestamp without time zone,
  discount_percent int,
  discount_amount  numeric(17, 2),
  bill_amount      numeric(17, 2),
  whole_amount     numeric(17, 2),
  payment_type     int,
  transact_number  text
);
ALTER TABLE bills ADD CONSTRAINT fk_bills_cafe_tables_id
  FOREIGN KEY (table_id) REFERENCES cafe_tables(id);
ALTER TABLE bills ADD CONSTRAINT fk_bills_waiters_id
  FOREIGN KEY (waiter_id) REFERENCES waiters(id);

CREATE TABLE bill_items (
  id            serial NOT NULL PRIMARY KEY,
  bill_id       int NOT NULL,
  menu_items_id int NOT NULL,
  order_date    timestamp without time zone,
  price         numeric(17, 2)
);
ALTER TABLE bill_items ADD CONSTRAINT fk_bill_items_bills_id
  FOREIGN KEY (bill_id) REFERENCES bills(id);
ALTER TABLE bill_items ADD CONSTRAINT fk_bill_items_menu_items_id
  FOREIGN KEY (menu_items_id) REFERENCES menu_items(id);

/**********************************************************************/
CREATE TABLE bill_dates (
  bill_date timestamp without time zone NOT NULL
);
