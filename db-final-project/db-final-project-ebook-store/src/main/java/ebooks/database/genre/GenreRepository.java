package ebooks.database.genre;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository
        extends CrudRepository<Genre, String> {
}
