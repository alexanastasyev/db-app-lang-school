CREATE TABLE languages
(
    id   serial primary key,
    name varchar(50) not null
);

CREATE TABLE teachers
(
    id serial primary key,
    firstname varchar(50) not null ,
    lastname varchar(50) not null ,
    patronymic varchar(50)
);

CREATE TABLE courses
(
    id serial primary key,
    name varchar(50) not null ,
    description varchar(1000) not null,
    language_id integer references languages(id),
    teacher_id integer references teachers(id)
);

CREATE TABLE lessons
(
    id serial primary key,
    course_id integer references courses(id),
    datetime timestamp not null
);

CREATE TABLE students
(
    id serial primary key,
    firstname varchar(50) not null ,
    lastname varchar(50) not null ,
    patronymic varchar(50)
);

CREATE TABLE students_courses
(
    id serial primary key,
    student_id integer references students(id),
    course_id integer references courses(id)
);

CREATE TABLE presences
(
    id serial primary key,
    student_id integer references students(id),
    lesson_id integer references lessons(id),
    presence boolean not null
);

CREATE TABLE tests
(
    id serial primary key,
    student_id integer references students(id),
    course_id integer references courses(id),
    topic varchar(50) not null,
    score integer not null
);

CREATE TABLE feedbacks
(
    id serial primary key,
    student_id integer references students(id),
    course_id integer references courses(id),
    score integer not null,
    text varchar(500)
);
