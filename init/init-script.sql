CREATE DATABASE IF NOT EXISTS db_socialmedia;

USE db_socialmedia;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    profil_image VARCHAR(255)
);

CREATE TABLE posts (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    created_date DATETIME(6),
    image VARCHAR(255),
    text VARCHAR(255),
    user_id BIGINT REFERENCES users(id)
);

CREATE TABLE user_post (
    post_id BIGINT NOT NULL REFERENCES posts(id),
    user_id BIGINT NOT NULL REFERENCES users(id),
    is_liked BIT,
    PRIMARY KEY (post_id, user_id)
);

INSERT INTO users (email, first_name, last_name, password, profil_image) VALUES
    ('wmoinet@test.fr', 'william', 'moinet', '123', NULL),
    ('user2@gmail.com', 'user', 'two', '456', NULL),
    ('john.doe@domain.com', 'john', 'doe', '789', NULL);

INSERT INTO posts (created_date, image, text, user_id) VALUES 
    ('2024-04-20T09:50:27.4822496', NULL, 'Ceci est une photo de mon voyage', 1),
    ('2023-08-11T18:50:12.4822438', NULL, 'Etre en été ça fait du bien', 3),
    ('2024-04-21T12:50:27.4845496', NULL, 'Quelqu un cherche des amis ici ?', 1),
    ('2023-12-25T12:50:27.4845496', NULL, 'Joyeux Noël à tous', 2);

INSERT INTO user_post (post_id, user_id, is_liked) VALUES 
    (2, 1, 1),
    (1, 3, 0),
    (4, 1, 1);
