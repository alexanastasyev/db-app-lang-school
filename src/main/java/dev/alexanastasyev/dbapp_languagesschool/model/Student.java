package dev.alexanastasyev.dbapp_languagesschool.model;

import java.util.Optional;

public class Student {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final Optional<String> patronymic;

    public Student(int id, String firstname, String lastname, Optional<String> patronymic) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Optional<String> getPatronymic() {
        return patronymic;
    }
}
