package dev.alexanastasyev.dbapp_languagesschool.model;

import java.time.LocalDateTime;

public class Lesson {
    private final int id;
    private final Course course;
    private final LocalDateTime dateTime;

    public Lesson(int id, Course course, LocalDateTime dateTime) {
        this.id = id;
        this.course = course;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
