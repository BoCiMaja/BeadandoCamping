package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.BillNotFoundException;

import java.util.Collection;

public interface BillingService {
    void record(Bill bill) throws BillAlreadyExistsException;

    void delete(Integer billId) throws BillNotFoundException;

    Collection<Bill> readAll();
}
