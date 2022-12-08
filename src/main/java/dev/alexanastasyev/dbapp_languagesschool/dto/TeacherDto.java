package dev.alexanastasyev.dbapp_languagesschool.dto;

public class TeacherDto {
    public final String firstname;
    public final String lastname;
    public final String patronymic;

    public TeacherDto(String firstname, String lastname, String patronymic) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
