package dev.alexanastasyev.dbapp_languagesschool.repository.language;

import dev.alexanastasyev.dbapp_languagesschool.model.Language;
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
public class LanguagesRepositoryJdbc implements LanguagesRepository {

    private final DataSource dataSource;

    @Autowired
    public LanguagesRepositoryJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Language> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name FROM languages WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Language(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                ));
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            return Optional.empty();
        }
    }

}
