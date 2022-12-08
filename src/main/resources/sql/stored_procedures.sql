CREATE PROCEDURE insert_teacher(firstname varchar, lastname varchar, patronymic varchar)
LANGUAGE SQL
AS $$
INSERT INTO teachers(firstname, lastname, patronymic) VALUES (firstname, lastname, patronymic);
$$;