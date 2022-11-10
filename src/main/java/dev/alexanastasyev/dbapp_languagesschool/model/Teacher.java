package dev.alexanastasyev.dbapp_languagesschool.model;

import java.util.Optional;

public class Teacher {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final Optional<String> patronymic;

    public Teacher(int id, String firstname, String lastname, String patronymic) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = Optional.of(patronymic);
    }

    public Teacher(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = Optional.empty();
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
