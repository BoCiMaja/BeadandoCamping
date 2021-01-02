package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;
import java.util.Collection;

public interface BillingDao {
    void create(Bill bill);

    Collection<Bill> readAll();

    void update(Integer billId, Bill updated);

    void delete(Integer billId);
}
