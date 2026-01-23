create table users
(
    id          serial primary key,
    first_name  VARCHAR(100) NOT NULL,
    second_name VARCHAR(100) NOT NULL
);