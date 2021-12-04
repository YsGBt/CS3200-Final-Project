package ebooks.database.ebook;

import ebooks.database.author.Author;
import ebooks.database.author.AuthorRepository;
import ebooks.database.genre.Genre;
import ebooks.database.genre.GenreRepository;
import ebooks.database.purchase.Purchase;
import ebooks.database.purchase.PurchaseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EbookDao {
    @Autowired
    EbookRepository ebookRepository;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/api/ebooks")
    public List<Ebook> findAllRecords() {
        return (List<Ebook>) ebookRepository.findAll();
    }

    @GetMapping("/api/ebooks/{id}")
    public Ebook findRecordById(
            @PathVariable("id") Integer id) {
        return ebookRepository.findById(id).get();
    }

    @GetMapping("/api/ebooks/{id}/remove")
    public void removeRecord(
            @PathVariable("id") Integer id) {
        ebookRepository.deleteById(id);
    }

    @GetMapping("/api/ebooks/create")
    public void createRecord() {
        Ebook newRecord = new Ebook();

        newRecord.setTitle("New Title");

        ebookRepository.save(newRecord);
    }

    @GetMapping("/api/ebooks/{id}/purchases/create")
    public void createOneToMany(
            @PathVariable("id") Integer id
    ) {
        Ebook oneRecord = findRecordById(id);

        Purchase newManyRecord = new Purchase();
        newManyRecord.setEbook(oneRecord);

        oneRecord.getPurchases().add(newManyRecord);

        ebookRepository.save(oneRecord);
        purchaseRepository.save(newManyRecord);
    }

    @GetMapping("/api/ebooks/{id}/purchases")
    public List<Purchase> findOneToManyRecords(
            @PathVariable("id") Integer id) {
        return ebookRepository.findById(id).get().getPurchases();
    }

    @GetMapping("/api/ebooks/{id}/authors/manytoone")
    public Author findEbookAuthor(
        @PathVariable("id") Integer id) {
        return ebookRepository.findById(id).get().getAuthor();
    }

    @GetMapping("/api/ebooks/{id}/genres/manytoone")
    public Genre findEbookGenre(
        @PathVariable("id") Integer id) {
        return ebookRepository.findById(id).get().getGenre();
    }

    @PutMapping("/api/ebooks")
    public void updateRecord(
            @RequestBody Ebook newRecord
    ) {
        Ebook oldRecord = ebookRepository.findById(newRecord.getId()).get();

        oldRecord.setTitle(newRecord.getTitle());
        oldRecord.setPublishedYear(newRecord.getPublishedYear());
        if (newRecord.getGenreType() != null) {
            oldRecord.setGenre(genreRepository.findById(newRecord.getGenreType()).get());
        }
        if (newRecord.getAuthorId() != null) {
            oldRecord.setAuthor(authorRepository.findById(newRecord.getAuthorId()).get());
        }
        oldRecord.setPurchases(newRecord.getPurchases());

        ebookRepository.save(oldRecord);
    }

}
