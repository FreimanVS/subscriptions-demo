--liquibase formatted sql
--changeset freimanvs:task1

DROP TABLE IF EXISTS users_subscriptions;
DROP TABLE IF EXISTS subscriptions_users;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS subscriptions;
DROP SEQUENCE IF EXISTS users_seq;
DROP SEQUENCE IF EXISTS subscriptions_seq;

--CREATE TABLE IF NOT EXISTS users(
--    id serial PRIMARY KEY,
--    name VARCHAR(255),
--    surname VARCHAR(255),
--    email VARCHAR(255),
--    username VARCHAR(255) UNIQUE,
--    password VARCHAR(255)
--);
--
--CREATE TABLE IF NOT EXISTS subscriptions(
--    id INT PRIMARY KEY,
--    name VARCHAR(255),
--    activation_date DATE NOT NULL DEFAULT CURRENT_DATE,
--    expire_date DATE NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS users_subscriptions(
--    user_id INT REFERENCES users(id) ON UPDATE NO ACTION,
--    subscription_id INT REFERENCES subscriptions(id) ON UPDATE NO ACTION,
--    PRIMARY KEY(user_id, subscription_id)
--);

CREATE SEQUENCE IF NOT EXISTS users_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS subscriptions_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;


CREATE TABLE IF NOT EXISTS users(
    id bigint NOT NULL,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_username_unique UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS subscriptions(
    id bigint NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT subscriptions_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users_subscriptions(
    user_id bigint NOT NULL,
    subscription_id bigint NOT NULL,
    CONSTRAINT fkgtv5xnn8qj2t23ut07tu8m0l7 FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhf8975hn03p7keqy3d8w1q8ps FOREIGN KEY (subscription_id)
        REFERENCES public.subscriptions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT users_subscriptions_pkey PRIMARY KEY (user_id, subscription_id)
);