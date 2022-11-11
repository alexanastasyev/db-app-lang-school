package dev.alexanastasyev.dbapp_languagesschool.repository.teacher;

import dev.alexanastasyev.dbapp_languagesschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
@Primary
public class TeacherRepositoryJdbc implements TeacherRepository {

    private final DataSource dataSource;

    @Autowired
    public TeacherRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Teacher> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, firstname, lastname, patronymic FROM teachers WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Teacher(
                        resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        Optional.ofNullable(resultSet.getString("patronymic"))
                ));
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
