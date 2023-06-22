-- Создание таблицы "media"
CREATE TABLE media
(
    id           SERIAL PRIMARY KEY,
    rating       FLOAT,
    movie_length INT,
    type         VARCHAR(255),
    name         VARCHAR(255),
    description  TEXT,
    year         INT,
    poster_id    INT,
    age_rating   INT
);

-- Создание таблицы "poster"
CREATE TABLE poster
(
    id  SERIAL PRIMARY KEY,
    url VARCHAR(255)
);

-- Создание таблицы "genre"
CREATE TABLE genre
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

-- Создание таблицы "trailer"
CREATE TABLE trailer
(
    id  SERIAL PRIMARY KEY,
    url VARCHAR(255)
);

-- Создание таблицы "person"
CREATE TABLE person
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255),
    role VARCHAR(255)
);

-- Создание связующей таблицы "media_genre"
CREATE TABLE media_genre
(
    media_id INT REFERENCES media (id),
    genre_id INT REFERENCES genre (id),
    PRIMARY KEY (media_id, genre_id)
);

-- Создание связующей таблицы "media_trailer"
CREATE TABLE media_trailer
(
    media_id   INT REFERENCES media (id),
    trailer_id INT REFERENCES trailer (id),
    PRIMARY KEY (media_id, trailer_id)
);

-- Создание связующей таблицы "media_person"
CREATE TABLE media_person
(
    media_id  INT REFERENCES media (id),
    person_id INT REFERENCES person (id),
    PRIMARY KEY (media_id, person_id)
);
