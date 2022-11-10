package dev.alexanastasyev.dbapp_languagesschool.model;

public class Presence {
    private final int id;
    private final Student student;
    private final Lesson lesson;
    private final boolean presence;

    public Presence(int id, Student student, Lesson lesson, boolean presence) {
        this.id = id;
        this.student = student;
        this.lesson = lesson;
        this.presence = presence;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public boolean isPresence() {
        return presence;
    }
}
