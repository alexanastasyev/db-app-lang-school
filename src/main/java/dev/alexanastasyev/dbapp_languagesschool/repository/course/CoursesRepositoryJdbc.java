package dev.alexanastasyev.dbapp_languagesschool.repository.course;

import dev.alexanastasyev.dbapp_languagesschool.model.Course;
import dev.alexanastasyev.dbapp_languagesschool.model.Language;
import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import dev.alexanastasyev.dbapp_languagesschool.repository.language.LanguagesRepository;
import dev.alexanastasyev.dbapp_languagesschool.repository.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class CoursesRepositoryJdbc implements CoursesRepository {

    private final LanguagesRepository languagesRepository;
    private final TeacherRepository teacherRepository;
    private final DataSource dataSource;

    @Autowired
    public CoursesRepositoryJdbc(LanguagesRepository languagesRepository, TeacherRepository teacherRepository, DataSource dataSource) {
        this.languagesRepository = languagesRepository;
        this.teacherRepository = teacherRepository;
        this.dataSource = dataSource;
    }

    @Override
    public List<Course> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, description, language_id, teacher_id FROM courses")) {

            List<Course> courses = new ArrayList<>();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Language language = languagesRepository.findById(resultSet.getInt("language_id"))
                        .orElseThrow(() -> new SQLException("Language not found"));

                Teacher teacher = teacherRepository.findById(resultSet.getInt("teacher_id"))
                        .orElseThrow(() -> new SQLException("Teacher not found"));

                courses.add(new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        language,
                        teacher
                ));
            }

            return courses;

        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
