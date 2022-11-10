package dev.alexanastasyev.dbapp_languagesschool.model;

import java.util.Optional;

public class Feedback {
    private final int id;
    private final Student student;
    private final Course course;
    private final int score;
    private final Optional<String> text;

    public Feedback(int id, Student student, Course course, int score, String text) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
        this.text = Optional.of(text);
    }

    public Feedback(int id, Student student, Course course, int score) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
        this.text = Optional.empty();
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getScore() {
        return score;
    }

    public Optional<String> getText() {
        return text;
    }
}
