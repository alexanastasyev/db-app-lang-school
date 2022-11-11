package dev.alexanastasyev.dbapp_languagesschool.repository.language;

import dev.alexanastasyev.dbapp_languagesschool.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class LanguagesRepositoryJdbcTemplate implements LanguagesRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public LanguagesRepositoryJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Optional<Language> findById(int id) {
        Language language = jdbc.queryForObject("SELECT id, name FROM languages WHERE id = ?", this::mapRowToLanguage, id);
        return Optional.ofNullable(language);
    }

    private Language mapRowToLanguage(ResultSet resultSet, int rowNumber) throws SQLException {
        return new Language(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }

}
