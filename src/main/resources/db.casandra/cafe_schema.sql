CREATE KEYSPACE cafe
    WITH REPLICATION = {
    'class' : 'SimpleStrategy',
    'replication_factor' : 1
    };


DROP TABLE cafe.bill_items;
DROP TABLE cafe.bills;
DROP TABLE cafe.cafe_tables;
DROP TABLE cafe.waiters;
DROP TABLE cafe.menu_items;
DROP TABLE cafe.menu_groups;
DROP TABLE cafe.bill_dates;

CREATE TABLE cafe.cafe_tables (
  id          int PRIMARY KEY,
  name        text,
  css_class   text,
  enabled     boolean,
  waiter_id   int
);

CREATE TABLE cafe.menu_groups (
  id    int  PRIMARY KEY,
  name  text
);

CREATE TABLE cafe.menu_items (
  id             int PRIMARY KEY,
  name           text,
  menu_group_id  int,
  price          decimal
);

CREATE TABLE cafe.waiters (
  id         int  PRIMARY KEY,
  first_name text,
  last_name  text,
  telephone  text,
  email      text
);

CREATE TABLE cafe.bills (
  id               int PRIMARY KEY,
  table_id         int,
  waiter_id        int,
  open_date        timestamp,
  persons          int,
  close_date       timestamp,
  discount_percent int,
  discount_amount  decimal,
  bill_amount      decimal,
  whole_amount     decimal,
  payment_type     int,
  transact_number  text
);

CREATE TABLE cafe.bill_items (
  id            int PRIMARY KEY,
  bill_id       int,
  menu_items_id int,
  order_date    timestamp,
  price         decimal
);

/**********************************************************************/
CREATE TABLE cafe.bill_dates (
  bill_date timestamp
);
