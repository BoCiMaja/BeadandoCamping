package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;
import java.util.Collection;

public interface BillingDao {
    void create(Bill bill);

    Collection<Bill> readAll();

    void update(int bill_id, Bill updated);

    void delete(int bill_id);
}
