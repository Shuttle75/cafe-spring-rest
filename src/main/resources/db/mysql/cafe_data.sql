INSERT IGNORE INTO vets VALUES (1, 'James', 'Carter');
INSERT IGNORE INTO vets VALUES (2, 'Helen', 'Leary');
INSERT IGNORE INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT IGNORE INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT IGNORE INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT IGNORE INTO vets VALUES (6, 'Sharon', 'Jenkins');

INSERT IGNORE INTO specialties VALUES (1, 'radiology');
INSERT IGNORE INTO specialties VALUES (2, 'surgery');
INSERT IGNORE INTO specialties VALUES (3, 'dentistry');

INSERT IGNORE INTO vet_specialties VALUES (2, 1);
INSERT IGNORE INTO vet_specialties VALUES (3, 2);
INSERT IGNORE INTO vet_specialties VALUES (3, 3);
INSERT IGNORE INTO vet_specialties VALUES (4, 2);
INSERT IGNORE INTO vet_specialties VALUES (5, 1);

INSERT IGNORE INTO types VALUES (1, 'cat');
INSERT IGNORE INTO types VALUES (2, 'dog');
INSERT IGNORE INTO types VALUES (3, 'lizard');
INSERT IGNORE INTO types VALUES (4, 'snake');
INSERT IGNORE INTO types VALUES (5, 'bird');
INSERT IGNORE INTO types VALUES (6, 'hamster');

INSERT IGNORE INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT IGNORE INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT IGNORE INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT IGNORE INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT IGNORE INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT IGNORE INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT IGNORE INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT IGNORE INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT IGNORE INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT IGNORE INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT IGNORE INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 1);
INSERT IGNORE INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 2);
INSERT IGNORE INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 3);
INSERT IGNORE INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 3);
INSERT IGNORE INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 4);
INSERT IGNORE INTO pets VALUES (6, 'George', '2000-01-20', 4, 5);
INSERT IGNORE INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 6);
INSERT IGNORE INTO pets VALUES (8, 'Max', '1995-09-04', 1, 6);
INSERT IGNORE INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 7);
INSERT IGNORE INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 8);
INSERT IGNORE INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 9);
INSERT IGNORE INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 10);
INSERT IGNORE INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 10);

INSERT IGNORE INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (3, 8, '2009-06-04', 'neutered');
INSERT IGNORE INTO visits VALUES (4, 7, '2008-09-04', 'spayed');



