package dev.alexanastasyev.dbapp_languagesschool.repository.course;

import dev.alexanastasyev.dbapp_languagesschool.model.Course;

import java.util.List;

public interface CoursesRepository {
    List<Course> findAll();
}
