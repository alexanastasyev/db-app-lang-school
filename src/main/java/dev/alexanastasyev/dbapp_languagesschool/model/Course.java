package dev.alexanastasyev.dbapp_languagesschool.model;

public class Course {
    private final int id;
    private final String name;
    private final String description;
    private final Language language;
    private final Teacher teacher;

    public Course(int id, String name, String description, Language language, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.language = language;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Language getLanguage() {
        return language;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
