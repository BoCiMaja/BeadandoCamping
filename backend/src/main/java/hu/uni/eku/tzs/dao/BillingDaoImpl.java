package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Bill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class BillingDaoImpl implements BillingDao {

    private final BillingRepository repository;

    @Override
    public void create(Bill bill) {
        repository.save(BillEntityModelConverter.model2entity(bill));
    }

    @Override
    public Collection<Bill> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> BillEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int billId, Bill update) {
        hu.uni.eku.tzs.dao.entity.Bill temp = repository.findByBillId(billId);
        temp.setBillId(update.getBillId());
        temp.setArrive(update.getArrive());
        temp.setLeave(update.getLeave());
        temp.setFirstName(update.getFirstName());
        temp.setSurName(update.getSurName());
        temp.setNumberOfDays(update.getNumberOfDays());
        temp.setTotalAmount(update.getTotalAmount());
        repository.save(temp);
    }

    @Override
    public void delete(int billId) {
        hu.uni.eku.tzs.dao.entity.Bill temp = repository.findByBillId(billId);
        if (temp != null)
            repository.delete(temp);
    }

    private static class BillEntityModelConverter {
        private static Bill entity2model(hu.uni.eku.tzs.dao.entity.Bill entity) {
            return new Bill(
                    entity.getBillId(),
                    entity.getArrive(),
                    entity.getLeave(),
                    entity.getFirstName(),
                    entity.getSurName(),
                    entity.getNumberOfDays(),
                    entity.getTotalAmount());
        }

        private static hu.uni.eku.tzs.dao.entity.Bill model2entity(Bill model) {
            return hu.uni.eku.tzs.dao.entity.Bill.builder()
                    .billId(model.getBillId())
                    .arrive(model.getArrive())
                    .leave(model.getLeave())
                    .firstName(model.getFirstName())
                    .surName(model.getSurName())
                    .numberOfDays(model.getNumberOfDays())
                    .totalAmount(model.getTotalAmount()).build();
        }
    }
}
