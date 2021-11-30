package ebooks.database.ebook;

import org.springframework.data.repository.CrudRepository;

public interface EbookRepository
        extends CrudRepository<Ebook, Integer> {
}
