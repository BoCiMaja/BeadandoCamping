package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.BillingDao;
import hu.uni.eku.tzs.model.Bill;
import hu.uni.eku.tzs.service.exceptions.BillAlreadyExistsException;
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
        final boolean isAlreadyRecorded = dao.readAll().stream().anyMatch(
                t -> t == bill);
        if (isAlreadyRecorded) {
            log.info("The bill is already recorded!");
            throw new BillAlreadyExistsException(String.format("Bill already exists!"));
        }
        dao.create(bill);
    }
    @Override
    public Collection<Bill> readAll() {
        return dao.readAll();
    }
}