INSERT INTO menu_groups VALUES (1, 'Салаты');
INSERT INTO menu_groups VALUES (2, 'Холодные закуски');
INSERT INTO menu_groups VALUES (3, 'Десерты');
INSERT INTO menu_groups VALUES (4, 'Пасты');
INSERT INTO menu_groups VALUES (5, 'Первые блюда');
INSERT INTO menu_groups VALUES (6, 'Закуски к пиву');
INSERT INTO menu_groups VALUES (7, 'Пицца');
INSERT INTO menu_groups VALUES (8, 'Кофе');
INSERT INTO menu_groups VALUES (9, 'Чай');
INSERT INTO menu_groups VALUES (10, 'Холодные напитки');
INSERT INTO menu_groups VALUES (11, 'Алкогольные напитки');
INSERT INTO menu_groups VALUES (12, 'Пиво');
INSERT INTO menu_groups VALUES (13, 'Вино');

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Цезарь с курицей',         1,  65);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Цезарь с лососем',         1, 118);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Греческий',                1,  79);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Зеленый с креветками',     1, 122);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Провинциальный',           1,  66);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Смарагдовый',              1,  43);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Салат теплый с телятиной', 1,  92);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Мясная тарелка',                 2,  106);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Бастурма, суджук с лимоном',     2,  76);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Сырная тарелка',                 2,  132);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Закуска из селедки с картошкой', 2,  57);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Овощная тарелка',                2,  53);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Закуска к водочке',              2,  27);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Мороженное с добавками', 3,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Фруктовая тарелка',      3,  72);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Торт "Наполеон"',        3,  58);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Спагетти "Карбонара"',           4,  72);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Пене с томатами',                4,  64);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Спагетти с морепродуктами Нери', 4,  107);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Фетучи с лесными грибами',       4,  89);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Канкильены четыре сыра',         4,  86);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Бульон куриный по домашнему', 5,  28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Крем суп грибной',            5,  58);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Окрошка',                     5,  36);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Солянка мясная',              5,  68);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Картофель фри с соусом азия чили',          6,  37);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Картофель по-селянски с часнфковым соусом', 6,  37);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Грибочки фри с часнфковым соусом',          6,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Свинячие уши с часныком и зеленым соусом',  6,  64);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Гренки с часнфковым соусом',                6,  22);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Куриные крилышки',                          6,  66);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ( 'Маргарита',        7,   94);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Четыре сыра',       7,  149);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Четыре мяса',       7,  156);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Сыцилийская',       7,  159);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Гавайская',         7,  136);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Морской коктейль',  7,  237);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Дьябло',            7,  167);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Пица с мидиями',    7,  172);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Перфетто',          7,  173);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Карбонара',         7,  143);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Tasso пиццв',       7,  162);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Пицца по селянски', 7,  132);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Паперони',          7,  139);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Фокачча (выпечка)', 7,   16);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Еспрессо',            8,  12);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Американо',           8,  12);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Американо с молоком', 8,  17);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Капуччино',           8,  19);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Латте',               8,  22);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Кофе Гляссэ',         8,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Какао',               8,  19);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Молоко',              8,  5);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Чай чорний "1000 и 1 ночь"',   9,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Чай зеленый "Альпийский луг"', 9,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Чай зеленый',                  9,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Чай черный классический',      9,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Чай "Брызги шампанского"',     9,  32);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Мед',                          9,  12);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Мохито',                10,   44);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Кола',                  10,   20);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Фанта',                 10,   20);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Швепс',                 10,   20);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вода Банаква с газом',  10,   20);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вода Банаква без газа', 10,   20);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вода Боржоми',          10,   40);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Сок Rich',              10,   14);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Немиров премиум',            11,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Немиров премиум клюква',     11,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Немиров деликат',            11,   18);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Немиров оригинальный',       11,   18);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Немиров с перцем',           11,   18);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Финляндия классическая',     11,   38);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Финляндия клюква',           11,   38);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Martini Bianco',             11,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Martini Extra dry',          11,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Тэкила Olmeka blanco',       11,   72);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Тэкила Olmeka gold',         11,   72);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ром Captain Morgan Black',   11,   56);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ром Baccardi Blanco',        11,   56);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Джин Beefeater',             11,   57);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Коньяк Закарпатский',        11,   38);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Коньяк Арарат 5 звезд',      11,   65);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Коньяк Sarajisvili 5 звезд', 11,   55);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Hennessy VS',                11,  132);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Виски Jameson',              11,   79);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Виски Jack Daniels',         11,   79);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Виски Chivas Regal 12',      11,  140);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ликер Baileys',              11,   62);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ликер Sambuca Molinari',     11,   77);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ликер Jagermeister',         11,   56);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Ликер Becherovka',           11,   56);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Heineken 0,33',           12,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Heineken 0,5',            12,   38);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Oettinger 0,33',          12,   19);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Oettinger 0,5',           12,   28);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Stare Misto 0,33',        12,   17);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Stare Misto 0,5',         12,   26);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Corona Extra',            12,   52);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Hoegaarden White безалк', 12,   46);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Авторское (полутемное)',  12,   33);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Черное (темное)',         12,   33);

INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Игристое брют Инкерман',                            13,  191);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Игристое VMartini Asti',                            13,  598);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вино белое полусладкое Алазанская долина Бадагони', 13,   43);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вино красное полусладкое Алазанская Заря Кахетии',  13,   43);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вино красное полусухое Пиросмани Бадагони',         13,   43);
INSERT INTO menu_items(name, menu_group_id, price) VALUES ('Вино белое сухое Цинанадали Бадагони',              13,   43);

INSERT INTO cafe_tables VALUES ( 1,  '1', 'cafe-table1', TRUE, 1);
INSERT INTO cafe_tables VALUES ( 2,  '2', 'cafe-table2', TRUE, 1);
INSERT INTO cafe_tables VALUES ( 3,  '3', 'cafe-table3', TRUE, 2);
INSERT INTO cafe_tables VALUES ( 4,  '4', 'cafe-table4', TRUE, 2);
INSERT INTO cafe_tables VALUES ( 5,  '5', 'cafe-table5', TRUE, 3);
INSERT INTO cafe_tables VALUES ( 6,  '6', 'cafe-table6', TRUE, 3);
INSERT INTO cafe_tables VALUES ( 7,  '7', 'cafe-table7', TRUE, 4);
INSERT INTO cafe_tables VALUES ( 8,  '8', 'cafe-table8', TRUE, 4);
INSERT INTO cafe_tables VALUES ( 9,  '9', 'cafe-table9', TRUE, 5);
INSERT INTO cafe_tables VALUES (10, '10', 'cafe-table10', TRUE, 5);
INSERT INTO cafe_tables VALUES (11, '11', 'cafe-table11', TRUE, 6);
INSERT INTO cafe_tables VALUES (12, '12', 'cafe-table12', TRUE, 6);
INSERT INTO cafe_tables VALUES (99, 'БАР', 'bar', TRUE, 7);

