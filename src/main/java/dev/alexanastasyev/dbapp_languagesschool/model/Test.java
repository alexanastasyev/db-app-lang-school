package dev.alexanastasyev.dbapp_languagesschool.model;

public class Test {
    private final int id;
    private final Student student;
    private final Course course;
    private final String topic;
    private final int score;

    public Test(int id, Student student, Course course, String topic, int score) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.topic = topic;
        this.score = score;
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

    public String getTopic() {
        return topic;
    }

    public int getScore() {
        return score;
    }
}
