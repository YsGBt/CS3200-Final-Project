package ebooks.database.purchase;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository
        extends CrudRepository<Purchase, Integer> {
}
