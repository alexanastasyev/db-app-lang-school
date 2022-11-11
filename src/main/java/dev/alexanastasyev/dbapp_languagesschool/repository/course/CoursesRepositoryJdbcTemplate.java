package dev.alexanastasyev.dbapp_languagesschool.repository.course;

import dev.alexanastasyev.dbapp_languagesschool.model.Course;
import dev.alexanastasyev.dbapp_languagesschool.model.Language;
import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import dev.alexanastasyev.dbapp_languagesschool.repository.language.LanguagesRepository;
import dev.alexanastasyev.dbapp_languagesschool.repository.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CoursesRepositoryJdbcTemplate implements CoursesRepository {

    private final LanguagesRepository languagesRepository;
    private final TeacherRepository teacherRepository;
    private final JdbcTemplate jdbc;

    @Autowired
    public CoursesRepositoryJdbcTemplate(LanguagesRepository languagesRepository, TeacherRepository teacherRepository, JdbcTemplate jdbc) {
        this.languagesRepository = languagesRepository;
        this.teacherRepository = teacherRepository;
        this.jdbc = jdbc;
    }

    @Override
    public List<Course> findAll() {
        return jdbc.query("SELECT id, name, description, language_id, teacher_id FROM courses", this::mapRowToCourse);
    }

    private Course mapRowToCourse(ResultSet resultSet, int rowNumber) throws SQLException {
        Language language = languagesRepository.findById(resultSet.getInt("language_id"))
                .orElseThrow(() -> new SQLException("Language not found"));

        Teacher teacher = teacherRepository.findById(resultSet.getInt("teacher_id"))
                .orElseThrow(() -> new SQLException("Teacher not found"));

        return new Course(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                language,
                teacher
        );
    }

}
