package dev.alexanastasyev.dbapp_languagesschool.repository.teacher;

import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;

import java.util.Optional;

public interface TeacherRepository {
    Optional<Teacher> findById(int id);
}
