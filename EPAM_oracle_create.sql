CREATE TABLE User_info
(
    id            SERIAL             NOT NULL,
    first_name    VARCHAR(50)        NOT NULL,
    mobile        VARCHAR(15) UNIQUE NOT NULL,
    email         VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(32)        NOT NULL,
    local_id      INT                NOT NULL,
    isAdmin       BOOLEAN            NOT NULL,
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
    id            SERIAL      NOT NULL,
    restaurant_id bigint      NOT NULL,
    date_time     timestamp NOT NULL,
    booked        bool        NOT NULL default false,
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
    curr_free_space int           NOT NULL,
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
insert into Category (id, local_item_id, name, local_id)
values (6, 1, 'Итальянская кухня', 1);
insert into Category (id, local_item_id, name, local_id)
values (7, 2, 'Японская кухня', 1);
insert into Category (id, local_item_id, name, local_id)
values (8, 3, 'Европейская кухня', 1);
insert into Category (id, local_item_id, name, local_id)
values (9, 4, 'Азиатская кухня', 1);
insert into Category (id, local_item_id, name, local_id)
values (10, 5, 'Кофейни', 1);


insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (1, 1, 1, 'Coffee & GO', 'http://dummyimage.com/250x250.png/cc0000/ffffff', 'Kasaray batyr, 155', 27, 4.7, 10,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (11, 1, 1, 'Coffee & GO', 'http://dummyimage.com/250x250.png/cc0000/ffffff', 'Карасай батыра, 155', 27, 4.7, 10,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (2, 2, 3, 'Keebler LLC', 'http://dummyimage.com/250x250.png/ff4444/ffffff', '25 Kensington Point', 23, 2.8, 6,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (3, 3, 2, 'Wuckert and Sons', 'http://dummyimage.com/250x250.png/dddddd/000000', '53439 Miller Circle', 45, 4.5,
        5,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (4, 4, 2, 'Kreiger-Corwin', 'http://dummyimage.com/250x250.png/dddddd/000000', '853 Starling Circle', 29, 1.2, 1,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (5, 5, 3, 'Conn, Kuvalis and Robel', 'http://dummyimage.com/250x250.png/dddddd/000000', '39 Iowa Parkway', 45,
        2.1,
        1, 2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (6, 6, 1, 'Pfeffer-Strosin', 'http://dummyimage.com/250x250.png/dddddd/000000', '33994 Sunnyside Parkway', 47,
        1.4,
        4, 2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (7, 7, 5, 'Carroll and Sons', 'http://dummyimage.com/250x250.png/dddddd/000000', '8 Armistice Trail', 45, 4.4, 9,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (8, 8, 5, 'Stiedemann, Reichert and Oberbrunner', 'http://dummyimage.com/250x250.png/dddddd/000000',
        '0407 Grim Junction', 15, 1.5, 4, 2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (9, 9, 1, 'Beier-Hahn', 'http://dummyimage.com/250x250.png/dddddd/000000', '404 Norway Maple Plaza', 34, 2.3, 7,
        2);
insert into Restaurant (id, local_item_id, category_id, name, image, address, capacity, rating, curr_free_space,
                        local_id)
values (10, 10, 3, 'Jakubowski LLC', 'http://dummyimage.com/250x250.png/dddddd/000000', '663 Hoffman Point', 44, 4.2, 1,
        2);