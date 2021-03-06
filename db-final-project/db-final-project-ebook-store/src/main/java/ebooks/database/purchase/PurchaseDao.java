package ebooks.database.purchase;

import ebooks.database.ebook.Ebook;
import ebooks.database.ebook.EbookRepository;
import ebooks.database.user.User;
import ebooks.database.user.UserRepository;
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
public class PurchaseDao {

  @Autowired
  PurchaseRepository repository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  EbookRepository ebookRepository;

  @GetMapping("/api/purchases")
  public List<Purchase> findAllRecords() {
    return (List<Purchase>) repository.findAll();
  }

  @GetMapping("/api/purchases/{id}")
  public Purchase findRecordById(
      @PathVariable("id") Integer id) {
    return repository.findById(id).get();
  }

  @GetMapping("/api/purchases/{id}/remove")
  public void removeRecord(
      @PathVariable("id") Integer id) {
    repository.deleteById(id);
  }

  @GetMapping("/api/purchases/create")
  public void createRecord() {
    Purchase newRecord = new Purchase();

    repository.save(newRecord);
  }

  @GetMapping("/api/purchases/{id}/users/manytoone")
  public User findPurchaseUser(
      @PathVariable("id") Integer id) {
    return repository.findById(id).get().getUser();
  }

  @GetMapping("/api/purchases/{id}/ebooks/manytoone")
  public Ebook findEbookGenre(
      @PathVariable("id") Integer id) {
    return repository.findById(id).get().getEbook();
  }

  @PutMapping("/api/purchases")
  public void updateRecord(
      @RequestBody Purchase newRecord
  ) {
    Purchase oldRecord = repository.findById(newRecord.getId()).get();
    System.out.println(newRecord.getPurchaseDate());

    oldRecord.setPurchaseDate(newRecord.getPurchaseDate());
    if (newRecord.getEbookId() != null) {
      oldRecord.setEbook(ebookRepository.findById(newRecord.getEbookId()).get());
    }
    if (newRecord.getUserId() != null) {
      oldRecord.setUser(userRepository.findById(newRecord.getUserId()).get());
    }

    repository.save(oldRecord);
  }

}
