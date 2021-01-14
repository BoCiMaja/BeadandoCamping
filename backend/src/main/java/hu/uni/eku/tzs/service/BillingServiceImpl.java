package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.BillingDao;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
import hu.uni.eku.tzs.service.exceptions.BillNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillingServiceImpl implements BillingService {

    private final BillingDao dao;

    @Override
    public void record(Bill bill) throws BillAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch(szamla ->
                        szamla.getBillId() == bill.getBillId());
        if (isAlreadyRecorded) {
            throw new BillAlreadyExistsException(String.format("Bill {%s} already exists!", bill.toString()));
        }
        dao.create(bill);
    }

    @Override
    public Collection<Bill> readAll() {
        return dao.readAll();
    }

    @Override
    public void delete(Integer billId) throws BillNotFoundException {
        dao.delete(billId);
    }
}
