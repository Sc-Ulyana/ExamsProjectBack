CREATE DATABASE exams;

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    login      varchar(20) UNIQUE                                                NOT NULL,
    password   varchar(150)                                                      NOT NULL,
    faculty_id int REFERENCES faculties (id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL,
    role_id    int REFERENCES roles (id) ON UPDATE CASCADE ON DELETE CASCADE     NOT NULL
);

CREATE TABLE roles
(
    id   SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE faculties
(
    id          SERIAL PRIMARY KEY,
    name        varchar(20) NOT NULL,
    description varchar(50) NOT NULL
);

CREATE TABLE exams
(
    id   SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE teachers
(
    id      SERIAL PRIMARY KEY,
    name    varchar(20)                                                          NOT NULL,
    fname   varchar(20)                                                          NOT NULL,
    surname varchar(20)                                                          NOT NULL,
    user_id int UNIQUE REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL
);

CREATE TABLE applicants
(
    id       SERIAL PRIMARY KEY,
    name     varchar(20)                                                          NOT NULL,
    surname  varchar(20)                                                          NOT NULL,
    avg_mark double precision,
    user_id  int UNIQUE REFERENCES users (id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL
);

CREATE TABLE exams_faculties
(
    id         SERIAL PRIMARY KEY,
    exam_id    int REFERENCES exams (id) ON UPDATE CASCADE ON DELETE CASCADE     NOT NULL,
    faculty_id int REFERENCES faculties (id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL,
    UNIQUE (faculty_id, exam_id)
);

CREATE TABLE exams_results
(
    id                 SERIAL PRIMARY KEY,
    applicant_id       int REFERENCES applicants (id) ON UPDATE CASCADE ON DELETE CASCADE      NOT NULL,
    exams_faculties_id int REFERENCES exams_faculties (id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL,
    teacher_id         int REFERENCES teachers (id) ON UPDATE CASCADE ON DELETE CASCADE        NOT NULL,
    mark               int                                                                     NOT NULL,
    CHECK ( mark > 0),
    CHECK ( mark < 11),
    UNIQUE (applicant_id, exams_faculties_id)
);

INSERT INTO roles(name)
VALUES ('ROLE_APPLICANT'),
       ('ROLE_TEACHER');

INSERT INTO faculties(name, description)
VALUES ('ФМиИТ', 'Факультет математики и информационных технологий'),
       ('ФФ', 'Филологический факультет'),
       ('ИФ', 'Исторический факультет'),
       ('БХФ', 'Биолого-химический факультет');

INSERT INTO exams(name)
VALUES ('Русский язык'),
       ('Английский язык'),
       ('Химия'),
       ('Биология'),
       ('Математика'),
       ('Физика'),
       ('История'),
       ('Обществознание');

INSERT INTO users(login, password, faculty_id, role_id)
VALUES ('anatoliy2000', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 1, 1),
       ('tanya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 2, 1),
       ('katya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 3, 1),
       ('aleksey', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 4, 1),
       ('anya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 3, 1),
       ('lesha', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 4, 1),
       ('petya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 1, 1),
       ('konstantin', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 1, 1),
       ('Frosya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 1, 1),
       ('anastasiya', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 1, 2),
       ('kostYa', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 2, 2),
       ('Vasily', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 3, 2),
       ('evgen', '$2a$04$u9iiEXvHpNPoMtWXgUaoaeXnufVMCZEMh9p6/kkjqqjLgmMh/RPhe', 4, 2);

INSERT INTO teachers(name, fname, surname, user_id)
VALUES ('Анастасия', 'Ивановна', 'Петрова', 10),
       ('Константин', 'Степанович', 'Иванов', 11),
       ('Василий', 'Антонович', 'Чехов', 12),
       ('Евгений', 'Петрович', 'Старовойтов', 13);

INSERT INTO applicants(name, surname, avg_mark, user_id)
VALUES ('Анатолий', 'Абрамов', null, 1),
       ('Татьяна', 'Кулакова', null, 2),
       ('Екатерина', 'Зиновьева', null, 3),
       ('Алексей', 'Захаров', null, 4),
       ('Анна', 'Матвеева', null, 5),
       ('Алексей', 'Трошин', null, 6),
       ('Петр', 'Рудаков', null, 7),
       ('Константин', 'Соколов', null, 8),
       ('Ефросинья', 'Афанасьева', null, 9);

INSERT INTO exams_faculties(exam_id, faculty_id)
VALUES (1, 1),
       (5, 1),
       (6, 1),
       (1, 2),
       (2, 2),
       (7, 2),
       (1, 3),
       (7, 3),
       (8, 3),
       (1, 4),
       (3, 4),
       (4, 4);

INSERT INTO exams_results(applicant_id, exams_faculties_id, teacher_id, mark)
VALUES (1, 1, 4, 8),
       (1, 2, 4, 7),
       (1, 3, 4, 9),
       (2, 4, 1, 6);

UPDATE applicants
SET avg_mark = (SELECT avg(mark)
                FROM exams_results
                         join applicants a on a.id = exams_results.applicant_id
                WHERE user_id = 1)
WHERE user_id = 1;

SELECT avg(mark)
FROM exams_results
         join applicants a on a.id = exams_results.applicant_id
WHERE user_id = 1;

SELECT *
from applicants
where user_id = 1;

SELECT description
from faculties;

