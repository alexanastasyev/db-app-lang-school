package dev.alexanastasyev.dbapp_languagesschool.repository.language;

import dev.alexanastasyev.dbapp_languagesschool.model.Language;

import java.util.Optional;

public interface LanguagesRepository {
    Optional<Language> findById(int id);
}
