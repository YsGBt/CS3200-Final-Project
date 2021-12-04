package ebooks.database.author;

import ebooks.database.ebook.Ebook;
import ebooks.database.ebook.EbookRepository;
import java.time.Year;
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
public class AuthorDao {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    EbookRepository ebookRepository;
    
    @GetMapping("/api/authors")
    public List<Author> findAllRecords() {
        return (List<Author>) authorRepository.findAll();
    }

    @GetMapping("/api/authors/{id}")
    public Author findRecordById(
            @PathVariable("id") Integer id) {
        return authorRepository.findById(id).get();
    }

    @GetMapping("/api/authors/{id}/remove")
    public void removeRecord(
            @PathVariable("id") Integer id) {
        authorRepository.deleteById(id);
    }

    @GetMapping("/api/authors/create")
    public void createRecord() {
        Author newRecord = new Author();

        newRecord.setFirstName("New Name");

        authorRepository.save(newRecord);
    }

    @GetMapping("/api/authors/{id}/ebooks/create")
    public void addEbookForAuthor(
            @PathVariable("id") Integer id
    ) {
        Author oneRecord = findRecordById(id);

        Ebook newManyRecord = new Ebook();
        newManyRecord.setTitle("New Ebook");
        newManyRecord.setAuthor(oneRecord);
        newManyRecord.setPublishedYear(Year.now().getValue());
        oneRecord.getEbooks().add(newManyRecord);

        authorRepository.save(oneRecord);
        ebookRepository.save(newManyRecord);
    }

    @GetMapping("/api/authors/{id}/ebooks")
    public List<Ebook> findEbooksForAuthor(
            @PathVariable("id") Integer id) {
        return authorRepository.findById(id).get().getEbooks();
    }

    @PutMapping("/api/authors")
    public void updateRecord(
            @RequestBody Author newRecord
    ) {
        Author oldRecord = authorRepository.findById(newRecord.getId()).get();

        oldRecord.setLastName(newRecord.getLastName());
        oldRecord.setFirstName(newRecord.getFirstName());
        oldRecord.setEbooks(newRecord.getEbooks());
        oldRecord.setDateOfBirth(newRecord.getDateOfBirth());

        authorRepository.save(oldRecord);
    }

}
