CREATE TABLE User_info
(
    id            SERIAL             NOT NULL,
    first_name    VARCHAR(50)        NOT NULL,
    mobile        VARCHAR(15) UNIQUE NOT NULL,
    email         VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(32)        NOT NULL,
    local_id      INT                NOT NULL,
    is_admin       BOOLEAN            NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Booking
(
    id             SERIAL NOT NULL,
    user_id        bigint NOT NULL,
    restaurant_id  bigint NOT NULL,
    date_id        int    NOT NULL,
    num_of_persons int    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Available_date_time
(
    id            SERIAL    NOT NULL,
    restaurant_id bigint    NOT NULL,
    date_time     timestamp NOT NULL,
    booked        bool      NOT NULL default false,
    PRIMARY KEY (id)
);



CREATE TABLE Restaurant
(
    id              SERIAL UNIQUE NOT NULL,
    local_item_id   int           NOT NULL,
    category_id     bigint        NOT NULL,
    name            VARCHAR(50)   NOT NULL,
    image           VARCHAR(256),
    address         VARCHAR(70)   NOT NULL,
    capacity        int           NOT NULL,
    rating          real,
    local_id        int           NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Category
(
    id            SERIAL      NOT NULL,
    local_item_id int         NOT NULL,
    name          VARCHAR(20) NOT NULL,
    local_id      int         NOT NULL,
    PRIMARY KEY (id)
);



CREATE TABLE Restaurant_administrator
(
    user_id       bigint NOT NULL,
    restaurant_id bigint NOT null
);


CREATE TABLE Local
(
    id         SERIAL      NOT NULL,
    short_name VARCHAR(20) NOT NULL,
    name       VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE User_info
    ADD CONSTRAINT User_fk0 FOREIGN KEY (local_id) REFERENCES Local (id);

ALTER TABLE Booking
    ADD CONSTRAINT Booking_fk0 FOREIGN KEY (user_id) REFERENCES User_info (id);
ALTER TABLE Booking
    ADD CONSTRAINT Booking_fk1 FOREIGN KEY (restaurant_id) REFERENCES Restaurant (id);

ALTER TABLE Restaurant
    ADD CONSTRAINT Restaurant_fk0 FOREIGN KEY (category_id) REFERENCES Category (id);
ALTER TABLE Restaurant
    ADD CONSTRAINT Restaurant_fk1 FOREIGN KEY (local_id) REFERENCES Local (id);

ALTER TABLE Category
    ADD CONSTRAINT Category_fk0 FOREIGN KEY (local_id) REFERENCES Local (id);

ALTER TABLE Restaurant_administrator
    ADD CONSTRAINT Restaurant_administrator_fk0 FOREIGN KEY (user_id) REFERENCES User_info (id);
ALTER TABLE Restaurant_administrator
    ADD CONSTRAINT Restaurant_administrator_fk1 FOREIGN KEY (restaurant_id) REFERENCES Restaurant (id);

ALTER TABLE Booking
    ADD CONSTRAINT Date_time_fk0 FOREIGN KEY (date_id) REFERENCES Available_date_time (id);
ALTER TABLE Available_date_time
    ADD CONSTRAINT Restaurant_fk0 FOREIGN KEY (restaurant_id) REFERENCES Restaurant (id);



insert into Local (id, short_name, name)
values (1, 'RU', 'Russian');
insert into Local (id, short_name, name)
values (2, 'EN', 'English');

insert into Category (id, local_item_id, name, local_id)
values (1, 1, 'Italian', 2);
insert into Category (id, local_item_id, name, local_id)
values (2, 2, 'Japanese', 2);
insert into Category (id, local_item_id, name, local_id)
values (3, 3, 'European', 2);
insert into Category (id, local_item_id, name, local_id)
values (4, 4, 'Asian', 2);
insert into Category (id, local_item_id, name, local_id)
values (5, 5, 'Coffee', 2);


INSERT INTO restaurant(local_item_id, category_id, "name", image, address, capacity, rating, curr_free_space, local_id)
VALUES (2, 3, 'Prism restaurant cafe',
        'https://cdn.shopify.com/s/files/1/0561/9181/1654/files/PRC_copy_250x.png?v=1647316245', '25 Kensington Point',
        23, 2.8, 6, 2),
       (2, 3, 'Prism restaurant cafe',
        'https://cdn.shopify.com/s/files/1/0561/9181/1654/files/PRC_copy_250x.png?v=1647316245', '25 Kенингстоун поинт',
        23, 2.8, 6, 1),
       (4, 2, 'Uliveta', 'https://romecavalieri.com/wp-content/uploads/2016/06/Uliveto_logo_finale-01-250x250.png',
        '853 Округ Старлинг', 29, 1.2, 1, 1),
       (4, 2, 'Uliveta', 'https://romecavalieri.com/wp-content/uploads/2016/06/Uliveto_logo_finale-01-250x250.png',
        '853 Starling Circle', 29, 1.2, 1, 2),
       (5, 3, 'Bears BBQ',
        'https://www.ashevillechamber.org/wp-content/uploads/2021/01/Bears-Smokehouse-logo-250x250.jpg',
        '39 Айова Парк', 45, 2.1, 1, 1),
       (5, 3, 'Bears BBQ',
        'https://www.ashevillechamber.org/wp-content/uploads/2021/01/Bears-Smokehouse-logo-250x250.jpg',
        '39 Iowa Parkway', 45, 2.1, 1, 2),
       (6, 1, 'Пляж Коко', 'https://www.logolynx.com/images/logolynx/s_1b/1b9e5b01cf1dba7daebfea4c3b9777fc.png',
        '3394 Саннисайд Парк', 47, 1.4, 4, 1),
       (6, 1, 'Coco Beach', 'https://www.logolynx.com/images/logolynx/s_1b/1b9e5b01cf1dba7daebfea4c3b9777fc.png',
        '33994 Sunnyside Parkway', 47, 1.4, 4, 2),
       (7, 5, 'Panda Express',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqUfwK6UwgOuhPu2boqH3_UsEfffBHf-hq-g&usqp=CAU',
        '8 Армстайс Трейл', 45, 4.4, 9, 1),
       (7, 5, 'Panda Express',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqUfwK6UwgOuhPu2boqH3_UsEfffBHf-hq-g&usqp=CAU',
        '8 Armistice Trail', 45, 4.4, 9, 2);
INSERT INTO restaurant (local_item_id, category_id, "name", image, address, capacity, rating, curr_free_space,
                        local_id)
VALUES (8, 5, 'Mana', 'https://managreekfusion.com/wp-content/uploads/2021/02/Mana-Greek-Fusion-logo-Jupiter-FL.jpg',
        '0407 Грим Фанкшн', 15, 1.5, 4, 1),
       (8, 5, 'Mana', 'https://managreekfusion.com/wp-content/uploads/2021/02/Mana-Greek-Fusion-logo-Jupiter-FL.jpg',
        '0407 Grim Junction', 15, 1.5, 4, 2),
       (9, 1, 'Automata',
        'https://www.kensingtonstreet.com.au/wp-content/uploads/2017/07/VendorPage_Logo_Automata_250px.png',
        '404 Нордвей Мейпл Плаза', 34, 2.3, 7, 1),
       (9, 1, 'Automata',
        'https://www.kensingtonstreet.com.au/wp-content/uploads/2017/07/VendorPage_Logo_Automata_250px.png',
        '404 Norway Maple Plaza', 34, 2.3, 7, 2),
       (10, 3, 'The Famous Cafe',
        'https://www.gatewaycityarts.com/wp-content/uploads/2021/09/Famous-Cafe-Logo-Round-bw-e1631017629103.png',
        '663 Хоффман Поинт', 44, 4.2, 1, 1),
       (10, 3, 'The Famous Cafe',
        'https://www.gatewaycityarts.com/wp-content/uploads/2021/09/Famous-Cafe-Logo-Round-bw-e1631017629103.png',
        '663 Hoffman Point', 44, 4.2, 1, 2),
       (3, 2, 'Los Pollos Hermanos',
        'https://www.logolynx.com/images/logolynx/s_9d/9d33db5da9f33b8e152150b6325c65c6.jpeg', '53439 Miller Circle',
        45, 4.5, 5, 2),
       (3, 2, 'Братья Цыплята', 'https://www.logolynx.com/images/logolynx/s_9d/9d33db5da9f33b8e152150b6325c65c6.jpeg',
        '53439 Округ Миллер', 45, 4.5, 5, 1),
       (1, 1, 'Coffee & GO',
        'https://image.shutterstock.com/image-vector/coffee-shop-badge-logo-beans-250nw-1455694871.jpg',
        'Kasaray batyr, 155', 27, 4.7, 10, 2),
       (1, 1, 'Coffee & GO',
        'https://image.shutterstock.com/image-vector/coffee-shop-badge-logo-beans-250nw-1455694871.jpg',
        'Карасай батыра, 155', 27, 4.7, 10, 1);


INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (1, '2022-06-20 10:00:00', false),
       (1, '2022-06-20 11:00:00', false),
       (1, '2022-06-20 12:00:00', false),
       (1, '2022-06-20 13:00:00', false),
       (1, '2022-06-20 14:00:00', false),
       (1, '2022-06-20 15:00:00', false),
       (1, '2022-06-20 16:00:00', false),
       (1, '2022-06-20 17:00:00', false),
       (1, '2022-06-20 18:00:00', false),
       (1, '2022-06-20 19:00:00', false),
       (1, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (2, '2022-06-20 10:00:00', false),
       (2, '2022-06-20 11:00:00', false),
       (2, '2022-06-20 12:00:00', false),
       (2, '2022-06-20 13:00:00', false),
       (2, '2022-06-20 14:00:00', false),
       (2, '2022-06-20 15:00:00', false),
       (2, '2022-06-20 16:00:00', false),
       (2, '2022-06-20 17:00:00', false),
       (2, '2022-06-20 18:00:00', false),
       (2, '2022-06-20 19:00:00', false),
       (2, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (3, '2022-06-20 10:00:00', false),
       (3, '2022-06-20 11:00:00', false),
       (3, '2022-06-20 12:00:00', false),
       (3, '2022-06-20 13:00:00', false),
       (3, '2022-06-20 14:00:00', false),
       (3, '2022-06-20 15:00:00', false),
       (3, '2022-06-20 16:00:00', false),
       (3, '2022-06-20 17:00:00', false),
       (3, '2022-06-20 18:00:00', false),
       (3, '2022-06-20 19:00:00', false),
       (3, '2022-06-20 20:00:00', false);


INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (4, '2022-06-20 10:00:00', false),
       (4, '2022-06-20 11:00:00', false),
       (4, '2022-06-20 12:00:00', false),
       (4, '2022-06-20 13:00:00', false),
       (4, '2022-06-20 14:00:00', false),
       (4, '2022-06-20 15:00:00', false),
       (4, '2022-06-20 16:00:00', false),
       (4, '2022-06-20 17:00:00', false),
       (4, '2022-06-20 18:00:00', false),
       (4, '2022-06-20 19:00:00', false),
       (4, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (5, '2022-06-20 10:00:00', false),
       (5, '2022-06-20 11:00:00', false),
       (5, '2022-06-20 12:00:00', false),
       (5, '2022-06-20 13:00:00', false),
       (5, '2022-06-20 14:00:00', false),
       (5, '2022-06-20 15:00:00', false),
       (5, '2022-06-20 16:00:00', false),
       (5, '2022-06-20 17:00:00', false),
       (5, '2022-06-20 18:00:00', false),
       (5, '2022-06-20 19:00:00', false),
       (5, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (6, '2022-06-20 10:00:00', false),
       (6, '2022-06-20 11:00:00', false),
       (6, '2022-06-20 12:00:00', false),
       (6, '2022-06-20 13:00:00', false),
       (6, '2022-06-20 14:00:00', false),
       (6, '2022-06-20 15:00:00', false),
       (6, '2022-06-20 16:00:00', false),
       (6, '2022-06-20 17:00:00', false),
       (6, '2022-06-20 18:00:00', false),
       (6, '2022-06-20 19:00:00', false),
       (6, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (7, '2022-06-20 10:00:00', false),
       (7, '2022-06-20 11:00:00', false),
       (7, '2022-06-20 12:00:00', false),
       (7, '2022-06-20 13:00:00', false),
       (7, '2022-06-20 14:00:00', false),
       (7, '2022-06-20 15:00:00', false),
       (7, '2022-06-20 16:00:00', false),
       (7, '2022-06-20 17:00:00', false),
       (7, '2022-06-20 18:00:00', false),
       (7, '2022-06-20 19:00:00', false),
       (7, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (8, '2022-06-20 10:00:00', false),
       (8, '2022-06-20 11:00:00', false),
       (8, '2022-06-20 12:00:00', false),
       (8, '2022-06-20 13:00:00', false),
       (8, '2022-06-20 14:00:00', false),
       (8, '2022-06-20 15:00:00', false),
       (8, '2022-06-20 16:00:00', false),
       (8, '2022-06-20 17:00:00', false),
       (8, '2022-06-20 18:00:00', false),
       (8, '2022-06-20 19:00:00', false),
       (8, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (9, '2022-06-20 10:00:00', false),
       (9, '2022-06-20 11:00:00', false),
       (9, '2022-06-20 12:00:00', false),
       (9, '2022-06-20 13:00:00', false),
       (9, '2022-06-20 14:00:00', false),
       (9, '2022-06-20 15:00:00', false),
       (9, '2022-06-20 16:00:00', false),
       (9, '2022-06-20 17:00:00', false),
       (9, '2022-06-20 18:00:00', false),
       (9, '2022-06-20 19:00:00', false),
       (9, '2022-06-20 20:00:00', false);

INSERT INTO available_date_time (restaurant_id, date_time, booked)
VALUES (10, '2022-06-20 10:00:00', false),
       (10, '2022-06-20 11:00:00', false),
       (10, '2022-06-20 12:00:00', false),
       (10, '2022-06-20 13:00:00', false),
       (10, '2022-06-20 14:00:00', false),
       (10, '2022-06-20 15:00:00', false),
       (10, '2022-06-20 16:00:00', false),
       (10, '2022-06-20 17:00:00', false),
       (10, '2022-06-20 18:00:00', false),
       (10, '2022-06-20 19:00:00', false),
       (10, '2022-06-20 20:00:00', false);
