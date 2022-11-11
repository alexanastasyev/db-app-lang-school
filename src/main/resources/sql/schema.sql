CREATE TABLE languages
(
    id   serial primary key,
    name varchar(50) not null
);

CREATE TABLE teachers
(
    id         serial primary key,
    firstname  varchar(50) not null,
    lastname   varchar(50) not null,
    patronymic varchar(50)
);

CREATE TABLE courses
(
    id          serial primary key,
    name        varchar(50)                       not null,
    description varchar(1000)                     not null,
    language_id integer references languages (id) not null,
    teacher_id  integer references teachers (id)  not null
);

CREATE TABLE lessons
(
    id        serial primary key,
    course_id integer references courses (id) not null,
    datetime  timestamp                       not null
);

CREATE TABLE students
(
    id         serial primary key,
    firstname  varchar(50) not null,
    lastname   varchar(50) not null,
    patronymic varchar(50)
);

CREATE TABLE students_courses
(
    id         serial primary key,
    student_id integer references students (id) not null,
    course_id  integer references courses (id)  not null
);

CREATE TABLE presences
(
    id         serial primary key,
    student_id integer references students (id) not null,
    lesson_id  integer references lessons (id)  not null,
    presence   boolean                          not null
);

CREATE TABLE tests
(
    id         serial primary key,
    student_id integer references students (id) not null,
    course_id  integer references courses (id)  not null,
    topic      varchar(50)                      not null,
    score      integer                          not null
);

CREATE TABLE feedbacks
(
    id         serial primary key,
    student_id integer references students (id) not null,
    course_id  integer references courses (id)  not null,
    score      integer                          not null,
    text       varchar(500)
);
