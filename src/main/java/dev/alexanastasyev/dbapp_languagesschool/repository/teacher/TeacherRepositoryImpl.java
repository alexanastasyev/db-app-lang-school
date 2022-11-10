package dev.alexanastasyev.dbapp_languagesschool.repository.teacher;

import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public TeacherRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Optional<Teacher> findById(int id) {
        Teacher teacher = jdbc.queryForObject("SELECT id, firstname, lastname, patronymic FROM teachers WHERE id = ?", this::mapRowToTeacher, id);
        return Optional.ofNullable(teacher);
    }

    private Teacher mapRowToTeacher(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Teacher(
                resultSet.getInt("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                Optional.ofNullable(resultSet.getString("patronymic"))
        );
    }

}