INSERT INTO waiters  VALUES (1,    'Волошина',     'Ирина', '+380503570570', 'email@gmail.com');
INSERT INTO waiters  VALUES (2,       'Чехун',      'Юрий', '+380504466345', 'email@gmail.com');
INSERT INTO waiters  VALUES (3,    'Шевченко',     'Света', '+380979705226', 'email@gmail.com');
INSERT INTO waiters  VALUES (4, 'Довгополова',     'Ольга', '+380664383959', 'email@gmail.com');
INSERT INTO waiters  VALUES (5,    'Мусиенко',     'Елена', '+380674465950', 'email@gmail.com');
INSERT INTO waiters  VALUES (6,      'Дубова',      'Анна', '+380970611632', 'email@gmail.com');
INSERT INTO waiters  VALUES (7,       'Пивак', 'Александр', '+380672856815', 'email@gmail.com');

/**********************************************************************************************************************/
INSERT INTO bill_dates VALUES('2017-08-01');
INSERT INTO bill_dates VALUES('2017-08-02');
INSERT INTO bill_dates VALUES('2017-08-03');
INSERT INTO bill_dates VALUES('2017-08-04');
INSERT INTO bill_dates VALUES('2017-08-05');
INSERT INTO bill_dates VALUES('2017-08-06');
INSERT INTO bill_dates VALUES('2017-08-07');
INSERT INTO bill_dates VALUES('2017-08-08');
INSERT INTO bill_dates VALUES('2017-08-09');
INSERT INTO bill_dates VALUES('2017-08-10');
INSERT INTO bill_dates VALUES('2017-08-11');
INSERT INTO bill_dates VALUES('2017-08-12');
INSERT INTO bill_dates VALUES('2017-08-13');
INSERT INTO bill_dates VALUES('2017-08-14');
INSERT INTO bill_dates VALUES('2017-08-15');
INSERT INTO bill_dates VALUES('2017-08-16');
INSERT INTO bill_dates VALUES('2017-08-17');
INSERT INTO bill_dates VALUES('2017-08-18');
INSERT INTO bill_dates VALUES('2017-08-19');
INSERT INTO bill_dates VALUES('2017-08-20');
INSERT INTO bill_dates VALUES('2017-08-21');
INSERT INTO bill_dates VALUES('2017-08-22');
INSERT INTO bill_dates VALUES('2017-08-23');
INSERT INTO bill_dates VALUES('2017-08-24');
INSERT INTO bill_dates VALUES('2017-08-25');
INSERT INTO bill_dates VALUES('2017-08-26');
INSERT INTO bill_dates VALUES('2017-08-27');
INSERT INTO bill_dates VALUES('2017-08-28');
INSERT INTO bill_dates VALUES('2017-08-29');
INSERT INTO bill_dates VALUES('2017-08-30');
INSERT INTO bill_dates VALUES('2017-08-31');

INSERT INTO bills (table_id, waiter_id, open_date, persons, payment_type)
SELECT
  cafe_tables.id,
  cafe_tables.waiter_id,
  DATE_ADD(DATE_ADD(DATE_ADD(bill_dates.bill_date,
                             INTERVAL FLOOR(18 + RAND() * 2) HOUR),
                    INTERVAL FLOOR(RAND() * 60) MINUTE),
           INTERVAL FLOOR(RAND() * 60) SECOND),
  FLOOR(2 + (RAND() * 3)),
  0
FROM bill_dates, cafe_tables;

UPDATE bills SET close_date = DATE_ADD(DATE_ADD(DATE_ADD(open_date, INTERVAL 4 HOUR), INTERVAL 12 MINUTE), INTERVAL 35 SECOND);

INSERT INTO bill_items (bill_id ,menu_items_id)
  SELECT
    bills.id,
    FLOOR(1 + (RAND() * 100))
  FROM bills, waiters;

UPDATE bill_items SET price = (SELECT price FROM menu_items WHERE id = bill_items.menu_items_id);

UPDATE bill_items, bills SET bill_items.order_date = DATE_ADD(bills.open_date, INTERVAL FLOOR(RAND() * 60) MINUTE)
WHERE bill_items.bill_id = bills.id;

UPDATE bills SET discount_amount = (SELECT SUM(price) FROM bill_items WHERE bill_id = bills.id);
UPDATE bills SET bill_amount = (SELECT SUM(price) FROM bill_items WHERE bill_id = bills.id);
UPDATE bills SET whole_amount = (SELECT SUM(price) FROM bill_items WHERE bill_id = bills.id);
