package dev.alexanastasyev.dbapp_languagesschool.service.teacher;

import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;

import java.util.List;

public interface TeachersService {
    List<Teacher> getAllTeachers();
    void addTeacher(Teacher teacher);
}
