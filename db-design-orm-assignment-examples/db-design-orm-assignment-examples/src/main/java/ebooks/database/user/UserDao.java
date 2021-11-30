package ebooks.database.user;

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
public class UserDao {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PurchaseRepository purchaseRepository;
    
    @GetMapping("/api/users")
    public List<User> findAllRecords() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public User findRecordById(
            @PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/api/users/{id}/remove")
    public void removeRecord(
            @PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/api/users/create")
    public void createRecord() {
        User newRecord = new User();

        newRecord.setFirstName("New Name");

        userRepository.save(newRecord);
    }

    @GetMapping("/api/users/{id}/purchases/create")
    public void addEbookForUser(
            @PathVariable("id") Integer id
    ) {
        User oneRecord = findRecordById(id);

        Purchase newManyRecord = new Purchase();
        newManyRecord.setUser(oneRecord);

        oneRecord.getPurchases().add(newManyRecord);

        userRepository.save(oneRecord);
        purchaseRepository.save(newManyRecord);
    }

    @GetMapping("/api/users/{id}/purchases")
    public List<Purchase> findOneToManyRecords(
            @PathVariable("id") Integer id) {
        return userRepository.findById(id).get().getPurchases();
    }

    @PutMapping("/api/users")
    public void updateRecord(
            @RequestBody User newRecord
    ) {
        User oldRecord = userRepository.findById(newRecord.getId()).get();

        oldRecord.setLastName(newRecord.getLastName());
        oldRecord.setFirstName(newRecord.getFirstName());
        oldRecord.setUsername(newRecord.getUsername());
        oldRecord.setPassword(newRecord.getPassword());
        oldRecord.setEmail(newRecord.getEmail());
        oldRecord.setDateOfBirth(newRecord.getDateOfBirth());

        userRepository.save(oldRecord);
    }
}
