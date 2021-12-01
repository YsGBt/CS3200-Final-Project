package ebooks.database.genre;

import ebooks.database.ebook.Ebook;
import ebooks.database.ebook.EbookRepository;
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
public class GenreDao {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    EbookRepository ebookRepository;
    
    @GetMapping("/api/genres")
    public List<Genre> findAllRecords() {
        return (List<Genre>) genreRepository.findAll();
    }

    @GetMapping("/api/genres/{genre}")
    public Genre findRecordById(
            @PathVariable("genre") String genre) {
        return genreRepository.findById(genre).get();
    }

    @GetMapping("/api/genres/{genre}/remove")
    public void removeRecord(
            @PathVariable("genre") String genre) {
        genreRepository.deleteById(genre);
    }

    @GetMapping("/api/genres/create")
    public void createRecord() {
//        Genre newRecord = new Genre();
//
//        newRecord.setId("New Name");
//
//        genreRepository.save(newRecord);
    }

    @GetMapping("/api/genres/{genre}/ebooks/create")
    public void addEbookForGenre(
            @PathVariable("genre") String genre
    ) {
        Genre oneRecord = findRecordById(genre);

        Ebook newManyRecord = new Ebook();
        newManyRecord.setTitle("New Ebook");
        newManyRecord.setGenre(oneRecord);

        oneRecord.getEbooks().add(newManyRecord);

        genreRepository.save(oneRecord);
        ebookRepository.save(newManyRecord);
    }

    @GetMapping("/api/genres/{genre}/ebooks")
    public List<Ebook> findEbooksForGenre(
            @PathVariable("genre") String genre) {
        return genreRepository.findById(genre).get().getEbooks();
    }

    @PutMapping("/api/genres")
    public void updateRecord(
            @RequestBody Genre newRecord
    ) {
        Genre oldRecord = genreRepository.findById(newRecord.getId()).get();

        oldRecord.setId(newRecord.getId());
        oldRecord.setEbooks(newRecord.getEbooks());

        genreRepository.save(oldRecord);
    }

}
